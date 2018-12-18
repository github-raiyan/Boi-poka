import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import job.SQLconnection;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class userhome extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	
	
	private JPanel contentPane;
	private JTable datatable;
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
					userhome frame = new userhome();
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
	public userhome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(userhome.class.getResource("/picture/app.jpg")));
		setBackground(Color.WHITE);
		degine();
		Centerize();
		conn =  SQLconnection.ConnecrOb();
		loadTable();
		
		login frame = new login();
		JOptionPane.showMessageDialog(null, "Welcome "+frame.welcomeName);
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
		
			//login frame = new login();
			String query = "SELECT Book_Name,Writer_Name,Edition_no,Publication,price FROM book_info";
			//if(userserialTF.equals(frame.serialid)) {
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
			String query = "INSERT INTO book_info (serialid,Name,Book_Name,Writer_Name,Edition_no,Publication,price) VALUES (?,?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(query);
			
			login frame = new login();
			pst.setString(1, frame.serialid);
			pst.setString(2, frame.welcomeName);
			
			pst.setString(3, booknameTF.getText());
			pst.setString(4, writernameTF.getText());
			pst.setString(5, editionnoTF.getText());
			pst.setString(6, publicationTF.getText());
			pst.setString(7, priceTF.getText());
			
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
			
			String query = "SELECT Book_Name,Writer_Name,Publication,price FROM book_info WHERE " 
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
		setTitle("User Home");
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
		label_1.setBounds(10, 22, 141, 50);
		contentPane.add(label_1);
		
		JLabel lblProfile = new JLabel("Home");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProfile.setBackground(Color.BLACK);
		lblProfile.setBounds(10, 89, 158, 35);
		contentPane.add(lblProfile);
		
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
		btnProfile.setBounds(10, 135, 158, 35);
		contentPane.add(btnProfile);
		
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
		button_1.setBounds(10, 275, 158, 35);
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
		button_2.setBounds(10, 319, 158, 35);
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
		button_3.setBounds(10, 365, 158, 35);
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
		button_4.setBounds(10, 411, 158, 35);
		contentPane.add(button_4);
		
		JButton btnFavouriteBooks = new JButton("Favourite ");
		btnFavouriteBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavouriteBooks frame = new FavouriteBooks();
				frame.setVisible(true);
				dispose();
			}
		});
		btnFavouriteBooks.setForeground(Color.WHITE);
		btnFavouriteBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFavouriteBooks.setBackground(Color.BLACK);
		btnFavouriteBooks.setBounds(10, 181, 158, 35);
		contentPane.add(btnFavouriteBooks);
		
		JButton btnWishList = new JButton("Wish List");
		btnWishList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wishlist frame = new Wishlist();
				frame.setVisible(true);
				dispose();
			}
		});
		btnWishList.setForeground(Color.WHITE);
		btnWishList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWishList.setBackground(Color.BLACK);
		btnWishList.setBounds(10, 229, 158, 35);
		contentPane.add(btnWishList);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogOut.setBackground(new Color(178, 34, 34));
		btnLogOut.setBounds(10, 457, 158, 35);
		contentPane.add(btnLogOut);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(userhome.class.getResource("/picture/green wall - Copy.jpg")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(10, 89, 158, 35);
		contentPane.add(label_3);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(userhome.class.getResource("/picture/black.jpg")));
		BlackLabel.setBackground(Color.BLACK);
		BlackLabel.setBounds(0, 0, 168, 579);
		contentPane.add(BlackLabel);
		
		JLabel label = new JLabel("Soft_71");
		label.setForeground(new Color(107, 142, 35));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(637, 549, 48, 30);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 164, 486, 172);
		contentPane.add(scrollPane);
		
		datatable = new JTable();
		scrollPane.setViewportView(datatable);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Algerian", Font.PLAIN, 25));
		btnAdd.setBackground(new Color(127, 255, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addData();
			}
		});
		btnAdd.setBounds(512, 503, 111, 59);
		contentPane.add(btnAdd);
		
		JLabel label_2 = new JLabel("Book Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(148, 0, 211));
		label_2.setFont(new Font("Segoe Print", Font.BOLD, 15));
		label_2.setBounds(189, 365, 111, 30);
		contentPane.add(label_2);
		
		JLabel lblWriterName = new JLabel("Writer name");
		lblWriterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWriterName.setForeground(new Color(148, 0, 211));
		lblWriterName.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblWriterName.setBounds(178, 406, 122, 30);
		contentPane.add(lblWriterName);
		
		JLabel lblEditionNo = new JLabel("Edition No");
		lblEditionNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditionNo.setForeground(new Color(148, 0, 211));
		lblEditionNo.setFont(new Font("Segoe Print", Font.BOLD, 16));
		lblEditionNo.setBounds(188, 447, 112, 30);
		contentPane.add(lblEditionNo);
		
		JLabel lblPublication = new JLabel("publication");
		lblPublication.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublication.setForeground(new Color(148, 0, 211));
		lblPublication.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblPublication.setBounds(178, 491, 122, 30);
		contentPane.add(lblPublication);
		
		booknameTF = new JTextField();
		booknameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		booknameTF.setBounds(310, 370, 173, 30);
		contentPane.add(booknameTF);
		booknameTF.setColumns(10);
		
		writernameTF = new JTextField();
		writernameTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		writernameTF.setColumns(10);
		writernameTF.setBounds(310, 406, 173, 30);
		contentPane.add(writernameTF);
		
		editionnoTF = new JTextField();
		editionnoTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		editionnoTF.setColumns(10);
		editionnoTF.setBounds(310, 447, 173, 30);
		contentPane.add(editionnoTF);
		
		publicationTF = new JTextField();
		publicationTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		publicationTF.setColumns(10);
		publicationTF.setBounds(310, 496, 173, 30);
		contentPane.add(publicationTF);
		
		priceTF = new JTextField();
		priceTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		priceTF.setColumns(10);
		priceTF.setBounds(310, 532, 173, 30);
		contentPane.add(priceTF);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"", "Book_Name", "Writer_Name", "Publication", "price"}));
		searchCB.setBounds(262, 127, 139, 26);
		contentPane.add(searchCB);
		
		searchTF = new JTextField();
		searchTF.setBounds(475, 127, 148, 26);
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchData();
			}
		});
		contentPane.add(searchTF);
		searchTF.setColumns(10);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(new Color(148, 0, 211));
		lblPrice.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblPrice.setBounds(200, 532, 100, 30);
		contentPane.add(lblPrice);
		
		JLabel label_4 = new JLabel("Boi Poka");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(new Color(0, 100, 0));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(327, 22, 308, 73);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(userhome.class.getResource("/picture/logo2.png")));
		label_5.setBounds(281, 26, 120, 73);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(userhome.class.getResource("/picture/logoproject.png")));
		label_6.setBounds(152, 145, 543, 579);
		contentPane.add(label_6);
	}
}
