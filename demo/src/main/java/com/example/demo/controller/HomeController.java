package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MinIOServiceImpl;
import java.lang.String;

import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;

import java.util.List;	
import java.util.ArrayList;

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
	@RequestMapping(value = "/bucketList", method = { RequestMethod.GET })
	public ArrayList<String> testList() throws Exception {
		return minIOServiceImpl.bucketList();
    }
	 
	@ResponseBody
	@RequestMapping(value = "/bucketMake", method = { RequestMethod.GET })
	public String bucketMake(@RequestBody String BucketName) throws Exception {
		return minIOServiceImpl.bucketMake(BucketName);
    }
	@ResponseBody
	@RequestMapping(value = "/bucketRemove", method = { RequestMethod.GET })
	public String bucketRemove(@RequestBody String BucketName) throws Exception {
		return minIOServiceImpl.bucketRemove(BucketName);
    }
	@ResponseBody
	@RequestMapping(value = "/objectList", method = { RequestMethod.GET })
	public Iterable<Result<Item>> objectList(@RequestBody String BucketName) throws Exception {
		return minIOServiceImpl.objectList(BucketName);
    }
	@ResponseBody
	@RequestMapping(value = "/objectMake", method = { RequestMethod.GET })
	public String objectMake(@RequestBody String bucketName,@RequestBody  String objectName,@RequestBody String fileName) throws Exception {
		return minIOServiceImpl.objectMake( bucketName, objectName, fileName);
    }


	@ResponseBody
	@RequestMapping(value = "/objectRemove", method = { RequestMethod.GET })
	public String objectRemove(@RequestBody String BucketName, @RequestBody  String objectName) throws Exception {
		return minIOServiceImpl.objectRemove(BucketName,objectName);
    }
	
}