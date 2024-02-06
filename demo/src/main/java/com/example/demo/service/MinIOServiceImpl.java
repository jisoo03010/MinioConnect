package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.lang.String;	
@Service
public class MinIOServiceImpl implements MinIOService{

    @Override
    public String joinMinIO() throws Exception {
        System.out.println("버킷 조인 ");
        String str = "abc";
        return str;
    }
    
}
