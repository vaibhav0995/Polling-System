import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class View_Notice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Notice frame = new View_Notice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public View_Notice() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 487);
		setResizable(false);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(109, 109, 109));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectNotice = new JLabel("select Notice :");
		lblSelectNotice.setForeground(Color.GREEN);
		lblSelectNotice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		 Connection con=Dbinfo.con;
		 String q="select * from notice";
		 Vector<String> v=new Vector<>();
		 try
		 {
			 PreparedStatement ps=con.prepareStatement(q);
			 ResultSet r=ps.executeQuery();
			 while(r.next())
			 {
				 String s=r.getString(1);
				 v.add(s);
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		JComboBox comboBox = new JComboBox(v);
		comboBox.insertItemAt("Select", 0);
		comboBox.setSelectedIndex(0);
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(SystemColor.textInactiveText);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { dispose();
			}
		});
		btnNewButton.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 13));
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 String text=null;
			String s=(String)comboBox.getSelectedItem();
			 String query="select * from notice where subject=?";
			 Connection con=Dbinfo.con;
			 try
			 {
				 PreparedStatement ps=con.prepareStatement(query);
				 ps.setString(1, s);
				 ResultSet res=ps.executeQuery();
				 while(res.next())
				 {
				  text=res.getString(2);
				 }
				 textArea.setLineWrap(true);
				 textArea.setText(text);
				
				 textArea.setEditable(false);
				 
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(205)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnView, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSelectNotice)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectNotice))
					.addGap(18)
					.addComponent(btnView)
					.addGap(28)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
