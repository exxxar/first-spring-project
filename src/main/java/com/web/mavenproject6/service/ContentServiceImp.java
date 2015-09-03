/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.repositories.ContentRepository;
import com.web.mavenproject6.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aleks
 */
@Service
public class ContentServiceImp implements ContentService{
  
    @Autowired
    private ContentRepository contentRepository;  
}
