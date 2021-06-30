package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Attendance extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
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
					Attendance frame = new Attendance();
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
	public Attendance() {
		setTitle("Attendance");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 794, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser jDateChooser1 = new JDateChooser();
		jDateChooser1.setBounds(347, 82, 210, 36);
		contentPane.add(jDateChooser1);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(242, 82, 55, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(191, 164, 106, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(347, 165, 127, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Present");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(242, 243, 109, 23);
		rdbtnNewRadioButton.setActionCommand("Present");
		contentPane.add(rdbtnNewRadioButton);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Absent");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(365, 243, 109, 23);
		rdbtnNewRadioButton_1.setActionCommand("Absent");
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group= new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","anuj3107");
                    stmt=connect.createStatement();
                    String sql="insert into attendance values(?,?,?);";
                    PreparedStatement pst=connect.prepareStatement(sql);
                    Date date =jDateChooser1.getDate();  
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                    String strDate = formatter.format(date);
                    pst.setString(2,strDate);
                    pst.setString(1,textField.getText());
                    String Presenty=null;
                    if(rdbtnNewRadioButton.isSelected())
                    {
                    	Presenty="Present";
                    	pst.setString(3,Presenty);
                    	pst.executeUpdate();
                    	JOptionPane.showMessageDialog(Attendance.this, "Attendance added");
                    }
                    else if(rdbtnNewRadioButton_1.isSelected())
                    {
                    	Presenty="Absent";
                    	pst.setString(3,Presenty);
                    	pst.executeUpdate();
                    	JOptionPane.showMessageDialog(Attendance.this, "Attendance added");
                    }
                    else {
                    	JOptionPane.showMessageDialog(Attendance.this, "Select Absent or Present");
                    }
                    jDateChooser1.setToolTipText("");
                    textField.setText("");
				}
				catch(Exception e1)
				{}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(292, 310, 127, 36);
		contentPane.add(btnNewButton);
	}
}
