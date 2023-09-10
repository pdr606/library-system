package com.example.demo.entities;

import com.example.demo.entities.enums.BooksStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_books")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String gener;
    private Integer quantity;
    private Integer tot_local;
    private Integer tot_available;

    private Integer bookStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "books")
    private List<Order> orders = new ArrayList<>();


    public Books(){
        this.bookStatus = 1;

    }

    public Books(Long id, String title, String author, Integer quantity, Integer tot_local, Integer tot_available, String gener) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.gener = gener;
        this.quantity = quantity;
        this.tot_local = tot_local;
        this.tot_available = tot_available;
        this.bookStatus = 1;
        setBookStatus(BooksStatus.valueOf(bookStatus));
    }

    public void withdrawBook(Books obj){
        obj.setTot_available(getTot_available() - 1);
        if(obj.getTot_available() == 0){
            setBookStatus(BooksStatus.valueOf(2));
        }
    }

    public void devolutionBook(Books obj){
        obj.setTot_available(obj.getTot_available() + 1);
        obj.setTot_local(obj.getTot_local() + 1);
        if(obj.getBooksStatus().getCode() == 2){
            setBookStatus(BooksStatus.valueOf(1));
            return;
        }
        return;
    }

    public BooksStatus getBooksStatus() {
        return BooksStatus.valueOf(bookStatus);
    }

    public void setBookStatus(BooksStatus orderStatus) {
        if(orderStatus != null) {
            this.bookStatus = orderStatus.getCode();
        }

    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTot_local() {
        return tot_local;
    }

    public void setTot_local(Integer tot_local) {
        this.tot_local = tot_local;
    }

    public Integer getTot_available() {
        return tot_available;
    }

    public void setTot_available(Integer tot_available) {
        this.tot_available = tot_available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
