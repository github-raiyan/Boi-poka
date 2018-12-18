import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Register extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		
		design();
	}
	public void design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\img_102074.png"));
		setTitle("Register");
		contentPane.setBackground( new Color(45, 152, 218) );
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel reg_lable = new JLabel("Registration");
		reg_lable.setHorizontalAlignment(SwingConstants.CENTER);
		reg_lable.setForeground(new Color(255, 255, 255));
		reg_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		reg_lable.setBounds(1, 30, 599, 30);
		contentPane.add(reg_lable);
		
		JTextArea userId_tf = new JTextArea("");
		userId_tf.setLineWrap(true);
		userId_tf.setForeground(new Color(0, 0, 0));
		userId_tf.setToolTipText("");
		userId_tf.setBounds(201, 80, 300, 30);
		contentPane.add(userId_tf);
		
		JLabel userId_lable = new JLabel("Name");
		userId_lable.setHorizontalAlignment(SwingConstants.CENTER);
		userId_lable.setForeground(new Color(255, 255, 255));
		userId_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userId_lable.setBounds(101, 80, 100, 30);
		contentPane.add(userId_lable);
		
		JTextArea userEmail_tf = new JTextArea("");
		userEmail_tf.setLineWrap(true);
		userEmail_tf.setForeground(new Color(0, 0, 0));
		userEmail_tf.setToolTipText("");
		userEmail_tf.setBounds(201, 140, 300, 30);
		contentPane.add(userEmail_tf);
		
		JLabel userEmail_lable = new JLabel("Email");
		userEmail_lable.setHorizontalAlignment(SwingConstants.CENTER);
		userEmail_lable.setForeground(new Color(255, 255, 255));
		userEmail_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userEmail_lable.setBounds(101, 140, 100, 30);
		contentPane.add(userEmail_lable);
		
		JTextArea userContact_tf = new JTextArea("");
		userContact_tf.setLineWrap(true);
		userContact_tf.setForeground(new Color(0, 0, 0));
		userContact_tf.setToolTipText("");
		userContact_tf.setBounds(201, 200, 300, 30);
		contentPane.add(userContact_tf);
		
		JLabel userContact_lable = new JLabel("Contact No.");
		userContact_lable.setHorizontalAlignment(SwingConstants.CENTER);
		userContact_lable.setForeground(new Color(255, 255, 255));
		userContact_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userContact_lable.setBounds(101, 200, 100, 30);
		contentPane.add(userContact_lable);
		
		JTextArea userUniversity_tf = new JTextArea("");
		userUniversity_tf.setLineWrap(true);
		userUniversity_tf.setForeground(new Color(0, 0, 0));
		userUniversity_tf.setToolTipText("");
		userUniversity_tf.setBounds(201, 260, 300, 30);
		contentPane.add(userUniversity_tf);
		
		JLabel userUniversity_lable = new JLabel("University");
		userUniversity_lable.setHorizontalAlignment(SwingConstants.CENTER);
		userUniversity_lable.setForeground(new Color(255, 255, 255));
		userUniversity_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userUniversity_lable.setBounds(101, 260, 100, 30);
		contentPane.add(userUniversity_lable);
		
		
		
		JLabel userPass_lable = new JLabel("Password");
		userPass_lable.setHorizontalAlignment(SwingConstants.CENTER);
		userPass_lable.setForeground(new Color(255, 255, 255));
		userPass_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userPass_lable.setBounds(101, 320, 100, 30);
		contentPane.add(userPass_lable);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 320, 300, 30);
		contentPane.add(passwordField);
		
		JCheckBox regCheck = new JCheckBox("I accept all the terms & condition");
		regCheck.setFont(new Font("Segoe UI", Font.BOLD, 14));
		regCheck.setBounds(201, 380, 300, 30);
		contentPane.add(regCheck);
		
		JButton reg_btn = new JButton("Register");
		reg_btn.setBackground(new Color(19, 15, 64));
		reg_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		reg_btn.setForeground(new Color(255, 255, 255));
		reg_btn.setBounds(401, 440, 100, 30);
		contentPane.add(reg_btn);
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(536, 531, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
		
	}
}
