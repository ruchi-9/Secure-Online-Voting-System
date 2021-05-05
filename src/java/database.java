
import java.sql.*;
public class database {
     Connection con;
    public  Connection getCon()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
          // System.out.println("Connecting to database...");
                         String url = "jdbc:mysql://localhost:3306/voting";
			 
                            con = DriverManager.getConnection(url,"root","");                   			
        } catch (ClassNotFoundException | SQLException ex) {
             System.out.println("data base file exception"+ex);
        }  
        
    return con;
}
}
