/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Users;
import com.web.mavenproject6.service.UserServiceImp;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Aleks
 */
@Controller
public class MainController {
    @Autowired
    private Environment env;
    
    @Autowired
    UserServiceImp userServiceImp; 
    
    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView defaultPage() throws ArithmeticException {

            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Login Form - Database Authentication");
            model.addObject("message", "This is default page!");
            model.setViewName("thy/home");
           return model;

    }
        
   
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Login Form - Database Authentication");
            model.addObject("message", "This page is for ROLE_ADMIN only!");
            model.setViewName("jsp/admin");
            return model;

    }

    
   @RequestMapping(value = "/404", method = RequestMethod.GET)
    public ModelAndView ex404() {
            return new ModelAndView("thy/404");            
    }
    
  
    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public ModelAndView ex500() {  
        return new ModelAndView("thy/500");        
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
            
            for(Users u:userServiceImp.list()){
                System.err.println(u.toString());
            }
            ModelAndView model = new ModelAndView();
            if (error != null) {
                  model.addObject("error", "Invalid username and password!");
            }

            if (logout != null) {
                  model.addObject("msg", "You've been logged out successfully.");
            }
            model.setViewName("thy/login");

            return model;

    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

            ModelAndView model = new ModelAndView();

            //check if user is login
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                  UserDetails userDetail = (UserDetails) auth.getPrincipal();	
                  model.addObject("username", userDetail.getUsername());
            }

            model.setViewName("thy/403");
            return model;

    }
    

    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Data integrity violation")
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);  
            //mav.addObject("errorcode", "404");
            mav.setViewName("jsp/403");
            return mav;
    }
    

}
