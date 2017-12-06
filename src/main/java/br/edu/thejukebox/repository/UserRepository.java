package br.edu.thejukebox.repository;

import br.edu.thejukebox.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findFirstByEmail(String email);
}
