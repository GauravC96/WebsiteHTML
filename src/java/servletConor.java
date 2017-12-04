import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

public class servletConor extends HttpServlet {

    //Wrapper for S3
    S3Wrapper s3Wrapper;
    
    
   //@WebServlet(urlPatterns = {"ConorMcgregor"})
    protected void processConor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        s3Wrapper = new S3Wrapper();
        String retrievedmyConorObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myConorObj.json");         
//        String retrievedmyJonJones = s3Wrapper.getStringObject("miniprojectufcwebsite", " myJonObj.json");
//        String retrievedmyDemetriousObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myDemetriousObj.json");
//        String retrievemyGeorgeObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myGeorgeObj.json");
//        String retrievedmyAndersonObj = s3Wrapper.getStringObject("miniprojectufcwebsite", "myAndersonObj.json");

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           out.println(retrievedmyConorObj);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processConor(request, response);
    
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