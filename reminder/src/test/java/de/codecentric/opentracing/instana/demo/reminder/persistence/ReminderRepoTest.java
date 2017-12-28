package de.codecentric.opentracing.instana.demo.reminder.persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Benjamin Wilms
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ReminderRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReminderRepo reminderRepo;

    @Before
    public void setUp() throws Exception {
        reminderRepo.deleteAll();
    }

    @Test
    public void whenFindById_thenReturnReminderEntity() throws Exception {
        //given
        Long referencedNoteId = 99l;
        Date localDateTime = new Date();
        ReminderEntity givenReminderEntity = new ReminderEntity(referencedNoteId, localDateTime);
        ReminderEntity persistedEntity = entityManager.persist(givenReminderEntity);
        entityManager.flush();

        // when
        Optional<ReminderEntity> foundEntityById = reminderRepo.findById(persistedEntity.getId());

        //then
        assertThat(foundEntityById.get().getNoteReferenceId(), is(referencedNoteId));
        assertThat(foundEntityById.get().getRemindDateTime(), is(localDateTime));

    }

    @Test
    public void whenDeleteById_thenNumberOfEntitiesIs_ZERO() throws Exception {
        //given
        ReminderEntity givenReminderEntity = new ReminderEntity();
        ReminderEntity persistedEntity = entityManager.persist(givenReminderEntity);
        entityManager.flush();
        int totalSizeBeforeDelete = reminderRepo.findAll().size();

        // when
        reminderRepo.deleteById(persistedEntity.getId());
        int totalSizeAfterDelete = reminderRepo.findAll().size();

        //then
        assertThat(totalSizeBeforeDelete, is(1));
        assertThat(totalSizeAfterDelete, is(0));

    }

    @Test
    public void whenFindAll_thenNumberOfEntitiesIs_3() throws Exception {
        //given
        entityManager.persist(new ReminderEntity());
        entityManager.persist(new ReminderEntity());
        entityManager.persist(new ReminderEntity());
        entityManager.flush();

        // when
        int totalSize = reminderRepo.findAll().size();

        //then
        assertThat(totalSize, is(3));

    }

}