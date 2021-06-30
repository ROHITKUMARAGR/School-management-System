package dbms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class i2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					i2 frame = new i2();
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
	public i2() {
		setAlwaysOnTop(true);
		setTitle("Teacher Section");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Student Marks");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new i3().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(237, 48, 263, 45);
		contentPane.add(btnNewButton);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new Attendance().setVisible(true);
			}
		});
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnAttendance.setBounds(237, 138, 263, 45);
		contentPane.add(btnAttendance);
		
		JButton btnCoursesEnrolled = new JButton("Courses enrolled");
		btnCoursesEnrolled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Courses_Enrolled().setVisible(true);
			}
		});
		btnCoursesEnrolled.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnCoursesEnrolled.setBounds(237, 232, 263, 45);
		contentPane.add(btnCoursesEnrolled);
		
		JButton btnShowResults = new JButton("Show Results");
		btnShowResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new student_marks().setVisible(true);
			}
			
		});
		btnShowResults.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnShowResults.setBounds(237, 330, 263, 45);
		contentPane.add(btnShowResults);
	}

}