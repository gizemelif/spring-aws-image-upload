package com.fileStore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileStore {
    private final AmazonS3 s3;

    //AmazonS3 sınıfı tipinde bir nesne alan bu cons ile dependency injection yapılır. Autowired annotation sayesinde
    //inject edilen sınıfın metotlarına doğrudan erişebiliriz.
    @Autowired
    public FileStore(AmazonS3 s3){
        this.s3 = s3;
    }

    //This method, that saves files files to Amazon S3.
    //Kaydedeceğimiz bucket için path ve kaydedilecek dosyanın adını alır.
    //InputStream is what gets saved to AmazonS3 bucket
    public void save(String path, String fileName,
                     Optional<Map<String, String>> optionalMetadata,
                     InputStream inputStream){
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetadata.ifPresent(map->{
            if(!map.isEmpty()){
                map.forEach(metadata::addUserMetadata);
            }
        });
        try{
            s3.putObject(path, fileName, inputStream, metadata);
        }catch (AmazonServiceException ex){
            throw new IllegalStateException("Failed to store file to s3", ex);
        }
    }
}
