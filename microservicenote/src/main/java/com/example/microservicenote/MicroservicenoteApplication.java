package com.example.microservicenote;

import com.example.microservicenote.entity.Note;
import com.example.microservicenote.repository.NoteRepository;
import com.example.microservicenote.service.NoteServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MicroservicenoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicenoteApplication.class, args);
	}

}
