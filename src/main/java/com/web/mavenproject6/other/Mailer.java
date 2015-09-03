/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.other;
//
//import org.springframework.mail.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.stereotype.Component;
/**
 *
 * @author Aleks
 */

@Component
public class Mailer {

    private MailSender mailSender;

    @Autowired
    @Qualifier("mailSender")
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String from, String to, String subject, String msg) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
      
        mailSender.send(message);
    }
}
