package com.intern.project.gui.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 584, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 204));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblNewLabel.setBounds(40, 108, 123, 66);
		panel.add(lblNewLabel);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblCourse.setBounds(251, 108, 123, 66);
		panel.add(lblCourse);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblScore.setBounds(435, 108, 123, 66);
		panel.add(lblScore);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.intern.project.gui.student.main().up();
			}
		});
		btnNewButton.setBounds(40, 228, 89, 43);
		panel.add(btnNewButton);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.intern.project.gui.course.GUI_main().up();
			}
		});
		btnEnter.setBounds(240, 228, 89, 43);
		panel.add(btnEnter);
		
		JButton btnEnter_1 = new JButton("Enter");
		btnEnter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.intern.project.gui.score.main().up();
			}
		});
		btnEnter_1.setBounds(423, 228, 89, 43);
		panel.add(btnEnter_1);
		
		JLabel lblWelcomeToStudent = new JLabel("Welcome to student information management system!");
		lblWelcomeToStudent.setBackground(new Color(255, 204, 0));
		lblWelcomeToStudent.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblWelcomeToStudent.setBounds(27, 21, 500, 43);
		panel.add(lblWelcomeToStudent);
	}
}
