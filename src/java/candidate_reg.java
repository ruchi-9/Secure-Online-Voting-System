import java.awt.HeadlessException;
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


public class candidate_reg extends HttpServlet {
static String ID,PASSWORD;
static double x ;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
         String name=request.getParameter("name");
            
              String Gender=request.getParameter("gender");
            String E_mail=request.getParameter("email");
              String phone_no=request.getParameter("phone_no");
                       
            
               database db=new database();
              Connection con=db.getCon();
               try{PreparedStatement ps = con.prepareStatement("insert into candidate (NAME,EMAIL_ID,PHONE_NO,GENDER ) values(?,?,?,?)");
                       ps.setString(2,E_mail); 
                         ps.setString(1,name);      //password
                    	 ps.setString(3, phone_no); //phone no
			 ps.setString(4,Gender); 
		   ps.executeUpdate();
                     PreparedStatement ps1 = con.prepareStatement("select ID from candidate where PHONE_NO=? and EMAIL_ID=?");
                     ps1.setString(1, phone_no);
                      ps1.setString(2,E_mail);
                      ResultSet rs = ps1.executeQuery();
                                     if(rs.next())
                         {
                              ID= rs.getString("ID");
	                                   
                         }
                         ID="CANDIDATE"+ID;
                         getRandomNumber();
                         PASSWORD= Double.toString(x);
                          PreparedStatement ps2 = con.prepareStatement("update candidate set PASSWORD=? where PHONE_NO=? and EMAIL_ID=?");
        			ps2.setString(1,PASSWORD);
                                   ps2.setString(2, phone_no);
                      ps2.setString(3,E_mail);
                                ps2.executeUpdate();
                                             PrintWriter out= response.getWriter();
                 out.println("{\"enter data sucessful\"}");     
                                   }            
                                   
                  catch(   SQLException | HeadlessException ex1)
                         {
	                      System.out.println("sql exception");
						    System.out.println("inner catch");
                                                     System.out.println(ex1);
			              }	
               response.sendRedirect("candidate_reg.html");
    }
    public static double getRandomNumber(){
    
     x=(Math.random()*((100-1)+1))+1;
   
    return x;
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
            out.println("<title>Servlet candidate_reg</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet candidate_reg at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
    }

}
