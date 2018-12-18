

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

//import job.Manegment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

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
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class profile extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField nameTF;
	private JTextField contactTF;
	private JTextField usernameTF;
	private JPasswordField passField;
	private JTextField emailTF;
	private JTextField adressTF;
	private JTextField ageTF;
	private JRadioButton rdbtnMale,rdbtnFemale;

	String v ="";
	private int Id = 0;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	//private Object row;
	
	public static String welcomeName = "";
	private JTable dataTable;
	public static String serialid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile frame = new profile();
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
	public profile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(profile.class.getResource("/picture/app.jpg")));
		degine();
		Centerize();
		conn =  SQLconnection.ConnecrOb();
		loadTable();
		
		login frame = new login();
		//JOptionPane.showMessageDialog(null, ""+frame.welcomeName);
		
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
	
	private void resetEverything() {
		
		nameTF.setText(null);
		ageTF.setText(null);
		contactTF.setText(null);
		emailTF.setText(null);
		buttonGroup.clearSelection();
		adressTF.setText(null);
		usernameTF.setText(null);
		passField.setText(null);
		
		loadTable();
		
	}

	private void loadTable() {
		try {
			String query = "SELECT id,Name,Age,Email FROM infotable";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			dataTable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void lodeToField() {
		try {
			int row = dataTable.getSelectedRow();
			login frame = new login();
			
			//System.out.println(frame.serialid);
			
			String ID = (dataTable.getModel().getValueAt(row, 0).toString());
			//System.out.println("ID "+ID);
			if(ID.equals(frame.serialid)) {
			
			String query = "SELECT * FROM infotable WHERE id = '"+ ID +"'";
			pst = conn.prepareStatement(query);
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Id = rs.getInt("id");
				
				nameTF.setText(rs.getString("Name"));
				ageTF.setText(rs.getString("Age"));
				contactTF.setText(rs.getString("Contact"));
				emailTF.setText(rs.getString("Email"));
		
				v = rs.getString("Gender");
				
				if(v.equals("Male")) {
					rdbtnMale.setSelected(true);
					rdbtnFemale.setSelected(false);
				} else if(v.equals("Female")) {
					rdbtnFemale.setSelected(true);
					rdbtnMale.setSelected(false);
				}else {
					System.out.println("");
				}
				
				adressTF.setText(rs.getString("Adress"));
				usernameTF.setText(rs.getString("Username"));
				passField.setText(rs.getString("Password"));
				
				
			}
			
			pst.close();
			rs.close();
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private void updateData() {
		try {
			
			String query = "UPDATE infotable SET Name = '"+ nameTF.getText() +"',Age = '"+ ageTF.getText() +"',Contact = '"+ contactTF.getText() +"',"
					+ "Email = '"+ emailTF.getText() +"',Adress = '"+ adressTF.getText() +"',Gender = '"+ v + "',username = '"+ usernameTF.getText() +"',password = '"+ passField.getText() 
					+"'WHERE Id = '"+ Id +"'";
			
			pst = conn.prepareStatement(query);
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "Data Updated Successfully");
			pst.close();
			
			resetEverything();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void degine() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfile.setBackground(Color.BLACK);
		lblProfile.setBounds(10, 129, 158, 35);
		contentPane.add(lblProfile);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userhome frame = new userhome();
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(10, 83, 158, 35);
		contentPane.add(btnHome);
		
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
		
		JButton button_2 = new JButton("Sell Books");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sell frame = new Sell();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 311, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Games");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game frame = new Game();
				frame.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 357, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("About");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About frame = new About();
				frame.setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 403, 158, 35);
		contentPane.add(button_4);
		
		JButton button_6 = new JButton("Favourite ");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavouriteBooks frame = new FavouriteBooks();
				frame.setVisible(true);
				dispose();
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(10, 173, 158, 35);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Wish List");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wishlist frame = new Wishlist();
				frame.setVisible(true);
				dispose();
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_7.setBackground(Color.BLACK);
		button_7.setBounds(10, 221, 158, 35);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Log Out");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_8.setBackground(new Color(178, 34, 34));
		button_8.setBounds(10, 449, 158, 35);
		contentPane.add(button_8);
		
		JLabel label_2 = new JLabel("Boi Poka");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(10, 22, 141, 50);
		contentPane.add(label_2);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(profile.class.getResource("/picture/green wall - Copy.jpg")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_11.setBackground(Color.BLACK);
		label_11.setBounds(10, 129, 158, 35);
		contentPane.add(label_11);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(profile.class.getResource("/picture/black.jpg")));
		BlackLabel.setBackground(Color.BLACK);
		BlackLabel.setBounds(0, 0, 168, 579);
		contentPane.add(BlackLabel);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}
		});
		btnEdit.setForeground(new Color(0, 0, 0));
		btnEdit.setFont(new Font("Algerian", Font.BOLD, 16));
		btnEdit.setBackground(new Color(46, 139, 87));
		btnEdit.setBounds(487, 517, 108, 51);
		contentPane.add(btnEdit);
		
		JLabel label = new JLabel("Soft_71");
		label.setForeground(new Color(107, 142, 35));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(637, 549, 48, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Name(full)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(148, 0, 211));
		label_1.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_1.setBounds(234, 232, 94, 22);
		contentPane.add(label_1);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(329, 232, 311, 24);
		contentPane.add(nameTF);
		
		JLabel label_3 = new JLabel("Contact");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(148, 0, 211));
		label_3.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_3.setBounds(244, 294, 84, 22);
		contentPane.add(label_3);
		
		contactTF = new JTextField();
		contactTF.setColumns(10);
		contactTF.setBounds(329, 294, 254, 24);
		contentPane.add(contactTF);
		
		JLabel label_4 = new JLabel("Gender :");
		label_4.setBackground(new Color(50, 205, 50));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(148, 0, 211));
		label_4.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_4.setBounds(430, 265, 74, 22);
		contentPane.add(label_4);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(175, 238, 238));
		rdbtnMale.setForeground(new Color(148, 0, 211));
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Segoe Print", Font.BOLD, 13));
		rdbtnMale.setBounds(509, 268, 64, 19);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(175, 238, 238));
		rdbtnFemale.setForeground(new Color(148, 0, 211));
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Segoe Print", Font.BOLD, 13));
		rdbtnFemale.setBounds(575, 267, 74, 19);
		contentPane.add(rdbtnFemale);
		
		JLabel label_5 = new JLabel("Username");
		label_5.setForeground(new Color(148, 0, 211));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_5.setBounds(244, 438, 84, 19);
		contentPane.add(label_5);
		
		usernameTF = new JTextField();
		usernameTF.setColumns(10);
		usernameTF.setBounds(329, 436, 254, 24);
		contentPane.add(usernameTF);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setForeground(new Color(148, 0, 211));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_6.setBounds(244, 468, 84, 19);
		contentPane.add(label_6);
		
		passField = new JPasswordField();
		passField.setBounds(329, 466, 254, 24);
		contentPane.add(passField);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(329, 327, 254, 24);
		contentPane.add(emailTF);
		
		JLabel label_7 = new JLabel("Email");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(148, 0, 211));
		label_7.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_7.setBounds(250, 329, 71, 22);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Adress");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(new Color(148, 0, 211));
		label_8.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_8.setBounds(244, 378, 84, 22);
		contentPane.add(label_8);
		
		adressTF = new JTextField();
		adressTF.setColumns(10);
		adressTF.setBounds(329, 365, 254, 50);
		contentPane.add(adressTF);
		
		JLabel label_10 = new JLabel("Age");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(new Color(148, 0, 211));
		label_10.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_10.setBounds(244, 261, 84, 22);
		contentPane.add(label_10);
		
		ageTF = new JTextField();
		ageTF.setColumns(10);
		ageTF.setBounds(329, 265, 64, 24);
		contentPane.add(ageTF);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 110, 471, 94);
		contentPane.add(scrollPane);
		
		dataTable = new JTable();
		dataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lodeToField();
			}
		});
		scrollPane.setViewportView(dataTable);
		
		JLabel label_9 = new JLabel("Boi Poka");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(new Color(0, 100, 0));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_9.setBackground(Color.BLACK);
		label_9.setBounds(363, 22, 141, 50);
		contentPane.add(label_9);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(profile.class.getResource("/picture/logoproject.png")));
		label_12.setBounds(167, 149, 543, 579);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(profile.class.getResource("/picture/logo2.png")));
		label_13.setBounds(261, 22, 120, 73);
		contentPane.add(label_13);
	}
}
