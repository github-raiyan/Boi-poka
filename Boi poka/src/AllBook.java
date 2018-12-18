import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class AllBook extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtByBookName;
	private JTextField txtByPublication;
	private JTextField txtByWriter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllBook frame = new AllBook();
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
	public AllBook() {
		setTitle("Update Book");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\kisspng-black-white-computer-icons-book-png-book-icon-5ab02df11585d6.9013344215214955370882.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground( new Color(45, 152, 218) );
		
		JLabel allBook_lable = new JLabel("All Books");
		allBook_lable.setHorizontalAlignment(SwingConstants.CENTER);
		allBook_lable.setForeground(new Color(255, 255, 255));
		allBook_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel updatecommand_lable = new JLabel("Select Keyword To Search & Click On Table For Book Information");
		updatecommand_lable.setHorizontalAlignment(SwingConstants.CENTER);
		updatecommand_lable.setForeground(new Color(255, 255, 255));
		updatecommand_lable.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		JLabel bookImage = new JLabel("");
		bookImage.setIcon(new ImageIcon("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\150canadianstories-Book-Cover-3D-x800.jpg"));
		bookImage.setFont(new Font("Segoe UI", Font.BOLD, 16));
		bookImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel bookName = new JLabel("Book Name");
		bookName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookName.setForeground(new Color(255, 255, 255));
		bookName.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel ownerName = new JLabel("Owner Name");
		ownerName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ownerName.setForeground(new Color(255, 255, 255));
		ownerName.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel ownerContact = new JLabel("Owner  Contact");
		ownerContact.setFont(new Font("Segoe UI", Font.BOLD, 14));
		ownerContact.setForeground(new Color(255, 255, 255));
		ownerContact.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel bookDetails = new JLabel("Book Details");
		bookDetails.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookDetails.setForeground(new Color(255, 255, 255));
		bookDetails.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton donate_btn = new JButton("Send Donate Request");
		donate_btn.setBackground(new Color(19, 15, 64));
		donate_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		donate_btn.setForeground(new Color(255, 255, 255));
		
		JLabel label = new JLabel("");
		
		table = new JTable();
		
		txtByBookName = new JTextField();
		txtByBookName.setHorizontalAlignment(SwingConstants.CENTER);
		txtByBookName.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtByBookName.setText("By Book Name");
		txtByBookName.setColumns(10);
		
		txtByPublication = new JTextField();
		txtByPublication.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtByPublication.setHorizontalAlignment(SwingConstants.CENTER);
		txtByPublication.setText("By Publication");
		txtByPublication.setColumns(10);
		
		txtByWriter = new JTextField();
		txtByWriter.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtByWriter.setHorizontalAlignment(SwingConstants.CENTER);
		txtByWriter.setText("By Writer");
		txtByWriter.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addGap(89)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
											.addComponent(ownerName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
											.addComponent(ownerContact, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
											.addComponent(bookDetails, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
									.addComponent(allBook_lable, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(table, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(txtByBookName, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtByWriter, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
										.addGap(81)
										.addComponent(txtByPublication, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addGap(32)))
								.addComponent(updatecommand_lable, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(donate_btn)
							.addGap(49))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(allBook_lable, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(updatecommand_lable, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtByBookName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtByPublication, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtByWriter, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bookImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bookName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ownerName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ownerContact, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookDetails, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addComponent(donate_btn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(536, 531, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
		
	}

}
