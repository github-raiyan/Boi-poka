import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FavouriteBooks extends JFrame {

	private JPanel contentPane;
	private JTable datatable;

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	
	private JTextField booknameTF;
	private JTextField writernameTF;
	private JTextField editionnoTF;
	private JTextField publicationTF;
	private JTextField priceTF;
	private JTextField searchTF;
	private JComboBox searchCB;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FavouriteBooks frame = new FavouriteBooks();
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
	public FavouriteBooks() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FavouriteBooks.class.getResource("/picture/app.jpg")));
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
		editionnoTF.setText(null);
		publicationTF.setText(null);
		
		priceTF.setText(null);
		loadTable();
		
	}


	private void loadTable() {
		try {
			String query = "SELECT Book_Name,Writer_Name,Edition_no,Publication,price FROM favorite";
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
			String query = "INSERT INTO favorite (Name,Book_Name,Writer_Name,Edition_no,Publication,price) VALUES (?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(query);
			
			login frame = new login();
			pst.setString(1, frame.welcomeName);
			
			pst.setString(2, booknameTF.getText());
			pst.setString(3, writernameTF.getText());
			pst.setString(4, editionnoTF.getText());
			pst.setString(5, publicationTF.getText());
			pst.setString(6, priceTF.getText());
			
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
			
			String query = "SELECT Book_Name,Writer_Name,Publication,price FROM favorite WHERE " 
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
		setTitle("Favourite Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFavourite = new JLabel("Favourite ");
		lblFavourite.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavourite.setForeground(Color.WHITE);
		lblFavourite.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFavourite.setBackground(Color.BLACK);
		lblFavourite.setBounds(10, 176, 158, 35);
		contentPane.add(lblFavourite);
		
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
		button.setBounds(10, 84, 158, 35);
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
		button_1.setBounds(10, 268, 158, 35);
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
		button_2.setBounds(10, 312, 158, 35);
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
		button_3.setBounds(10, 358, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("About");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 404, 158, 35);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Contact Us");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBackground(Color.BLACK);
		button_5.setBounds(10, 451, 158, 35);
		contentPane.add(button_5);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profile frame = new profile();
				frame.setVisible(true);
				dispose();
			}
		});
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProfile.setBackground(Color.BLACK);
		btnProfile.setBounds(10, 130, 158, 35);
		contentPane.add(btnProfile);
		
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
		button_7.setBounds(10, 222, 158, 35);
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
		button_8.setBounds(10, 497, 158, 35);
		contentPane.add(button_8);
		
		JLabel label = new JLabel("Boi Poka");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 100, 0));
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBackground(Color.BLACK);
		label.setBounds(21, 23, 141, 50);
		contentPane.add(label);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(FavouriteBooks.class.getResource("/picture/green wall - Copy.jpg")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(10, 176, 158, 35);
		contentPane.add(label_7);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(FavouriteBooks.class.getResource("/picture/black.jpg")));
		BlackLabel.setBackground(Color.BLACK);
		BlackLabel.setBounds(0, 0, 168, 579);
		contentPane.add(BlackLabel);
		
		JLabel label_1 = new JLabel("Soft_71");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(637, 538, 48, 30);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 161, 461, 158);
		contentPane.add(scrollPane);
		
		datatable = new JTable();
		scrollPane.setViewportView(datatable);
		
		JButton button_6 = new JButton("Add");
		button_6.setFont(new Font("Segoe Script", Font.BOLD, 14));
		button_6.setBackground(new Color(0, 250, 154));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addData();
			}
		});
		button_6.setBounds(521, 495, 100, 44);
		contentPane.add(button_6);
		
		booknameTF = new JTextField();
		booknameTF.setColumns(10);
		booknameTF.setBounds(270, 342, 173, 30);
		contentPane.add(booknameTF);
		
		writernameTF = new JTextField();
		writernameTF.setColumns(10);
		writernameTF.setBounds(270, 378, 173, 30);
		contentPane.add(writernameTF);
		
		editionnoTF = new JTextField();
		editionnoTF.setColumns(10);
		editionnoTF.setBounds(270, 419, 173, 30);
		contentPane.add(editionnoTF);
		
		publicationTF = new JTextField();
		publicationTF.setColumns(10);
		publicationTF.setBounds(270, 468, 173, 30);
		contentPane.add(publicationTF);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"", "Book_Name", "Writer_Name", "Publication", "price"}));
		searchCB.setBounds(257, 124, 131, 26);
		contentPane.add(searchCB);
		
		priceTF = new JTextField();
		priceTF.setColumns(10);
		priceTF.setBounds(270, 509, 173, 30);
		contentPane.add(priceTF);
		
		searchTF = new JTextField();
		searchTF.setColumns(10);
		searchTF.setBounds(465, 124, 141, 26);
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchData();
			}
		});
		contentPane.add(searchTF);
		
		JLabel label_2 = new JLabel("Book Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(148, 0, 211));
		label_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		label_2.setBounds(170, 342, 100, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Writer name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(148, 0, 211));
		label_3.setFont(new Font("Segoe Print", Font.BOLD, 14));
		label_3.setBounds(170, 383, 100, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Edition No");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(148, 0, 211));
		label_4.setFont(new Font("Segoe Print", Font.BOLD, 14));
		label_4.setBounds(170, 424, 100, 30);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("publication");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(148, 0, 211));
		label_5.setFont(new Font("Segoe Print", Font.BOLD, 14));
		label_5.setBounds(170, 468, 100, 30);
		contentPane.add(label_5);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(new Color(148, 0, 211));
		lblPrice.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblPrice.setBounds(170, 510, 100, 30);
		contentPane.add(lblPrice);
		
		JLabel label_6 = new JLabel("Boi Poka");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(0, 100, 0));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(313, 11, 308, 73);
		contentPane.add(label_6);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(FavouriteBooks.class.getResource("/picture/logoproject.png")));
		label_8.setBounds(152, 143, 543, 579);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(FavouriteBooks.class.getResource("/picture/logo2.png")));
		label_9.setBounds(278, 11, 120, 73);
		contentPane.add(label_9);
	}
}
