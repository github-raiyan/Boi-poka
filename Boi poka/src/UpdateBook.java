import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class UpdateBook extends JFrame {

	private JPanel contentPane;
	private JTable updateTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBook frame = new UpdateBook();
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
	public UpdateBook() {
		design();
	}
	public void design() {
		setTitle("Update Book");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tawhid\\eclipse-workspace\\Book\\img\\kisspng-black-white-computer-icons-book-png-book-icon-5ab02df11585d6.9013344215214955370882.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground( new Color(45, 152, 218) );
		
		JLabel updateBook_lable = new JLabel("Update Book");
		updateBook_lable.setHorizontalAlignment(SwingConstants.CENTER);
		updateBook_lable.setForeground(new Color(255, 255, 255));
		updateBook_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		updateBook_lable.setBounds(1, 30, 599, 30);
		contentPane.add(updateBook_lable);
		
		JLabel updatecommand_lable = new JLabel("Select The Book You Want To Update");
		updatecommand_lable.setHorizontalAlignment(SwingConstants.CENTER);
		updatecommand_lable.setForeground(new Color(255, 255, 255));
		updatecommand_lable.setFont(new Font("Segoe UI", Font.BOLD, 11));
		updatecommand_lable.setBounds(1, 71, 599, 30);
		contentPane.add(updatecommand_lable);
		
		JLabel bookName_lable = new JLabel("Book Name");
		bookName_lable.setHorizontalAlignment(SwingConstants.CENTER);
		bookName_lable.setForeground(new Color(255, 255, 255));
		bookName_lable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookName_lable.setBounds(101, 214, 100, 30);
		contentPane.add(bookName_lable);
		
		JTextArea bookName_tf = new JTextArea("");
		bookName_tf.setLineWrap(true);
		bookName_tf.setForeground(new Color(0, 0, 0));
		bookName_tf.setToolTipText("");
		bookName_tf.setBounds(201, 214, 300, 30);
		contentPane.add(bookName_tf);
		
		JLabel bookWriterName_label = new JLabel("Writer Name");
		bookWriterName_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookWriterName_label.setForeground(new Color(255, 255, 255));
		bookWriterName_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookWriterName_label.setBounds(101, 266, 100, 30);
		contentPane.add(bookWriterName_label);
		
		JTextArea bookWriterName_tf = new JTextArea("");
		bookWriterName_tf.setLineWrap(true);
		bookWriterName_tf.setForeground(new Color(0, 0, 0));
		bookWriterName_tf.setToolTipText("");
		bookWriterName_tf.setBounds(201, 266, 300, 30);
		contentPane.add(bookWriterName_tf);
		
		JLabel bookType_label = new JLabel("Type of Book");
		bookType_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookType_label.setForeground(new Color(255, 255, 255));
		bookType_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookType_label.setBounds(101, 428, 100, 30);
		contentPane.add(bookType_label);
		
		JTextArea bookType_tf = new JTextArea("");
		bookType_tf.setLineWrap(true);
		bookType_tf.setForeground(new Color(0, 0, 0));
		bookType_tf.setToolTipText("");
		bookType_tf.setBounds(201, 428, 300, 30);
		contentPane.add(bookType_tf);
		
		JLabel bookEditionNo_label = new JLabel("Edition No");
		bookEditionNo_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookEditionNo_label.setForeground(new Color(255, 255, 255));
		bookEditionNo_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookEditionNo_label.setBounds(101, 318, 100, 30);
		contentPane.add(bookEditionNo_label);
		
		JTextArea bookEditionNo_tf = new JTextArea("");
		bookEditionNo_tf.setLineWrap(true);
		bookEditionNo_tf.setForeground(new Color(0, 0, 0));
		bookEditionNo_tf.setToolTipText("");
		bookEditionNo_tf.setBounds(201, 318, 100, 30);
		contentPane.add(bookEditionNo_tf);
		
		JLabel bookPrice_label = new JLabel("Price");
		bookPrice_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookPrice_label.setForeground(new Color(255, 255, 255));
		bookPrice_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookPrice_label.setBounds(301, 318, 100, 30);
		contentPane.add(bookPrice_label);
		
		JTextArea bookPrice_tf = new JTextArea("");
		bookPrice_tf.setLineWrap(true);
		bookPrice_tf.setForeground(new Color(0, 0, 0));
		bookPrice_tf.setToolTipText("");
		bookPrice_tf.setBounds(401, 318, 100, 30);
		contentPane.add(bookPrice_tf);
		
		JLabel bookPublication_label = new JLabel("Publication");
		bookPublication_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookPublication_label.setForeground(new Color(255, 255, 255));
		bookPublication_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookPublication_label.setBounds(101, 370, 100, 30);
		contentPane.add(bookPublication_label);
		
		JTextArea bookPublication_tf = new JTextArea("");
		bookPublication_tf.setLineWrap(true);
		bookPublication_tf.setForeground(new Color(0, 0, 0));
		bookPublication_tf.setToolTipText("");
		bookPublication_tf.setBounds(201, 370, 100, 30);
		contentPane.add(bookPublication_tf);
		
		JLabel bookCoverImage_label = new JLabel("Cover Image");
		bookCoverImage_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookCoverImage_label.setForeground(new Color(255, 255, 255));
		bookCoverImage_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookCoverImage_label.setBounds(301, 370, 100, 30);
		contentPane.add(bookCoverImage_label);
		
		JTextArea bookImage_tf = new JTextArea("");
		bookImage_tf.setLineWrap(true);
		bookImage_tf.setForeground(new Color(0, 0, 0));
		bookImage_tf.setToolTipText("");
		bookImage_tf.setBounds(401, 370, 100, 30);
		contentPane.add(bookImage_tf);
		
		JLabel bookDetails_label = new JLabel("Details");
		bookDetails_label.setHorizontalAlignment(SwingConstants.CENTER);
		bookDetails_label.setForeground(new Color(255, 255, 255));
		bookDetails_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		bookDetails_label.setBounds(101, 479, 100, 30);
		contentPane.add(bookDetails_label);
		
		JTextArea bookDetails_tf = new JTextArea("");
		bookDetails_tf.setLineWrap(true);
		bookDetails_tf.setForeground(new Color(0, 0, 0));
		bookDetails_tf.setToolTipText("");
		bookDetails_tf.setBounds(201, 479, 300, 30);
		contentPane.add(bookDetails_tf);
		
		/******/
		JButton updateBook_btn = new JButton("Update Book");
		updateBook_btn.setBackground(new Color(19, 15, 64));
		updateBook_btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
		updateBook_btn.setForeground(new Color(255, 255, 255));
		updateBook_btn.setBounds(361, 520, 140, 30);
		contentPane.add(updateBook_btn);
		
		updateTable = new JTable();
		updateTable.setBounds(1, 112, 583, 80);
		contentPane.add(updateTable);
		
		JLabel team = new JLabel("Soft_71");
		team.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		team.setBounds(536, 531, 48, 30);
		team.setForeground(new Color(199, 236, 238));
		contentPane.add(team);
	}
}
