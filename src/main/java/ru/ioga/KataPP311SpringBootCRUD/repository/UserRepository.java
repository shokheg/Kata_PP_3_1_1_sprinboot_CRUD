package ru.ioga.KataPP311SpringBootCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ioga.KataPP311SpringBootCRUD.model.User;

/**
 * @author shokhalevich
 */
public interface UserRepository extends JpaRepository<User, Long> {



}
