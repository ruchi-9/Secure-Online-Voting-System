
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
public class admin extends HttpServlet {
database db=new database();
Connection con=db.getCon();
AdminShow adminShow = new AdminShow();
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

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String name="",phone="",email="",output="";
                PrintWriter out = response.getWriter();
                try{
                HttpSession session=request.getSession(false);
                String usertype=(String)session.getAttribute("usertype");
                String username=(String)session.getAttribute("userid");
             if(usertype.trim().equalsIgnoreCase("admin"))
             {
                 String id = username.substring(0, 5);
                 String idd = username.substring(5, username.length());
                 try
                  {
                      System.out.print("in admin page admin");
                    PreparedStatement ps=con.prepareStatement("select * from admin where ID=?");
                    ps.setString(1,idd);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                        {
                                            name= rs.getString("NAME");
	                                    phone= rs.getString("PHONE_NO"); 
                                            email= rs.getString("EMAIL_ID");
                        }
                      output=adminShow.Display(name, phone, email);
                      out.println(output);
                  }  catch(Exception ex)
              {
                 response.sendRedirect("Logout");
              }
             }
             else
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
}
