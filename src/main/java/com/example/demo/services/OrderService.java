package com.example.demo.services;

import com.example.demo.entities.Books;
import com.example.demo.entities.Order;
import com.example.demo.entities.enums.BooksStatus;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.exceptions.ResourceBookSoldOutException;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private BooksService booksService;

    @Autowired
    private TwilioService twilioService;

    public Order saveWidthdraw(Order order){
        if(order.getBooks().getTot_available() >= 0){
            return repository.save(order);

        } else {
            throw new ResourceBookSoldOutException();
        }
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void checkExpiration(){
        List<Order> list = findAll();
        LocalDate currentDate = LocalDate.now();
        if(!list.isEmpty()){
            for(Order obj : list){
                if(currentDate.isAfter(obj.getReturnDate()) && obj.getOrderStatus().getCode() != 2){
                    obj.setOrderStatus(OrderStatus.valueOf(2));
                    twilioService.sendMessageToExpiredOrder(obj);
                    repository.save(obj);
                }
            }
        }
    }

    public void saveDevolution(Long id){
        Order order = findById(id);
        order.setOrderStatus(OrderStatus.valueOf(3));
        order.getBooks().devolutionBook(order.getBooks());
        repository.save(order);
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public List<Order> findExpiredOrder(){
        return repository.findExpiredOrder();
    }
}
