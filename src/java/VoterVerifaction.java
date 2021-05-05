/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUCHI
 */
public class VoterVerifaction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session=request.getSession();  
           String name=(String)session.getAttribute("usertype");
        if(name.trim().equalsIgnoreCase("voter")){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String output="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>2-Step Verification</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"      <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" +
"         <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" +
"         <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"         <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n" +
"         <style>\n" +
"              \n" +
"         </style>\n" +
"   </head>\n" +
"     <body>\n" +
"         <div><h1 style=\"text-align:center;  background-color: #ccccff; margin-top: 0px; padding-top: 25px; padding-bottom: 25px;\"> Welcome To Online Voting System</h1></div>\n" +
"         <div class=\"container\">\n" +
"	<div class=\"row\">\n" +
"		<div class=\"col-md-4 col-md-offset-4\">\n" +
"            <div class=\"panel panel-default\">\n" +
"              <div class=\"panel-body\">\n" +
"                <div class=\"text-center\">\n" +
"                  <h3><i class=\"fa fa-lock fa-4x\"></i></h3>\n" +
"                  <h2 class=\"text-center\">2 Step Verification</h2>\n" +
"                  <p>Enter Your OTP For validation</p>\n" +
"                  <div class=\"panel-body\">\n" +
"                     <form  autocomplete=\"off\" class=\"form\" action=\"VoterValidation\" method=\"post\">\n" +
"                      <div class=\"form-group\">\n" +
"                        <div class=\"input-group\">\n" +
"                          <span class=\"input-group-addon\"><i class=\"fa fa-lock\"></i></span>\n" +
"                          <input id=\"email\" name=\"otp\" placeholder=\"Enert OTP\" class=\"form-control\"  type=\"text\" required=\"\">\n" +
"                        </div>\n" +
"                      </div>\n" +
"                      <div class=\"form-group\">\n" +
"                        <input class=\"btn btn-lg btn-primary btn-block\" value=\"Submit OTP\" type=\"submit\">\n" +
"                      </div>\n" +
"                    </form>\n" +
"    \n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>\n" +
"	</div>\n" +
"</div>\n" +
"     </body>\n" +
"</html>\n" +
"";
        out.print(output);
    }
        else
        {
          response.sendRedirect("index.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
