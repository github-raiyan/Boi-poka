import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BookLover extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookLover frame = new BookLover();
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
	public BookLover() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\img_87237.png"));
		setTitle("Requestor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground( new Color(45, 152, 218) );
		
		JLabel bookInfo_lable = new JLabel("Requestor Information");
		bookInfo_lable.setHorizontalAlignment(SwingConstants.CENTER);
		bookInfo_lable.setForeground(new Color(255, 255, 255));
		bookInfo_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookInfo_lable.setBounds(1, 30, 599, 30);
		contentPane.add(bookInfo_lable);
		
		JLabel requestorImage = new JLabel("");
		requestorImage.setIcon(new ImageIcon("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\download.png"));
		requestorImage.setFont(new Font("Segoe UI", Font.BOLD, 16));
		requestorImage.setHorizontalAlignment(SwingConstants.CENTER);
		requestorImage.setBounds(11, 59, 150, 150);
		contentPane.add(requestorImage);
		
		JLabel bookName = new JLabel("Book Name");
		bookName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookName.setForeground(new Color(255, 255, 255));
		bookName.setHorizontalAlignment(SwingConstants.LEFT);
		bookName.setBounds(250, 90, 200, 30);
		contentPane.add(bookName);
		
		JLabel ownerName = new JLabel("Requestor Name");
		ownerName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ownerName.setForeground(new Color(255, 255, 255));
		ownerName.setHorizontalAlignment(SwingConstants.LEFT);
		ownerName.setBounds(250, 130, 200, 30);
		contentPane.add(ownerName);
		
		JLabel requestorContact = new JLabel("Requestor  Contact");
		requestorContact.setFont(new Font("Segoe UI", Font.BOLD, 14));
		requestorContact.setForeground(new Color(255, 255, 255));
		requestorContact.setHorizontalAlignment(SwingConstants.LEFT);
		requestorContact.setBounds(250, 170, 200, 30);
		contentPane.add(requestorContact);
		
		JLabel requestorMessage = new JLabel("Requestor Message");
		requestorMessage.setFont(new Font("Segoe UI", Font.BOLD, 14));
		requestorMessage.setForeground(new Color(255, 255, 255));
		requestorMessage.setHorizontalAlignment(SwingConstants.LEFT);
		requestorMessage.setBounds(250, 210, 200, 30);
		contentPane.add(requestorMessage);
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(526, 386, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
		
	}

}
