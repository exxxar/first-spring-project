/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import com.mysql.jdbc.TimeUtil;
import com.web.mavenproject6.validators.annotation.MyEmpty;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import javax.annotation.Resources;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
/**
 *
 * @author Aleks
 */

@Entity
@Table(name="users")
public class Users implements Serializable
{

     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   
    @NotEmpty
    @Length(max = 45)    
    private String username;
    
    @MyEmpty
    @Length(max = 45)
    private String password;
    
    @NotNull 
    private boolean enabled;
    
    private String email;
    private String name;
    private String address;
    private Date regDate;
    private Date lastOnlineDate;
    private Date deleteDate;

    public Users(long id, String username, String password, boolean enabled, String email, String name, String address, Date regDate, Date lastOnlineDate, Date deleteDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.name = name;
        this.address = address;
        this.regDate = regDate;
        this.lastOnlineDate = lastOnlineDate;
        this.deleteDate = deleteDate;
    }

    public Users() {
        this.username = "";
        this.password = "";
        this.enabled = true;
        this.email = "";
        this.name = "";
        this.address = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastOnlineDate() {
        return lastOnlineDate;
    }

    public void setLastOnlineDate(Date lastOnlineDate) {
        this.lastOnlineDate = lastOnlineDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled + ", email=" + email + ", name=" + name + ", address=" + address + ", regDate=" + regDate + ", lastOnlineDate=" + lastOnlineDate + ", deleteDate=" + deleteDate + '}';
    }

   
   
}