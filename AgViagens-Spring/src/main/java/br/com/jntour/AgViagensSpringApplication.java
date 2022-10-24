package br.com.jntour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgViagensSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgViagensSpringApplication.class, args);

//		System.out.println(new BCryptPasswordEncoder().encode("senha123" ) );
	}

}
