/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Users;
import com.web.mavenproject6.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aleks
 */

@Service
public class UserServiceImp implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(Users user) {
        userRepository.save(user);
    }
    
    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public Users findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
         userRepository.delete(id);
    }
    
    public List<Users> list(){
        return (List<Users>) userRepository.findAll();
    }
}
