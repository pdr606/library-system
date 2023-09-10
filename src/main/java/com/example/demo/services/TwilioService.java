package com.example.demo.services;


import com.example.demo.config.TwilioConfig;
import com.example.demo.entities.Order;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TwilioService {

    @Autowired
    private TwilioConfig twilioConfig;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void sendMessageToCreateOrder(Order obj){
        try{
            PhoneNumber to = new PhoneNumber(obj.getStudent().getTelephone());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String messageToStudent = "Olá " + obj.getStudent().getName().toUpperCase() + " você fez a retirada do livro " +
                    obj.getBooks().getTitle().toUpperCase() + " e irá expirar no dia " + sdf.format(obj.getReturnDate());

            Message message = Message.creator(
                    to,
                    from,
                    messageToStudent
            ).create();

        } catch (Exception e){
            System.out.println("Exception" + e.getMessage());
        }

    }

    public void sendMessageToExpiredOrder(Order obj) {
        try{
            PhoneNumber to = new PhoneNumber(obj.getStudent().getTelephone());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String messageToStudent = "Olá " + obj.getStudent().getName().toUpperCase() + " o prazo de entrega do seu livro " +
                    obj.getBooks().getTitle().toUpperCase() + " expirou no dia " + sdf.format(obj.getReturnDate()) + " faça a devolução " +
                    "na blibioteca";

            Message message = Message.creator(
                    to,
                    from,
                    messageToStudent
            ).create();

        } catch (Exception e){
            System.out.println("Exception" + e.getMessage());
        }

    }


}
