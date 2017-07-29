import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JProgressBar;

public class ProgressBar 
{
	

	
	public static void setValue(JProgressBar progressBar)
	{

		//progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		
		
		int i=0;
		 while(i!=100)
		 {
			 i+=1;
			 progressBar.setValue(i);
			 try
			 {
				 Thread.sleep(20);
			 }
			 
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
			

	}
}