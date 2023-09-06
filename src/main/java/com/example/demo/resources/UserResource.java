package com.example.demo.resources;


import com.example.demo.dto.SearchUserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.BooksService;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private BooksService booksService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/cpf")
    public ResponseEntity<User> findByUnicCpf(@RequestParam  String cpf){
        User user = service.findByUnicCpf(cpf);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

}
