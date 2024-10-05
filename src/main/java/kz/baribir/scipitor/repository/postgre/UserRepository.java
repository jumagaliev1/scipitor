package kz.baribir.scipitor.repository.postgre;

import kz.baribir.scipitor.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
