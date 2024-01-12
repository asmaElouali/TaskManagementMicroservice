package com.example.microservicenote.service;

import com.example.microservicenote.entity.Note;
import com.example.microservicenote.repository.NoteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteServiceimplTest {

    @Mock private NoteRepository noteRepository;
    private NoteServiceimpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new NoteServiceimpl(noteRepository);
    }



    @Test
    void canReadAll() {
        //when
        underTest.readAll();
        //then
        verify(noteRepository).findAll();
    }

    @Test
    void canSaveNote() {
        //given
        Long userId = 1L;
        Note note1 = new Note( "Body 1", "Category 1", "Title 1", userId);

        // when
        underTest.saveNote(note1);

        //then
        ArgumentCaptor<Note> noteArgumentCaptor = ArgumentCaptor.forClass(Note.class);
        verify(noteRepository).save(noteArgumentCaptor.capture());

        Note capturedNote = noteArgumentCaptor.getValue();

        assertThat(capturedNote).isEqualTo(note1);
    }

    @Test
    void canReadNote() {
        Long id = 4L;
        // Mock the behavior of noteRepository.findById to return an empty result
        when(noteRepository.findById(id)).thenReturn(Optional.empty());

        // Call the method under test and expect a RuntimeException
        assertThrows(RuntimeException.class, () -> underTest.readNote(id));
        //then
        verify(noteRepository).findById(id);
    }

    @Test
    void testDelete() {
        Long id = 1L;
        Long userId = 1L;
        Note note = new Note("Body 1", "Category 1", "Title 1", userId);  // Create a sample Note object
        when(underTest.readNote(id)).thenReturn(note);

        // When
        underTest.delete(id);

        // Then
        verify(noteRepository).delete(note);
    }

    @Test
    @Disabled
    void findByIdUser() {
    }
}