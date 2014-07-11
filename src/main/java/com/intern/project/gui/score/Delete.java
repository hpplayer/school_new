package com.intern.project.gui.score;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.intern.project.POJO.Score;
import com.intern.project.daoImpl.ScoreDaoImpl;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete {

	private JFrame frame;
	private JTextField textField_stuID;
	private JTextField textField_crsID;
	private JTextField textField_Score;
	private JTextField textField_StuName;
	private JTextField textField_crsName;
	private long stuID;
	private String stuName;
	private long crsID;
	private String crsName;
	private int score;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Delete() {
		initialize();
	}
		
	public Delete(long stuID, String stuName, long crsID, String crsName, int score) {
		initialize();
		frame.setVisible(true);
		this.stuID = stuID;
		System.out.println(stuID);
		this.stuName = stuName;
		this.crsID = crsID;
		this.crsName = crsName;
		this.score = score;
		textField_stuID.setText(stuID+"");
		textField_Score.setText(score+"");
		textField_crsID.setText(crsID+"");
		textField_StuName.setText(stuName);
		textField_crsName.setText(crsName);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 560, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course ID:");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse.setBounds(50, 160, 87, 39);
		panel.add(lblCourse);
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(50, 98, 87, 39);
		panel.add(lblNewLabel);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentName.setBounds(297, 98, 111, 39);
		panel.add(lblStudentName);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourseName.setBounds(297, 160, 111, 39);
		panel.add(lblCourseName);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScore.setBounds(50, 216, 70, 31);
		panel.add(lblScore);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you to remove information below?");
		lblAreYouSure.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAreYouSure.setBounds(27, 11, 487, 76);
		panel.add(lblAreYouSure);
		
		textField_stuID = new JTextField();
		textField_stuID.setBackground(Color.WHITE);
		textField_stuID.setEditable(false);
		textField_stuID.setBounds(157, 108, 86, 20);
		textField_stuID.setColumns(10);
		//System.out.println(stuID);

		panel.add(textField_stuID);
		

		
		textField_crsID = new JTextField();
		textField_crsID.setBackground(Color.WHITE);
		textField_crsID.setEditable(false);
		textField_crsID.setColumns(10);
		textField_crsID.setBounds(157, 170, 86, 20);
		
		panel.add(textField_crsID);
		
		
		textField_Score = new JTextField();
		textField_Score.setBackground(Color.WHITE);
		textField_Score.setEditable(false);
		textField_Score.setColumns(10);
		textField_Score.setBounds(157, 222, 86, 20);
	
		panel.add(textField_Score);
		
		textField_StuName = new JTextField();
		textField_StuName.setBackground(Color.WHITE);
		textField_StuName.setEditable(false);
		textField_StuName.setColumns(10);
		textField_StuName.setBounds(417, 108, 86, 20);
	
		panel.add(textField_StuName);
		
		textField_crsName = new JTextField();
		textField_crsName.setBackground(Color.WHITE);
		textField_crsName.setEditable(false);
		textField_crsName.setColumns(10);
		textField_crsName.setBounds(417, 170, 86, 20);
		
		panel.add(textField_crsName);
		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDaoImpl impl = new ScoreDaoImpl();
				try {
					impl.deleteByStuIdANDCrsID(stuID, crsID);
					main.getInstance().drawTable();
					frame.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(264, 276, 118, 39);
		panel.add(btnNewButton);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNo.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNo.setBounds(416, 276, 118, 39);
		panel.add(btnNo);
	}
}
