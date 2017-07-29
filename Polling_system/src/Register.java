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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	String vid,name,age,gender,mobile,utype,passwd,passwd1;
	Connection con=null;
	ResultSet res=null;
	int flag=0,flag1=0;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
   
	String value[]={"Select","Male","Female"};
	JComboBox comboBox = new JComboBox(value); 
	public void reset()
	 {
		 textField.setText(null);
	      textField_1.setText(null);
	      textField_2.setText(null);
	      textField_3.setText(null);
	      passwordField.setText(null);
         passwordField_1.setText(null);
         comboBox.setSelectedIndex(0);

	 }
	
	public Register(String s) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 669);
		setResizable(false);
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("images1.jpg"));
		
		JLabel lblVoterId = new JLabel(s+" ID");
		lblVoterId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		if(s=="admin")
		{
			 vid="";
			for(int i=1;i<=7;i++)
			{
				vid+=(int)(Math.random()*9)+1;
			}
			textField.setText(vid);
			textField.setEditable(false);
		}
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		comboBox.setSelectedIndex(0);
		
	
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblUserType = new JLabel("User type");
		lblUserType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		 utype=s;
		  textField_4.setText(utype);
		  textField_4.setEditable(false);
		JButton btnRegister = new JButton("register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setForeground(new Color(255, 0, 0));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  vid=textField.getText();
			  name=textField_1.getText();
			  age=textField_2.getText();
			  gender=(String)comboBox.getSelectedItem();
			  mobile=textField_3.getText();
			 
			  char ch[]=passwordField.getPassword();
			  passwd=String.copyValueOf(ch);
			  char ch1[]=passwordField_1.getPassword();
			  passwd1=String.copyValueOf(ch1);
			  if(vid.length()==0 || name.length()==0 || age.length()==0 || gender=="select" || mobile.length()==0 || mobile.length()<10 || passwd.length()==0)
			  {
				  JOptionPane.showMessageDialog(getParent(),"Please fill all fields !","Error",JOptionPane.ERROR_MESSAGE);
			  }
			  else{
			  con=new Dbinfo().con;
			  String query="select * from id where voter_id=?";
			  String query1="insert into reg_user values(?,?,?,?,?,?,?,?)";
			 if(s.equals("voter"))
			 {
			  try
			  {
			   PreparedStatement ps=con.prepareStatement(query);
			   PreparedStatement ps1=con.prepareStatement(query1);
               ps.setString(1, vid);
               ps1.setString(2, passwd);
               ps1.setString(3, name);
               ps1.setString(4, age);
               ps1.setString(5, gender);
               ps1.setString(6, mobile);
               ps1.setString(7, utype);
               ps1.setInt(8, 0);
               ps1.setString(1, vid);

               res=ps.executeQuery();
              // flag1=ps.executeUpdate();
               while(res.next())
               {
            	  flag=1;
            	  break;
               }
               if(flag==1 && passwd.equals(passwd1) )
               {
            	   flag=ps1.executeUpdate();
               }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			} 
			  else
			  {
				  try{
				  PreparedStatement ps1=con.prepareStatement(query1);
	               ps1.setString(2, passwd);
	               ps1.setString(3, name);
	               ps1.setString(4, age);
	               ps1.setString(5, gender);
	               ps1.setString(6, mobile);
	               ps1.setString(7, utype);
	               ps1.setString(8, "0");
	               ps1.setString(1, vid);
				   flag=ps1.executeUpdate();
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
			  }
			  if(flag==1 )
			  {
				  JOptionPane.showMessageDialog(getParent(),"Succesfully Registered !!", "success", JOptionPane.INFORMATION_MESSAGE);  
			      reset();
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(getParent(),"Registration failed !!", "error", JOptionPane.ERROR_MESSAGE); 
		          reset();
			  }
			}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
	           		reset();
			}
		});
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(btnQuit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(49)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblReenterPassword, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVoterId, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblUserType, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
									.addGap(47))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(109)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblGender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblName, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblMobile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(58)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(passwordField)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_2)
									.addComponent(textField)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
									.addComponent(textField_3)
									.addComponent(textField_4)))))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVoterId))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAge))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMobile))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserType))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReenterPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnQuit)
						.addComponent(btnReset))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
