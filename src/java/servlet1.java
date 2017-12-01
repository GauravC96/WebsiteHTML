/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class servlet1 extends HttpServlet {

    //Wrapper for S3
    S3Wrapper s3Wrapper;
    
    

    
    protected void processConor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        downloads.retrievedmyConorObj = s3Wrapper.getdownloadObject("miniprojectufcwebsite", "myConorObj.json");
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
           //out.println(retrievedmyConorObj);

        }
    }
   
    protected void processJon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyJonJones = s3Wrapper.getdownloadObject("miniprojectufcwebsite", " myJonObj.json");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           out.println(retrievedmyJonJones);

        }
    }

    protected void processDemetrious(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyDemetriousObj = s3Wrapper.getdownloadObject("miniprojectufcwebsite", "myDemetriousObj.json");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyDemetriousObj);

        }
    }

    protected void processGeorge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievemyGeorgeObj = s3Wrapper.getdownloadObject("miniprojectufcwebsite", "myGeorgeObj.json");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievemyGeorgeObj);

        }
    }
    protected void processAnderson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyAndersonObj = s3Wrapper.getdownloadObject("miniprojectufcwebsite", "myAndersonObj.json");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyAndersonObj);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processConor(request, response);
        System.out.print(downloads.retrievedmyConorObj);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
