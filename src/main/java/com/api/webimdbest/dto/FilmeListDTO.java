package com.api.webimdbest.dto;


import jakarta.validation.constraints.AssertTrue;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import com.api.webimdbest.services.UserService;

import java.util.UUID;

@Component
public class FilmeListDTO {

    private UUID idUser;

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }
}
