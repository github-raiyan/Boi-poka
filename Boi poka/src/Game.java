import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
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
	public Game() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/picture/app.jpg")));
		setTitle("Game");
		degine();
		Centerize();
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
		label_1.setBounds(27, 23, 141, 50);
		contentPane.add(label_1);
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblGames.setForeground(Color.WHITE);
		lblGames.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGames.setBackground(Color.BLACK);
		lblGames.setBounds(10, 372, 158, 35);
		contentPane.add(lblGames);
		
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
		button_1.setBounds(10, 276, 158, 35);
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
		button_2.setBounds(10, 320, 158, 35);
		contentPane.add(button_2);
		
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
		button_4.setBounds(10, 418, 158, 35);
		contentPane.add(button_4);
		
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
		btnHome.setBounds(10, 84, 158, 35);
		contentPane.add(btnHome);
		
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
		button_6.setBounds(10, 182, 158, 35);
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
		button_7.setBounds(10, 230, 158, 35);
		contentPane.add(button_7);
		
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
		btnLogOut.setBounds(10, 464, 158, 35);
		contentPane.add(btnLogOut);
		
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
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Game.class.getResource("/picture/green wall - Copy.jpg")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(10, 372, 158, 35);
		contentPane.add(label_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Game.class.getResource("/picture/black.jpg")));
		label.setBackground(Color.BLACK);
		label.setBounds(0, 0, 168, 579);
		contentPane.add(label);
		
		JLabel lblLevel = new JLabel("");
		lblLevel.setIcon(new ImageIcon(Game.class.getResource("/picture/rsz_11.png")));
		lblLevel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				level1 frame = new level1();
				frame.setVisible(true);
				dispose();
			}
		});
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setBounds(286, 226, 308, 211);
		contentPane.add(lblLevel);
		
		JLabel label_2 = new JLabel("Boi Poka");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(321, 64, 308, 73);
		contentPane.add(label_2);
		
		JLabel lblLevel_1 = new JLabel("Level 1");
		lblLevel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				level1 frame = new level1();
				frame.setVisible(true);
				dispose();
			}
		});
		lblLevel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLevel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel_1.setBounds(329, 465, 212, 35);
		contentPane.add(lblLevel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Game.class.getResource("/picture/logo2.png")));
		label_4.setBounds(259, 64, 120, 73);
		contentPane.add(label_4);
	}
}
