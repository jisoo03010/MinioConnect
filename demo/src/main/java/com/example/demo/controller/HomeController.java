package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MinIOServiceImpl;


// 서버 모니터링 추출 관련
@Controller
public class HomeController {

	@RequestMapping("/")
	public String Index() {
		return "index";
	}

	@Autowired
	MinIOServiceImpl minIOServiceImpl;

	@ResponseBody
	@RequestMapping(value = "/testList", method = { RequestMethod.GET })
	public String testList() throws Exception {
		String d = minIOServiceImpl.joinMinIO();
		return d;
    }
	
}