import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RemoveUser extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveUser frame = new RemoveUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public RemoveUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 196);
		setTitle("Remove User");
		setResizable(false);
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectVoterId = new JLabel("Select voter ID");
		lblSelectVoterId.setForeground(Color.RED);
		lblSelectVoterId.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
		Vector<String> v=new Vector<>();
		Connection con=new Dbinfo().con;
		ResultSet res=null;
		String query="select * from reg_user";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			res=ps.executeQuery();
			while(res.next())
			{
				String s=res.getString(1);
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
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setForeground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String id=(String)comboBox.getSelectedItem();
				
				String query1="delete from reg_user where id=?";
				try
				{
					PreparedStatement ps1=con.prepareStatement(query1);
					ps1.setString(1,id);
					if(id=="select")
					{
						JOptionPane.showMessageDialog(getParent(), "Please select a voter id","Error",JOptionPane.ERROR_MESSAGE);
					}
					else{
					int result=JOptionPane.showConfirmDialog(getParent(),"Delete "+id,"Information", JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION)
					{
						int flag=ps1.executeUpdate();
						if(flag==1)
						{
						JOptionPane.showMessageDialog(getParent(), id+" Deleted !","Success",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						}
						else
					    JOptionPane.showMessageDialog(getParent(), "Error Occured !","failed",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						
					}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
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
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblSelectVoterId)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnCancel))
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectVoterId)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnCancel))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
