package com.example.client.repositories;

import com.example.client.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
     public Client findByNom(String nom);

     //List<Client> findUsersWithNotes(Long userId);
}