package com.to.hibernate.mini;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HibernateDemoApplication {

	@GetMapping
	public String message(){
		return "welcome to javatechie";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);

	}

}
