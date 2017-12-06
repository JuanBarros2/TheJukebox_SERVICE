package br.edu.thejukebox.repository;

import br.edu.thejukebox.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
