package de.codecentric.opentracing.demo.notes.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Benjamin Wilms
 */
public interface NoteRepo extends JpaRepository<NoteEntity,Long> {


}