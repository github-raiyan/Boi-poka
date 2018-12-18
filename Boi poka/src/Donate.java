import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Donate extends JFrame {

	private JPanel contentPane;
	private JTextField detailTF;
	private JTextField contactTF;
	private JTextField booknameTF;
	private JTable datatable;
	private JTextField writernameTF;
	private JComboBox searchCB;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	private JTextField searchTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donate frame = new Donate();
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
	public Donate() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Donate.class.getResource("/picture/app.jpg")));
		degine();
		Centerize();
		conn =  SQLconnection.ConnecrOb();
		loadTable();
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
		
		booknameTF.setText(null);
		writernameTF.setText(null);
		contactTF.setText(null);
		detailTF.setText(null);
		loadTable();
		
	}


	private void loadTable() {
		try {
			String query = "SELECT Book_Name,Writer_Name,Owner_Contact,Book_Detail,status FROM dotane";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			datatable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addData() {
		try {
			String query = "INSERT INTO dotane (Name,Book_Name,Writer_Name,Owner_Contact,Book_Detail,status) VALUES (?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(query);
			
			login frame = new login();
			pst.setString(1, frame.welcomeName);
			
			pst.setString(2, booknameTF.getText());
			pst.setString(3, writernameTF.getText());
			pst.setString(4, contactTF.getText());
			pst.setString(5, detailTF.getText());
			pst.setString(6, null);
			pst.execute();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "New Info Added");
			
			resetEverything();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void searchData() {
		try {
			
			String Selection = (String) searchCB.getSelectedItem();
			
			String query = "SELECT Book_Name,Writer_Name,Owner_Contact FROM dotane WHERE " 
			+ Selection + " LIKE '" +searchTF.getText()+"%'";
			
			pst = conn.prepareStatement(query);
			rs= pst.executeQuery();
			
			datatable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void degine() {
		setTitle("Donate Books List");
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
		label_1.setBounds(10, 11, 141, 50);
		contentPane.add(label_1);
		
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
		button.setBounds(10, 80, 158, 35);
		contentPane.add(button);
		
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
		button_2.setBounds(10, 308, 158, 35);
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
		button_3.setBounds(10, 354, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("About");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 400, 158, 35);
		contentPane.add(button_4);
		
		JButton button_6 = new JButton("Profile");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profile frame = new profile();
				frame.setVisible(true);
				dispose();
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBackground(Color.BLACK);
		button_6.setBounds(10, 126, 158, 35);
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
		button_7.setBounds(10, 216, 158, 35);
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
		button_8.setBounds(10, 447, 158, 35);
		contentPane.add(button_8);
		
		JButton btnFavourite = new JButton("Favourite ");
		btnFavourite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavouriteBooks frame = new FavouriteBooks();
				frame.setVisible(true);
				dispose();
			}
		});
		btnFavourite.setForeground(Color.WHITE);
		btnFavourite.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFavourite.setBackground(Color.BLACK);
		btnFavourite.setBounds(10, 170, 158, 35);
		contentPane.add(btnFavourite);
		
		JLabel lblDonateBooks = new JLabel("Donate Books");
		lblDonateBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonateBooks.setForeground(Color.WHITE);
		lblDonateBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDonateBooks.setBackground(Color.BLACK);
		lblDonateBooks.setBounds(10, 262, 158, 35);
		contentPane.add(lblDonateBooks);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Donate.class.getResource("/picture/green wall - Copy.jpg")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(10, 262, 158, 35);
		contentPane.add(label_5);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(Donate.class.getResource("/picture/black.jpg")));
		BlackLabel.setBackground(Color.BLACK);
		BlackLabel.setBounds(0, 0, 168, 579);
		contentPane.add(BlackLabel);
		
		JLabel label = new JLabel("Soft_71");
		label.setForeground(new Color(107, 142, 35));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(637, 538, 48, 30);
		contentPane.add(label);
		
		JLabel lblDonateBooksList = new JLabel("Donate Books List");
		lblDonateBooksList.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonateBooksList.setForeground(Color.BLACK);
		lblDonateBooksList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDonateBooksList.setBackground(Color.BLACK);
		lblDonateBooksList.setBounds(353, 113, 158, 35);
		contentPane.add(lblDonateBooksList);
		
		JLabel label_3 = new JLabel("Owner  Contact");
		label_3.setBackground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(148, 0, 211));
		label_3.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_3.setBounds(197, 409, 128, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Book Details");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(148, 0, 211));
		label_4.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_4.setBounds(225, 450, 100, 30);
		contentPane.add(label_4);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addData();
			}
		});
		btnDonate.setForeground(new Color(0, 0, 0));
		btnDonate.setFont(new Font("Felix Titling", Font.BOLD, 18));
		btnDonate.setBackground(new Color(152, 251, 152));
		btnDonate.setBounds(459, 513, 168, 40);
		contentPane.add(btnDonate);
		
		JLabel label_6 = new JLabel("Book Name");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(new Color(148, 0, 211));
		label_6.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_6.setBounds(238, 331, 86, 30);
		contentPane.add(label_6);
		
		detailTF = new JTextField();
		detailTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		detailTF.setForeground(Color.BLACK);
		detailTF.setColumns(10);
		detailTF.setBounds(335, 451, 231, 30);
		contentPane.add(detailTF);
		
		contactTF = new JTextField();
		contactTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contactTF.setForeground(Color.BLACK);
		contactTF.setColumns(10);
		contactTF.setBounds(335, 410, 231, 30);
		contentPane.add(contactTF);
		
		booknameTF = new JTextField();
		booknameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		booknameTF.setForeground(Color.BLACK);
		booknameTF.setColumns(10);
		booknameTF.setBounds(335, 330, 231, 30);
		contentPane.add(booknameTF);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 186, 471, 121);
		contentPane.add(scrollPane);
		
		datatable = new JTable();
		scrollPane.setViewportView(datatable);
		
		writernameTF = new JTextField();
		writernameTF.setForeground(Color.BLACK);
		writernameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		writernameTF.setColumns(10);
		writernameTF.setBounds(335, 369, 231, 30);
		contentPane.add(writernameTF);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"", "Book_Name", "Writer_Name", "Owner_Contact"}));
		searchCB.setBounds(264, 154, 128, 22);
		contentPane.add(searchCB);
		
		JLabel lblWriterName = new JLabel("Writer Name");
		lblWriterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWriterName.setForeground(new Color(148, 0, 211));
		lblWriterName.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblWriterName.setBounds(215, 367, 110, 30);
		contentPane.add(lblWriterName);
		
		JLabel label_2 = new JLabel("Boi Poka");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(383, 24, 223, 73);
		contentPane.add(label_2);
		
		searchTF = new JTextField();
		searchTF.setBounds(459, 155, 147, 20);
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchData();
			}
		});
		contentPane.add(searchTF);
		searchTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Donate.class.getResource("/picture/logoproject.png")));
		lblNewLabel.setBounds(142, 106, 543, 653);
		contentPane.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Donate.class.getResource("/picture/logo2.png")));
		label_7.setBounds(286, 24, 120, 73);
		contentPane.add(label_7);
	}
}
