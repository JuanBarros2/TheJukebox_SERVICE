package br.edu.thejukebox;

import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.model.User;
import br.edu.thejukebox.repository.AccountRepository;
import br.edu.thejukebox.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class ThejukeboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThejukeboxApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository accountRepository) {
		return (evt) -> Arrays.asList(
				"juanbarros".split(","))
				.forEach(
						a -> {
						accountRepository.save(new User( a,"1234"));
						});
	}

	@Bean
 	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
