// In this file Registeration of Voter is done .
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VoterRegister extends HttpServlet {
    // Declaration of variables
String ID,MAILSTRING;
String output="";
private database db=new database();
Connection con=db.getCon();
PreparedStatement ps =null;
ResultSet rs=null;
Password pass = new Password();
PrintWriter out= null;
String vid="";
Encription encription = new Encription();
VoterRegistrationDisplay voterRegistrationDisplay = new VoterRegistrationDisplay();
static double x ;
byte[] random = new byte[10];
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int mailflag=0,phoneflag=0,errorflag=0;
                String phone_no ="";
                out =response.getWriter();
                //getting the details from user interface
                String name=request.getParameter("username").trim();
                String Gender=request.getParameter("gender").trim();
                phone_no=request.getParameter("PHONENO").trim();
                String E_mail=request.getParameter("EMAIL").trim();
                String password=request.getParameter("txtPassword").trim();
                //generate random number for the salt.
                SecureRandom secure_rand = new SecureRandom();
                secure_rand.nextBytes(random);
                System.out.println(random);
                String salt=new String(random);
                 System.out.print("salt is "+salt);
                password+=salt;
                // password is encripted by the MD5
                 password = encription.Password(password);
                 System.out.print("password length is "+password.length());
                 //checking whether the voter is already register or not
                 try
                {
                    //check mail id is already available or not
                 ps = con.prepareStatement("select * from voter where EMIAL_ID=? ");
                 ps.setString(1,E_mail);
                 rs = ps.executeQuery();
                 //check for every row in database
                 if(rs.next())
                 {
                     mailflag=1;
                     System.out.print(mailflag+"  "+rs);
                 }
                 rs=null;
                 System.out.print(mailflag+"  "+rs);
                 // check phone number already available or not
                 ps = con.prepareStatement("select * from voter where PHONE_NO=? ");
                 ps.setString(1, phone_no);
                 rs = ps.executeQuery();
                 if(rs.next())
                 {
                     phoneflag=1;
                 System.out.print(phoneflag+"  "+rs);
                 }
                }
                catch(Exception e)
                {
                System.out.println("phone number exception "+e);
                }
                
                //insert data into database if already not present
                  if(mailflag==0&&phoneflag==0)
                  {
                   try
                    {
                        //save information into database
                        ps= con.prepareStatement("insert into voter (NAME,PHONE_NO,GENDER,EMIAL_ID,PASSWORD,SALT ) values(?,?,?,?,?,?)");
                        ps.setString(1, name);     
                        ps.setString(2, phone_no); 
			ps.setString(3,Gender);
		        ps.setString(4,E_mail);
		        ps.setString(5,password);
                        ps.setString(6,salt);
			ps.executeUpdate();
                        //get id from dataabse
                        ps = con.prepareStatement("select ID from voter where PHONE_NO=? or EMIAL_ID=?");
                        ps.setString(1, phone_no);
                        ps.setString(2,E_mail);
                        ResultSet rs1 = ps.executeQuery();
                        if(rs1.next())
                          {
                               ID= rs1.getString("ID");

                          }
                         vid=ID;
                         ID="voter"+ID;
                         MAILSTRING=pass.GenratePassword(6);
                         System.out.println("before mailstring done");
                         ps = con.prepareStatement("update voter set MAILSTRING=? where PHONE_NO=? and EMIAL_ID=?");
                         ps.setString(1,MAILSTRING);
                         ps.setString(2, phone_no);
                         ps.setString(3,E_mail);
                         ps.executeUpdate();
                         //send username and activation link in the email
                         mail m = new mail(E_mail,"DETAIL FOR LOGIN IN VOTING PROJECT","<h2>ThankYou For registration <br> UserName: "+ID+"<br>Activation <br>http://localhost:8080/voting/Activation?id="+vid+"&verc="+MAILSTRING+"</h2>");
                         response.sendRedirect("index.html");
                     }
                     catch(SQLException | IOException ex1 )
                         {
	                      System.out.println("sql exception");
			      System.out.println("inner catch");
                              System.out.println(ex1);
                              out.println("SOMETHING IS WRONG");
                         }
                  }
                  else
                  {
                   output= voterRegistrationDisplay.display(mailflag,E_mail, phoneflag,phone_no,name);
                   out.println(output);
                  }
    }
  @Override
    public String getServletInfo() {
        return "Short description";
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet voter_reg</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet voter_reg at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {processRequest(request, response);

			   }


}
