package com.example.demo.service;
import java.util.ArrayList;

import java.lang.String;
import java.util.List;

import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;	

public interface MinIOService {
    MinioClient joinMinIO() throws Exception;

    // bucket 관련 
    ArrayList<String> bucketList() throws Exception;
    String bucketMake(String bucketName) throws Exception;
    String bucketRemove(String bucketName) throws Exception;

    // object 관련 
    Iterable<Result<Item>> objectList(String bucketName) throws Exception;
}
