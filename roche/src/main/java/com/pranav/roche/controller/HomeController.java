package com.pranav.roche.controller;
    
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.roche.model.Stat;
import com.pranav.roche.payload.RequestFB;
import com.pranav.roche.service.FBService;  
    
    @RestController  
    public class HomeController {  
       @Autowired
       FBService fbService; 
        @RequestMapping(value = "/hello", method = RequestMethod.GET)    
        public String hello(){  
            return"Hello!";  
        }
        
        @RequestMapping(value="/fb", method = RequestMethod.POST)
        public List<String> fb(@RequestBody RequestFB rfb){
            List<String> result = fbService.homeFB(rfb);
            return  result;
        }

        @RequestMapping(value = "/statistics", method = RequestMethod.GET)    
        public String stat(){  
            //push new objects with count 1
            //check if object as it is present in DB or not?
            //count increment if exists.
            //or add new object with count 1
            return"Hello!";  
        }

    }  