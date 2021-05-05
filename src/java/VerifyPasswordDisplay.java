/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RUCHI
 */
public class VerifyPasswordDisplay {
    String output="";
    public String Display(String msg)
    {
        output+="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Update Password</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <script src=\"javascript/validation.js\" type=\"text/javascript\"></script>\n" +
"     <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"     <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"     <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
"     <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
"     <style>\n" +
"            \n" +
"          body {\n" +
"  margin: 0;\n" +
"  padding: 0;\n" +
"  background-color: #17a2b8;\n" +
"  height: 100vh;\n" +
"}\n" +
"\n" +
".container #login-row #login-column #login-box {\n" +
"  margin-top: -8px;\n" +
"  max-width: 600px;\n" +
"  height: 620px;\n" +
"  border: 1px solid #9C9C9C;\n" +
"  background-color: #EAEAEA;\n" +
"}\n" +
".container #login-row #login-column #login-box #login-form {\n" +
"  padding: 20px;\n" +
"}\n" +
" .container #login-row #login-column #login-box #login-form #register-link {\n" +
"  margin-top: -85px;\n" +
"}\n" +
"        </style>\n" +
"        <script>\n" +
"          window.onload = function ()\n" +
"           {\n" +
"             var txtPassword = document.getElementById(\"txtPassword\");\n" +
"             var txtConfirmPassword = document.getElementById(\"txtConfirmPassword\");\n" +
"             txtPassword.onchange = ConfirmPassword;\n" +
"             txtConfirmPassword.onkeyup = ConfirmPassword;\n" +
"             function ConfirmPassword() \n" +
"             {\n" +
"             txtConfirmPassword.setCustomValidity(\"\");\n" +
"             if (txtPassword.value != txtConfirmPassword.value) \n" +
"              {\n" +
"                  txtConfirmPassword.setCustomValidity(\"Passwords do not match.\");\n" +
"              }\n" +
"              }\n" +
"            }\n" +
"      </script>\n" +
"    </head>\n" +
"    <div><h1 style=\"text-align:center;  background-color: #ccccff; padding-top: 25px; padding-bottom: 25px;\">Welcome TO Online Voting System </h1></div>\n" +
"  <div id=\"Register\">\n" +
"        <div class=\"container\">\n" +
"            <div id=\"login-row\" class=\"row justify-content-center align-items-center\">\n" +
"                <div id=\"login-column\" class=\"col-md-6\">\n" +
"                    <div id=\"login-box\" class=\"col-md-12\">\n" +
"                        <h3 style=\"text-align:center; color:red\">"+msg+"</h3>\n" +
"                      <form id=\"login-form\" class=\"form\" action=\"VerifyPassword\" method=\"post\">\n" +
"                         <div class=\"form-group\">\n" +
"                              <label class=\"text-info\">Old Password</label>\n" +
"                              <input name=\"oldpassword\" type=\"password\"  title=\"Password must contain: Minimum 8 characters atleast 1 Alphabet and 1 Number\"\n" +
"                               class=\"form-control\" placeholder=\"Enter old Password\" required  />\n" +
"                         </div> \n" +
"                        <div class=\"form-group\">\n" +
"                              <label class=\"text-info\">New Password</label>\n" +
"                              <input name=\"txtPassword\" type=\"password\" id=\"txtPassword\" title=\"Password must contain: Minimum 8 characters atleast 1 Alphabet and 1 Number\"\n" +
"                               class=\"form-control\" placeholder=\"Enter new Password\" required pattern=\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\" />\n" +
"                         </div>\n" +
"                         <div class=\"form-group\">\n" +
"                              <label class=\"text-info\">Confirm Password</label>\n" +
"                             <input name=\"txtConfirmPassword\" type=\"password\" id=\"txtConfirmPassword\" class=\"form-control\"\n" +
"                              placeholder=\"Confirm Password\" />\n" +
"                         </div>\n" +
"                         <div class=\"form-group\">\n" +
"                                <input type=\"submit\" name=\"submit\" class=\"btn btn-info btn-md\" value=\"SUBMIT\">\n" +
"                         </div>\n" +
"                    </form>\n" +
"                </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        </div>  \n" +
"</html>\n" +
"";
      return output;
    }
    
}
