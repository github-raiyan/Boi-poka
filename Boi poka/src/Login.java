import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		design();
	}
	
	public void design() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\register-secure-security-user-login-icon--7.png"));
		setFont(null);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground( new Color(45, 152, 218) );
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login_lable = new JLabel("Login");
		login_lable.setHorizontalAlignment(SwingConstants.CENTER);
		login_lable.setForeground(new Color(255, 255, 255));
		login_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		login_lable.setBounds(1, 30, 599, 30);
		contentPane.add(login_lable);
		
		JTextArea userEmail_tf = new JTextArea("");
		userEmail_tf.setLineWrap(true);
		userEmail_tf.setForeground(new Color(0, 0, 0));
		userEmail_tf.setToolTipText("");
		userEmail_tf.setBounds(201, 80, 300, 30);
		contentPane.add(userEmail_tf);
		
		JLabel userId_lable = new JLabel("Email");
		userId_lable.setHorizontalAlignment(SwingConstants.CENTER);
		userId_lable.setForeground(new Color(255, 255, 255));
		userId_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userId_lable.setBounds(101, 80, 100, 30);
		contentPane.add(userId_lable);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 141, 300, 30);
		contentPane.add(passwordField);
		
		JLabel pass_lable = new JLabel("Password");
		pass_lable.setHorizontalAlignment(SwingConstants.CENTER);
		pass_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		pass_lable.setBounds(101, 141, 100, 30);
		contentPane.add(pass_lable);
		pass_lable.setForeground(new Color(255, 255, 255));
		
		JButton login_btn = new JButton("Login");
		login_btn.setBackground(new Color(19, 15, 64));
		login_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		login_btn.setForeground(new Color(255, 255, 255));
		login_btn.setBounds(401, 200, 100, 30);
		contentPane.add(login_btn);
		
		JButton reg_btn = new JButton("Register");
		reg_btn.setBackground(new Color(19, 15, 64));
		reg_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		reg_btn.setForeground(new Color(255, 255, 255));
		reg_btn.setBounds(401, 260, 100, 30);
		contentPane.add(reg_btn);
		
		JLabel reg_lable = new JLabel("Don't have account?");
		reg_lable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reg_lable.setBounds(251, 260, 200, 30);
		reg_lable.setForeground(new Color(255, 255, 255));
		contentPane.add(reg_lable);
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(526, 386, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
	}
}
