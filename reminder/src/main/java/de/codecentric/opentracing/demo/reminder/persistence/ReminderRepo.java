package de.codecentric.opentracing.demo.reminder.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Benjamin Wilms
 */
public interface ReminderRepo extends JpaRepository<ReminderEntity,Long> {
}
