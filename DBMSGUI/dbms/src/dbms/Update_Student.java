package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class Update_Student extends JFrame {

	
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
	
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
					Update_Student frame = new Update_Student();
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
	public Update_Student() {
		setTitle("Update Student Information");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"First Name", "Middle Name", "Last Name", "Father Name", "Mother Name", "Contact No.", "Class ", "D.O.B", "Address"}));
		comboBox.setBounds(327, 118, 220, 38);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select What to Update");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(86, 118, 209, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(135, 218, 160, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(327, 222, 220, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");        		    
                connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","anuj3107");
                stmt=connect.createStatement();
                String v=(String)comboBox.getSelectedItem();
                if(v=="First Name")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set First_Name=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "First Name Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="Middle Name")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set Middle_Name=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Middle Name Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="Last Name")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set Last_Name=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Last Name Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="Father Name")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set Father_Name=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Father Name Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="Mother Name")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set Mother_Name=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Mother Name Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="Contact No.")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set `Contact_No.`=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Contact No. Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="Class")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set class=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Class Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else if(v=="D.O.B")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set `D.O.B`=?  where Student_ID=?;");
                	Date date =jDateChooser1.getDate(); 
                	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                    String strDate = formatter.format(date);
                	pst.setString(1,strDate);
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "D.O.B Updated Successfully");
                	textField_1.setText("");
                	jDateChooser1.setDate(null);
                }
                else if(v=="Address")
                {
                	PreparedStatement pst=connect.prepareStatement("update student set Address=?  where Student_ID=?;");
                	pst.setString(1,textField.getText());
                	pst.setString(2,textField_1.getText());
                	pst.executeUpdate();
                	JOptionPane.showMessageDialog(Update_Student.this, "Address Updated Successfully");
                	textField.setText("");
                	textField_1.setText("");
                }
                else {
                	JOptionPane.showMessageDialog(Update_Student.this, "Enter Data properly");
                }
                
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(Update_Student.this, "Date Must be in format MM/dd/yyyy");
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(242, 319, 154, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(193, 54, 102, 33);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(327, 54, 146, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jDateChooser1.setBounds(590, 222, 193, 33);
		contentPane.add(jDateChooser1);
		
		JLabel lblNewLabel_3 = new JLabel("(For Date)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(634, 184, 102, 27);
		contentPane.add(lblNewLabel_3);
	}
}
