package com.example.demo.resources;


import com.example.demo.entities.Books;
import com.example.demo.entities.User;
import com.example.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksResource {

    @Autowired
    private BooksService service;

    @GetMapping
    public ResponseEntity<List<Books>> findAll(){
        List<Books> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Books> insert(@RequestBody Books obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
}
