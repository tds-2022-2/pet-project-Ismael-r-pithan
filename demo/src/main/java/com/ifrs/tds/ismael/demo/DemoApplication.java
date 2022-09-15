package com.ifrs.tds.ismael.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
class MainController {

	@GetMapping("/")
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.status(HttpStatus.OK).body("Ola mundo");
	}
}
