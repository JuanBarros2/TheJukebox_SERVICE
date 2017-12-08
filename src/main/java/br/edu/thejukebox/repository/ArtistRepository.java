package br.edu.thejukebox.repository;

import br.edu.thejukebox.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Artist findFirstByName(String name);
}
