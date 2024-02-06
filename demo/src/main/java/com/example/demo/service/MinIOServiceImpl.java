package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import java.util.ArrayList;

import io.minio.ListObjectsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;

import java.lang.String;
import java.util.List; 

@Service
public class MinIOServiceImpl implements MinIOService {

    // 중복 코드 추출
    private MinioClient getMinioClient() throws Exception {
        return MinioClient.builder()
                .endpoint("http://127.0.0.1:9000")
                .credentials("GupkDrAzlb8NtAKC60mA", "NhBPm3pMzNWtn0uPgrerCj43Hg5nRVipJ3bxva5x")
                .build();
    }

    @Override
    public MinioClient joinMinIO() throws Exception {
        return getMinioClient();
    }

    @Override
    public ArrayList<String> bucketList() throws Exception {
        MinioClient minioClient = getMinioClient();
        List<Bucket> bucketList = minioClient.listBuckets();
        ArrayList<String>  bucketListArray = new ArrayList<String> ();
        for (Bucket bucket : bucketList) {
            bucketListArray.add(bucket.name());
        }
        return bucketListArray;
    }
    @Override
    public String bucketMake(String bucketName) throws Exception {
        MinioClient minioClient = getMinioClient();
        minioClient.makeBucket( MakeBucketArgs.builder()
            .bucket(bucketName)
            .build());

        return "성공적으로 Bucket이 생성되었습니다.";
    }
    @Override
    public String bucketRemove(String bucketName) throws Exception {
        MinioClient minioClient = getMinioClient();
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        return "성공적으로 Bucket이 생성되었습니다.";
    }
    @Override
    public Iterable<Result<Item>> objectList(String bucketName) throws Exception {
        MinioClient minioClient = getMinioClient();
       Iterable<Result<Item>> results = minioClient.listObjects(
            ListObjectsArgs.builder().bucket(bucketName).build());
        return results;
    }
}
