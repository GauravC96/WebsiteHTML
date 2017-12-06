
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

public class servlet1 extends HttpServlet {

    //Wrapper for S3
    S3Wrapper s3Wrapper;

    //@WebServlet(urlPatterns = {"ConorMcgregor"})
    protected void processConor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyConorObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myConorObj.json");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyConorObj);

        }
    }
    
        protected void processJon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyJonObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myJonObj.json");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyJonObj);

        }
    }
         protected void processDemetrious(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyDemetriousObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myDemetriousObj.json");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyDemetriousObj);

        }
    }
         
          protected void processGeorge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyGeorgeObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myGeorgeObj.json");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyGeorgeObj);

        }
    }
          
              protected void processAnderson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyAndersonObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myAndersonObj.json");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(retrievedmyAndersonObj);

        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String queryStr = request.getQueryString();
        if (queryStr == null) {
            return;
        }

        if (queryStr.equals("conor")) {
            processConor(request, response);
        } else if (queryStr.equals("jon")) {
           processJon(request, response);
        } else if (queryStr.equals("demetrious")) {
            processDemetrious(request, response);
        } else if (queryStr.equals("george")) {
            processGeorge(request, response);
        }else if (queryStr.equals("anderson")) {
            processAnderson(request, response);
    }
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
