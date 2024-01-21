package com.pranav.roche.service;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pranav.roche.payload.RequestFB;

@Service
public interface FBService {
     String testFB();

     List<String> homeFB(RequestFB rfb);
     
     //dbops();
     //statFB();
     

}
