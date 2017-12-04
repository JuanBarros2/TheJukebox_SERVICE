package br.edu.thejukebox.repository;

import br.edu.thejukebox.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
