/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RUCHI
 */
public class VoterRegistrationDisplay
{
    String output="";
  public String display(int mailflag,String email,int phoneflag,String phone,String name)    
  {
      output="\n" +
"<html>\n" +
"    <head>\n" +
"        <title>VOTER REGISTER</title>\n" +
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
"#login .container #login-row #login-column #login-box {\n" +
"  margin-top: -8px;\n" +
"  max-width: 600px;\n" +
"  height: 520px;\n" +
"  border: 1px solid #9C9C9C;\n" +
"  background-color: #EAEAEA;\n" +
"}\n" +
"#login .container #login-row #login-column #login-box #login-form {\n" +
"  padding: 20px;\n" +
"}\n" +
"#login .container #login-row #login-column #login-box #login-form #register-link {\n" +
"  margin-top: -85px;\n" +
"}\n" +
"        </style>\n" +
"     </head>\n" +
"    <div><h1 style=\"text-align:center;  background-color: #ccccff; padding-top: 25px; padding-bottom: 25px;\"> VOTER REGISTERATION</h1></div>\n" +
"  <div id=\"login\">\n" +
"        <div class=\"container\">\n" +
"            <div id=\"login-row\" class=\"row justify-content-center align-items-center\">\n" +
"                <div id=\"login-column\" class=\"col-md-6\">\n" +
"                    <div id=\"login-box\" class=\"col-md-12\">\n" ;

      
     
      
      if(mailflag==1&& phoneflag==1)
      {
      output+="<h4 style=\"text-align:center;color: red\">Email or Passwrod Already Present </h4>\n" ;
      }
      else if(mailflag==1)
      {
      output+="<h4 style=\"text-align:center;color: red\">Email Already Present </h4>\n" ;
      }
      else  if(phoneflag==1)
      {
      output+="<h4 style=\"text-align:center;color: red\">Passwrod Already Present </h4>\n" ;
      }
      output+="<form id=\"login-form\" class=\"form\" action=\"VoterRegister\" method=\"post\">\n" +
"                    <div class=\"form-group\">\n" +
"                                <label for=\"username\" class=\"text-info\">Name:</label><br>\n" +
"                                <input type=\"text\" placeholder=\"Enter UserName\" value=\""+name+"\" name=\"username\" id=\"id\"  class=\"form-control\" required>\n" +
"                            </div>\n" +
"                        <div class=\"form-group\">\n" +
"                                <label for=\"EMAIL\" class=\"text-info\">EMAIL:</label><br>\n" +
"                                <input type=\"email\" placeholder=\"Enter Email\" value=\""+email+"\"name=\"EMAIL\" id=\"id\"  class=\"form-control\" required>\n" +
"                            </div>\n" +
"                        <div class=\"form-group\">\n" +
"                                <label for=\"PHONE_NO\" class=\"text-info\">PHONE NO:</label><br>\n" +
"                                <input onkeydown=\"validateNumber(event);\" maxlength=\"10\" value=\""+phone+"\" placeholder=\"Enter Phone no\" name=\"PHONENO\" id=\"id\"  class=\"form-control\" required>\n" +
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
"                                <input type=\"submit\" name=\"submit\" class=\"btn btn-info btn-md\" value=\"SUBMIT\">\n" +
"                              \n" +
"                            </div>\n" +
"                    </form>\n" +
"  </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        </div>  \n" +
"</html>\n" +
"";
    return output;
  }
  
}
