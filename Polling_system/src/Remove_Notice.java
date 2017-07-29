import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Remove_Notice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove_Notice frame = new Remove_Notice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Remove_Notice() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 413, 203);
		setResizable(false);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectNoticeTo = new JLabel("Select Notice to be removed");
		lblSelectNoticeTo.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		Vector<String> v=new Vector<>();
		Connection con=Dbinfo.con;
		String query="select subject from notice";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
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
		comboBox.insertItemAt("select", 0);
		comboBox.setSelectedIndex(0);
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  int flag=0;
			  String sub=(String)comboBox.getSelectedItem();
			  String query="delete from notice where subject=?";
			  Connection con=Dbinfo.con;
			  try
			  {
				  PreparedStatement ps=con.prepareStatement(query);
				  ps.setString(1, sub);
				  flag=ps.executeUpdate();
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			  if(flag==1)
			  {
				  JOptionPane.showMessageDialog(getParent(), "Notice deleted !!","Success",JOptionPane.INFORMATION_MESSAGE);
			      dispose();
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(getParent(), " Deletion Failed !!","error",JOptionPane.ERROR_MESSAGE);

			  }
			}
		});
		btnRemove.setForeground(Color.RED);
		btnRemove.setFont(new Font("Sitka Text", Font.PLAIN, 13));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectNoticeTo)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(68, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblSelectNoticeTo)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemove)
						.addComponent(btnCancel))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
