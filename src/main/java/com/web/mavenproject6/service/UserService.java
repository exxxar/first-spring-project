/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Users;

/**
 *
 * @author Aleks
 */
public interface UserService {
    void add(Users user);
    long count();
    Users findOne(Long id);
    void delete(Long id);
}
