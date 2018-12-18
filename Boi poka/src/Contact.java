import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contact extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact frame = new Contact();
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
	public Contact() {
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
	
	public void degine(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Boi Poka");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(27, 11, 141, 50);
		contentPane.add(label_1);
		
		JLabel lblContactUs = new JLabel("Contact Us");
		lblContactUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactUs.setForeground(Color.WHITE);
		lblContactUs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactUs.setBackground(Color.BLACK);
		lblContactUs.setBounds(10, 452, 158, 35);
		contentPane.add(lblContactUs);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userhome frame = new userhome();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(10, 86, 158, 35);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Donate Books");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Donate frame = new Donate();
				frame.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(10, 270, 158, 35);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Games");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 360, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("About");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About frame = new About();
				frame.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 406, 158, 35);
		contentPane.add(button_3);
		
		JButton button_5 = new JButton("Profile");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profile frame = new profile();
				frame.setVisible(true);
				dispose();
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(10, 132, 158, 35);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Wish List");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wishlist frame = new Wishlist();
				frame.setVisible(true);
				dispose();
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(10, 224, 158, 35);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Log Out");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_7.setBackground(Color.BLACK);
		button_7.setBounds(10, 499, 158, 35);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Favourite ");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavouriteBooks frame = new FavouriteBooks();
				frame.setVisible(true);
				dispose();
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_8.setBackground(Color.BLACK);
		button_8.setBounds(10, 177, 158, 35);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("Sell Books");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sell frame = new Sell();
				frame.setVisible(true);
				dispose();
			}
		});
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_9.setBackground(Color.BLACK);
		button_9.setBounds(10, 316, 158, 35);
		contentPane.add(button_9);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setIcon(new ImageIcon(Contact.class.getResource("/picture/black.jpg")));
		lblContact.setBackground(Color.BLACK);
		lblContact.setBounds(0, 0, 168, 579);
		contentPane.add(lblContact);
	}

}
