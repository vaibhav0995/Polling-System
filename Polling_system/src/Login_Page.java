import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JRadioButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
public class Login_Page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	int flag=0;
	Connection con=null;
	ResultSet res=null;
    String id=null;
    String passwd=null;
	String utype="";
    String name="";
    private JTextField textField_1;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Page frame = new Login_Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Login_Page() {
		setTitle("Login Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);

		setBounds(100, 100, 816, 493);
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String image="ECI.jpg";

		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		
		JLabel lblVoterId = new JLabel("User ID");
		lblVoterId.setForeground(Color.DARK_GRAY);
		lblVoterId.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  int flag=0;
			  id=textField.getText();
			  char ch[]=passwordField.getPassword();
			  passwd=String.copyValueOf(ch);
			  String query="select * from reg_user where id=? and password=?"; 
				try
			  {
				 con=new Dbinfo().con;
				 PreparedStatement ps=con.prepareStatement(query);
				 ps.setString(1,id);
				 ps.setString(2, passwd);
				 res=ps.executeQuery();
				 while(res.next())
			     {
			    	 flag=1;
			    	 utype=res.getString(7);
			    	 name=res.getString(3);
			    	 break;
			    	
			     }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
				if(flag==1 && utype.equalsIgnoreCase("voter"))
				{
		            new Voter_Section1(name,id).setVisible(true);
		            dispose();
				}  
		         else if(flag==1 && utype.equalsIgnoreCase("admin"))
		        {
		          new Admin_Section(name,id).setVisible(true);
		          dispose();
		        }
		         else
		    	 {
		    		 JOptionPane.showMessageDialog(getParent(),"login failed ! plz register yourself !!","error",JOptionPane.ERROR_MESSAGE);;
		    	 }
			
			}
		});
		 
		JButton btnNewUser = new JButton("new User");
		btnNewUser.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		btnNewUser.setToolTipText("Register new User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 new Register("voter").setVisible(true);
			}
		});
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			  System.exit(0);
			}
		});
	
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("logo1.jpg"));
		
		JRadioButton rdbtnShow = new JRadioButton("show");
		rdbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(flag==0)
				{
					textField_1.setText(passwordField.getText());
					flag=1;
				}
				else
				{
					textField_1.setText(null);
					flag=0;
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addGap(221))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewUser, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(288))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnQuit)
							.addGap(320))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPassword)
										.addComponent(lblVoterId))
									.addGap(42)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addComponent(rdbtnShow)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
							.addGap(21))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVoterId))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword)
						.addComponent(rdbtnShow, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnLogin)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit)
					.addGap(5))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
