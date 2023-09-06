package com.example.demo.dto;

import java.io.Serializable;

public class WidthdrawAndDevolutionDTO implements Serializable {

    private String cpf;
    private Long idBook;




    public WidthdrawAndDevolutionDTO(){

    }

    public WidthdrawAndDevolutionDTO(String cpf, Long idBook) {
        this.cpf = cpf;
        this.idBook = idBook;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }
}
