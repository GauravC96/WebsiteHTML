/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.nio.charset.StandardCharsets;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class S3Wrapper {

    //Amazon S3 service instance used by this class
    AmazonS3 s3;

    //Constructor
    public S3Wrapper() {

        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (~/.aws/credentials), and is in valid format.",
                    e);
        }

        s3 = new AmazonS3Client(credentials);
    }

    private boolean bucketExists(String firstPartBucketName) {
        List<Bucket> bucketList = s3.listBuckets();
        for (Bucket bucket : bucketList) {
            if (bucket.getName().indexOf(firstPartBucketName) >= 0) {
                return true;
            }
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
    }//one minute , it was fuking working a minute ago fuking java

    public String downloadObject(String bucketName, String key) {
        String stuff = "";
        System.out.println("Downloading an object");
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
        //String stuff = ("Content-Type: " + object.getObjectMetadata().getContentType());
        try {
            stuff = displayTextInputStream(object.getObjectContent());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return stuff;
    }

    public void addStringObject(String bucketName, String key, String string) {
        //Convert string to InputStream
        byte[] stringBytes = string.getBytes(StandardCharsets.UTF_8);
        InputStream stream = new ByteArrayInputStream(stringBytes);

        //Create metadata in which we specify the string length
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(stringBytes.length);

        //Upload InputStream
        PutObjectRequest request = new PutObjectRequest(bucketName, key, stream, metadata);
        s3.putObject(request);
        System.out.println("Added object from string. BucketName: " + bucketName + "; key: " + key + "; String: " + string);
    }

    private static String displayTextInputStream(InputStream input) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println("    " + line);
        }
        System.out.println();
        return line;
    }

    public String getStringObject(String bucketName, String key) {
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

}
