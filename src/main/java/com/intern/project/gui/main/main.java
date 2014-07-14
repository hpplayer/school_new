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

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.gui.course.GUI_main;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;

public class main {

	private JFrame frmMainControlPanel;
	ClassPathXmlApplicationContext ac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmMainControlPanel.setVisible(true);
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
		 ac = new ClassPathXmlApplicationContext("com/intern/project/resources/spring_gui.impl.xml");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainControlPanel = new JFrame();
		frmMainControlPanel.setTitle("Main Control Panel");
		frmMainControlPanel.setResizable(false);
		frmMainControlPanel.setBounds(100, 100, 584, 382);
		frmMainControlPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 204));
		frmMainControlPanel.getContentPane().add(panel, BorderLayout.CENTER);
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
				com.intern.project.gui.student.main test = (com.intern.project.gui.student.main) ac.getBean("StudentGUI");
				test.up();
			}
		});
		
		btnNewButton.setBounds(40, 228, 89, 43);
		panel.add(btnNewButton);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new com.intern.project.gui.course.GUI_main().up();
				GUI_main gm = (GUI_main) ac.getBean("courseGUI");
				gm.up();
			}
		});
		btnEnter.setBounds(240, 228, 89, 43);
		panel.add(btnEnter);
		
		JButton btnEnter_1 = new JButton("Enter");
		btnEnter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				com.intern.project.gui.score.main gm = (com.intern.project.gui.score.main) ac.getBean("ScoreGUI");
				gm.up();
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
