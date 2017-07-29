import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class HowToVote extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowToVote frame = new HowToVote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public HowToVote() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 403);
		setResizable(false);
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnGotIt = new JButton("Got it !!");
		btnGotIt.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		btnGotIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		JLabel lblHowToVote = new JLabel("How To Vote ");
		lblHowToVote.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblNewLabel = new JLabel("For casting your valuable vote you must be pre-registered with us having your voter ID and a ");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_1 = new JLabel("unique password. After login you can cast your vote following underwritten steps :- ");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_2 = new JLabel(">>STEP 1: select your Party name.");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_3 = new JLabel(">>STEP 2: select your candidate.");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_4 = new JLabel(">>STEP 3: click on VOTE to successfully cast your vote.");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_5 = new JLabel("NOTE : In any case you will not be allowed to re-vote in the same session, so please do not ");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNewLabel_6 = new JLabel("share your userID and password with anyone !!");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_6.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(249)
							.addComponent(lblHowToVote))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(221)
							.addComponent(btnGotIt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(lblNewLabel_6)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblHowToVote)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(lblNewLabel_1)
					.addGap(29)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addGap(42)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnGotIt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
