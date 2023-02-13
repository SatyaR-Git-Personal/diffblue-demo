package com.example.unit.diffBlue;

import com.example.unit.diffBlue.Student.Student;
import com.example.unit.diffBlue.Student.StudentJdbcRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiffBlueApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(DiffBlueApplication.class, args);
	}

	@Override
	public void run(String... args) {

		logger.info("Student id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting -> {}", repository.insert(new Student(10010L, "Satya", "A1234657")));

		logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

		repository.deleteById(10002L);

		logger.info("All users -> {}", repository.findAll());
	}


}
