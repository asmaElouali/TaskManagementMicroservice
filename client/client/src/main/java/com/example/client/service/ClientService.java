package com.example.client.service;

import com.example.client.client.UserClient;
import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final UserClient userClient;
    public FullUserResponce findUsersWithNotes(Long userId) {
        var client = clientRepository.findById(userId)
                .orElse(Client.builder().nom("Not found")
                        .email("Not found")
                .build());
        var note =  userClient.findAllNotesByUser(userId); // find all notes
        return FullUserResponce.builder().nom(client.getNom()).password(client.getPassword()).notes(note).build();
    }
}
