package com.intern.project.gui.score;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Score;
import com.intern.project.daoImpl.ScoreDaoImpl;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Edit {

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
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit window = new Edit();
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
	public Edit() {
		initialize();
	}
		
	public Edit(long stuID, String stuName, long crsID, String crsName, int score) {
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
		frame.setBounds(100, 100, 553, 322);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
	
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course ID:");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse.setBounds(50, 108, 87, 39);
		panel.add(lblCourse);
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(50, 49, 87, 39);
		panel.add(lblNewLabel);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentName.setBounds(297, 49, 111, 39);
		panel.add(lblStudentName);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourseName.setBounds(297, 108, 111, 39);
		panel.add(lblCourseName);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScore.setBounds(50, 158, 70, 31);
		panel.add(lblScore);
		
		textField_stuID = new JTextField();
		textField_stuID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

					
						if (e.getKeyCode() == KeyEvent.VK_ENTER){
							frame.getRootPane().setDefaultButton(btnNewButton);
						}
						
					}

		});
		textField_stuID.setEditable(false);
		textField_stuID.setBackground(SystemColor.activeCaptionBorder);
		textField_stuID.setBounds(157, 59, 86, 20);
		textField_stuID.setColumns(10);
		//System.out.println(stuID);

		panel.add(textField_stuID);
		

		
		textField_crsID = new JTextField();
		textField_crsID.setEditable(false);
		textField_crsID.setBackground(SystemColor.activeCaptionBorder);
		textField_crsID.setColumns(10);
		textField_crsID.setBounds(157, 118, 86, 20);
		
		panel.add(textField_crsID);
		
		
		textField_Score = new JTextField();
		textField_Score.setBackground(Color.WHITE);
		textField_Score.setColumns(10);
		textField_Score.setBounds(157, 170, 86, 20);
	
		panel.add(textField_Score);
		
		textField_StuName = new JTextField();
		textField_StuName.setEditable(false);
		textField_StuName.setBackground(SystemColor.activeCaptionBorder);
		textField_StuName.setColumns(10);
		textField_StuName.setBounds(418, 59, 86, 20);
	
		panel.add(textField_StuName);
		
		textField_crsName = new JTextField();
		textField_crsName.setEditable(false);
		textField_crsName.setBackground(SystemColor.activeCaptionBorder);
		textField_crsName.setColumns(10);
		textField_crsName.setBounds(418, 118, 86, 20);
		
		panel.add(textField_crsName);
		
		btnNewButton= new JButton("Done");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ScoreDaoImpl impl = new ScoreDaoImpl();
				ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_DaoImpl.xml");
				ScoreDaoImpl impl = (ScoreDaoImpl) ctx.getBean("ScoreImpl");
				try {
					long stuID = Long.valueOf(textField_stuID.getText());
					long crsID = Long.valueOf(textField_crsID.getText());
					int score = Integer.valueOf(textField_Score.getText());
					Score tempo = new Score();
					tempo.setCourse_ID(crsID);
					tempo.setScore(score);
					tempo.setStudent_ID(stuID);
					impl.update(tempo);
					main.getInstance().drawTable();
					frame.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(381, 215, 118, 39);
		panel.add(btnNewButton);
	}
}
