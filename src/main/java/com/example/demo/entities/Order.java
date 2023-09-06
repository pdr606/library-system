package com.example.demo.entities;

import com.example.demo.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate creationDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate returnDate;

    private  Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties("orders")
    private User student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("orders")
    private Books books;


    public Order(){

    }

    public Order(Long id, User student, Books books) {
        this.id = id;
        this.student = student;
        this.books = books;
        this.creationDate = LocalDate.now();
        this.returnDate = creationDate.plus(30, ChronoUnit.DAYS);
        this.orderStatus = 1;
        setOrderStatus(OrderStatus.valueOf(orderStatus));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus){
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }
}
