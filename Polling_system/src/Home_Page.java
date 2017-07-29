import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;


public class Home_Page extends JFrame 

{

	private JPanel contentPane;

	static JProgressBar progressBar = new JProgressBar(0,100);

	 static Home_Page frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Home_Page();
					frame.setVisible(true);
                    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        ProgressBar.setValue(progressBar);

		new Login_Page().setVisible(true);
		
		frame.dispose();
	}

	
	public Home_Page() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 440);
		setLocationRelativeTo(this);

		try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("ECI.jpg"));
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("advertisement.jpg"));
		
		getContentPane().add(BorderLayout.SOUTH,progressBar);

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(258, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(230))
				.addComponent(progressBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(194)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
