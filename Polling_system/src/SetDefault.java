import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

public class SetDefault 
{
  static void setDefault()
  {
	  int flag=0,flag1=0;
	  String query="select * from voting";
	  String query1="select * from reg_user";
	  String query2="delete from voting where party=? and candidate=?";
	  String query3="update reg_user set status=0 where id=?";
	  Connection con=new Dbinfo().con;
	  try
	  {
		  PreparedStatement ps=con.prepareStatement(query);
		  PreparedStatement ps1=con.prepareStatement(query1);
		  PreparedStatement ps2=con.prepareStatement(query2);
		  PreparedStatement ps3=con.prepareStatement(query3);
		  ResultSet res=ps.executeQuery();
		  ResultSet res1=ps1.executeQuery();
		  while(res.next())
		  {
			  ps2.setString(1,res.getString(1));
			  ps2.setString(2, res.getString(2));
			  flag=ps2.executeUpdate();
		  }
		  while(res1.next())
		  {
			  ps3.setString(1,res1.getString(1));
			  flag1=ps3.executeUpdate();
		  }
		
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
}
