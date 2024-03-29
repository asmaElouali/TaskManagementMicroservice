package com.example.microservicenote.repository;

import com.example.microservicenote.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
   // List<Note> findByIdUser(Long id);

    List<Note> findAllByIdUser(Long userId);
}
