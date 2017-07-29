import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UserDetail1 extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetail1 frame = new UserDetail1(null,null,null,null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public UserDetail1(String s1,String s2,String s3,String s4,String s5,String vid) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 369);
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(" Name :");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_1 = new JLabel("User ID :");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_2 = new JLabel("age :");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Gender :");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Mobile no. :");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_5 = new JLabel(s1);
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_6 = new JLabel(s2);
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_7 = new JLabel(s3);
		lblNewLabel_7.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_8 = new JLabel(s4);
		lblNewLabel_8.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_9 = new JLabel(s5);
		lblNewLabel_9.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel_10 = new JLabel("Details of user ID: "+vid);
		lblNewLabel_10.setForeground(Color.ORANGE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		btnOk.setForeground(Color.DARK_GRAY);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			  dispose();
			}
		});
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
		       new ChangePassword(s1).setVisible(true);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(92)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_9)
										.addComponent(lblNewLabel_8)
										.addComponent(lblNewLabel_7)
										.addComponent(lblNewLabel_6)
										.addComponent(lblNewLabel_5)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
									.addComponent(btnChangePassword)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_10)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_5))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_1))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_2))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_3))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnChangePassword))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
