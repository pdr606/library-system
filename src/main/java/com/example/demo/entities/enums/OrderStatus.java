package com.example.demo.entities.enums;

public enum OrderStatus {

    CURRENT(1),
    EXPIRED(2),

    FINISHED(3);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
