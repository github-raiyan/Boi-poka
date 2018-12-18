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
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/picture/app.jpg")));
		setTitle("About");
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
		contentPane.setBackground(new Color(224, 255, 255));
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
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAbout.setBackground(Color.BLACK);
		lblAbout.setBounds(10, 404, 158, 35);
		contentPane.add(lblAbout);
		
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
		button.setBounds(10, 83, 158, 35);
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
		button_1.setBounds(10, 267, 158, 35);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Games");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game frame = new Game();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 357, 158, 35);
		contentPane.add(button_2);
		
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
		button_5.setBounds(10, 129, 158, 35);
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
		button_6.setBounds(10, 221, 158, 35);
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
		button_7.setBackground(new Color(178, 34, 34));
		button_7.setBounds(10, 450, 158, 35);
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
		button_8.setBounds(10, 174, 158, 35);
		contentPane.add(button_8);
		
		JButton btnSellBooks = new JButton("Sell Books");
		btnSellBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sell frame = new Sell();
				frame.setVisible(true);
				dispose();			
			}
		});
		btnSellBooks.setForeground(Color.WHITE);
		btnSellBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSellBooks.setBackground(Color.BLACK);
		btnSellBooks.setBounds(10, 313, 158, 35);
		contentPane.add(btnSellBooks);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(About.class.getResource("/picture/green wall - Copy.jpg")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(10, 404, 158, 35);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/picture/black.jpg")));
		label.setBackground(Color.BLACK);
		label.setBounds(0, 0, 168, 579);
		contentPane.add(label);
		
		JTextPane txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl = new JTextPane();
		txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl.setBackground(new Color(224, 255, 255));
		txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl.setEditable(false);
		txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl.setText("In the 21TH century, online shop has become the philopher's stone. The necessity of books to every level of people and the advantages of online store has emerged the project Boipoka as the a successful one.\r\n\r\nBoipoka is an software, where the customer can get bookeasily. A customer search a book by book title,add his booklist and finaly purchase the book.he can sell his book and also can donate them to others.In this software there are some fun games are also avaiable.\nWebsite: sites.google.com/diu.edu.bd/soft-71\r\n\r\nFor this project our group members are\r\nAbrar Khan\r\nMd Tawhidul islam\r\nRaiyan Hossain\r\nMst. Tazma khatun\r\nMd. Maraj-ul-islam");
		txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl.setBounds(189, 141, 483, 359);
		contentPane.add(txtpnAldfkjsdfjAkdflkjlaksdjflkKjldkfjlkasjdfl);
		
		JLabel label_3 = new JLabel("Boi Poka");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 100, 0));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(321, 45, 308, 73);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(About.class.getResource("/picture/logo2.png")));
		label_4.setBounds(267, 45, 120, 73);
		contentPane.add(label_4);
	}
}
