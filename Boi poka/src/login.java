import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import job.SQLconnection;

//import job.Manegment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	
	private JTextField usernameField;
	private JPasswordField passField;
	
	public static String welcomeName = ""; //welcome in database...........
	public static int id = 0;
	public static String serialid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/picture/app.jpg")));
		setBackground(new Color(255, 255, 255));
		setTitle("Log In");
		degine();
		Centerize();
		conn =  SQLconnection.ConnecrOb();
	}
	
	public void logintable() {
		try {
			
			String query = "select * from infotable WHERE Username = ? AND Password = ?";
			pst = conn.prepareStatement(query);
			pst.setString(1, usernameField.getText());
			pst.setString(2, passField.getText());
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				
				welcomeName = rs.getString("Name");
				serialid = rs.getString("id");
				
				//JOptionPane.showMessageDialog(null, "Login successful");
				
				userhome frame = new userhome();
				frame.setVisible(true);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Login Failed");
			}
			
			pst.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
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
		
		JLabel label_4 = new JLabel("Log In");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(10, 131, 158, 35);
		contentPane.add(label_4);
		
		JLabel lblLogIn_1 = new JLabel("");
		lblLogIn_1.setIcon(new ImageIcon(login.class.getResource("/picture/green wall - Copy.jpg")));
		lblLogIn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn_1.setForeground(Color.WHITE);
		lblLogIn_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogIn_1.setBackground(Color.BLACK);
		lblLogIn_1.setBounds(10, 131, 158, 35);
		contentPane.add(lblLogIn_1);
		
		JLabel label_1 = new JLabel("Boi Poka");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(10, 11, 141, 50);
		contentPane.add(label_1);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(10, 85, 158, 35);
		contentPane.add(button);
		
		JButton button_2 = new JButton("Donate Books");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generaldonate frame = new generaldonate();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 177, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Sell Books");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generalsell frame = new Generalsell();
				frame.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 221, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Games");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralgame frame = new genaralgame();
				frame.setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 267, 158, 35);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("About");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralabout frame = new genaralabout();
				frame.setVisible(true);
				dispose();
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(10, 313, 158, 35);
		contentPane.add(button_5);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(login.class.getResource("/picture/Screenshot_2.jpg")));
		BlackLabel.setBackground(new Color(0, 0, 0));
		BlackLabel.setBounds(0, 0, 168, 472);
		contentPane.add(BlackLabel);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setForeground(new Color(0, 100, 0));
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogIn.setBackground(Color.BLACK);
		lblLogIn.setBounds(361, 91, 94, 22);
		contentPane.add(lblLogIn);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.setBounds(305, 146, 265, 35);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passField.setBounds(305, 205, 265, 35);
		contentPane.add(passField);
		
		JButton button_1 = new JButton("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usernameField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter username");
				}else if(passField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter passoword To Continue");
				}else {
					logintable();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		button_1.setBackground(new Color(107, 142, 35));
		button_1.setBounds(474, 270, 100, 30);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("Don't have account?");
		label.setForeground(new Color(60, 179, 113));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(301, 363, 176, 30);
		contentPane.add(label);
		
		JButton button_7 = new JButton("Register");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
				dispose();
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		button_7.setBackground(new Color(178, 34, 34));
		button_7.setBounds(474, 363, 100, 30);
		contentPane.add(button_7);
		
		JLabel label_2 = new JLabel("Soft_71");
		label_2.setForeground(new Color(107, 142, 35));
		label_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_2.setBounds(637, 442, 48, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Boi Poka");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 100, 0));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(345, 11, 308, 73);
		contentPane.add(label_3);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(login.class.getResource("/picture/password.png")));
		label_8.setToolTipText("password");
		label_8.setBounds(235, 187, 60, 65);
		contentPane.add(label_8);
		
		JLabel label_7 = new JLabel("");
		label_7.setToolTipText("Username");
		label_7.setIcon(new ImageIcon(login.class.getResource("/picture/usericon.png")));
		label_7.setBounds(235, 131, 60, 65);
		contentPane.add(label_7);
		
		JLabel label_5 = new JLabel("");
		label_5.setBackground(new Color(224, 255, 255));
		label_5.setIcon(new ImageIcon(login.class.getResource("/picture/logoproject.png")));
		label_5.setBounds(161, 11, 543, 579);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(login.class.getResource("/picture/logo2.png")));
		label_6.setBounds(281, 11, 120, 73);
		contentPane.add(label_6);
	}
}
