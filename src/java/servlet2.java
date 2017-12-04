import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

public class servlet2 extends HttpServlet {

    //Wrapper for S3
    S3Wrapper s3Wrapper;
    
    
   //@WebServlet(urlPatterns = {"ConorMcgregor"})
    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyJonJones = s3Wrapper.getStringObject("miniprojectufcwebsite", "myJonObj.json");

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           out.println(retrievedmyJonJones);

        }
    }
   
//    protected void processJon(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        s3Wrapper = new S3Wrapper();
//        String retrievedmyJonJones = s3Wrapper.getStringObject("miniprojectufcwebsite", " myJonObj.json");
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//           out.println(retrievedmyJonJones);
//
//        }
//    }
//
//    protected void processDemetrious(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        s3Wrapper = new S3Wrapper();
//        String retrievedmyDemetriousObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myDemetriousObj.json");
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println(retrievedmyDemetriousObj);
//
//        }
//    }
//
//    protected void processGeorge(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        s3Wrapper = new S3Wrapper();
//        String retrievemyGeorgeObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myGeorgeObj.json");
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println(retrievemyGeorgeObj);
//
//        }
//    }
//    protected void processAnderson(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        s3Wrapper = new S3Wrapper();
//        String retrievedmyAndersonObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myAndersonObj.json");
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println(retrievedmyAndersonObj);
//
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    
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