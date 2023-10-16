package com.api.webimdbest.services;


import com.api.webimdbest.models.FilmeModel;
import com.api.webimdbest.repositories.FilmeRepository;
import com.api.webimdbest.utilities.FilmeCapture;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmeService {
    final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public List<FilmeModel> listarFilmes() {
        FilmeCapture filmeCapture = new FilmeCapture(this);
        filmeCapture.Action();
        return filmeRepository.findAll();
    }

    @Transactional
    public FilmeModel saveFilme(FilmeModel filmeModel) {
        return filmeRepository.save(filmeModel);
    }

    public Optional<FilmeModel> getFilmeById(String idFilme) {
        return filmeRepository.getFilmById(idFilme);
    }
}


