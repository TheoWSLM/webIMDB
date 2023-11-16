package com.api.webimdbest.controllers;

import com.api.webimdbest.dto.FilmeListDTO;
import com.api.webimdbest.models.ErrorResponse;
import com.api.webimdbest.models.FilmeModel;
import com.api.webimdbest.services.FilmeService;
import com.api.webimdbest.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/filme")
public class FilmeController {
    final FilmeService filmeService;
    final UserService userService;

    public FilmeController(FilmeService filmeService, UserService userService) {
        this.filmeService = filmeService;
        this.userService = userService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listFilmes(@RequestParam(name = "userId") UUID userId) {
        if (userService.doesUserExist(userId.toString())) {
            List<FilmeModel> filmes = filmeService.listarFilmes();
            return ResponseEntity.status(HttpStatus.OK).body(filmes);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Usuário não encontrado no banco de dados.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
