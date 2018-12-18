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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Wishlist extends JFrame {

	private JPanel contentPane;
	private JTable datatable;
	private JTextField booknameTF;
	private JTextField writernameTF;
	private JTextField editionnoTF;
	private JTextField publicationTF;
	private JComboBox searchCB;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	private JTextField priceTF;
	private JTextField searchTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wishlist frame = new Wishlist();
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
	public Wishlist() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Wishlist.class.getResource("/picture/app.jpg")));
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
			String query = "SELECT Book_Name,Writer_Name,Edition_no,Publication,price FROM wishlist";
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
			String query = "INSERT INTO wishlist (Name,Book_Name,Writer_Name,Edition_no,Publication,price) VALUES (?,?,?,?,?,?)";
			
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
		setTitle("Wish List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BlackLabel = new JLabel("Boi Poka");
		BlackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BlackLabel.setForeground(new Color(0, 100, 0));
		BlackLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		BlackLabel.setBackground(Color.BLACK);
		BlackLabel.setBounds(10, 11, 141, 50);
		contentPane.add(BlackLabel);
		
		JLabel lblWishList = new JLabel("Wish List");
		lblWishList.setHorizontalAlignment(SwingConstants.CENTER);
		lblWishList.setForeground(Color.WHITE);
		lblWishList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWishList.setBackground(Color.BLACK);
		lblWishList.setBounds(10, 217, 158, 35);
		contentPane.add(lblWishList);
		
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
		button.setBounds(10, 79, 158, 35);
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
		button_1.setBounds(10, 263, 158, 35);
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
		button_2.setBounds(10, 307, 158, 35);
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
		button_3.setBounds(10, 353, 158, 35);
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
		button_4.setBounds(10, 399, 158, 35);
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
		button_6.setBounds(10, 125, 158, 35);
		contentPane.add(button_6);
		
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
		btnFavourite.setBounds(10, 171, 158, 35);
		contentPane.add(btnFavourite);
		
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
		button_8.setBounds(10, 445, 158, 35);
		contentPane.add(button_8);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Wishlist.class.getResource("/picture/green wall - Copy.jpg")));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(10, 217, 158, 35);
		contentPane.add(label_8);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Wishlist.class.getResource("/picture/black.jpg")));
		label.setBackground(Color.BLACK);
		label.setBounds(0, 0, 168, 579);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Soft_71");
		label_1.setForeground(new Color(107, 142, 35));
		label_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(637, 538, 48, 30);
		contentPane.add(label_1);
		
		JLabel lblMyWishList = new JLabel("My Wish List");
		lblMyWishList.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWishList.setForeground(Color.BLACK);
		lblMyWishList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMyWishList.setBackground(Color.BLACK);
		lblMyWishList.setBounds(348, 101, 158, 35);
		contentPane.add(lblMyWishList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(206, 190, 467, 152);
		contentPane.add(scrollPane);
		
		datatable = new JTable();
		scrollPane.setViewportView(datatable);
		
		JButton button_7 = new JButton("Add");
		button_7.setFont(new Font("Segoe Script", Font.PLAIN, 14));
		button_7.setBackground(new Color(60, 179, 113));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addData();
			}
		});
		button_7.setBounds(510, 517, 100, 44);
		contentPane.add(button_7);
		
		booknameTF = new JTextField();
		booknameTF.setColumns(10);
		booknameTF.setBounds(276, 357, 173, 30);
		contentPane.add(booknameTF);
		
		writernameTF = new JTextField();
		writernameTF.setColumns(10);
		writernameTF.setBounds(276, 399, 173, 30);
		contentPane.add(writernameTF);
		
		editionnoTF = new JTextField();
		editionnoTF.setColumns(10);
		editionnoTF.setBounds(276, 440, 173, 30);
		contentPane.add(editionnoTF);
		
		publicationTF = new JTextField();
		publicationTF.setColumns(10);
		publicationTF.setBounds(276, 483, 173, 30);
		contentPane.add(publicationTF);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"", "Book_Name", "Writer_Name", "Publication", "price"}));
		searchCB.setBounds(259, 157, 132, 22);
		contentPane.add(searchCB);
		
		searchTF = new JTextField();
		searchTF.setColumns(10);
		searchTF.setBounds(481, 157, 133, 22);
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
		label_2.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_2.setBounds(177, 357, 100, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Writer name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(148, 0, 211));
		label_3.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_3.setBounds(177, 398, 100, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Edition No");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(148, 0, 211));
		label_4.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_4.setBounds(177, 439, 100, 30);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("publication");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(148, 0, 211));
		label_5.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_5.setBounds(177, 483, 100, 30);
		contentPane.add(label_5);
		
		priceTF = new JTextField();
		priceTF.setColumns(10);
		priceTF.setBounds(276, 524, 173, 30);
		contentPane.add(priceTF);
		
		JLabel label_6 = new JLabel("price");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(148, 0, 211));
		label_6.setFont(new Font("Segoe Print", Font.BOLD, 13));
		label_6.setBounds(178, 525, 100, 30);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Boi Poka");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(317, 17, 308, 73);
		contentPane.add(label_7);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Wishlist.class.getResource("/picture/logoproject.png")));
		label_9.setBounds(142, 151, 543, 579);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Wishlist.class.getResource("/picture/logo2.png")));
		label_10.setBounds(259, 17, 120, 73);
		contentPane.add(label_10);
	}
}
