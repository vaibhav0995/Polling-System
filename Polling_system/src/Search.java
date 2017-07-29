import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	Connection con=null;
	String id=null;
	int flag=0;
	ResultSet res=null;
	String s1,s2,s3,s4,s5;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Search() {
		setTitle("Search");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 204);
		setLocationRelativeTo(this);

contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterTheVoter = new JLabel("Enter the Voter ID to be searched");
		lblEnterTheVoter.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Sitka Text", Font.BOLD, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  id=textField.getText();
			  con=new Dbinfo().con;
			  String query="select * from reg_user where id=?";
			  try
			  {
			   PreparedStatement ps=con.prepareStatement(query);
			   ps.setString(1, id);
			   res=ps.executeQuery();
			   while(res.next())
			   {
				   flag=1;
				   s1=res.getString(3);
				   s2=res.getString(1);
				   s3=res.getString(4);
				   s4=res.getString(5);
				   s5=res.getString(6);
			   }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			
			  if(id.length()==0)
			  {
				  JOptionPane.showMessageDialog(getParent(),"enter the information !", "information",JOptionPane.INFORMATION_MESSAGE);

			  }
			  else if(flag==1)
				{
				 
				  new UserDetail(s1,s2,s3,s4,s5,s2).setVisible(true);
				  dispose();
				}
				 
			  else
			  {
				  JOptionPane.showMessageDialog(getParent(),"No Record Found for the "+id, "information",JOptionPane.INFORMATION_MESSAGE);
			      textField.setText(null);
			  }
			}
			
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 textField.setText(null);
			}
		});
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			 dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEnterTheVoter)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReset)
							.addGap(18)
							.addComponent(btnQuit))
						.addComponent(textField))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblEnterTheVoter)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnReset)
						.addComponent(btnQuit))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
