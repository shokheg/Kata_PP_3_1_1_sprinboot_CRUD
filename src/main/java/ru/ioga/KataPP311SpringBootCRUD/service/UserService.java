package ru.ioga.KataPP311SpringBootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ioga.KataPP311SpringBootCRUD.model.User;
import ru.ioga.KataPP311SpringBootCRUD.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author shokhalevich
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
