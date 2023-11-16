package com.api.webimdbest.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "USER_DB")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 25)
    private String login;
    @Column(nullable = true, length = 50)
    private String nome;
    @Column(nullable = false, length = 100)
    private String passWord;
    @Column(nullable = false, length = 100)
    private String passWordConfirmation;

    @Column(nullable = true)
    @ManyToMany
    private List<FilmeModel> items;

    @Column(nullable = false, length = 100)
    private String favoriteMovie;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<FilmeModel> getItems() {
        return items;
    }

    public void setItems(List<FilmeModel> items) {
        this.items = items;
    }

    public String getPassWordConfirmation() {
        return passWordConfirmation;
    }

    public void setPassWordConfirmation(String passWordConfirmation) {
        this.passWordConfirmation = passWordConfirmation;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(String favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }
}
