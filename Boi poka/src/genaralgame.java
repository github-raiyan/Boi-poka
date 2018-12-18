import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class genaralgame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					genaralgame frame = new genaralgame();
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
	public genaralgame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(genaralgame.class.getResource("/picture/app.jpg")));
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
		setBounds(100, 100, 711, 511);
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
		label_1.setBounds(20, 30, 141, 50);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Game");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(10, 276, 158, 35);
		contentPane.add(label_2);
		
		JLabel lblGame = new JLabel("");
		lblGame.setIcon(new ImageIcon(genaralgame.class.getResource("/picture/green wall - Copy.jpg")));
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setForeground(Color.WHITE);
		lblGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGame.setBackground(Color.BLACK);
		lblGame.setBounds(10, 276, 158, 35);
		contentPane.add(lblGame);
		
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
		button.setBounds(10, 140, 158, 35);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Donate Books");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generaldonate frame = new generaldonate();
				frame.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(10, 186, 158, 35);
		contentPane.add(button_1);
		
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
		button_2.setBounds(10, 230, 158, 35);
		contentPane.add(button_2);
		
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
		button_4.setBounds(10, 322, 158, 35);
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
		btnHome.setBounds(10, 91, 158, 35);
		contentPane.add(btnHome);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(genaralgame.class.getResource("/picture/black.jpg")));
		label.setBounds(0, 0, 168, 472);
		contentPane.add(label);
		
		JLabel label_3 = new JLabel("Boi Poka");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(0, 100, 0));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(310, 63, 308, 73);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				level1 frame = new level1();
				frame.setVisible(true);
				dispose();
			}
		});
		label_4.setIcon(new ImageIcon(genaralgame.class.getResource("/picture/rsz_11.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(310, 173, 308, 211);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Level 1");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				level1 frame = new level1();
				frame.setVisible(true);
				dispose();
			}
		});
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(357, 407, 212, 35);
		contentPane.add(label_5);
	}
}
