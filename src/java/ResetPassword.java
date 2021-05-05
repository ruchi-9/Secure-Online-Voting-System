/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RUCHI
 */
public class ResetPassword extends HttpServlet {
private database db=new database();
Connection con=db.getCon();
PreparedStatement ps =null;
ResultSet rs=null;
String ID,PASSWORD,output="";
Password pass = new Password();
ForgotPassword forgotPassword= new ForgotPassword();

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
                    String invalid="3";
                  PrintWriter out = response.getWriter();
                  String usertype =request.getParameter("usertype");
                  String email=request.getParameter("email");
                  String password="";
                  Encription encription = new Encription();
                  System.out.println("reset email "+email);
                  if(usertype.equalsIgnoreCase("voter"))
                  {
                   try
                    {
                        //check mail id is already available or not 
                        ps = con.prepareStatement("select * from voter where EMIAL_ID=? ");
                        ps.setString(1,email);
                        rs = ps.executeQuery();
                        if(rs.next())
                         {
                           String salt=rs.getString("SALT");
                           PASSWORD=pass.GenratePassword(6);
                           password=PASSWORD+salt;
                           password = encription.Password(password);
                           ps = con.prepareStatement("update voter set PASSWORD=?, INVALID=? where EMIAL_ID=?");
                           ps.setString(1,password);
                           ps.setString(2,invalid);
                           ps.setString(3,email);
                           ps.executeUpdate();
                           //send username and passwrod to voter usign mail 
                           mail m = new mail(email,"DETAIL FOR LOGIN IN VOTING PROJECT","<h2>ThankYou For registration <br> UserName: voter"+rs.getString(7)+"<br>Password:"+PASSWORD+"</h2>");
                           response.sendRedirect("index.html");
                         }
                     else
                      {
                        output=forgotPassword.display(email);
                        out.print(output);
                      }
                    }
                   catch(Exception e)
                    {
                      System.out.println("Email exception "+e);
                    }
                  }
                 else if(usertype.equalsIgnoreCase("candidate"))
                  {
                   try
                     {
                       //check mail id is already available or not 
                      ps = con.prepareStatement("select * from candidate where EMAIL_ID=? ");
                      ps.setString(1,email);
                     
                      rs = ps.executeQuery();
                    
                      if(rs.next())
                         {
                              String salt=rs.getString("SALT");
                           PASSWORD=pass.GenratePassword(6);
                            password=PASSWORD+salt;
                           password = encription.Password(password);
                           
                           ps = con.prepareStatement("update candidate set PASSWORD=?, INVALID=? where EMAIL_ID=?");
        	           ps.setString(1,password);
                           ps.setString(2,invalid);
                           ps.setString(3,email);
                           ps.executeUpdate();
                           
                           //send username and passwrod to voter usign mail 
                           mail m = new mail(email,"DETAIL FOR LOGIN IN VOTING PROJECT","<h2>ThankYou For registration <br> UserName: candi"+rs.getString(6)+"<br>Password:"+PASSWORD+"</h2>");
                         
                           response.sendRedirect("index.html"); 
                         }
                     else
                      {
                        output=forgotPassword.display(email);
                        out.print(output);
                      }
                }
                catch(Exception e)
                {
                System.out.println("Email exception "+e);
                }
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
