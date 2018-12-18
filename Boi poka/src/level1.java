import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class level1 extends JFrame {

	private JPanel contentPane;

	private double count=0;
	private double p=0;
	private int milisecs = 0;
	private int secends = 0;
	private int minutes = 0;
	private int hours = 0;
	private int a=0;
	private boolean state = true;
	private JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					level1 frame = new level1();
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
	public level1() {
		setTitle("Treasure Hunt");
		Degine();
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
	
	public void point() {
		count=count+100;
		p++;
		dispiay();
	}
	
	public void dispiay() {
		if(p==20) {
		JOptionPane.showMessageDialog(null, "Your point is "+count);
		Game frame = new Game();
		frame.setVisible(true);
		dispose();
		}
	}
	
	public void start() {
		state = true;
		Thread t = new Thread() {
			public void run() {
				 for(;;) {
					 if(state == true) {
						 try {
							 sleep(1);
							 if(milisecs==1000) {
									a++;
									if(a==5) {
										count=count-30;
									}
									if(a==10) {
										count=count-50;
									}
									if(a==15) {
										count=count-60;
									}
									if(a==30) {
										count=count-78;
									}
							 }
							 if(milisecs>1000) {
								 milisecs = 0;
								 secends++;
							 }
							 if(secends>60) {
								 milisecs = 0;
								 secends = 0;
								 minutes++;
							 }
							 if(minutes>60) {
								 milisecs = 0;
								 secends = 0;
								 minutes = 0;
								 hours = 0;
							 }
							 
							 //minisecTF.setText(""+milisecs);
							 milisecs++;
							 //secendTF.setText(""+secends);
							// miniteTF.setText(""+minutes);
							 //hourTF.setText(""+hours);
							 
							 
						 }catch (Exception e) {
								e.printStackTrace();
							}
					 } 
					else {
						 break;
					 }
				 }
			}
		};
		
		t.start();
		
	}
	
	public void Degine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnScarf = new JButton("Scarf");
		btnScarf.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
		btnScarf.setBackground(new Color(255, 255, 255));
		btnScarf.setBounds(93, 524, 95, 30);
		contentPane.add(btnScarf);
		
		JLabel scarf = new JLabel("");
		scarf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnScarf.setVisible(false);
				scarf.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		scarf.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/scarf.png")));
		scarf.setBounds(372, 279, 95, 65);
		contentPane.add(scarf);
		
		JButton Bellbtn = new JButton("Bell");
		Bellbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Bellbtn.setBackground(new Color(0, 255, 0));
		Bellbtn.setBounds(93, 524, 95, 30);
		contentPane.add(Bellbtn);
		
		JLabel bell = new JLabel("");
		bell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bellbtn.setVisible(false);
				bell.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		bell.setIcon(new ImageIcon(level1.class.getResource("/picture/bell.png")));
		bell.setBounds(45, 94, 34, 100);
		contentPane.add(bell);
		
		JButton btnBooks = new JButton("Books");
		btnBooks.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		btnBooks.setBackground(new Color(102, 255, 0));
		btnBooks.setBounds(801, 524, 105, 30);
		contentPane.add(btnBooks);
		
		JLabel books = new JLabel("");
		books.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBooks.setVisible(false);
				books.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		books.setIcon(new ImageIcon(level1.class.getResource("/picture/book.png")));
		books.setBounds(863, 298, 34, 50);
		contentPane.add(books);
		
		JButton btnMakeupBox = new JButton("Makeup Box");
		btnMakeupBox.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		btnMakeupBox.setBackground(new Color(255, 255, 255));
		btnMakeupBox.setBounds(495, 524, 105, 31);
		contentPane.add(btnMakeupBox);
		
		JLabel makeupbox = new JLabel("");
		makeupbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMakeupBox.setVisible(false);
				makeupbox.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		makeupbox.setIcon(new ImageIcon(level1.class.getResource("/picture/makeupbox.png")));
		makeupbox.setBounds(927, 327, 70, 67);
		contentPane.add(makeupbox);
		
		JButton btnSock = new JButton("Sock");
		btnSock.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		btnSock.setBackground(new Color(0, 255, 255));
		btnSock.setBounds(187, 524, 105, 30);
		contentPane.add(btnSock);
		
		JLabel socks = new JLabel("");
		socks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSock.setVisible(false);
				socks.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		socks.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/socks.png")));
		socks.setBounds(774, 280, 45, 38);
		contentPane.add(socks);
		
		JButton btnDiamond = new JButton("Diamond");
		btnDiamond.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDiamond.setBackground(Color.YELLOW);
		btnDiamond.setBounds(187, 524, 105, 30);
		contentPane.add(btnDiamond);
		
		JLabel diamond = new JLabel("");
		diamond.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDiamond.setVisible(false);
				diamond.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		diamond.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/dimond.png")));
		diamond.setBounds(433, 368, 34, 30);
		contentPane.add(diamond);
		
		JButton btnRedioPlayer = new JButton("CD player");
		btnRedioPlayer.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		btnRedioPlayer.setBackground(new Color(255, 255, 0));
		btnRedioPlayer.setBounds(0, 524, 95, 30);
		contentPane.add(btnRedioPlayer);
		
		JLabel Redioplayer = new JLabel("");
		Redioplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRedioPlayer.setVisible(false);
				Redioplayer.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		Redioplayer.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/radio.png")));
		Redioplayer.setBounds(272, 345, 85, 50);
		contentPane.add(Redioplayer);
		
		JButton CatBT = new JButton("Cat");
		CatBT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CatBT.setBackground(new Color(0, 255, 255));
		CatBT.setBounds(0, 524, 95, 30);
		contentPane.add(CatBT);
		
		JLabel cat = new JLabel("");
		cat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CatBT.setVisible(false);
				cat.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		cat.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/cat.png")));
		cat.setBounds(423, 327, 34, 67);
		contentPane.add(cat);
		
		JButton btnBack = new JButton("<-Back");
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game frame = new Game();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(863, 13, 105, 38);
		contentPane.add(btnBack);
		
		JLabel wallpic = new JLabel("");
		wallpic.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/wallframe.png")));
		wallpic.setBounds(709, 149, 45, 40);
		contentPane.add(wallpic);
		
		JButton btnCap = new JButton("Cap");
		btnCap.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
		btnCap.setBackground(new Color(255, 255, 0));
		btnCap.setBounds(902, 524, 94, 30);
		contentPane.add(btnCap);
		
		JLabel cap = new JLabel("");
		cap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCap.setVisible(false);
				cap.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		cap.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/cup.png")));
		cap.setBounds(457, 280, 51, 38);
		contentPane.add(cap);
		
		JButton btnDoorMat = new JButton("Door mat");
		btnDoorMat.setFont(new Font("Monotype Corsiva", Font.PLAIN, 15));
		btnDoorMat.setBackground(new Color(51, 255, 0));
		btnDoorMat.setBounds(289, 524, 105, 30);
		contentPane.add(btnDoorMat);
		
		JLabel mat = new JLabel("");
		mat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDoorMat.setVisible(false);
				mat.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		mat.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/mat.png")));
		mat.setBounds(619, 445, 111, 50);
		contentPane.add(mat);
		
		JButton btnHelmet = new JButton("Helmet");
		btnHelmet.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		btnHelmet.setBackground(new Color(255, 165, 0));
		btnHelmet.setBounds(698, 524, 105, 30);
		contentPane.add(btnHelmet);
		
		JLabel helmet = new JLabel("");
		helmet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnHelmet.setVisible(false);
				helmet.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		helmet.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/helmet.png")));
		helmet.setBounds(45, 445, 70, 55);
		contentPane.add(helmet);
		
		JButton btnCd = new JButton("CD");
		btnCd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCd.setBackground(Color.YELLOW);
		btnCd.setBounds(698, 524, 105, 30);
		contentPane.add(btnCd);
		
		JLabel CD = new JLabel("");
		CD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCd.setVisible(false);
				CD.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		CD.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/CD.png")));
		CD.setBounds(720, 421, 34, 30);
		contentPane.add(CD);
		
		JButton btnButterfly = new JButton("Butterfly");
		btnButterfly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnButterfly.setBackground(new Color(255, 165, 0));
		btnButterfly.setBounds(801, 524, 105, 30);
		contentPane.add(btnButterfly);
		
		JLabel Butterfly = new JLabel("");
		Butterfly.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnButterfly.setVisible(false);
				Butterfly.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		Butterfly.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/butterfly.png")));
		Butterfly.setBounds(643, 210, 25, 21);
		contentPane.add(Butterfly);
		
		JButton btnToyboat = new JButton("Toy Boat");
		btnToyboat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnToyboat.setBackground(new Color(255, 165, 0));
		btnToyboat.setBounds(289, 524, 105, 30);
		contentPane.add(btnToyboat);
		
		JLabel toyboat = new JLabel("");
		toyboat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnToyboat.setVisible(false);
				toyboat.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		toyboat.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/toyboat.png")));
		toyboat.setBounds(204, 159, 51, 50);
		contentPane.add(toyboat);
		
		JButton btnRing = new JButton("Ring");
		btnRing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRing.setBackground(new Color(0, 255, 255));
		btnRing.setBounds(495, 524, 105, 30);
		contentPane.add(btnRing);
		
		JLabel Ring = new JLabel("");
		Ring.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRing.setVisible(false);
				Ring.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		Ring.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/ring.png")));
		Ring.setBounds(10, 287, 34, 31);
		contentPane.add(Ring);
		
		JLabel Walkman = new JLabel("");
		Walkman.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/Walkman.png")));
		Walkman.setBounds(467, 313, 60, 31);
		contentPane.add(Walkman);
		
		JButton btnShorts = new JButton("Shorts");
		btnShorts.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		btnShorts.setBackground(new Color(255, 255, 0));
		btnShorts.setBounds(599, 524, 105, 30);
		contentPane.add(btnShorts);
		
		JLabel shorts = new JLabel("");
		shorts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnShorts.setVisible(false);
				shorts.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		shorts.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/shorts.png")));
		shorts.setBounds(518, 262, 51, 50);
		contentPane.add(shorts);
		
		JButton btnRibon = new JButton("Ribon");
		btnRibon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRibon.setBackground(new Color(0, 255, 0));
		btnRibon.setBounds(599, 524, 105, 30);
		contentPane.add(btnRibon);
		
		JLabel redribon = new JLabel("");
		redribon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRibon.setVisible(false);
				redribon.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		redribon.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/ribon.png")));
		redribon.setBounds(313, 234, 30, 21);
		contentPane.add(redribon);
		
		JButton btnShoe = new JButton("Shoe");
		btnShoe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShoe.setBackground(new Color(248, 248, 255));
		btnShoe.setBounds(902, 524, 94, 30);
		contentPane.add(btnShoe);
		
		JLabel Shoe = new JLabel("");
		Shoe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnShoe.setVisible(false);
				Shoe.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		Shoe.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/show.png")));
		Shoe.setBounds(185, 405, 70, 31);
		contentPane.add(Shoe);
		
		JLabel Clock = new JLabel("");
		Clock.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/Clock.png")));
		Clock.setBounds(479, 137, 46, 41);
		contentPane.add(Clock);
		
		JLabel hotairbaloon = new JLabel("");
		hotairbaloon.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/hotairbaloon.png")));
		hotairbaloon.setBounds(252, 72, 60, 67);
		contentPane.add(hotairbaloon);
		
		JLabel happyface = new JLabel("");
		happyface.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/happyface.png")));
		happyface.setBounds(361, 327, 25, 21);
		contentPane.add(happyface);
		
		JButton btnMug = new JButton("Mug");
		btnMug.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		btnMug.setBackground(new Color(255, 0, 102));
		btnMug.setBounds(393, 524, 105, 30);
		contentPane.add(btnMug);
		
		JLabel mug = new JLabel("");
		mug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnMug.setVisible(false);
				mug.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		mug.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/mug.png")));
		mug.setBounds(551, 305, 45, 38);
		contentPane.add(mug);
		
		JButton btnAlamClock = new JButton("Alam Clock");
		btnAlamClock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlamClock.setBackground(new Color(248, 248, 255));
		btnAlamClock.setBounds(393, 524, 105, 30);
		contentPane.add(btnAlamClock);
		
		JLabel alamclock = new JLabel("");
		alamclock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAlamClock.setVisible(false);
				alamclock.setVisible(false);
				point();
				start();
				textField.setText(""+count);
			}
		});
		alamclock.setIcon(new ImageIcon(level1.class.getResource("/gamepicture/alamclock.png")));
		alamclock.setBounds(643, 244, 45, 38);
		contentPane.add(alamclock);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(level1.class.getResource("/picture/frame.png")));
		background.setBounds(0, 62, 996, 438);
		contentPane.add(background);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		textField.setColumns(10);
		textField.setBounds(82, 11, 70, 30);
		contentPane.add(textField);
		
		JLabel lblPoint = new JLabel("Point :");
		lblPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPoint.setBounds(9, 11, 70, 30);
		contentPane.add(lblPoint);
		
		JLabel lblTreasureHunt = new JLabel("Treasure Hunt");
		lblTreasureHunt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreasureHunt.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTreasureHunt.setForeground(new Color(0, 139, 139));
		lblTreasureHunt.setBounds(252, 11, 417, 38);
		contentPane.add(lblTreasureHunt);
	}
}
