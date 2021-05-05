import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LOGIN extends HttpServlet {
     
Encription encription = new Encription();  

String salt=null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
           String username =request.getParameter("username").trim();
           String password=request.getParameter("password").trim();
           String msg="";
           System.out.println("password is \t"+password);
           PrintWriter out = response.getWriter(); 
           try
          {  
           database db=new database();
           Connection con=db.getCon();
           String id = username.substring(0, 5);
           String idd = username.substring(5, username.length());
           //set session 
           HttpSession session=request.getSession();  
           session.setAttribute("userid",username); 
                    //check for the candidate login        
                 if(id.equalsIgnoreCase("candi"))
                     { 
                      try
                       { 
                          PreparedStatement ps = con.prepareStatement("SELECT * FROM CANDIDATE where ID=?");
                          ps.setString(1,idd);
                          ResultSet rs = ps.executeQuery();
                        if(rs.next())
                          {   
                              if(rs.getInt("INVALID")>0)
                              {String salt=rs.getString("SALT");
                                    password+=salt;
                                    password = encription.Password(password).trim();
                                    System.out.println("password is ="+password);
                                    System.out.println("salt is ="+salt);
                                    System.out.println("database password="+rs.getString("PASSWORD"));
                             
                             if(rs.getString("PASSWORD").equals(password))
                              {
                               
                               PreparedStatement psss = con.prepareStatement("update CANDIDATE set INVALID=3 where ID =?");
                               psss.setString(1, idd);
                               psss.executeUpdate();
                               session.setAttribute("usertype","candidate");            
                               RequestDispatcher rd=request.getRequestDispatcher("CandidateShow");
                               rd.forward(request, response);
                              }
                             else 
                              {   
                                  System.out.println("in invalid password state ");
                                  int invalidpassword = rs.getInt("INVALID")-1;
                                  PreparedStatement psss = con.prepareStatement("update CANDIDATE set INVALID=? where ID =?");
                                  psss.setInt(1,invalidpassword);
                                  psss.setString(2, idd);
                                  psss.executeUpdate();
                                  out.println(InvalidLogin.invalidpassword(username,msg));
                              }
                            }else
                             {
                                
                               msg="Account Is Locked<br> Please Reset Password To Unlock Your Account";
                               out.println(InvalidLogin.invalidpassword(username,msg));
                             }
                          }
                        
                          else
                           {
                             out.println(InvalidLogin.invalidpassword(username,msg));
                           }
                        }
                      catch(SQLException | HeadlessException ex1)
                         {
	                     System.out.println(ex1);
                             out.println(InvalidLogin.invalidpassword(username,msg));                    
			 }	
                      }
                 // check for the voter login 
                   else if(id.equalsIgnoreCase("voter"))
                        {
                         try
                          {
                          PreparedStatement ps = con.prepareStatement("SELECT * FROM VOTER where id=?");
                          ps.setString(1,idd);
                          ResultSet rs = ps.executeQuery();
                          if(rs.next())
                           {
                             if(rs.getInt("INVALID")>0)
                             {
                                 String salt=rs.getString("SALT");
                                 System.out.println("salt in database ="+salt);
                                 password+=salt;
                                 
                                 System.out.println("......................."+password);
                                 password = encription.Password(password);
                             System.out.println("password is ="+password);
                             System.out.println("database password="+rs.getString("PASSWORD"));
                             
		             if(rs.getString("PASSWORD").equals(password))
		               { 
                                 PreparedStatement psss = con.prepareStatement("update voter set INVALID=3 where ID =?");
                                 psss.setString(1, idd);
                                 psss.executeUpdate();
                                if(rs.getInt("ACTIVATION")==1)
                                {
			         session.setAttribute("usertype","voter"); 
                                 Otp o = new Otp();
                                 String userotp = o.OTP(4);
                                 System.out.println("otp is :"+ userotp);
                                 session.setAttribute("userotp",userotp); 
                                 mail m = new mail(rs.getString(4),"OTP For Verification","Your OTP is :"+userotp);
			         RequestDispatcher rd=request.getRequestDispatcher("VoterVerifaction");
                                 rd.forward(request, response);
                               } else
                              {
                                msg="Account Not Activated";
                                out.println(InvalidLogin.invalidpassword(username,msg));
                              }
                               }
                             else
                               {
                                  System.out.println("in invalid password state ");
                                  int invalidpassword = rs.getInt("INVALID")-1;
                                  PreparedStatement psss = con.prepareStatement("update voter set INVALID=? where ID =?");
                                  psss.setInt(1,invalidpassword);
                                  psss.setString(2, idd);
                                  psss.executeUpdate();
                                  out.println(InvalidLogin.invalidpassword(username,msg));
                              }
                             }else
                             {
                                
                               msg="Account Is Locked<br> Please Reset Password To Unlock Your Account";
                               out.println(InvalidLogin.invalidpassword(username,msg));
                             }
                             }
                           else
                             {
                                 msg="";
                                out.println(InvalidLogin.invalidpassword(username,msg));
                             }
                            }
                        catch(SQLException | HeadlessException ex1)
                         {
	                      System.out.println(ex1);
                              out.println(InvalidLogin.invalidpassword(username,msg));
		         }	
                        }
                    else if(id.equalsIgnoreCase("admin"))
                    { System.out.print("IN admin login");
                       try
                        {
                          PreparedStatement ps = con.prepareStatement("SELECT * FROM ADMIN where id=?");
                          ps.setString(1,idd);
                          ResultSet rs = ps.executeQuery();
                          System.out.print(password);
                         
                          if(rs.next())
                          { 
                              String salt=rs.getString("SALT");
                                 password+=salt;
                                 System.out.print("PASSWORD IN THE file "+password);
                                 password = encription.Password(password).trim();
                                 System.out.println("getting password from databse"+rs.getString("password"));
                             if((rs.getString("password").equals(password)))
		               {
                                 System.out.print("in admin page1111");
                                 session.setAttribute("usertype","admin"); 
			         RequestDispatcher rd=request.getRequestDispatcher("admin");
                                 rd.forward(request, response);
		               }
                             else
                              {
                                out.println(InvalidLogin.invalidpassword(username,msg));
                              }
                           }
                        }
                       catch(SQLException | HeadlessException ex1)
                        {
	                      System.out.println("Exception  sss"+ex1);
		              out.println(InvalidLogin.invalidpassword(username,msg));
                        }	
                    }
                       else
                       {
                           out.println(InvalidLogin.invalidpassword(username,msg));
                       }
                      }
           catch(Exception ex1)
                         {
	                    
			      System.out.println("final catch");
                              System.out.println(ex1);
                           out.println(InvalidLogin.invalidpassword(username,msg));
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
            out.println("<title>Servlet LOGIN</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LOGIN at " + request.getContextPath() + "</h1>");
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
