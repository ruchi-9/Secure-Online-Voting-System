
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.HeadlessException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class voter_show extends HttpServlet {
public  String a1,a2,a3,a4,a5,a6,value,value1,q1,q2,q3;
public  String can[]=new String[10];
public  String canid[]=new String[10];
public  int i=0;
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try{
             HttpSession session=request.getSession(false);
             String usertype=(String)session.getAttribute("usertype");
             if(usertype.trim().equalsIgnoreCase("voter"))
             {
             String name=(String)session.getAttribute("userid");
             System.out.println("in voter show page  name"+name);
             String id = name.substring(0, 5);
             String idd = name.substring(5, name.length());
             boolean flag=false;
             String candidentname="";
             int candidentid=-1;

             System.out.println(name);
             System.out.println(id);
             System.out.println("source id is "+idd);
            
        try {
                a1=idd;
                database db=new database();
                Connection con=db.getCon();
                PreparedStatement ps1 = con.prepareStatement("select  * from voter where ID =?");
		ps1.setString(1,a1);
		ResultSet rs = ps1.executeQuery();
                System.out.println(idd);
		         if(rs.next())
		          	    {
	                                    a2= rs.getString("NAME");
	                                    a3= rs.getString("PASSWORD");
                                            a4= rs.getString("PHONE_NO"); 
                                            a5= rs.getString("GENDER");
                                            a6= rs.getString("EMIAL_ID");
                                       PreparedStatement ps = con.prepareStatement("select  * from candidate order by ID");
                		       ResultSet rs1 = ps.executeQuery();
                                       System.out.println("candidate query");
                                     i=0;
		                    while(rs1.next())
		        	        {   
                                            System.out.println(i);  
                                            can[i]= rs1.getString("NAME"); 
                                            canid[i]= rs1.getString("ID"); 
                                             i++;
                                            System.out.println("name is"+can[0]);
                                            System.out.println("ID of candidate is"+canid[0]);                                          
                                        } 
                                      System.out.println("value of i is "+i);
                                      System.out.println(can[0]);
                                      System.out.println(can[1]);
                                       
                                      PreparedStatement ps12 = con.prepareStatement("select  * from voting where VOTER_ID =?");
		                      ps12.setString(1,a1);
		                      ResultSet rsc = ps12.executeQuery();
                                      if(rsc.next())
		        	       {
                                           
                                             flag= true;
	                                     q1= rsc.getString("CANDIDATE_ID");
                                             PreparedStatement ps2 = con.prepareStatement("select  * from candidate where ID=?");
                                             ps2.setString(1,q1);
		                             ResultSet rs12 = ps2.executeQuery();
                                             if(rs12.next())
                                             {
                                                  System.out.println("1111111111111111111");
                                             candidentname=rs12.getString("NAME");
                                             candidentid =rs12.getInt("ID");
                                              System.out.println(candidentname);
                                             
                                             }
                                        }
                                    }
                             else {
                             System.out.println("wrong enter id");
			       }
                         System.out.println(a1);
                         System.out.println(a2);
                         System.out.println(a3);
                         System.out.println(a4);
                         System.out.println(a5);
                         System.out.println(a6);
                         
            }
        
        catch(Exception ex)
        {
             System.out.println("EXCEPTION");
             System.out.println(ex);
        }
          
          PrintWriter out= response.getWriter();
          String a ="";
          VoterShow vs = new VoterShow();
          System.out.println("Candidate name "+candidentname+" flag "+flag);
          a = vs.display(a1,a2, a4, a6, flag, i, can, canid,candidentname,candidentid);
           
          
                 out.println(a);
    }
             else
             {
              response.sendRedirect("Logout");
             }}catch(Exception e )
             {
             response.sendRedirect("Logout");
             }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       processRequest(request, response);
    }
}
