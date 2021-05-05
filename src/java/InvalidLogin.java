public class InvalidLogin {
    
    public static String invalidpassword(String username,String msg)
    {
     String output="<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"     <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"\n" +
"   <style>\n" +
"          body {\n" +
"  margin: 0;\n" +
"  padding: 0;\n" +
"  background-color: #17a2b8;\n" +
"  height: 100vh;\n" +
"}\n" +
"#login .container #login-row #login-column #login-box {\n" +
"  \n" +
"margin-top: -8px; "+
" max-width: 600px;\n" +
"  height: 550px;\n" +
"  border: 1px solid #9C9C9C;\n" +
"  background-color: #EAEAEA;\n" +
"}\n" +
"#login .container #login-row #login-column #login-box #login-form {\n" +
"  padding: 20px;\n" +
"}\n" +
"#login .container #login-row #login-column #login-box #login-form #register-link {\n" +
"  margin-top: -85px;\n" +
"}\n" +
"      </style>\n" +
"    </head>\n" +
"<body>\n" +
"    <div><h1 style=\"text-align:center;  background-color: #ccccff; padding-top: 25px; padding-bottom: 25px;\">Welcome TO Online Voting System</h1></div>\n" +
"    <div id=\"login\">\n" +
"        <div class=\"container\">\n" +
"            <div id=\"login-row\" class=\"row justify-content-center align-items-center\">\n" +
"                <div id=\"login-column\" class=\"col-md-6\">\n" +
"                    <div id=\"login-box\" class=\"col-md-12\">\n" +
"                        <form id=\"login-form\" class=\"form\" action=\"LOGIN\" method=\"post\">\n" ;
if(msg.equalsIgnoreCase(""))
{
output+="<div class=\"form-group\">\n" +
"<p><h4 style=\"color:red; text-align: center\">Invalid UserName OR password</h4></p>\n" +
"</div>\n" ;
} 
else
{
output+="<div class=\"form-group\">\n" +
"<p><h4 style=\"color:red; text-align: center\">"+msg+"</h4></p>\n" +
"</div>\n" ;
}
output+="                             <div class=\"form-group\" style=\" padding: auto; text-align: center\">\n" +
"                                <img src=\"image/image.png\" alt=\"\" style=\"height:150px; width: 150px;\"/>\n" +
"                            </div>\n" +
"                                <div class=\"form-group\">\n" +
"                                <label for=\"username\" class=\"text-info\">Username:</label><br>\n" +
"                                <input type=\"text\" name=\"username\" id=\"id\" value=\""+username+"\" class=\"form-control\" required>\n" +
"                            </div>\n" +
"                            <div class=\"form-group\">\n" +
"                                <label for=\"password\" class=\"text-info\">Password:</label><br>\n" +
"                                <input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" required>\n" +
"                            </div>\n" +
"                            <div class=\"form-group\">\n" +
"                                <input type=\"submit\" name=\"submit\" class=\"btn btn-info btn-md\" value=\"Login\">\n" +
"                                <input type=\"reset\" name=\"submit\" class=\"btn btn-info btn-md\" value=\"Reset\">\n" +
"                            </div>\n" +
"                            <div class=\"form-group\">\n" +
"                                <p style=\"color: red\"><a href=\"ResetPassword.html\">Reset Password?</a></p>\n" +
                                 "<a href=\"voter_reg.html\">IF NOT REGISTERED</a>"+
"                            </div>\n" +
"                        </form>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"    </div>\n" +
"</body>\n" +
"</html>\n" +
"";
     return output;
    }
}
