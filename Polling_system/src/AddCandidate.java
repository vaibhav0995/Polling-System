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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddCandidate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAdd;
	private JButton btnCancel;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCandidate frame = new AddCandidate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public AddCandidate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 242);
		setResizable(false);
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblParty = new JLabel(" Party Name");
		lblParty.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCandidateName = new JLabel("Candidate Name");
		lblCandidateName.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int flag=0;
				String p_name=textField.getText();
				String c_name=textField_1.getText();
				if(p_name.length()==0 || c_name.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "please fill all fields","error",JOptionPane.ERROR_MESSAGE);
				}
				Connection con=new Dbinfo().con;
				String query="insert into voting values (?,?,?)";
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, p_name);
					ps.setString(2, c_name);
					ps.setInt(3, 0);
					flag=ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Candidate added!!","Success",JOptionPane.INFORMATION_MESSAGE);
				     textField.setText(null);
				     textField_1.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), "failed","error",JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 13));
		btnCancel.addActionListener(new ActionListener() {
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
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCandidateName)
								.addComponent(lblParty))
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblParty)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCandidateName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnAdd))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
