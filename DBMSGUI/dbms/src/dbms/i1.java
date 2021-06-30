package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class i1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	Connection connect = null;
    Statement stmt = null;
    ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					i1 frame = new i1();
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
	public i1() {
		setAlwaysOnTop(true);
		setTitle("Teacher Section");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 766, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(259, 41, 228, 47);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(322, 129, 200, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(158, 132, 98, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(158, 228, 98, 23);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(322, 225, 200, 32);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
                connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","anuj3107");
                stmt=connect.createStatement();
				String sql2="Select Teacher_ID, `D.O.B` from teacher where Teacher_ID=? and `D.O.B`=?"; 
				PreparedStatement pst2=connect.prepareStatement(sql2);
				pst2.setString(1,textField.getText());
				pst2.setString(2,passwordField.getText());
				rs=pst2.executeQuery();
				if(rs.next())
				{
					new i2().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(i1.this, "Enter valid Teacher ID and Password");
				}
				}
				catch(Exception e1)
				{}
				
			}
		});
		btnNewButton.setBounds(322, 317, 108, 32);
		contentPane.add(btnNewButton);
	}
}