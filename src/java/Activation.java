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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *
 * @author RUCHI
 */
public class Activation extends HttpServlet {
private database db=new database();
Connection con=db.getCon();
PreparedStatement ps =null;
ResultSet rs=null;
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
        System.out.println("ACTIVATION FILE IS CALLING");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            int id=0; ;
            try{
                 id=Integer.parseInt(request.getParameter("id").trim());
               }
            catch(Exception e)
              {
             out.print("Error occur "+e);
              }
             String vreg=request.getParameter("verc") ;
             
             //check id is not null
             if(id==0)
             {
              response.sendError(404);
              }
             else
             {
                 try
                 { System.out.println("11111111111111");
                     ps = con.prepareStatement("select MAILSTRING from voter where ID=? ");
                   ps.setInt(1,id);
                   rs = ps.executeQuery();
                   System.out.println("2222");
                  // System.out.println(rs.next());
                   if(rs.next())
                    {
                        String ss= rs.getString(1);
                        System.out.println("password from database"+ss);
                        System.out.println("password from activation"+vreg);
                        System.out.println(ss.equalsIgnoreCase(vreg));
                       if(ss.equalsIgnoreCase(vreg))
                       {  System.out.println("22222222222");
                           ps = con.prepareStatement("update voter set ACTIVATION=1 where ID=?");
                           ps.setInt(1,id);
                           ps.executeUpdate();
                           System.out.println(ps.executeUpdate());
                           System.out.println("333333");
                            out.print("Activation Sucessfully ");
                            System.out.println("ACTIVATION sucesfull");
                           System.out.println("4444");
                           response.sendRedirect("index.html");
                           
                       }
                       else
                       {
                            out.print("Activation Failed ");
                            response.sendRedirect("index.html");
                       }
                    }     
                 } catch(SQLException | IOException e)
               {
                   System.out.println(e);
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
