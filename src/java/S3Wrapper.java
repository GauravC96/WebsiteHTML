/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.ByteArrayInputStream;
import java.util.UUID;
import java.util.List;
import java.nio.charset.StandardCharsets;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.ObjectMetadata;


public class S3Wrapper {
    
    //Amazon S3 service instance used by this class
    AmazonS3 s3;
    
    
    //Constructor
    public S3Wrapper(){

        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } 
        catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
        }

        s3 = new AmazonS3Client(credentials);
    }


       private boolean bucketExists(String firstPartBucketName){
        List<Bucket> bucketList = s3.listBuckets();
        for (Bucket bucket : bucketList) {
            if(bucket.getName().indexOf(firstPartBucketName) >= 0)
                return true;
        }
        return false;
    }

    public String getdownloadObject(String bucketName, String key) {
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
        BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
        //Read the string from the input stream
        try {
            String tmpStr = "";
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                tmpStr += line;
            }
            return tmpStr;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public void downloadObject(String bucketName, String key) {
        System.out.println("Downloading an object");
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
        System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
        try {
            displayTextInputStream(object.getObjectContent());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println("    " + line);
        }
        System.out.println();
    }

}


    
