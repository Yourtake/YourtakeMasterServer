/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.controller.web;

import com.yourtake.init.DBInit;
import com.yourtake.model.dao.GenericDAO;
import com.yourtake.model.pojo.users.Individual;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author MumbaiZone
 */
@Controller
public class InitController {
    
    @Autowired
    @Qualifier("individualDAO")
    GenericDAO dao;
    
     public InitController() {
    }
    
     @RequestMapping(value="/")
   public ModelAndView sendHomePage(HttpServletRequest request){
         System.out.println("Home");
       return new ModelAndView("init");
   }
      @RequestMapping(value="/adminlogin")
   public ModelAndView sendAdminLogin(HttpServletRequest request){
          System.out.println("login");
       return new ModelAndView("adminlogin");
   }
   
     @RequestMapping(value="/admin")
   public ModelAndView sendAdminPage(HttpServletRequest request){
         System.out.println("admin");
       return new ModelAndView("adminpage");
   }
   
   
     
    @PostConstruct
    public void init() {
        DBInit.main(null);
    }
    
    
}
