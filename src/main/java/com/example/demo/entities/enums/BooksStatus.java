package com.example.demo.entities.enums;

public enum BooksStatus {

    DISPONIBLE(1),

    SOLD_OUT(2);


    private int code;

    private BooksStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static BooksStatus valueOf(int code){
        for(BooksStatus value : BooksStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid BooksStatus code");
    }
}
