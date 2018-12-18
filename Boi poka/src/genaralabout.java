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
import javax.swing.JTextPane;

public class genaralabout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					genaralabout frame = new genaralabout();
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
	public genaralabout() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(genaralabout.class.getResource("/picture/app.jpg")));
		setTitle("about");
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
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("Boi Poka");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(10, 11, 141, 50);
		contentPane.add(label_1);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAbout.setBackground(Color.BLACK);
		lblAbout.setBounds(10, 329, 158, 35);
		contentPane.add(lblAbout);
		
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
		button.setBounds(10, 146, 158, 35);
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
		button_1.setBounds(10, 192, 158, 35);
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
		button_2.setBounds(10, 236, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Games");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralgame frame = new genaralgame();
				frame.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 282, 158, 35);
		contentPane.add(button_3);
		
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
		button_6.setBounds(10, 100, 158, 35);
		contentPane.add(button_6);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(genaralabout.class.getResource("/picture/green wall - Copy.jpg")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(10, 328, 158, 35);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(genaralabout.class.getResource("/picture/black.jpg")));
		label.setBounds(0, 0, 168, 472);
		contentPane.add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(224, 255, 255));
		textPane.setText("In the 21TH century, online shop has become the philopher's stone. The necessity of books to every level of people and the advantages of online store has emerged the project Boipoka as the a successful one.\r\n\r\nBoipoka is an software, where the customer can get bookeasily. A customer search a book by book title,add his booklist and finaly purchase the book.he can sell his book and also can donate them to others.In this software there are some fun games are also avaiable.\r\n\r\nFor this project out group members are\r\nAbrar Khan\r\nMd tawhidul islam\r\nRayhan hossen\r\nMst. Tazma khatun\r\nMd. Maraj-ul-islam");
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setEditable(false);
		textPane.setBounds(202, 113, 483, 359);
		contentPane.add(textPane);
		
		JLabel label_3 = new JLabel("Boi Poka");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 100, 0));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(314, 24, 308, 73);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(genaralabout.class.getResource("/picture/logo2.png")));
		label_4.setBounds(273, 24, 120, 73);
		contentPane.add(label_4);
	}

}
