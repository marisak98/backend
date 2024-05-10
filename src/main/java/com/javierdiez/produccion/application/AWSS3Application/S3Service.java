package com.javierdiez.produccion.application.AWSS3Application;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Log4j2
public class S3Service {
    private AmazonS3 s3Client;

    @Value("${spring.aws.s3.bucket-name}")
    private String bucketName;

    public S3Service(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadFile(String KeyName, MultipartFile file) throws IOException {
        var putObjectResult = s3Client.putObject(bucketName, KeyName, file.getInputStream(), null);
        log.info(putObjectResult.getMetadata());
    }

    public S3Object getFile(String KeyName) {
        return s3Client.getObject(bucketName, KeyName);
    }

}
