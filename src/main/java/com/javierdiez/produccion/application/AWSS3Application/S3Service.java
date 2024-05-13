package com.javierdiez.produccion.application.AWSS3Application;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.javierdiez.produccion.domian.planosDomain.Planos;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class S3Service {
    private final AmazonS3 s3Client;

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

   public List<Planos> getDocuments(String blueprintName){
        List<Planos> planos = new ArrayList<>();

       ObjectListing objectListing = s3Client.listObjects(bucketName);
       for (S3ObjectSummary os : objectListing.getObjectSummaries()){
           String fileName = os.getKey().substring(os.getKey().lastIndexOf("/") + 1);
           if (fileName.equals(blueprintName)){
               Planos plano = new Planos();
               plano.setId(Long.parseLong(os.getKey()));
               plano.setName(fileName);
               plano.setS3Url(bucketName + "/" + os.getKey());

               planos.add(plano);
           }
       }
        return planos;
   }
}
