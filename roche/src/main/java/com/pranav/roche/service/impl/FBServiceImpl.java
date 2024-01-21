package com.pranav.roche.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pranav.roche.model.Stat;
import com.pranav.roche.payload.RequestFB;
import com.pranav.roche.repository.*;
import com.pranav.roche.service.FBService;

@Service
public class FBServiceImpl implements FBService{

    @Autowired
    private StatRepository statRepository;

    public String testFB(){  
        System.out.println("Test Okay");
        return "Test Okay";
    }

    public List<String> homeFB(RequestFB rfb){
        //conditionals to check existance and count 
        /**
         *  if (exist1(rfb)){
         *  count++;
         *  update(rfb,count); 
         * }
         *  else{
         *      System.out.println("Save New");
         *      dbops(rfb,1);
         *  }
         * 
         * **/ 

        
        dbops(rfb,1);


        List<String> ls = new ArrayList<String>();
        int limit = rfb.getLimit();
        int int1 = rfb.getInt1(); 
        int int2 = rfb.getInt2(); 
        String str1 = rfb.getStr1(); 
        String str2 = rfb.getStr2();

        for(int i=1;i<=limit;i++){
            if(i % (int1*int2)==0){
                System.out.println(str1+str2);
                ls.add(str1+str2);
                continue;
             }
            if(i%int1==0){
                System.out.println(str1);
                ls.add(str1);
                continue;
            }
            if(i%int2==0){
                System.out.println(str2);
                ls.add(str2);
                continue;
            }
            ls.add(Integer.toString(i));
        }
        return ls;
    }

    public void dbops(RequestFB rfb, int count){
        Stat s= new Stat();
        s.setInt1(rfb.getInt1());
        s.setInt2(rfb.getInt2());
        s.setLimit(rfb.getLimit());
        s.setStr1(rfb.getStr1());
        s.setStr2(rfb.getStr2());
        s.setCount(count);
        statRepository.save(s);
        System.out.println("request saved");
    }

    public boolean exist1(RequestFB rfb){
        int i1=rfb.getInt1();
        int i2=rfb.getInt2();
        int l=rfb.getLimit();
        String s1=rfb.getStr1();
        String s2=rfb.getStr2();
        List<Stat> all= statRepository.findAll();
        List<Stat> match1=all.stream()
                            .filter(p -> p.getInt1()==i1)
                            .filter(p-> p.getInt2()==i2) 
                            .filter(p->p.getLimit()==l) 
                            .filter(p->p.getStr1()==s1)
                            .filter(p->p.getStr2()==s2)
                            .limit(1).collect(Collectors.toList());
        if(match1.size()==1){
            return true;
        }
        else{
            return false;
        }
        //statRepository.exists(rfb);     
    }
    public void update1(RequestFB rfb, int c){
        Stat s= new Stat();
        //statRepository.save(null);
        statRepository.save(s);
    }
    public Stat statFB(){  
        System.out.println("Statistics");
        List<Stat> all= statRepository.findAll();
        return "Test Okay";
    }
}
