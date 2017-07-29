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
import java.sql.PseudoColumnUsage;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class AddVoters extends JFrame {

	Connection con=null;
	  int flag=0;
     String id=null;
	private JPanel contentPane;
	private JTextField textField;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVoters frame = new AddVoters();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public AddVoters() {
		setResizable(false);
		setTitle("Add voters !!");
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterVoterId = new JLabel("Enter Voter ID :");
		lblEnterVoterId.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		
	btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
		      id=textField.getText();
			  con=Dbinfo.con;
			  String query="insert into id values(?,?)";
			  try
			  {
				  PreparedStatement ps=con.prepareStatement(query);
				  ps.setInt(1,0);
				  ps.setString(2,id);
				 System.out.println(flag);
				  flag=ps.executeUpdate();
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
				  //JOptionPane.showMessageDialog(getParent(),"id Added !","Succes",JOptionPane.INFORMATION_MESSAGE);
			      textField.setText(null);
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(getParent(),"id not Added !","failed",JOptionPane.ERROR_MESSAGE);
			      textField.setText(null);

			  }
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			      textField.setText(null);

			}
		});
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 12));
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
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
							.addComponent(btnQuit)
							.addGap(19))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterVoterId)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnReset)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(162, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnterVoterId)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnReset))
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(136, Short.MAX_VALUE)
					.addComponent(btnQuit)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
