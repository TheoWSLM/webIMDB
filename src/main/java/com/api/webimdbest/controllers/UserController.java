package com.api.webimdbest.controllers;

import com.api.webimdbest.dto.UserCreateDTO;
import com.api.webimdbest.dto.UserLoginDTO;
import com.api.webimdbest.models.ErrorResponse;
import com.api.webimdbest.models.FilmeModel;
import com.api.webimdbest.models.UserModel;
import com.api.webimdbest.services.FilmeService;
import com.api.webimdbest.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    final UserService userService;
    final FilmeService filmeService;

    public UserController(UserService userService, FilmeService filmeService){

        this.userService = userService;
        this.filmeService = filmeService;
    }
    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserCreateDTO userCreateDTO){
        String login = userCreateDTO.getLogin();
        if (userService.isLoginTaken(login)) {
            ErrorResponse errorResponse = new ErrorResponse("Esse login de usuário já está em uso.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } else {
            var userModel = new UserModel();
            BeanUtils.copyProperties(userCreateDTO, userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userModel));
        }
    }
    @PostMapping ("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginDTO userLoginDTO) {

        Optional<UserModel> user = userService.getUserByLogin(userLoginDTO.getLogin());
        if (user.isPresent() && Objects.equals(user.get().getPassWord(), userLoginDTO.getPassWord())) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get().getId());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Usuário ou senha incorretos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/addFilme")
    public ResponseEntity<?> addFilme(@RequestParam(name = "idUser") UUID idUser, @RequestParam(name = "filmId") String filmId) {

        Optional<UserModel> user = userService.getUserById(idUser);
        if (user.isPresent()) {
            UserModel userToUpdate = user.get();
            Optional<FilmeModel> filme = filmeService.getFilmeById(filmId);
            if(filme.isPresent()) {
                List<FilmeModel> filmesDoUsuario = userToUpdate.getItems();

                if (filmesDoUsuario.contains(filme.get())) {
                    ErrorResponse errorResponse = new ErrorResponse("Filme já existe na lista desse usuário");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);


                }
                userToUpdate.getItems().add(filme.get());
                userService.saveUser(userToUpdate);
                return ResponseEntity.status(HttpStatus.OK).body(filme.get());
            }else{
                ErrorResponse errorResponse = new ErrorResponse("Filme não encontrado na base de dados");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        }

        @GetMapping("meusFilmes")
    public ResponseEntity<?> meusFilmes(@RequestParam(name = "idUser") UUID idUser) {
            Optional<UserModel> user = userService.getUserById(idUser);
            if (user.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(user.get().getItems());
            } else {
                ErrorResponse errorResponse = new ErrorResponse("Usuário não encontrado");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        }

    @DeleteMapping("excluirFilme")
    public ResponseEntity<?> deleteFilme(@RequestParam(name = "idUser") UUID idUser, @RequestParam(name = "idFilme") String idFilme) {
        Optional<UserModel> user = userService.getUserById(idUser);
        Optional<FilmeModel> filme = filmeService.getFilmeById(idFilme);
        if (user.isPresent()) {
            if(filme.isPresent()) {
                UserModel userToUpdate = user.get();
                List<FilmeModel> filmesDoUsuario = userToUpdate.getItems();

                if (filmesDoUsuario.contains(filme.get())) {
                    filmesDoUsuario.remove(filme.get());
                    userService.saveUser(userToUpdate);
                    return ResponseEntity.status(HttpStatus.OK).body("Filme removido com sucesso");
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O filme não foi encontrado na lista desse usuário");
                }

            }else{
                ErrorResponse errorResponse = new ErrorResponse("Filme não encontrado");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

        } else {
            ErrorResponse errorResponse = new ErrorResponse("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    }



