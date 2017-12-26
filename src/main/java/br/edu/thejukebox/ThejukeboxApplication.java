package br.edu.thejukebox;

import br.edu.thejukebox.model.*;
import br.edu.thejukebox.repository.AccountRepository;
import br.edu.thejukebox.repository.ArtistRepository;
import br.edu.thejukebox.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@SpringBootApplication
public class ThejukeboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThejukeboxApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BCryptPasswordEncoder crypt) {
		return (evt) -> Arrays.asList(
				"juanbarros".split(","))
				.forEach(
						a -> {
							Account account = new Account(new User(a, crypt.encode("1234")));
							Artist artist = new Artist("Arctic Monkeys");
							account.getArtistSet().add(artist);
							Album album = new Album();
							album.setName("Humbug");
							Music music = new Music();
							music.setName("Secret Door");
							music.setDuration("3");
							music.setYear(2009);
							music.setAlbum(album);
							music.setArtist(artist);
							album.getMusicSet().add(music);
							account.getAlbumSet().add(album);
							accountRepository.save(account);
						});
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

	@Bean
 	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
