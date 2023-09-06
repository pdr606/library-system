package com.example.demo.services;


import com.example.demo.entities.Books;
import com.example.demo.repositories.BooksRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    public List<Books> findAll(){
        return repository.findAll();
    }

    public Books findById(Long id){
        Optional<Books> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Books insert(Books obj){
        return repository.save(obj);
    }

    public Books withdrawBookToStock(Long id){
        Books obj = findById(id);
        obj.withdrawBook(obj);
        return repository.save(obj);

    }
}
