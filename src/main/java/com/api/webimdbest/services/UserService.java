package com.api.webimdbest.services;

import com.api.webimdbest.models.UserModel;
import com.api.webimdbest.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }
    public boolean doesUserExist(String userId) {
        return userRepository.existsById(UUID.fromString(userId));
    }

    public boolean isLoginTaken(String login) {
        return userRepository.existsByLogin(login);
    }

    public Optional<UserModel> getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }
    public Optional<UserModel> getUserById(UUID idUser){
        return userRepository.findById(idUser);
    }
}

