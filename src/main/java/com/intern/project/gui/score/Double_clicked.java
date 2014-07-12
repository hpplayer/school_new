package com.intern.project.gui.score;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JEditorPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.CourseDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;
import com.intern.project.gui.course.GUI_main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Double_clicked {

	private JFrame frmScoreDetails;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	long stuID;
	String stuName;
	long courseNum;
	int score;
	int PL;
	String corName;
	int row;
	int col;
	
	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Double_clicked window = new Double_clicked(row, col);
					window.frmScoreDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Double_clicked(int row, int col) {
		initialize();
		frmScoreDetails.setVisible(true);
		this.row = row;
		this.col = col;
	
		//System.out.println(row);
		//System.out.println(col);
		try {
		//stuID = (Long) main.getInstance().table.getValueAt(row, 0);
			//System.out.println(main.getInstance().table.getValueAt(0, 0));
		stuID = Long.valueOf( main.getInstance().table.getValueAt(row, 0).toString());
		
		stuName = new StudentDaoImpl().findByID(stuID).getName();
		//System.out.println(stuName);
		int colNum = col;

		switch(colNum){
		case 2:{
			courseNum = 1101;
			break;
		}
		case 3:{
			courseNum = 1102;
			break;
		}
		case 4:{
			courseNum = 1103;
			break;
		}
		case 5:{
			courseNum = 1104;
			break;
		}
		case 6:{
			courseNum = 1105;
			break;
		}
		case 7:{
			courseNum = 1106;
			break;
		}
		case 8:{
			courseNum =1107;
			break;
		}
		case 9:{
			courseNum = 1108;
			break;
		}
		case 10:{
			courseNum = 1109;
			break;
		}
		default:{
			//do nothing
			break;
		}
		}
		//System.out.println("colNumL: " +colNum);
		//System.out.println((String) main.getInstance().table.getValueAt(row, col));

		 score = Integer.valueOf( main.getInstance().table.getValueAt(row, col).toString());
	
	
		
		PL = new CourseDaoImpl().findByID(courseNum).getPassline();
		corName = new CourseDaoImpl().findByID(courseNum).getCourseName();
		textField.setText(stuName);
		textField_1.setText(corName);
		textField_2.setText(PL+"");
		textField_3.setText(stuID+"");
		textField_4.setText(courseNum+"");
		textField_5.setText(score+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScoreDetails = new JFrame();
		frmScoreDetails.setTitle("Score Details");
		frmScoreDetails.setBounds(100, 100, 555, 410);
		frmScoreDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
	
		frmScoreDetails.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 32, 105, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(311, 32, 105, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(53, 110, 105, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseId.setBounds(311, 110, 105, 27);
		panel.add(lblCourseId);
		
		JLabel lblPassline = new JLabel("Passline");
		lblPassline.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassline.setBounds(53, 194, 105, 27);
		panel.add(lblPassline);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setBounds(311, 194, 105, 27);
		panel.add(lblScore);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					frmScoreDetails.getRootPane().setDefaultButton(btnNewButton);
				}
			}
		});
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setEditable(false);
		textField.setBounds(53, 70, 181, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(53, 157, 181, 32);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.inactiveCaption);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(53, 243, 181, 32);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.inactiveCaption);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(311, 67, 181, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.inactiveCaption);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(311, 156, 181, 32);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.inactiveCaption);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(311, 243, 181, 32);
		panel.add(textField_5);
		
		btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmScoreDetails.dispose();
			}
		});
		btnNewButton.setBounds(69, 310, 381, 27);
		panel.add(btnNewButton);
	}
}
