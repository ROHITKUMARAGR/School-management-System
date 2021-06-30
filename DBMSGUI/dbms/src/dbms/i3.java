package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class i3 extends JFrame {

	Connection connect = null;
    Statement stmt = null;
    ResultSet rs;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtEnterMarks;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					i3 frame = new i3();
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
	public i3() {
		setAlwaysOnTop(true);
		setTitle("Student Marks");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(268, 65, 377, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(88, 65, 135, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(77, 151, 157, 36);
		contentPane.add(lblNewLabel_1);
		
		txtEnterMarks = new JTextField();
		txtEnterMarks.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtEnterMarks.setBounds(268, 220, 377, 44);
		contentPane.add(txtEnterMarks);
		txtEnterMarks.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Marks");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(79, 220, 144, 44);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
	                connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","anuj3107");	
	        		stmt=connect.createStatement();
	        		String sql="insert into marks values(?,?,?,?);";
	        		PreparedStatement pst=connect.prepareStatement(sql);
	        		pst.setString(1,textField.getText());
	        		pst.setString(2,textField_1.getText());
	        		pst.setString(3,txtEnterMarks.getText());
	        		int m=Integer.parseInt(txtEnterMarks.getText());
	        		if(m>35)
	        		{
	        		pst.setString(4,"Pass");	
	        		pst.executeUpdate();
	        		}
	        		else {
	        		pst.setString(4,"Fail");	
		        	pst.executeUpdate();	
	        		}
	        		JOptionPane.showMessageDialog(i3.this,"Data Entered Successfully");
	        		textField_1.setText("");
	        		txtEnterMarks.setText("");
	        		
				}
				catch(Exception e1)
				{
				 JOptionPane.showMessageDialog(i3.this, "Student with this Id does not exists");
				 textField.setText("");
				 textField_1.setText("");
	        	 txtEnterMarks.setText("");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(196, 319, 96, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");        		    
	                connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","anuj3107");
	                String sql="select count(*) as c1 from student;";
	        		stmt=connect.createStatement();
	        		rs=stmt.executeQuery(sql);
	        		if(rs.next()){
	        	    int ID = rs.getInt("c1");
	        	    ID++;
	        	    String ros=Integer.toString(ID);
	        	    ros='S'+ros;
	        	    textField.setText(ros);
	        		}
				}
				catch(Exception e1)
				{}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.setBounds(366, 319, 96, 36);
		contentPane.add(btnNext);
		
		textField_1 = new JTextField();
		textField_1.setBounds(268, 143, 377, 44);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}