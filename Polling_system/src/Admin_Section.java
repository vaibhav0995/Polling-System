import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;

public class Admin_Section extends JFrame {

	private JPanel contentPane;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Section frame = new Admin_Section(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	String s1,s2,s3,s4,s5;
	public Admin_Section(String uname,String s) 
	{
		setTitle("Admin Section");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 791, 498);
		setLocationRelativeTo(this);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMyProfile = new JMenu("View");
		mnMyProfile.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		
		menuBar.add(mnMyProfile);
		
		JMenuItem mntmMyProfile = new JMenuItem("My Profile");
		
		KeyStroke kf=KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_DOWN_MASK);
		mntmMyProfile.setAccelerator(kf);
		mntmMyProfile.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String query="select * from reg_user where id=?";
				  Connection con=new Dbinfo().con;
				  try
				  {
					  PreparedStatement ps=con.prepareStatement(query);
					  ps.setString(1,s);
					  ResultSet res=ps.executeQuery();
					  while(res.next())
					  {
						  s1=res.getString(3);
						   s2=res.getString(1);
						   s3=res.getString(4);
						   s4=res.getString(5);
						   s5=res.getString(6);
						  break;
					  }
					
	                new UserDetail1(s1,s2,s3,s4,s5,s2).setVisible(true);
				   
					  
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
			}
		});
		mnMyProfile.add(mntmMyProfile);
		
		JMenu mnMore = new JMenu("More");
		mnMore.setBackground(new Color(138, 43, 226));
		mnMore.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnMore);
		
		JMenu mnEdit = new JMenu("Edit");
		
		mnEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnMore.add(mnEdit);
		
		JMenuItem mntmName = new JMenuItem("name");
		mntmName.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new Edit(s,"name").setVisible(true);
			}
		});
		mnEdit.add(mntmName);
		
		JMenuItem mntmMobile = new JMenuItem("mobile");
		mntmMobile.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmMobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new Edit(s,"mobile").setVisible(true);
			}
		});
		mnEdit.add(mntmMobile);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int result=JOptionPane.showConfirmDialog(getParent(),"Do you really want to logout","Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION)
				{
					new Login_Page().setVisible(true);
					dispose();
					setVisible(false);
				}
				else
				{
					
				}
			}
		});
		
		JMenuItem mntmRemoveAnyUser = new JMenuItem("remove any user");
		//mntmRemoveAnyUser.setLabel("ctrl+r");
		KeyStroke kf1=KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_DOWN_MASK);
		mntmRemoveAnyUser.setAccelerator(kf1);
		mntmRemoveAnyUser.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmRemoveAnyUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new RemoveUser().setVisible(true);
			}
		});
		mnMore.add(mntmRemoveAnyUser);
		
		JMenuItem mntmSetAsDefault = new JMenuItem("Set as Default");
		//mntmSetAsDefault.setLabel("ctrl+d");
		KeyStroke kf2=KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_DOWN_MASK);
		mntmSetAsDefault.setAccelerator(kf2);
		mntmSetAsDefault.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmSetAsDefault.setForeground(new Color(255, 0, 0));
		mntmSetAsDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int result=JOptionPane.showConfirmDialog(getParent(),"Set as Default ??","Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION)
				{
					new SetDefault().setDefault();
					JOptionPane.showMessageDialog(getParent(), "Default set Success !!","Success",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
				}
			}
		});
		
		JMenuItem mntmDisplayReultsTo = new JMenuItem("Display Reults to voters");
		mntmDisplayReultsTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 int i=JOptionPane.showConfirmDialog(getParent(), "Display results to voters ??","Sure",JOptionPane.YES_NO_OPTION);
			 if(i==JOptionPane.YES_OPTION)
			 {
		      Dbinfo.get_confirm(1);
			 }
			 else
			 {
				 Dbinfo.get_confirm(0);
			 }
			}
		});
		
		JMenuItem mntmRemoveOldNotices = new JMenuItem("remove old notices");
		mntmRemoveOldNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			   new Remove_Notice().setVisible(true);
			}
		});
		mntmRemoveOldNotices.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmRemoveOldNotices.setForeground(new Color(0, 0, 0));
		mnMore.add(mntmRemoveOldNotices);
		mntmDisplayReultsTo.setForeground(Color.RED);
		mntmDisplayReultsTo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnMore.add(mntmDisplayReultsTo);
		mnMore.add(mntmSetAsDefault);
		
		String a="";
		if (Dbinfo.start==false)
	    {
			a="Start ";
		}
		else
		{
			a="end ";
		}
		JMenuItem mntmStartElection = new JMenuItem(a+"election");
		mntmStartElection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Dbinfo.get_start(!Dbinfo.start);
			    Admin_Section obj=new Admin_Section(uname, s);
			    obj.setVisible(false);
			    dispose();
			    obj.setVisible(true);
			}
		});
		mntmStartElection.setForeground(Color.RED);
		mntmStartElection.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		mnMore.add(mntmStartElection);
		mnMore.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome admin "+uname+" !");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBackground(new Color(51, 255, 102));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("admin.png"));
		
		JButton btnNewButton = new JButton("upload voter_ID");
		btnNewButton.setForeground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Stencil", Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  new AddVoters().setVisible(true);
			}
		});
		
		JButton btnSearchUserBy = new JButton("Search user by voter id");
		btnSearchUserBy.setForeground(new Color(95, 158, 160));
		btnSearchUserBy.setFont(new Font("Stencil", Font.ITALIC, 17));
		btnSearchUserBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  new Search().setVisible(true);
			}
		});
		
		JButton btnResults = new JButton("RESULTS");
		btnResults.setFont(new Font("Stencil", Font.ITALIC, 18));
		btnResults.setForeground(new Color(255, 0, 0));
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  new Result().setVisible(true);
			}
		});
		
		JButton btnAddNewAdmin = new JButton("Add new Admin");
		btnAddNewAdmin.setForeground(new Color(95, 158, 160));
		btnAddNewAdmin.setFont(new Font("Stencil", Font.ITALIC, 18));
		btnAddNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  new Register("admin").setVisible(true);
			}
		});
		
		JButton btnChangePassword = new JButton("Add Candidates List");
		btnChangePassword.setFont(new Font("Stencil", Font.ITALIC, 18));
		btnChangePassword.setForeground(new Color(95, 158, 160));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			  new AddCandidate().setVisible(true);
			}
		});
		
		JButton btnAddNotice = new JButton("Add Notice");
		btnAddNotice.setForeground(new Color(95, 158, 160));
		btnAddNotice.setFont(new Font("Stencil", Font.ITALIC, 18));
		btnAddNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 
			 new Notice().setVisible(true);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(378, Short.MAX_VALUE)
					.addComponent(btnAddNotice, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(283))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(25)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addComponent(btnSearchUserBy)
									.addGap(18)
									.addComponent(btnResults, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(130)
											.addComponent(btnAddNewAdmin, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSearchUserBy, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnResults, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddNewAdmin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnAddNotice, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
