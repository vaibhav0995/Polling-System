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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
    int flag=0,flag1=0;
	String passwd,passwd1,cpasswd,s1;
	Connection con=null;
	ResultSet res=null;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public ChangePassword(String s) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Change Password");
		setResizable(false);
		setLocationRelativeTo(this);
		setBounds(100, 100, 476, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Changing Password for "+s+" !");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Current Password");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("Re-Enter Password");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		passwordField_1 = new JPasswordField();
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  cpasswd=textField.getText();
			  char ch[]=passwordField.getPassword();
			  passwd=String.copyValueOf(ch);
			  char ch1[]=passwordField_1.getPassword();
			  passwd1=String.copyValueOf(ch1);
			  con=new Dbinfo().con;
			  String query= "select * from reg_user where name=? and password=?";
			  String query1="update reg_user set password=? where password=?";
			  try
			  {
				  PreparedStatement ps=con.prepareStatement(query);
				  PreparedStatement ps1=con.prepareStatement(query1);
				  ps.setString(1, s);
				  ps.setString(2, cpasswd);
				  res=ps.executeQuery();
				  while(res.next())
				  {
					  flag=1;
					  break;
				  }
				  if(flag==1)
				  {
					if(passwd.equals(passwd1)) 
					{
					    ps1.setString(1,passwd);
					    ps1.setString(2,cpasswd );
						flag1=ps1.executeUpdate();
						JOptionPane.showMessageDialog(getParent(), "Password changed !","information",JOptionPane.INFORMATION_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
						passwordField_1.setText(null);
					}
					else
					{
						JOptionPane.showMessageDialog(getParent(), "Password does not match !", "Error", JOptionPane.ERROR_MESSAGE);
					}
				  }
				  else
				  {
					  JOptionPane.showMessageDialog(getParent(), "Current Password is Incorrect !","Error",JOptionPane.ERROR_MESSAGE);
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			  
			  
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addGap(41)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_2))
									.addGap(57)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField_1)
										.addComponent(passwordField)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangePassword)
						.addComponent(btnExit))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
