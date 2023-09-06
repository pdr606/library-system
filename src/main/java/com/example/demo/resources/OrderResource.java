package com.example.demo.resources;


import com.example.demo.dto.WidthdrawAndDevolutionDTO;
import com.example.demo.entities.Books;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.services.BooksService;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private UserService service;

    @Autowired
    private BooksService booksService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity <List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/expired")
    public ResponseEntity<List<Order>> findExpiredOrder(){
        List<Order> list = orderService.findExpiredOrder();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveDevolution(@PathVariable Long id){
        orderService.saveDevolution(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity <Order> withdrawBook(@RequestBody WidthdrawAndDevolutionDTO WidthDrawDTO){
        User user = service.findByCpf(WidthDrawDTO);
        Books book = booksService.findById(WidthDrawDTO.getIdBook());
        book = booksService.withdrawBookToStock(book.getId());
        Order order = new Order(null, user, book );
        orderService.saveWidthdraw(order);
        return ResponseEntity.ok().body(order);
    }
}
