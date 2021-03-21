package com.aslbackend.service;

import com.aslbackend.data.model.ProductCategory;
import com.aslbackend.data.model.User;
import com.aslbackend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerivce {

    private final UserRepository repository;

    @Autowired
    public UserSerivce(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void save(User usr) {
        repository.save(usr);
    }

    public void deleteById(Long id) {
        if( repository.existsById(id)){
            repository.deleteById(id);
        }
    }

}
