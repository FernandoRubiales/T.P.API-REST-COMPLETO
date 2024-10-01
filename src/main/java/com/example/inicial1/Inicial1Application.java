package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.LocalidadRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, LocalidadRepository localidadRepository, AutorRepository autorRepository) {
		return args -> {

			Localidad loc1 = Localidad.builder().
					denominacion("Godoy Cruz").
					build();
			Localidad loc2 = Localidad.builder().
					denominacion("Godoy Cruz").
					build();

			localidadRepository.save(loc1);
			localidadRepository.save(loc2);

			Autor autor1 = Autor.builder().
					nombre("Liliana").
					apellido("Bodoc").
					biografia("Liliana nacio en Santa Fe en 1958.").
					build();

			autorRepository.save(autor1);

			Domicilio dom1 = Domicilio.builder().
					calle("Suipacha").
					numero(239).build();

			Domicilio dom2 = Domicilio.builder().
					calle("Soler").
					numero(115).build();


			Persona per1 = Persona.builder().
					nombre("Alberto").apellido("Cortez").dni(43425467).
					build();

			Persona per2 = Persona.builder().
					nombre("Martin").apellido("Rojas").dni(34567123).
					build();

			personaRepository.save(per1);
			personaRepository.save(per2);

			dom1.setLocalidad(loc1);
			dom2.setLocalidad(loc2);

			per1.setDomicilio(dom1);
			per2.setDomicilio(dom2);

		};

		};

}
