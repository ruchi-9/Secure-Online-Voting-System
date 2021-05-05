
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUCHI
 */
public class voting extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            HttpSession session=request.getSession(false);  
            String name=(String)session.getAttribute("usertype");
            if(name.trim().equalsIgnoreCase("voter"))
             {
               String voterid=request.getParameter("voterid");
               String candidateid=request.getParameter("voteid");
               System.out.println("AAAAAAAAAAAAAA");
               System.out.println(voterid);
               System.out.println(candidateid);
                   database db=new database();
                   Connection con=db.getCon();
                    try
                      { 
                         PreparedStatement ps = con.prepareStatement("insert into voting(VOTER_ID,CANDIDATE_ID ) values(?,?)");
                         ps.setString(1, voterid);     //id
                         ps.setString(2, candidateid); //phone no
			 ps.executeUpdate();
                         RequestDispatcher rd=request.getRequestDispatcher("voter_show");
                         rd.forward(request, response);
                      }
                     catch(SQLException | HeadlessException ex1)
                         {
	                      System.out.println("sql exception");
			      System.out.println("inner catch");
                              System.out.println(ex1);
	                  }	
             }
             else
             {
               response.sendRedirect("index.html");
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
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet voting</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet voting at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
