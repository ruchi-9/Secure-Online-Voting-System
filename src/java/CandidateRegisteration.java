import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CandidateRegisteration extends HttpServlet 
{
    String ID,PASSWORD;
    String output="";
    private database db=new database();
    Connection con=db.getCon();
    PreparedStatement ps=null,ps1=null;
    ResultSet rs=null;
    Password pass = new Password();
    Encription encription = new Encription();
    CandidateRegisterationDisplay candidateRegisterationDisplay= new CandidateRegisterationDisplay();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out= response.getWriter();
        try{
        int mailflag=0,phoneflag=0,errorflag=0;
        String name=request.getParameter("name");
        String Gender=request.getParameter("gender");
        String E_mail=request.getParameter("Email");
        String phone_no=request.getParameter("PHONENO");
        System.out.println("Candidate name"+name);
        System.out.println("Candidate gender"+Gender);
        System.out.println("Candidate email"+E_mail);
        System.out.println("Candidate phone"+phone_no);
        // check mail and password into database
        try
        {
            //check mail id is already available or not 
            ps = con.prepareStatement("select * from candidate where EMAIL_ID=? ");
            
            ps.setString(1,E_mail);
            rs = ps.executeQuery();
            System.out.print("in mail flag cand");
            if(rs.next())
            {
                mailflag=1;
                System.out.print("in mail flag cand1111"+mailflag+"  "+rs);
            }
            rs=null;
            System.out.print(mailflag+"  "+rs);
            // check phone number already available or not 
            ps = con.prepareStatement("select * from candidate where PHONE_NO=? ");
            ps.setString(1, phone_no);
            rs = ps.executeQuery();
            if(rs.next())
            {
                phoneflag=1;
                System.out.print(mailflag+"  "+rs);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("phone numebr exception "+e);
        }
            //insert data into database
            if(mailflag==0&&phoneflag==0)
            {
                try
                {
                    //save information to the databse
                    ps = con.prepareStatement("insert into candidate (NAME,EMAIL_ID,PHONE_NO,GENDER ) values(?,?,?,?)");
                    ps.setString(2,E_mail); 
                    ps.setString(1,name);
                    ps.setString(3, phone_no); 
                    ps.setString(4,Gender);
                    System.out.println("save information ");
                    ps.executeUpdate();
                    //get id from databse
                    ps1 = con.prepareStatement("select ID from candidate where PHONE_NO=? and EMAIL_ID=?");
                    ps1.setString(1, phone_no);
                    ps1.setString(2,E_mail);
                    rs= ps1.executeQuery();
                    
                    if(rs.next())
                    {
                        ID= rs.getString("ID");
                    }
                    ID="CANDI"+ID;
                    PASSWORD=pass.GenratePassword(6);  // generate the password randomly
                    String password=PASSWORD;
                    byte[] random = new byte[32];
                     SecureRandom csprng = new SecureRandom();
                csprng.nextBytes(random);
                System.out.println(random);
                String salt=new String(random);
               password+=salt;
                 System.out.println("........................"+password);
                 password = encription.Password(password);   //encrypt the password
                    ps = con.prepareStatement("update candidate set PASSWORD=?,SALT=? where PHONE_NO=? and EMAIL_ID=?");
                    ps.setString(1,password);
                    ps.setString(2,salt);
                    ps.setString(3, phone_no);
                    ps.setString(4,E_mail);
                    ps.executeUpdate();
                    System.out.println("before mail");
                    //send username and passwrod to voter usign mail 
                    mail m = new mail(E_mail,"DETAIL FOR LOGIN IN VOTING PROJECT","<h2>ThankYou For registration <br> UserName: "+ID+"<br>Password:"+PASSWORD+"</h2>");
                    response.sendRedirect("admin");
                    //PrintWriter out= response.getWriter();
                    //out.println("{\"enter data sucessful\"}");  
                }  
                catch(Exception ex1)
                {
                    System.out.println("sql exception");
                    System.out.println("inner catch");
                    System.out.println(ex1);
                    out.println("SOMETHING IS WRONG");
                }
            }
            else
            {
                
                output= candidateRegisterationDisplay.display(mailflag,E_mail, phoneflag,phone_no,name);
                System.out.println("else part ");
                out.print(output);
                System.out.println("else part ");
            }
    } catch(Exception e ){System.out.print("can final excception "+e);}
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
