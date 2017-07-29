import java.beans.VetoableChangeSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class Dbinfo
{
 	static Connection con;
 	static int c=0;
 	static Boolean start=false;
 	static Vector<String> header;
 	static Vector<Vector<String>> outer;
 	static
 	{
 		try{
 		Class.forName("com.mysql.jdbc.Driver");
 		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/polling","root","rat");
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
 	}
    public static void get_confirm(int a)
    {
    	c=a;
    }
 	public static void get_start(Boolean a)
 	{
 		start=a;
 	}
 	
    public static void getTable()
    {
    	header=new Vector<>();
    	outer=new Vector<>();
    	String query="select * from voting";
    	try
    	{
    		PreparedStatement ps=con.prepareStatement(query);
    		ResultSet res=ps.executeQuery();
    		ResultSetMetaData rsmd=res.getMetaData();
    		int col=rsmd.getColumnCount();
    		for(int i=1;i<=col;i++)
    		{
    			String col_name=rsmd.getColumnName(i);
    			header.add(col_name);
    		}
    		while(res.next())
    		{
    			Vector<String> records=new Vector<>();
    			for(int i=1;i<=col;i++)
    			{
    				String s=res.getString(i);
    				records.add(s);
    			}
    			outer.add(records);
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
 	
}