package com.example.microservicenote.controller;

import com.example.microservicenote.entity.Note;
import com.example.microservicenote.service.NoteServiceimpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@AutoConfigureMockMvc
@SpringBootTest
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteServiceimpl noteService;

   /* @MockBean
    private UserService userService;*/

    @Test
    void testGetNotes() throws Exception  {
        when(noteService.readAll()).thenReturn(Collections.singletonList(new Note("Body 1", "Category 1", "Title 1", 1L)));

        mockMvc.perform(MockMvcRequestBuilders.get("/Managment/notee")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testSaveNote() throws Exception {
        Long userId = 1L;
        Note note = new Note("Body 1", "Category 1", "Title 1", userId);
        when(noteService.saveNote(note)).thenReturn(note);

        mockMvc.perform(MockMvcRequestBuilders.post("/Managment/notee")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testReadNote() throws Exception {
        Long noteId = 1L;
        when(noteService.readNote(noteId)).thenReturn(new Note( "Body 1", "Category 1", "Title 1", 1L));

        mockMvc.perform(MockMvcRequestBuilders.get("/Managment/notee/{id}", noteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteNote() throws Exception {
        Long noteId = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/Managment/notee/{id}", noteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }


    @Test
    void testUpdate() throws Exception {
        Long userId = 1L;
        Note note = new Note("Body 1", "Category 1", "Title 1", userId);
        when(noteService.saveNote(note)).thenReturn(note);

        mockMvc.perform(MockMvcRequestBuilders.put("/Managment/notee")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //@Test
   // @Disabled
   /* void testFindByClient() throws Exception {
        NoteController noteController = new NoteController(noteService, userService);

        // Test data
        Long userId = 1L;
       // Client user = new Client();  // Create a user object
        List<Note> notes = Collections.singletonList(new Note());  // Create a list of notes

        // Mock behavior
        when(userService.userById(userId)).thenReturn(user);
        when(noteService.findByIdUser(userId)).thenReturn(notes);

        // Test the method with a valid user
        ResponseEntity<List<Note>> response = noteController.findByClient(userId);

        // Verify the behavior
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notes, response.getBody());

        // Test the method with a non-existing user
        when(userService.userById(userId)).thenReturn(null);
        response = noteController.findByClient(userId);

        // Verify the behavior
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        // Test the method with an exception
        when(userService.userById(userId)).thenThrow(new RuntimeException("Internal Server Error"));
        response = noteController.findByClient(userId);

        // Verify the behavior
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }*/
}
