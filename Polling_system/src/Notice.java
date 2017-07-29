import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Notice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice frame = new Notice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public Notice() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 457);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		JLabel lblEnterTextBelow = new JLabel("Enter text below");
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String s=textField.getText();
				Connection con=new Dbinfo().con;
				String note=textArea.getText();
			    if(note.length()==0)
			    {
			    	JOptionPane.showMessageDialog(getParent(), "write something in the field !","Information",JOptionPane.INFORMATION_MESSAGE);
			    }
			    else if(note.length()>1000)
			    {
			    	JOptionPane.showMessageDialog(getParent(), "Notice should be less than 500 words","Information",JOptionPane.INFORMATION_MESSAGE);

			    }
			    else
			    {
			    String query="insert into notice values(?,?)";
			   try
			   {
				   PreparedStatement ps=con.prepareStatement(query);
				  
				   ps.setString(1, s);
				   ps.setString(2, note);
				   ps.executeUpdate();
				  textArea.setText(null);
			    	textField.setText(null);
				  JOptionPane.showMessageDialog(getParent(), "Notice added !","Information",JOptionPane.INFORMATION_MESSAGE);

			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
			 
			}}
		});
		
		JLabel lblSubject = new JLabel("Subject: :");
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEnterTextBelow)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSubject)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(lblEnterTextBelow)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOk)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
