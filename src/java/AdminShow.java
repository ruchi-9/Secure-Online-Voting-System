import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RUCHI
 */
 public class AdminShow {
    String output="";
    database db=new database();
    Connection con=db.getCon();
     Winner win = new Winner();
    public String Display(String name,String phone ,String email)
    {
        output="<!DOCTYPE html>\n" +
"<html>\n" +
"   <head>\n" +
"       <title>Admin Home </title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"      <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"<script>\n" +
"function openCity(evt, cityName) {\n" +
"    var i, tabcontent, tablinks;\n" +
"    tabcontent = document.getElementsByClassName(\"tabcontent\");\n" +
"    for (i = 0; i < tabcontent.length; i++) {\n" +
"        tabcontent[i].style.display = \"none\";\n" +
"    }\n" +
"    tablinks = document.getElementsByClassName(\"tablinks\");\n" +
"    for (i = 0; i < tablinks.length; i++) {\n" +
"        tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n" +
"    }\n" +
"    document.getElementById(cityName).style.display = \"block\";\n" +
"    evt.currentTarget.className += \" active\";\n" +
"}\n" +
"</script>\n" +
"  <style>\n" +
"        body\n" +
"        {\n" +
"            margin: 0px;\n" +
"            padding: 0px;\n" +
"         \n" +
"        }\n" +
"        tr\n" +
"        {\n" +
"            font-size: 20px;\n" +
"        }\n" +
"        #votername\n" +
"        {\n" +
"            padding-left:50px;\n" +
"        }\n" +
"        #votertext\n" +
"        {\n" +
"            margin-left: 12px;\n" +
"            margin-top: 10px;\n" +
"            text-align: right;\n" +
"        }   \n" +
"  /* Style the tab */\n" +
".tab {\n" +
"    overflow: hidden;\n" +
"    border: 1px solid #ccc;\n" +
"    background-color: #f1f1f1;\n" +
"}\n" +
"\n" +
"/* Style the buttons inside the tab */\n" +
".tab button {\n" +
"    background-color: inherit;\n" +
"    float: left;\n" +
"    border: none;\n" +
"    outline: none;\n" +
"    cursor: pointer;\n" +
"    padding: 14px 16px;\n" +
"    transition: 0.3s;\n" +
"    font-size: 17px;\n" +
"}\n" +
"\n" +
".tab button:hover {\n" +
"    background-color: #ddd;\n" +
"}\n" +
"\n" +
".tab button.active {\n" +
"    background-color: #ccc;\n" +
"}\n" +
"\n" +
".tabcontent {\n" +
"    display: none;\n" +
"    border-top: none;\n" +
"}\n" +
"#actionbutton\n" +
"{\n" +
"    height: 50px;\n" +
"    margin-bottom: 40px;\n" +
"    border-radius: 5px;\n" +
"    width: 180px;\n" +
"}\n" +
"  </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div><h1 style=\"text-align:center;  background-color: #ccccff; padding-top: 25px; padding-bottom: 25px;\">Welcome TO Online Voting System </h1>\n" +
"            \n" +
"        </div>\n" +
"                 <div style=\"margin-top:-8px\" >\n" +
"                     <div style=\"width: 320px;height: 555px; background-color: #EAEAEA; float: left; border-right: 2px #ffffff solid; text-align: center\">\n" +
"                       <img src=\"image/userpic.png\" alt=\"\" style=\"width:170px; height: 170px;border-radius: 50%;\"/>\n" ;
output+="                       <h4 style=\"padding-top:5px\">"+name+"</h4>\n" +
"                       <br>\n" +
"                       <br>\n" +
"                       <br>\n" +
"                       <hr>\n" +
"                       <h5>Basic Information</h5>\n" +
"                       <hr>\n" +
"                       <h6 style=\"text-align:left\">Phone Number: "+phone+" \n" +
"                           <br> \n" +
"                           <br>\n" +
"                           \n" +
"                           Email: "+email+"\n" +
"                       </h6>\n" +
"                       <br>\n" +
"                           <button class=\"tablinks\" style=\"width:318px; height: 40px\" onclick=\"location.href = 'Logout';\" >Logout</button>\n" +
" <button class=\"tablinks\" style=\"width:318px; height: 40px\" onclick=\"location.href = 'UpdatePassword';\" >Update Password</button>\n" +
"                   </div>\n" +
"                     <div style=\"width:1027px;height: 555px; max-height: 560px;overflow:auto; background-color: #FBF8F7; float: left\">\n" +
"                  \n" +
"                         <div class=\"tab\" style=\"padding-right:-40px\">\n" +
        "<button class=\"tablinks\" onclick=\"openCity(event, 'Candidate')\">Candidate Registraion</button>"+
"                               <button class=\"tablinks\" onclick=\"openCity(event, 'London')\">Voting</button>\n" +
"                               <button class=\"tablinks\" onclick=\"openCity(event, 'Paris')\">Action</button>\n" +
"                          </div>\n" +
"                         \n" +
"                   \n" +
"                         <div id=\"London\" class=\"tabcontent container\">\n" +
"    <h3 style=\"text-align:center;\">Current Voting Count</h3>\n" +

        "    <hr>\n" ;
       
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
                 }
        output+="<h4 style=\"text-align:center\">Voting Information</h4>";
output+="    <hr>\n" +
"    <table class=\"table table-bordered\" style=\"max-width:500px; border: none\">\n" +
"        <thead>\n" +
"        <th>Candidate Name</th>\n" +
"        <th>Vote Count</th>\n" +
"        </thead>\n" ;
                  try{
                         PreparedStatement psi=null;
                         ResultSet rs1=null;
                         String canname="";
                         int count=0;
                                 
                         PreparedStatement ps = con.prepareStatement("select  * from candidate");
                	 ResultSet rs = ps.executeQuery();
                         while(rs.next())
                          {
                              System.out.println("in can list ");
                            psi=con.prepareStatement("select  count(*) from voting where CANDIDATE_ID =?");
                            psi.setString(1,rs.getString("ID"));
                            rs1 = psi.executeQuery();
                            canname=rs.getString("NAME");
                           if(rs1.next())
                           {
                               count=rs1.getInt(1);
                           }
                           output+="<tr>\n"+
                           "<td>"+canname+"</td>\n" +
                           "<td>"+count+"</td>\n" +
                           "</tr>\n" ;
                          }
                  }
                       catch(Exception e)
                       {}
output+="    </table>\n" ;
output+="</div>\n" +
"\n" +
"<div id=\"Paris\" class=\"tabcontent\">\n" +
"    <h3 style=\"text-align: center\">Choose An Action</h3>\n" +
"    <hr>\n" +
"    <div style=\"text-align: center\">\n" ;

                if(win.winnerfalg()==1)
                 {
                     
output+="<button id=\"actionbutton\" onclick=\"location.href = 'ResumeVoting';\">Resume Voating</button>\n" ;
                 }
                else
                {
                
output+="<button id=\"actionbutton\" onclick=\"location.href = 'DeclareResult';\">Declare Result</button>\n" ;
                }
output+="<br>\n" +
"        <button id=\"actionbutton\" onclick=\"location.href = 'ResetResult';\">Reset Voting</button>\n" +
"    </div>\n" +
"</div>\n" ;
        
output+="<div id=\"Candidate\" class=\"tabcontent\">\n" +
"    <h3 style=\"text-align: center\">Candidate Registration</h3>\n" +
"    <hr>\n" +
"    <div style=\"\">\n" +
"    <form id=\"login-form\" class=\"form\" action=\"CandidateRegisteration\" method=\"post\" style=\"width:80%\">\n" +
"                    <div class=\"form-group\">\n" +
"                                <label for=\"username\" class=\"text-info\">Name:</label><br>\n" +
"                                <input type=\"text\" placeholder=\"Enter UserName\" name=\"name\" id=\"id\"  class=\"form-control\" required>\n" +
"                            </div>\n" +
"                        <div class=\"form-group\">\n" +
"                                <label for=\"EMAIL\" class=\"text-info\">EMAIL:</label><br>\n" +
"                                <input type=\"email\" placeholder=\"Enter Email\" name=\"Email\" id=\"id\"  class=\"form-control\" required>\n" +
"                            </div>\n" +
"                        <div class=\"form-group\">\n" +
"                                <label for=\"PHONE_NO\" class=\"text-info\">PHONE NO:</label><br>\n" +
"                                <input onkeydown=\"validateNumber(event);\" maxlength=\"10\" placeholder=\"Enter Phone no\" name=\"PHONENO\" id=\"id\"  class=\"form-control\" required>\n" +
"                            </div>\n" +
"                         <div class=\"form-group\">\n" +
"                             <label class=\"text-info\">GENDER </label>\n" +
"                            <td>         <select name=\"gender\" required  style=\"height:35px ; border-radius: 5px\">\n" +
"                                         <option value=\"\" selected>------Select Gender--------</option>\n" +
"                                         <option value=\"male\">MALE</option>\n" +
"                                         <option value=\"female\">FEMALE</option>\n" +
"                                         <option value=\"others\">OTHERS</option>\n" +
"                                         </select>\n" +
"                         </div>\n" +
"                         <div class=\"form-group\">\n" +
"                                <input type=\"submit\" name=\"submit\" class=\"btn btn-info btn-md\" value=\"Register\">\n" +
"                              \n" +
"                            </div>\n" +
"                    </form>\n" +
"        </div>\n" +
"</div>";

output+="\n" +
"                     </div>\n" +
"               </div>\n" +
"    </body>\n" +
"</html>";
      return output;
    }
}
