/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RUCHI
 */
public class ForgotPassword {
    String output="";
    public String display(String email)
    {
        output="<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Reset Password</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"      <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" +
"         <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" +
"         <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"         <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css\">\n" +
"         <style>\n" +
"              \n" +
"         </style>\n" +
"   </head>\n" +
"     <body>\n" +
"         <div><h1 style=\"text-align:center;  background-color: #ccccff; margin-top: 0px; padding-top: 25px; padding-bottom: 25px;\"> Welcome To Online Voting System</h1></div>\n" +
"         <div class=\"container\">\n" +
"	<div class=\"row\">\n" +
"		<div class=\"col-md-4 col-md-offset-4\">\n" +
"            <div class=\"panel panel-default\">\n" +
"              <div class=\"panel-body\">\n" +
"                <div class=\"text-center\">\n" +
"                  <h3><i class=\"fa fa-lock fa-4x\"></i></h3>\n" +
"                  <h2 class=\"text-center\">Forgot Password?</h2>\n" +
"                  <p>Enter Your Registered Email-Id</p>\n" +
"                  <div class=\"panel-body\">\n" +
"                      <h4 style=\"text-align:center; color: red\">Email-Id not registered</h4>\n" +
"                      <form  autocomplete=\"off\" class=\"form\" action=\"\" method=\"post\">\n" +
"                          <div class=\"form-group\">\n" +
"                            <div class=\"input-group\">\n" +
"                             <span class=\"input-group-addon\"><i class=\"fa fa-user\"></i></span>\n" +
"                                   <select name=\"usertype\" required class=\"form-control\">\n" +
"                                         <option value=\"\" selected>--------------Select UserType---------------</option>\n" +
"                                         <option value=\"voter\">Voter</option>\n" +
"                                         <option value=\"candidate\">Candidate</option>\n" +
"                                         </select>\n" +
"                             </div>\n" +
"                          </div>\n" +
"                      <div class=\"form-group\">\n" +
"                        <div class=\"input-group\">\n" +
"                          <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-envelope color-blue\"></i></span>\n" +
"                          <input id=\"email\" name=\"email\" placeholder=\"email address\" class=\"form-control\"  type=\"email\" required=\"\">\n" +
"                        </div>\n" +
"                      </div>\n" +
"                      <div class=\"form-group\">\n" +
"                        <input class=\"btn btn-lg btn-primary btn-block\" value=\"Reset Password\" type=\"submit\">\n" +
"                      </div>\n" +
"                    </form>\n" +
"    \n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"            </div>\n" +
"          </div>\n" +
"	</div>\n" +
"</div>\n" +
"     </body>\n" +
"</html>\n" +
"";
    return output;
    }
    
}
