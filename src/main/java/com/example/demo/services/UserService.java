package com.example.demo.services;


import com.example.demo.dto.WidthdrawAndDevolutionDTO;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        return repository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByCpf(WidthdrawAndDevolutionDTO WidthDrawDTO){
        return repository.findByCpf(WidthDrawDTO.getCpf());
    }

    public User findByUnicCpf(String cpf){
        return repository.findByCpf(cpf);

    }

    public User insert(User obj){
        return repository.save(obj);
    }

}
