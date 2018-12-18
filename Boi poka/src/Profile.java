import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		design();
	}
	
	public void design() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\img_87237.png"));
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground( new Color(45, 152, 218) );
		
		JButton allBook_btn = new JButton("All Books");
		allBook_btn.setBackground(new Color(19, 15, 64));
		allBook_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		allBook_btn.setForeground(new Color(255, 255, 255));
		allBook_btn.setBounds(470, 11, 110, 30);
		contentPane.add(allBook_btn);
		
		JLabel userimg = new JLabel("");
		userimg.setIcon(new ImageIcon("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\user.png"));
		userimg.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userimg.setHorizontalAlignment(SwingConstants.CENTER);
		userimg.setBounds(10, 60, 150, 150);
		contentPane.add(userimg);
		
		JLabel userName = new JLabel("User Name");
		userName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		userName.setForeground(new Color(255, 255, 255));
		userName.setHorizontalAlignment(SwingConstants.LEFT);
		userName.setBounds(250, 90, 200, 30);
		contentPane.add(userName);
		
		JLabel userBook= new JLabel("My Book List");
		userBook.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userBook.setForeground(new Color(255, 255, 255));
		userBook.setHorizontalAlignment(SwingConstants.LEFT);
		userBook.setBounds(250, 130, 200, 30);
		contentPane.add(userBook);
		
		JButton editProfile_btn = new JButton("Edit Profile");
		editProfile_btn.setBackground(new Color(19, 15, 64));
		editProfile_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		editProfile_btn.setForeground(new Color(255, 255, 255));
		editProfile_btn.setBounds(10, 240, 150, 30);
		contentPane.add(editProfile_btn);
		
		JButton donateReq_btn = new JButton("Donet Request");
		donateReq_btn.setBackground(new Color(19, 15, 64));
		donateReq_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		donateReq_btn.setForeground(new Color(255, 255, 255));
		donateReq_btn.setBounds(10, 280, 150, 30);
		contentPane.add(donateReq_btn);
		
		JButton updateBook_btn = new JButton("Update Book");
		updateBook_btn.setBackground(new Color(19, 15, 64));
		updateBook_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		updateBook_btn.setForeground(new Color(255, 255, 255));
		updateBook_btn.setBounds(250, 350, 140, 30);
		contentPane.add(updateBook_btn);
		
		JButton addBook_btn = new JButton("+Add Book");
		addBook_btn.setBackground(new Color(19, 15, 64));
		addBook_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addBook_btn.setForeground(new Color(255, 255, 255));
		addBook_btn.setBounds(420, 350, 140, 30);
		contentPane.add(addBook_btn);
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(526, 386, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
	}
}
