package com.nttdata.demobootcamp;

import com.nttdata.demobootcamp.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.demobootcamp.infraestructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemobootcampApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final UserRepository userRepository;

	@Autowired
	public DemobootcampApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemobootcampApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		//Populating embedded database here
		User luis = new User("Luis", "Garcia");
		User gia = new User("Gia", "Suarez");
		User rosa = new User("Rosa", "Valverde");
		User cielo = new User("Cielo", "Tejada");

		userRepository.save(luis);
		userRepository.save(gia);
		userRepository.save(rosa);
		userRepository.save(cielo);
		LOG.info("Done saving users. Data: {}.", userRepository.findAll());
	}

}
