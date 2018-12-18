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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Sell extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	
	private JPanel contentPane;
	private JTextField booknameTF;
	private JTextField writernameTF;
	private JTextField editionnoTF;
	private JTextField publicationTF;
	private JTextField priceTF;
	private JTextField detailTF;
	private JTable Datatable;
	private JComboBox searchCB;
	private JTextField searchTF;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sell frame = new Sell();
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
	public Sell() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sell.class.getResource("/picture/app.jpg")));
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
			String query = "SELECT Book_Name,Writer_Name,Edition_no,Publication,price,Detail,status FROM sell";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			Datatable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addData() {
		try {
			String query = "INSERT INTO sell (Name,Book_Name,Writer_Name,Edition_no,Publication,price,Detail,status) VALUES (?,?,?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(query);
			
			login frame = new login();
			pst.setString(1, frame.welcomeName);
			
			pst.setString(2, booknameTF.getText());
			pst.setString(3, writernameTF.getText());
			pst.setString(4, editionnoTF.getText());
			pst.setString(5, publicationTF.getText());
			pst.setString(6, priceTF.getText());
			pst.setString(7, detailTF.getText());
			pst.setString(8, null);
			
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
			
			String query = "SELECT Book_Name,Writer_Name,Publication,price FROM sell WHERE " 
				+ Selection + " LIKE '" +searchTF.getText()+"%'";
			
			pst = conn.prepareStatement(query);
			rs= pst.executeQuery();
			
			Datatable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void degine(){
		setTitle("Sell Books List");
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
		
		JLabel lblSellBooks = new JLabel("Sell Books");
		lblSellBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellBooks.setForeground(Color.WHITE);
		lblSellBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellBooks.setBackground(Color.BLACK);
		lblSellBooks.setBounds(10, 311, 158, 35);
		contentPane.add(lblSellBooks);
		
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
		button.setBounds(10, 83, 158, 35);
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
		button_1.setBounds(10, 267, 158, 35);
		contentPane.add(button_1);
		
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
		button_6.setBounds(10, 129, 158, 35);
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
		btnFavourite.setBounds(10, 174, 158, 35);
		contentPane.add(btnFavourite);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Sell.class.getResource("/picture/green wall - Copy.jpg")));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(10, 313, 158, 35);
		contentPane.add(label_8);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(Sell.class.getResource("/picture/black.jpg")));
		BlackLabel.setBackground(Color.BLACK);
		BlackLabel.setBounds(0, 0, 168, 579);
		contentPane.add(BlackLabel);
		
		JLabel label = new JLabel("Soft_71");
		label.setForeground(new Color(107, 142, 35));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(637, 549, 48, 30);
		contentPane.add(label);
		
		JLabel lblSellBooksList = new JLabel("Sell Books List");
		lblSellBooksList.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellBooksList.setForeground(Color.BLACK);
		lblSellBooksList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellBooksList.setBackground(Color.BLACK);
		lblSellBooksList.setBounds(350, 94, 158, 35);
		contentPane.add(lblSellBooksList);
		
		JButton button_2 = new JButton("+Add book");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addData();
			}
		});
		button_2.setForeground(new Color(0, 0, 0));
		button_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
		button_2.setBackground(new Color(127, 255, 0));
		button_2.setBounds(487, 527, 140, 41);
		contentPane.add(button_2);
		
		JLabel label_2 = new JLabel("Book Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(148, 0, 211));
		label_2.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_2.setBounds(202, 297, 100, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Writer name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(148, 0, 211));
		label_3.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_3.setBounds(202, 331, 100, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Edition No");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(148, 0, 211));
		label_4.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_4.setBounds(202, 372, 100, 30);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("publication");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(148, 0, 211));
		label_5.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_5.setBounds(202, 416, 100, 30);
		contentPane.add(label_5);
		
		booknameTF = new JTextField();
		booknameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		booknameTF.setColumns(10);
		booknameTF.setBounds(315, 297, 173, 30);
		contentPane.add(booknameTF);
		
		writernameTF = new JTextField();
		writernameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		writernameTF.setColumns(10);
		writernameTF.setBounds(315, 333, 173, 30);
		contentPane.add(writernameTF);
		
		editionnoTF = new JTextField();
		editionnoTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editionnoTF.setColumns(10);
		editionnoTF.setBounds(315, 374, 173, 30);
		contentPane.add(editionnoTF);
		
		publicationTF = new JTextField();
		publicationTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		publicationTF.setColumns(10);
		publicationTF.setBounds(315, 415, 173, 30);
		contentPane.add(publicationTF);
		
		priceTF = new JTextField();
		priceTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		priceTF.setColumns(10);
		priceTF.setBounds(315, 459, 173, 30);
		contentPane.add(priceTF);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"", "Book_Name", "Writer_Name", "Publication", "price"}));
		searchCB.setBounds(265, 136, 131, 26);
		contentPane.add(searchCB);
		
		searchTF = new JTextField();
		searchTF.setColumns(10);
		searchTF.setBounds(471, 136, 140, 26);
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchData();
			}
		});
		contentPane.add(searchTF);
		
		JLabel label_6 = new JLabel("price");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(new Color(148, 0, 211));
		label_6.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_6.setBounds(202, 457, 100, 30);
		contentPane.add(label_6);
		
		JLabel lblDetail = new JLabel("Detail");
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetail.setForeground(new Color(148, 0, 211));
		lblDetail.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblDetail.setBounds(202, 498, 100, 30);
		contentPane.add(lblDetail);
		
		detailTF = new JTextField();
		detailTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		detailTF.setColumns(10);
		detailTF.setBounds(312, 500, 173, 30);
		contentPane.add(detailTF);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 177, 465, 109);
		contentPane.add(scrollPane);
		
		Datatable = new JTable();
		scrollPane.setViewportView(Datatable);
		
		JLabel label_7 = new JLabel("Boi Poka");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 100, 0));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(322, 10, 308, 73);
		contentPane.add(label_7);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Sell.class.getResource("/picture/logo2.png")));
		label_9.setBounds(276, 11, 120, 73);
		contentPane.add(label_9);
		
		JLabel backgroundlogo = new JLabel("");
		backgroundlogo.setIcon(new ImageIcon(Sell.class.getResource("/picture/logoproject.png")));
		backgroundlogo.setBounds(152, 150, 543, 579);
		contentPane.add(backgroundlogo);
	}
}
