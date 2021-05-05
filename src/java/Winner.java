
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
public class Winner {
    
               database db=new database();
               Connection con=db.getCon();
               PreparedStatement ps =null;
               ResultSet rs = null;
               int  wflag =0,winnerid=0;
               String vote="";
               String name="";
               
               public int winnerfalg()
               {
                   String query = "SELECT * FROM `result` ";
                   try{
                   ps = con.prepareStatement(query);
                   rs = ps.executeQuery();
                   if(rs.next())
                   {
                      winnerid=rs.getInt("WINNERID");
                      wflag = rs.getInt("RESULTFLAG");
                   }
                   }catch(Exception e)
                   {
                    System.out.println("winner"+e);
                   }
                   try
                   {
                           ps=con.prepareStatement("select  count(*) from voting where VOTER_ID =?");
                           ps.setInt(1,winnerid);
                           rs = ps.executeQuery();
                           if(rs.next())
                           {
                            vote=rs.getString(1);
                           }
                           PreparedStatement ps = con.prepareStatement("select  * from candidate where ID =?");
		               ps.setInt(1,winnerid);
		               ResultSet rs = ps.executeQuery();
                               if(rs.next())
                               {
                                 name= rs.getString("NAME");
                               }
                   }
                   catch(Exception e)
                   {
                   System.out.println("cand name exception "+e);
                   }
                   System.out.println("winner flag ="+wflag);
                   return wflag;
               }
               public String winervote()
               {
                   try
                   {
                           ps=con.prepareStatement("select  count(*) from voting where CANDIDATE_ID =?");
                           ps.setInt(1,winnerid);
                           rs = ps.executeQuery();
                           if(rs.next())
                           {
                            vote=rs.getString(1);
                            System.out.println("winner vote is "+vote);
                           }
                           PreparedStatement ps = con.prepareStatement("select  * from candidate where ID =?");
		               ps.setInt(1,winnerid);
		               ResultSet rs = ps.executeQuery();
                               if(rs.next())
                               {
                                 name= rs.getString("NAME");
                               }
                   }
                   catch(Exception e)
                   {
                   System.out.println("cand name exception "+e);
                   }
                 return vote;
               }
               public String WinName()
               {
                return name;
               }
               public String DisplayString()
               {
                return "<div style=\"width:100%; text-align:center\"><h4 style=\"padding-top:30px\"> Winner is  : "+name+" Vote "+vote+"</h4></div>";
               }
}
