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
import javax.swing.ImageIcon;
import java.awt.Color;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class generaldonate extends JFrame {

	private JPanel contentPane;
	private JTable datatable;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	private JTextField searchTF;
	private JComboBox searchCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generaldonate frame = new generaldonate();
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
	public generaldonate() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(generaldonate.class.getResource("/picture/app.jpg")));
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
	
	private void loadTable() {
		try {
			String query = "SELECT Book_Name,Writer_Name,Book_Detail FROM dotane";
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
		setTitle("Donate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_4 = new JLabel("Donate Books");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(10, 188, 158, 35);
		contentPane.add(label_4);
		
		JLabel label_1 = new JLabel("Boi Poka");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 100, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(10, 11, 141, 50);
		contentPane.add(label_1);
		
		JLabel lblDonateBooks = new JLabel("");
		lblDonateBooks.setIcon(new ImageIcon(generaldonate.class.getResource("/picture/green wall - Copy.jpg")));
		lblDonateBooks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonateBooks.setForeground(Color.WHITE);
		lblDonateBooks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDonateBooks.setBackground(Color.BLACK);
		lblDonateBooks.setBounds(10, 188, 158, 35);
		contentPane.add(lblDonateBooks);
		
		JButton button = new JButton("Log in");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBackground(Color.BLACK);
		button.setBounds(10, 142, 158, 35);
		contentPane.add(button);
		
		JButton button_2 = new JButton("Sell Books");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Generalsell frame = new Generalsell();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(10, 232, 158, 35);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Games");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralgame frame = new genaralgame();
				frame.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 278, 158, 35);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("About");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				genaralabout frame = new genaralabout();
				frame.setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBackground(Color.BLACK);
		button_4.setBounds(10, 324, 158, 35);
		contentPane.add(button_4);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Homepage frame = new Homepage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(10, 96, 158, 35);
		contentPane.add(btnHome);
		
		searchCB = new JComboBox();
		searchCB.setModel(new DefaultComboBoxModel(new String[] {"", "Book_Name", "Writer_Name", "Owner_Contact"}));
		searchCB.setBounds(276, 151, 141, 22);
		contentPane.add(searchCB);
		
		searchTF = new JTextField();
		searchTF.setColumns(10);
		searchTF.setBounds(456, 152, 135, 22);
		searchTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchData();
			}
		});
		contentPane.add(searchTF);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(generaldonate.class.getResource("/picture/black.jpg")));
		label.setBounds(0, 0, 168, 472);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 211, 394, 225);
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
		
		JLabel label_2 = new JLabel("Boi Poka");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(352, 37, 308, 73);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Soft_71");
		label_3.setForeground(new Color(107, 142, 35));
		label_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		label_3.setBounds(637, 431, 48, 30);
		contentPane.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(generaldonate.class.getResource("/picture/logo2.png")));
		label_5.setBounds(288, 37, 120, 73);
		contentPane.add(label_5);
	}

}
