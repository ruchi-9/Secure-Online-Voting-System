
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Candidate {
    
    public String display(String id,String name,String Phone,String email, int totalvote,int yourvate)
    {
        System.out.println("name into candidate "+name);
        String output="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Candidate Home </title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"          <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"\n" +
"    <style>\n" +
"        body\n" +
"        {\n" +
"            margin: 0px;\n" +
"            padding: 0px;\n" +
"            \n" +
"        }\n" +
"        tr\n" +
"        {\n" +
"            font-size: 20px;\n" +
"        }\n" +
"        #votername\n" +
"        {\n" +
"            padding-left:50px;\n" +
"            \n" +
"        }\n" +
"        #votertext\n" +
"        {\n" +
"            margin-left: 12px;\n" +
"            margin-top: 10px;\n" +
"            text-align: right;\n" +
"        }\n" +
"    </style>\n" +
"    </head>\n" +
"    <body>\n" +
"            <div><h1 style=\"text-align:center;  background-color: #ccccff; padding-top: 25px; padding-bottom: 25px;\">Welcome TO Online Voting System</h1></div>\n" +
"    \n" +
"                 <div style=\"margin-top:-8px\" >\n" +
"                     <div style=\"width: 320px;height: 555px; background-color: #EAEAEA; float: left; border-right: 2px #ffffff solid; text-align: center\">\n" +
"                       <img src=\"image/userpic.png\" alt=\"\" style=\"width:170px; height: 170px;border-radius: 50%;\"/>\n" +
"                       <h4 style=\"padding-top:5px\">"+name+"</h4>\n" +
"                       <br>\n" +
"                       <br>\n" +
"                       <br>\n" +
"                       <hr>\n" +
"                       <h5>Basic Information</h5>\n" +
"                       <hr>\n" +
"                       <h6 style=\"text-align:left\">Phone Number: "+Phone+" \n" +
"                           <br> \n" +
"                           <br>\n" +
"                           Email: "+email+"\n" +
"                       </h6> \n" +
" <button class=\"tablinks\" style=\"width:318px; height: 40px\" onclick=\"location.href = 'Logout';\" >Logout</button>\n" +
" <button class=\"tablinks\" style=\"width:318px; height: 40px\" onclick=\"location.href = 'UpdatePassword';\" >Update Password</button>\n" +

                "                   </div>\n" +
"                     <div style=\"width:1027px;height: 555px; max-height: 560px;overflow:auto; background-color: #FBF8F7; float: left\">\n" ;

output+="<h4 style=\"text-align:center\">Voting Information</h4>"+
"    <table class=\"table table-bordered\" style=\"max-width:500px; border: none\">\n" +
"        <thead>\n" +
"        <th>Total Vote</th>\n" +
"        <th>Your Vote</th>\n" +
"        </thead>\n" ;
output+="<tr>\n"+
"<td>"+totalvote+"</td>\n" +
"<td> "+yourvate+"</td>\n" ;
output+="</tr></table>\n";  
Winner win = new Winner();
                if(win.winnerfalg()==1)
                 {
                 
                   
output+=        "<h4 style=\"text-align:center\">Winner Information</h4>"+
"    <table class=\"table table-bordered\" style=\"max-width:500px; border: none\">\n" +
"        <thead>\n" +
"        <th>Candidate Name</th>\n" +
"        <th>Vote Count</th>\n" +
"        </thead>\n" ;
                           output+="<tr>\n"+
                           "<td>"+win.WinName()+"</td>\n" +
                           "<td>"+win.winervote()+"</td>\n" +
                           "</tr>\n" ;
                      
                      output+="    </table>\n" ;
        output+="<h4 style=\"text-align:center\">Others Vothing Information</h4>";
output+="    <hr>\n" +
"    <table class=\"table table-bordered\" style=\"max-width:500px; border: none\">\n" +
"        <thead>\n" +
"        <th>Candidate Name</th>\n" +
"        <th>Vote Count</th>\n" +
"        </thead>\n" ;
                  try{
                         PreparedStatement psi=null;
                         ResultSet rs1=null;
                         String cannname="";
                         int count=0;
                         database db=new database();
                            Connection con=db.getCon();   
                         PreparedStatement ps = con.prepareStatement("select  * from candidate ");
                	 ResultSet rs = ps.executeQuery();
                         while(rs.next())
                          {
                              System.out.println("in can list ");
                            psi=con.prepareStatement("select  count(*) from voting where CANDIDATE_ID =?");
                            psi.setString(1,rs.getString("ID"));
                            rs1 = psi.executeQuery();
                            if(rs.getInt("ID")==0)
                            {
                                cannname="NOTA";
                            }
                            else{
                            cannname=rs.getString("NAME");
                            }if(rs1.next())
                           {
                               count=rs1.getInt(1);
                           }
                           output+="<tr>\n"+
                           "<td>"+cannname+"</td>\n" +
                           "<td>"+count+"</td>\n" +
                           "</tr>\n" ;
                          }
                  }
                       catch(Exception e)
                       {}
output+="    </table>\n" ;
           
                 }
        output+="";
output+="                     </div>\n" +
"               </div>\n" +
"    </body>\n" +
"</html>\n" +
"";
        return output;
    }
}
