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
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUCHI
 */
public class VerifyPassword extends HttpServlet {

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
           response.setContentType("text/html;charset=UTF-8");
                 database db=new database();
                 VerifyPasswordDisplay VPD = new VerifyPasswordDisplay();
                 Connection con=db.getCon();
                 PrintWriter out = response.getWriter();
                 try
                 {
                 HttpSession session=request.getSession(false);
                 String usertype=(String)session.getAttribute("usertype");
                 usertype=usertype.trim();
                 String message="";
                 String username=(String)session.getAttribute("userid");
                 username = username.trim();
                 username = username.substring(5, username.length());
                 System.out.print("username in verify password \t"+username);
                 System.out.print("usertype in verify password\t"+usertype);
                  Encription encription = new Encription();
                 String oldpassword =request.getParameter("oldpassword").trim();
                 String newpassword =request.getParameter("txtPassword").trim();
                 newpassword=encription.Password(newpassword).trim();
            
                 if(usertype.equalsIgnoreCase("candidate"))
                 {
                     try{
                         PreparedStatement ps1 = con.prepareStatement("select  * from candidate where ID =?");
		               ps1.setString(1,username);
		               ResultSet rs = ps1.executeQuery();
                               if(rs.next())
                               {
                                   String password=rs.getString("PASSWORD");
                                   password = encription.Password(password).trim();
                                 if(password.equals(oldpassword))
                                  {
                                   PreparedStatement   ps = con.prepareStatement("update candidate set PASSWORD=? where ID=?");
                                   ps.setString(1,newpassword);
                                   ps.setString(2,username);
                                   ps.executeUpdate();
                                   response.sendRedirect("Logout");
                                  }
                                 else
                                 {
                                     message="Incorrect Password";
                                     VPD.Display(message);
                                 }
                               }
                               else
                               {
                                   response.sendRedirect("Logout");
                               }
                     }catch(Exception e)
                     {
                      System.out.print("update password candidate\n"+e);
                     }      
                 }
                 else if(usertype.equalsIgnoreCase("voter"))
                 {
                     try
                     {
                         PreparedStatement ps1 = con.prepareStatement("select * from voter where ID =?");
		               ps1.setString(1,username);
		               ResultSet rs = ps1.executeQuery();
                               if(rs.next())
                               {
                               String password=oldpassword;
                                   password = encription.Password(password).trim();
                                System.out.print(password);
                                if(rs.getString("PASSWORD").equals(password))
                                  { 
                                   PreparedStatement   ps = con.prepareStatement("update voter set PASSWORD=? where ID=?");
                                   ps.setString(1,newpassword);
                                   ps.setString(2,username);
                                   ps.executeUpdate();
                                   System.out.print("update password voter 1111111111");
                                   
                                   response.sendRedirect("Logout");
                                  }
                                else
                                {
                                  message="Incorrect Password";
                                  VPD.Display(message);
                                }
                               }
                               else{response.sendRedirect("Logout");}
                               
                     }catch(Exception e)
                     {
                      System.out.print("update password voter \n"+e);
                     }      
                 }
                
                 else
                 {
                 
                 }
                 }catch(Exception ee){response.sendError(404);}
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
