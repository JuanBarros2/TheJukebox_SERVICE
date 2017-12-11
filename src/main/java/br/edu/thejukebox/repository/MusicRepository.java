package br.edu.thejukebox.repository;

import br.edu.thejukebox.model.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Long> {
    Music findFirstByName(String name);
}
