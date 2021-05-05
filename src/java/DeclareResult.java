import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUCHI
 */
public class DeclareResult extends HttpServlet {

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
                 HttpSession session=request.getSession(false);
                 database db=new database();
                 Connection con=db.getCon();
                 System.out.println("aaaaaaaaaaaaaaaaaa");
                  PreparedStatement ps;
                 String s="";
                 String[] ss;
                 int[] a;
                 int canid;
                 //String usertype=(String)session.getAttribute("usertype");
                 String id=(String)session.getAttribute("userid");
                
                  String username = id.substring(0, 5);
                   System.out.println("username is"+username.trim());
                 if(username.trim().equalsIgnoreCase("admin"))
                  { System.out.print("1111111111111");
                     try
                     {
                           ps = con.prepareStatement("SELECT CANDIDATE_ID  FROM voting GROUP BY CANDIDATE_ID HAVING CANDIDATE_ID !=0 and COUNT(VOTING_ID)=(SELECT COUNT(VOTING_ID) vote FROM voting GROUP BY CANDIDATE_ID ORDER BY COUNT(VOTING_ID) DESC LIMIT 1)");
		           ResultSet rs = ps.executeQuery();
                           while(rs.next())
                           {
                            s+=rs.getString(1);
                            s+=",";
                           }
                           System.out.print(s);
                            System.out.print("..........");
                            System.out.print(s);
                           ss= s.split(",");
                           a=Arrays.asList(ss).stream().mapToInt(Integer::parseInt).toArray(); 
                           int rnd = new Random().nextInt(a.length);
                            System.out.print("33333");
                           canid= a[rnd];
                           System.out.print("canid is "+canid);
                           String query="update result set RESULTFLAG=1 , WINNERID="+canid+" where ID=1";
                           System.out.print(query);
                           
                           ps = con.prepareStatement(query);
                           ps.executeUpdate();
                           response.sendRedirect("admin");
                     }
                     catch(Exception e)
                     {
                     response.sendRedirect("admin");
                     }
                     
                 }
                else
                 {
                 
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
