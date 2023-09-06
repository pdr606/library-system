package com.example.demo.services;


import com.example.demo.config.TwilioConfig;
import com.example.demo.entities.Order;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Autowired
    private TwilioConfig twilioConfig;

    public void sendMessageToExpiredOrder(Order obj) {
        System.out.println("Iniciei twilio");
        System.out.println(obj.getStudent().getTelephone());
        System.out.println(twilioConfig.getTrialNumber());
        try{
            PhoneNumber to = new PhoneNumber(obj.getStudent().getTelephone());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String messageToStudent = "Olá " + obj.getStudent().getName().toUpperCase() + " o prazo de entrega do seu livro " +
                    obj.getBooks().getTitle().toUpperCase() + " expirou no dia " + obj.getReturnDate() + " faça a devolução " +
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
