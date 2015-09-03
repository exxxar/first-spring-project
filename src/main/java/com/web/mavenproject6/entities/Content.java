/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Aleks
 */
@Entity
@Table
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;
    
    public Content()
    {
    }
    public Content(Integer id, String name, String address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        return "User [address=" + address + ", id=" + id + ", name=" + name+ "]";
    }
}
