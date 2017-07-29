import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Voter_Section1 extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voter_Section1 frame = new Voter_Section1(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Voter_Section1(String name,String s){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 759, 489);
		setTitle("Voter Section");
		setResizable(false);
		Vector<String> v=new Vector<>();
		Vector<String> v1=new Vector<>();
		
		String query="select * from voting";
		Connection con=new Dbinfo().con;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				String s1=res.getString(1);
				String s2=res.getString(2);
				if(Dbinfo.start==true){
				v.add(s1);
				v1.add(s2);}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JComboBox comboBox = new JComboBox(v);
		
		JComboBox comboBox_1 = new JComboBox(v1);
        comboBox.insertItemAt("select", 0);
        comboBox.setSelectedIndex(0);	
        comboBox.setToolTipText("select Party Name");
        comboBox_1.insertItemAt("select", 0);
        comboBox_1.setSelectedIndex(0);	
        comboBox_1.setToolTipText("select Candidate Name");
        JLabel lblPartyName = new JLabel("Party Name");
        lblPartyName.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
        lblPartyName.setForeground(new Color(255, 0, 0));
		
		JLabel lblCandidate = new JLabel("Candidate");
		lblCandidate.setForeground(new Color(255, 0, 0));
		lblCandidate.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("FormattedTextField.caretForeground"));
		setJMenuBar(menuBar);
		
		JMenu mnNotices = new JMenu("View");
		mnNotices.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 12));
		menuBar.add(mnNotices);
		
		JMenuItem mntmNotices = new JMenuItem("Notices");
		mntmNotices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			  new View_Notice().setVisible(true);
			}
		});
		mntmNotices.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnNotices.add(mntmNotices);
		
		JMenuItem mntmResults = new JMenuItem("Results");
		mntmResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Dbinfo.c==0)
				{
					JOptionPane.showMessageDialog(getParent(),"Sorry can't display results at this moment !!","information",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					 JFrame frm=new JFrame();
						
						frm.setSize(500, 300);
						frm.setLocationRelativeTo(frm);
						frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
						
						Dbinfo.getTable();
						
						JTable t=new JTable(Dbinfo.outer, Dbinfo.header);
						JScrollPane pane=new JScrollPane(t);
						frm.getContentPane().add(pane);
						frm.setVisible(true);
				}
			}
		});
		mntmResults.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mnNotices.add(mntmResults);
		
		JMenu mnProfile = new JMenu("Profile");
		mnProfile.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnProfile);
		
		JMenuItem mntmMyProfile = new JMenuItem("My Profile");
		KeyStroke kf=KeyStroke.getKeyStroke(KeyEvent.VK_M,KeyEvent.CTRL_DOWN_MASK);
		mntmMyProfile.setAccelerator(kf);
		mntmMyProfile.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmMyProfile.addActionListener(new ActionListener() {
			 String s1,s2,s3,s4,s5;
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
		mnProfile.add(mntmMyProfile);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		mnProfile.add(mnEdit);
		
		JMenuItem mntmMobile = new JMenuItem("mobile");
		mntmMobile.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmMobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				new Edit(s,"mobile").setVisible(true);
			}
		});
		mnEdit.add(mntmMobile);
		
		JMenuItem mntmName = new JMenuItem("name");
		mntmName.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				 new Edit(s,"name").setVisible(true);
			}
		});
		mnEdit.add(mntmName);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmLogOut.setForeground(Color.RED);
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int result=JOptionPane.showConfirmDialog(getParent(),"Do you really want to logout","Information", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION)
				{
					new Login_Page().setVisible(true);
					dispose();
				}
				else
				{
					
				}
			}
		});
		mnProfile.add(mntmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 16));
		menuBar.add(mnHelp);
		
		JMenuItem mntmHowToVote = new JMenuItem("How to vote");
		KeyStroke kf1=KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_DOWN_MASK);
		mntmHowToVote.setAccelerator(kf1);
		mntmHowToVote.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmHowToVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new HowToVote().setVisible(true);
			}
		});
		mnHelp.add(mntmHowToVote);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				 new About().setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("voter.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Welcome "+name+" !!");
		lblNewLabel_1.setFont(new Font("Pristina", Font.BOLD | Font.ITALIC, 17));
		
		JButton btnNewButton = new JButton(new ImageIcon("vote.jpg"));
		btnNewButton.setToolTipText("click to vote");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  Connection con=new Dbinfo().con;
			  String c_name=null;
			  String p_name=(String)comboBox.getSelectedItem();
			  String q="select * from voting where party=?";
			  try
			  {
				  PreparedStatement p=con.prepareStatement(q);
				  p.setString(1,p_name);
				  ResultSet r=p.executeQuery();
				  while(r.next())
				  {
					  c_name=r.getString(2);
				  }
				  comboBox_1.setSelectedItem(c_name);
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			  c_name=(String)comboBox_1.getSelectedItem();
			  if(p_name=="select" || c_name=="select")
			  {
				  JOptionPane.showMessageDialog(getParent(), "Failed !!","Error",JOptionPane.ERROR_MESSAGE);

			  }
			  else{
			  int status=0;
			  int flag=0,flag1=0;
			  ResultSet res=null;
			  String query="select * from reg_user where id=?";
			  String query1="update voting set votes= votes+1 where party=? and candidate=?";
			  String query2="update reg_user set status=1 where id=?";
			 
			  try
			  {
				  PreparedStatement ps=con.prepareStatement(query);
				  PreparedStatement ps1=con.prepareStatement(query1);
				  PreparedStatement ps2=con.prepareStatement(query2);
				  ps.setString(1, s);
				  res=ps.executeQuery();
				  while(res.next())
				  {
					  status=res.getInt(8);
				  }
				  if(status==1)
				  {
					  JOptionPane.showMessageDialog(getParent(), "Sorry ! you have already voted for this session !","Error",JOptionPane.ERROR_MESSAGE);
				  }
				  else
				  {
					  ps1.setString(1,p_name);
					  ps1.setString(2, c_name);
					  ps2.setString(1, s);
					  flag=ps1.executeUpdate();
					  //flag1=ps2.executeUpdate();
					  if(flag==1 )
					  {
						  flag1=ps2.executeUpdate();
						  JOptionPane.showMessageDialog(getParent(), "Voted Successfully ! Thank You","Success",JOptionPane.INFORMATION_MESSAGE);
                         
					  }
					  else
					  {
						  JOptionPane.showMessageDialog(getParent(), "Failed !!","Error",JOptionPane.ERROR_MESSAGE);

					  }
				  }
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon());
       
		
		
		 
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addGap(79))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(lblNewLabel_2)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCandidate)
							.addGap(87))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPartyName, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(12)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, 0, 262, Short.MAX_VALUE)
						.addComponent(comboBox, 0, 262, Short.MAX_VALUE))
					.addGap(168))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(332)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)
							.addGap(5)
							.addComponent(lblNewLabel_2)
							.addGap(92)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPartyName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCandidate))
							.addGap(62)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
