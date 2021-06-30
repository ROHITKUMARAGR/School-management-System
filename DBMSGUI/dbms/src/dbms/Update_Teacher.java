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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update_Teacher extends JFrame {

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
					Update_Teacher frame = new Update_Teacher();
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
	public Update_Teacher() {
		setAlwaysOnTop(true);
		setTitle("Update Teacher Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 879, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(197, 72, 102, 33);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(360, 73, 146, 30);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("Select What to Update");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(90, 145, 209, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(139, 221, 160, 33);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"First Name", "Middle Name", "Last Name", "Father Name", "Mother Name", "Contact No.", "Class ", "D.O.B", "Address"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(360, 145, 220, 38);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(360, 225, 220, 33);
		contentPane.add(textField_1);
		
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
	                	PreparedStatement pst=connect.prepareStatement("update teacher set First_Name=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "First Name Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="Middle Name")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set Middle_Name=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Middle Name Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="Last Name")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set Last_Name=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Last Name Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="Father Name")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set Father_Name=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Father Name Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="Mother Name")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set Mother_Name=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Mother Name Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="Contact No.")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set `Contact_No.`=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Contact No. Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="Class")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set class=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Class Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else if(v=="D.O.B")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set `D.O.B`=?  where Teacher_ID=?;");
	                	Date date =jDateChooser1.getDate(); 
	                	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	                    String strDate = formatter.format(date);
	                	pst.setString(1,strDate);
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "D.O.B Updated Successfully");
	                	textField_1.setText("");
	                	jDateChooser1.setDate(null);
	                }
	                else if(v=="Address")
	                {
	                	PreparedStatement pst=connect.prepareStatement("update teacher set Address=?  where Teacher_ID=?;");
	                	pst.setString(1,textField.getText());
	                	pst.setString(2,textField_1.getText());
	                	pst.executeUpdate();
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Address Updated Successfully");
	                	textField.setText("");
	                	textField_1.setText("");
	                }
	                else {
	                	JOptionPane.showMessageDialog(Update_Teacher.this, "Enter Data properly");
	                }
	                
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(Update_Teacher.this, "Date Must be in format MM/dd/yyyy");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(257, 293, 154, 38);
		contentPane.add(btnNewButton);
		
		jDateChooser1 = new com.toedter.calendar.JDateChooser();
		jDateChooser1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jDateChooser1.setBounds(590, 222, 193, 33);
		contentPane.add(jDateChooser1);
		
		JLabel lblNewLabel_3 = new JLabel("(For Date)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(664, 187, 102, 27);
		contentPane.add(lblNewLabel_3);
	}
}
