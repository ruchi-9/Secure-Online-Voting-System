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
public class result extends HttpServlet {
public  String can[]=new String[10];
public  String canid[]=new String[10];
public  int yourvote[]=new int[10];
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id;
        int totalvote=0,i=0;
          PrintWriter out= response.getWriter();
        try {
                               database db=new database();
                               Connection con=db.getCon();
                          
                           PreparedStatement ps1=con.prepareStatement("select  count(*) from voting");
                           System.out.println("counting query");
                           ResultSet rs = ps1.executeQuery();
                           if(rs.next())
                           {
                               totalvote=rs.getInt(1);
                           }
                           PreparedStatement ps = con.prepareStatement("select  * from candidate");
                		       ResultSet rs1 = ps.executeQuery();
                                       System.out.println("candidate query");
		                    while(rs1.next())
		        	        {   
                                            System.out.println("value of i="+i);  
                                            can[i]= rs1.getString("NAME"); 
                                            canid[i]= rs1.getString("ID"); 
                                            System.out.println("name is"+can[i]);
                                            System.out.println("ID of candidate is"+canid[i]);    
                                             i++;
                                        } 
                           ps1=con.prepareStatement("select count(*) from voting where CANDIDATE_ID=?");
                           for(int q=0;q<i;q++)
                           {
                           ps1.setString(1,canid[q]);
                           System.out.println("candidate id ="+canid[q]);
                           rs1 = ps1.executeQuery();
                           while(rs1.next())
                           {
                               yourvote[q]=rs1.getInt(1);
                           }}
                          
                           for(int q=0;q<i;q++){
                            out.print(can[q]+"="+yourvote[q]+"   ");
                        }
                                out.print("total vote is ="+totalvote);
        }
                     catch(Exception e)
                         {
                             System.out.println("Exception "+e);
                         }
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet result</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet result at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
}
