package com.ds.phase1;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ds.phase1.model.UserCheckin;
import com.ds.phase1.repository.UserCheckinRepository;

@SpringBootApplication
public class Cse586Phase1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Cse586Phase1Application.class, args);
	}

	@Autowired
	UserCheckinRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Backend Up");
	}

}
