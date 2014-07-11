package com.intern.project.gui.course;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.daoImpl.CourseDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_delete_confirm {
	int ID;
	String name;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_delete_confirm window = new GUI_delete_confirm(ID, name);
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
	public GUI_delete_confirm(int ID, String name) {
		this.ID = ID;
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAreYouSure = new JLabel("Are  you sure you want to remove course:");
		lblAreYouSure.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAreYouSure.setBounds(49, 30, 340, 48);
		frame.getContentPane().add(lblAreYouSure);
		
		JLabel lblNewLabel = new JLabel("Course ID: " + ID);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(100, 77, 383, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Yes\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CourseDaoImpl impl = new CourseDaoImpl();
				try {
					impl.deleteById(ID);
				} catch (Exception e) {
					e.printStackTrace();
				}
				GUI_main.getInstance().drawTable();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(51, 171, 103, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(256, 171, 107, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel( "Course name: " + name.toString());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(100, 115, 345, 38);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
