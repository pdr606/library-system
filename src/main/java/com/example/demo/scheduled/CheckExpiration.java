package com.example.demo.scheduled;

import com.example.demo.scheduled.exceptions.CheckExpirationException;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CheckExpiration {

    @Autowired
    private OrderService orderService;

    @Scheduled(fixedRate = 30000)
    public void checkExpiration(){
        try{
            System.out.println("Executei");
            orderService.checkExpiration();
        } catch (Exception e){
            throw new CheckExpirationException();

        }

    }
}
