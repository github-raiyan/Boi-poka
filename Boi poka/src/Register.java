import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import job.FristFrame;
//import job.SQLconnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField contactTF;
	private JTextField usernameTF;
	private JPasswordField passField;
	private JTextField emailTF;
	private JTextField adressTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ageTF;
	private JRadioButton rdbtnMale,rdbtnFemale;
	private JCheckBox chckbxIAcceptedAll;
	
	String v ="";
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;

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
		setTitle("Register");
		Degine();
		Centerize();
		conn =  SQLconnection.ConnecrOb();
	}
	
	private void Registertable() {
		try {
			String query = "INSERT INTO infotable (Name,Age,Contact,Email,Gender,Adress,username,password) VALUES (?,?,?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(query);
			pst.setString(1, nameTF.getText());
			pst.setString(2, ageTF.getText());
			pst.setString(3, contactTF.getText());
			pst.setString(4, emailTF.getText());
			if(rdbtnMale.isSelected()) {
				v = rdbtnMale.getText().toString();
			} else if(rdbtnFemale.isSelected()) {
				v = rdbtnFemale.getText().toString();
			} else {
				JOptionPane.showMessageDialog(null, "Select Gender");
			}
			pst.setString(5, String.valueOf(v));
			pst.setString(6, adressTF.getText());
			
			pst.setString(7, usernameTF.getText());
			pst.setString(8, passField.getText());
			
			pst.execute();
			pst.close();
			
			
			JOptionPane.showMessageDialog(null, "Singup successfull");
			
			userhome frame = new userhome();
			frame.setVisible(true);
			dispose();
			
		}
		catch (Exception e) {
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
	
	public void Degine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Soft_71");
		label.setForeground(new Color(107, 142, 35));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(647, 442, 48, 30);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Boi Poka");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(10, 11, 141, 50);
		contentPane.add(label_2);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblRegistration_1 = new JLabel("Registration");
		lblRegistration_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration_1.setForeground(Color.WHITE);
		lblRegistration_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration_1.setBackground(Color.BLACK);
		lblRegistration_1.setBounds(10, 129, 158, 35);
		contentPane.add(lblRegistration_1);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(10, 83, 158, 35);
		contentPane.add(button);
		
		JButton button_2 = new JButton("Donate Books");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 221, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Sell Books");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 265, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Games");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 311, 158, 35);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("About");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(10, 357, 158, 35);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Contact Us");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(10, 404, 158, 35);
		contentPane.add(button_6);
		
		JButton button_1 = new JButton("Log in");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(10, 175, 158, 35);
		contentPane.add(button_1);
		
		JLabel BackLabel = new JLabel("");
		BackLabel.setIcon(new ImageIcon(Register.class.getResource("/picture/Screenshot_2.jpg")));
		BackLabel.setBackground(Color.BLACK);
		BackLabel.setBounds(0, 0, 168, 472);
		contentPane.add(BackLabel);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(new Color(0, 100, 0));
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration.setBackground(Color.BLACK);
		lblRegistration.setBounds(367, 47, 94, 22);
		contentPane.add(lblRegistration);
		
		JLabel lblNamefull = new JLabel("Name(full)");
		lblNamefull.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamefull.setForeground(new Color(0, 0, 0));
		lblNamefull.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNamefull.setBounds(235, 96, 94, 22);
		contentPane.add(lblNamefull);
		
		nameTF = new JTextField();
		nameTF.setBounds(330, 96, 311, 24);
		contentPane.add(nameTF);
		nameTF.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setForeground(Color.BLACK);
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContact.setBounds(245, 158, 84, 22);
		contentPane.add(lblContact);
		
		contactTF = new JTextField();
		contactTF.setColumns(10);
		contactTF.setBounds(330, 158, 254, 24);
		contentPane.add(contactTF);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(431, 129, 74, 22);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnMale.setBounds(510, 132, 53, 19);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnFemale.setBounds(570, 132, 71, 19);
		contentPane.add(rdbtnFemale);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(245, 302, 84, 19);
		contentPane.add(lblUsername);
		
		usernameTF = new JTextField();
		usernameTF.setColumns(10);
		usernameTF.setBounds(330, 300, 254, 24);
		contentPane.add(usernameTF);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(245, 332, 84, 19);
		contentPane.add(lblPassword);
		
		passField = new JPasswordField();
		passField.setBounds(330, 330, 254, 24);
		contentPane.add(passField);
		
		JButton btnResiter = new JButton("Resiter");
		btnResiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxIAcceptedAll.isSelected()) {
					Registertable();
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Read Term And Condition.");
				}
			}
			
		});
		btnResiter.setBackground(new Color(46, 139, 87));
		btnResiter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResiter.setBounds(558, 421, 112, 30);
		contentPane.add(btnResiter);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(330, 191, 254, 24);
		contentPane.add(emailTF);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(251, 193, 71, 22);
		contentPane.add(lblEmail);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setForeground(Color.BLACK);
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdress.setBounds(245, 242, 84, 22);
		contentPane.add(lblAdress);
		
		adressTF = new JTextField();
		adressTF.setColumns(10);
		adressTF.setBounds(330, 229, 254, 50);
		contentPane.add(adressTF);
		
		chckbxIAcceptedAll = new JCheckBox("I accept all the terms & condition");
		chckbxIAcceptedAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxIAcceptedAll.setBounds(330, 377, 247, 30);
		contentPane.add(chckbxIAcceptedAll);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(245, 125, 84, 22);
		contentPane.add(lblAge);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(330, 129, 64, 24);
		contentPane.add(ageTF);
	}
}
