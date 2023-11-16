package com.api.webimdbest.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreateDTO {


    @NotBlank
    @Size(max=50)
    private String nome;
    @NotBlank
    @Size(max=25)
    private String login;
    @NotBlank
    @Size(max=100, min = 8)
    private String passWord;

    @NotBlank
    @Size(max=100, min = 8)
    private String passWordConfirmation;

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

    @AssertTrue(message = "A senha e a confirmação de senha não são iguais.")
    public boolean isPasswordConfirmed() {
        return passWord != null && passWord.equals(passWordConfirmation);
    }

}
