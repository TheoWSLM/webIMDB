package com.api.webimdbest.repositories;

import com.api.webimdbest.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeModel, String> {
    List<FilmeModel> findAll();
    Optional<FilmeModel> getFilmById(String idFilme);
}
