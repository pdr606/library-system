package com.example.demo.dto;

import java.io.Serializable;

public class SearchUserDTO implements Serializable {

    private String cpf;

    public SearchUserDTO(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
