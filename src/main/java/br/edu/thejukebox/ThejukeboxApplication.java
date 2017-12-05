package br.edu.thejukebox;

import br.edu.thejukebox.model.Account;
import br.edu.thejukebox.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ThejukeboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThejukeboxApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository) {
		return (evt) -> Arrays.asList(
				"juanbarros".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account("juan",
									"Juan"));
						});
	}

}
