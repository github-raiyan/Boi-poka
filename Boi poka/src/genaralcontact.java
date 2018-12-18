import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class genaralcontact extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					genaralcontact frame = new genaralcontact();
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
	public genaralcontact() {
		setTitle("Contact");
		degine();
		Centerize();
	}
	
	public void Centerize() {
		Dimension screenSize,frameSize;
		int x,y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width)/2;
		y = (screenSize.height - frameSize.height)/2;
		setLocation(x ,y);
	}
	
	public void degine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Boi Poka");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(10, 23, 141, 50);
		contentPane.add(label_1);
		
		JLabel lblContactUs = new JLabel("Contact Us");
		lblContactUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactUs.setForeground(Color.WHITE);
		lblContactUs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactUs.setBackground(Color.BLACK);
		lblContactUs.setBounds(10, 380, 158, 35);
		contentPane.add(lblContactUs);
		
		JButton button = new JButton("Log in");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(10, 152, 158, 35);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Donate Books");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generaldonate frame = new generaldonate();
				frame.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(10, 198, 158, 35);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Sell Books");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generalsell frame = new Generalsell();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 242, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Games");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 288, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("About");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralabout frame = new genaralabout();
				frame.setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 334, 158, 35);
		contentPane.add(button_4);
		
		JButton button_6 = new JButton("Home");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(10, 106, 158, 35);
		contentPane.add(button_6);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(genaralcontact.class.getResource("/picture/black.jpg")));
		label.setBounds(0, 0, 168, 472);
		contentPane.add(label);
	}

}
