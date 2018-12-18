import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JTable datatable;
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
					Homepage frame = new Homepage();
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
	
	public Homepage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage.class.getResource("/picture/app.jpg")));
		Degine();
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
	
	private void loadTable() {
		try {
			String query = "SELECT Book_Name,Writer_Name,Edition_no,publication FROM book_info";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			datatable.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
			
		}catch (Exception e) {
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
	
	public void Degine() {
		setTitle("Boi Poka");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("Home");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(10, 85, 158, 35);
		contentPane.add(label_2);
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon(Homepage.class.getResource("/picture/green wall - Copy.jpg")));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHome.setForeground(Color.WHITE);
		lblHome.setBackground(Color.BLACK);
		lblHome.setBounds(10, 85, 158, 35);
		contentPane.add(lblHome);
		
		JLabel lblBoiPoka = new JLabel("Boi Poka");
		lblBoiPoka.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblBoiPoka.setBackground(new Color(0, 0, 0));
		lblBoiPoka.setForeground(new Color(0, 100, 0));
		lblBoiPoka.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoiPoka.setBounds(20, 24, 141, 50);
		contentPane.add(lblBoiPoka);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogIn.setBackground(Color.BLACK);
		btnLogIn.setBounds(10, 134, 158, 35);
		contentPane.add(btnLogIn);
		
		JButton btnDonateBooks = new JButton("Donate Books");
		btnDonateBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generaldonate frame = new generaldonate();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDonateBooks.setForeground(Color.WHITE);
		btnDonateBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDonateBooks.setBackground(Color.BLACK);
		btnDonateBooks.setBounds(10, 180, 158, 35);
		contentPane.add(btnDonateBooks);
		
		JButton btnSellBooks = new JButton("Sell Books");
		btnSellBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generalsell frame = new Generalsell();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSellBooks.setForeground(Color.WHITE);
		btnSellBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSellBooks.setBackground(Color.BLACK);
		btnSellBooks.setBounds(10, 224, 158, 35);
		contentPane.add(btnSellBooks);
		
		JButton btnGames = new JButton("Games");
		btnGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralgame frame = new genaralgame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnGames.setForeground(Color.WHITE);
		btnGames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGames.setBackground(Color.BLACK);
		btnGames.setBounds(10, 270, 158, 35);
		contentPane.add(btnGames);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralabout frame = new genaralabout();
				frame.setVisible(true);
				dispose();
			}
		});
		btnAbout.setForeground(Color.WHITE);
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAbout.setBackground(Color.BLACK);
		btnAbout.setBounds(10, 316, 158, 35);
		contentPane.add(btnAbout);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"scarch", "Book_Name", "Writer_Name", "Publication", "price"}));
		searchCB.setBounds(274, 141, 139, 26);
		contentPane.add(searchCB);
		
		searchTF = new JTextField();
		searchTF.setColumns(10);
		searchTF.setBounds(490, 141, 141, 26);
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchData();
			}
		});
		contentPane.add(searchTF);
		
		JLabel BlackLabel = new JLabel("");
		BlackLabel.setIcon(new ImageIcon(Homepage.class.getResource("/picture/Screenshot_2.jpg")));
		BlackLabel.setBounds(0, 0, 168, 472);
		contentPane.add(BlackLabel);
		
		JLabel label = new JLabel("Soft_71");
		label.setForeground(new Color(107, 142, 35));
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(637, 442, 48, 30);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 199, 446, 220);
		contentPane.add(scrollPane);
		
		datatable = new JTable();
		datatable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "You Have to Log in first");
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		scrollPane.setViewportView(datatable);
		
		JLabel label_1 = new JLabel("Boi Poka");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(361, 24, 308, 73);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Homepage.class.getResource("/picture/logo2.png")));
		label_3.setBounds(305, 24, 120, 73);
		contentPane.add(label_3);
	}
}
