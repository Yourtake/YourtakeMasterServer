/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yourtake.controller.web;

import com.yourtake.init.DBInit;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author MumbaiZone
 */
@Controller
public class InitController {
     public InitController() {
    }
    
     @RequestMapping(value="/")
   public ModelAndView sendHomePage(HttpServletRequest request){
       return new ModelAndView("home");
   }
     
     
    @PostConstruct
    public void init() {
        DBInit.main(null);
    }
    
    
}
