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
public class CandidateShow extends HttpServlet {
    public  String candidatename,phone,email;
    int totalvote=0;
    int yourvote=0;
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
            try
            {    
               HttpSession session=request.getSession(false);
               String usertype=(String)session.getAttribute("usertype");
             if(usertype.trim().equalsIgnoreCase("candidate"))
             {
                     String name=request.getParameter("username");
                     System.out.println("name of the candidate to login="+name);
                     String id = name.substring(5, name.length());
                            System.out.println("name of the candidate to login after the substring="+id);
                         try {
                               database db=new database();
                               Connection con=db.getCon();
                               PreparedStatement ps1 = con.prepareStatement("select  * from candidate where ID =?");
		               ps1.setString(1,id);
		               ResultSet rs = ps1.executeQuery();
                               System.out.println("ID OF THE CANDIDATE"+id);
		           if(rs.next())
                           {
                                            candidatename= rs.getString("NAME");
                                            phone= rs.getString("PHONE_NO"); 
                                            email= rs.getString("EMAIL_ID");
                           }
                           ps1=con.prepareStatement("select  count(*) from voting");
                           System.out.println("777777777777");
                           rs = ps1.executeQuery();
                           if(rs.next())
                           {
                               totalvote=rs.getInt(1);
                           }
                           ps1=con.prepareStatement("select  count(*) from voting where CANDIDATE_ID =?");
                           ps1.setString(1,id);
                           rs = ps1.executeQuery();
                           if(rs.next())
                           {
                               yourvote=rs.getInt(1);
                           }
                        }
                     catch(Exception e)
                         {
                             System.out.println("Exception "+e);
                         }
                      PrintWriter out= response.getWriter();
                      Candidate can =new  Candidate();
                      String a= can.display(id, candidatename, phone, email, totalvote,yourvote);
                      out.print(a);

             }else
             {
                response.sendRedirect("Logout");
             }
    }catch(Exception e)
    {
     response.sendRedirect("Logout");
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
