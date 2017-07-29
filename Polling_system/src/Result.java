import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Result extends JFrame {

	private JPanel contentPane;

	
	int total=0;
	String s,s1;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	int max=0,i=0;
	public void getMax()
	{
		String query="select * from voting";
		Connection con=new Dbinfo().con;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if(max<=rs.getInt(3))
				{
					max=rs.getInt(3);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Result() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 272);
		setTitle("Results");
		setResizable(false);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String query="select * from voting";
		String query1="select * from voting where votes=?";
		Connection con=new Dbinfo().con;
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			PreparedStatement ps1=con.prepareStatement(query1);

			ResultSet rs=ps.executeQuery();
			getMax();
			ps1.setInt(1, max);
			ResultSet rs1=ps1.executeQuery();

			while(rs.next())
			{
				total+=rs.getInt(3);
			}
			while(rs1.next())
			{
				s=rs1.getString(1);
				s1=rs1.getString(2);
				i++;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JLabel lblResults = new JLabel("RESULTS");
		lblResults.setForeground(Color.GREEN);
		lblResults.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblTotalNoOf = new JLabel("Total no. of votes >>");
		lblTotalNoOf.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblNewLabel = new JLabel(String.valueOf(total));
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblWinningParty = new JLabel("Winning Party >>");
		lblWinningParty.setForeground(Color.RED);
		lblWinningParty.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
		
        JLabel lblWinningCandidate = new JLabel("Winning Candidate >>");
        lblWinningCandidate.setForeground(Color.RED);
        lblWinningCandidate.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 13));
		
        if(i>1)
        {
        	JOptionPane.showMessageDialog(getParent(), "There is tie between candidates having maximum votes. Go to Tabular Details ","information",JOptionPane.INFORMATION_MESSAGE);
        
        }
       
         JLabel lblNewLabel_1 = new JLabel(s);
         JLabel lblNewLabel_2 = new JLabel(s1);
        
		
		JButton btnTabularDetails = new JButton("Tabular Details");
		btnTabularDetails.setForeground(Color.RED);
		btnTabularDetails.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 14));
		btnTabularDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
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
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(177)
							.addComponent(lblResults))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTotalNoOf)
								.addComponent(lblWinningParty)
								.addComponent(lblWinningCandidate))
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(172)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(133)
							.addComponent(btnTabularDetails, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblResults)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalNoOf)
						.addComponent(lblNewLabel))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblWinningParty))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWinningCandidate)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnTabularDetails)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
