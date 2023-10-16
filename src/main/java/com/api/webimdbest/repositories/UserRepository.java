package com.api.webimdbest.repositories;

import com.api.webimdbest.models.FilmeModel;
import com.api.webimdbest.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    boolean existsByLogin(String login);
    Optional<UserModel> findByLogin(String login);
    Optional<UserModel> findById(UUID id);

}
