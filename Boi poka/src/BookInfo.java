import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class BookInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtWriteMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfo frame = new BookInfo();
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
	public BookInfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\kisspng-black-white-computer-icons-book-png-book-icon-5ab02df11585d6.9013344215214955370882.jpg"));
		setTitle("Book Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground( new Color(45, 152, 218) );
		
		JLabel bookInfo_lable = new JLabel("Book Information");
		bookInfo_lable.setHorizontalAlignment(SwingConstants.CENTER);
		bookInfo_lable.setForeground(new Color(255, 255, 255));
		bookInfo_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookInfo_lable.setBounds(1, 30, 599, 30);
		contentPane.add(bookInfo_lable);
		
		JLabel bookImage = new JLabel("");
		bookImage.setIcon(new ImageIcon("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\150canadianstories-Book-Cover-3D-x800.jpg"));
		bookImage.setFont(new Font("Segoe UI", Font.BOLD, 16));
		bookImage.setHorizontalAlignment(SwingConstants.CENTER);
		bookImage.setBounds(10, 70, 150, 150);
		contentPane.add(bookImage);
		
		JLabel bookName = new JLabel("Book Name");
		bookName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookName.setForeground(new Color(255, 255, 255));
		bookName.setHorizontalAlignment(SwingConstants.LEFT);
		bookName.setBounds(250, 90, 200, 30);
		contentPane.add(bookName);
		
		JLabel ownerName = new JLabel("Owner Name");
		ownerName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ownerName.setForeground(new Color(255, 255, 255));
		ownerName.setHorizontalAlignment(SwingConstants.LEFT);
		ownerName.setBounds(250, 130, 200, 30);
		contentPane.add(ownerName);
		
		JLabel ownerContact = new JLabel("Owner  Contact");
		ownerContact.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ownerContact.setForeground(new Color(255, 255, 255));
		ownerContact.setHorizontalAlignment(SwingConstants.LEFT);
		ownerContact.setBounds(250, 170, 200, 30);
		contentPane.add(ownerContact);
		
		JLabel bookDetails = new JLabel("Book Details");
		bookDetails.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookDetails.setForeground(new Color(255, 255, 255));
		bookDetails.setHorizontalAlignment(SwingConstants.LEFT);
		bookDetails.setBounds(250, 210, 200, 30);
		contentPane.add(bookDetails);
		
		JLabel message = new JLabel("Message");
		message.setFont(new Font("Segoe UI", Font.BOLD, 14));
		message.setForeground(new Color(255, 255, 255));
		message.setHorizontalAlignment(SwingConstants.LEFT);
		message.setBounds(250, 290, 70, 30);
		contentPane.add(message);
		
		JButton donate_btn = new JButton("Send Donate Request");
		donate_btn.setBackground(new Color(19, 15, 64));
		donate_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		donate_btn.setForeground(new Color(255, 255, 255));
		donate_btn.setBounds(385, 350, 175, 30);
		contentPane.add(donate_btn);
		
		txtWriteMessage = new JTextField();
		txtWriteMessage.setBounds(329, 290, 231, 30);
		contentPane.add(txtWriteMessage);
		txtWriteMessage.setColumns(10);
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(526, 386, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
	}
}
