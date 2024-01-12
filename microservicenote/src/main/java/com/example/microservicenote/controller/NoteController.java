package com.example.microservicenote.controller;

import com.example.microservicenote.entity.Note;
import com.example.microservicenote.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/Managment")
public class NoteController {

    @Autowired
    private NoteService noteservice;



    //@Autowired
   // private ClientService clientService;

    @GetMapping("/notee")
    public List<Note> getNotes(){
        return noteservice.readAll();
    }

    @PostMapping("/notee")
    public Note saveNote(@RequestBody Note note) {
        return noteservice.saveNote(note);
    }

    @GetMapping("/notee/{id}")
    public Note readNote(@PathVariable Long id) {
        return noteservice.readNote(id);
    }

    @DeleteMapping("/notee/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        noteservice.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/notee")
    public Note Update(@RequestBody Note note) {
        return noteservice.saveNote(note);
    }

    /*@GetMapping("/notee/client/{Id}")
    public ResponseEntity<List<Note>> findByClient(@PathVariable Long Id) {
        try {
            Client client = clientService.clientById(Id);
            if (client != null) {
                List<Note> notes = noteservice.findByIdUser(Id);
                return ResponseEntity.ok(notes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }*/

    // @PostMapping("/notes/{clientId}")
    /*
    public ResponseEntity<Object> save(@PathVariable Long clientId, @RequestBody
    Note note) {
        try {
            // Fetch the client details using the clientService
            Client client = clientService.clientById(clientId);

            if (client != null) {
                // Set the fetched client in the voiture object

                note.setIdUser(clientId);
                Note savedNote = noteservice.saveNote(note);
                return ResponseEntity.ok(savedNote);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Client not found with ID: " + clientId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving Note: " + e.getMessage());
        }
    }
*/

    @GetMapping("/client/{user-id}")
    public List<Note> getNotes(@PathVariable("user-id") Long userId){
        return noteservice.readAllNoteByUser(userId);
    }

}
