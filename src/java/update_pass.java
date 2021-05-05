import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RUCHI
 */
public class update_pass extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password=request.getParameter("password");
        String ID=request.getParameter("ID");
         // if the user is voter
               database db=new database();
               Connection con=db.getCon();
               if(ID.equalsIgnoreCase("voter"))
               {           
               try
               {
                         PreparedStatement ps = con.prepareStatement("update voter set PASSWORD = ? where ID = ?");
                         ps.setString(1,password);      //password
                         ps.setString(2,ID);
			 ps.executeUpdate();
                         
               }
                  catch(   SQLException | HeadlessException ex1)
                         {
	                      System.out.println("sql exception");
			      System.out.println(ex1);
			 }
               }
               else if(ID.equalsIgnoreCase("candi"))   // if candidate then
               {try{
                    
                    PreparedStatement ps1 = con.prepareStatement("update candidate set PASSWORD = ? where ID = ?");
                         ps1.setString(1,password);      //password
                         ps1.setString(2,ID);
			 ps1.executeUpdate();
               }
                  catch(SQLException | HeadlessException ex1)
                         {
	                      System.out.println("sql exception");
			      System.out.println(ex1);
			 }
               }


                        
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_pass</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update_pass at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
