package com.bucket;

public enum BucketName {
    PROFILE_IMAGE("gizemscode-aws-upload-123");
    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }
    public String getBucketName(){
        return bucketName;
    }
}
