package br.com.m4y50n.bankapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.m4y50n.bankapi.model.User;
import br.com.m4y50n.bankapi.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    };

    public User createUser(final User userData) {
        final User user = new User(userData.getName(), userData.getCpf(), userData.getEmail(), userData.getPassword());

        return userRepository.save(user);
    }

    public List<User> readUsers() {
        return userRepository.findAll();
    }

    public User retriveUser(final long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("Error: User not found"));
    }

    public User updateUser(final User userData, final long id) throws Exception {
        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("Error: User not found"));

        foundUser.setName(userData.getName());
        foundUser.setCpf(userData.getCpf());
        foundUser.setEmail(userData.getEmail());
        foundUser.setPassword(userData.getPassword());

        return userRepository.save(foundUser);
    }

    public void deleteUser(final long id) throws Exception {
        final User foundUser = userRepository.findById(id).orElseThrow(() -> new Exception("Error: User not found"));

        // foundUser.onDelete();
        userRepository.delete(foundUser);
    }
}
