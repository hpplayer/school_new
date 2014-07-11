package com.intern.project.gui.course;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Course;
import com.intern.project.daoImpl.CourseDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GUI_query {
	private List<Course> tempo;

	private ArrayList tempolist;
	private JFrame frmSearchCourse;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_query window = new GUI_query();
					window.frmSearchCourse.setVisible(true);
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public GUI_query() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmSearchCourse = new JFrame();
		frmSearchCourse.setTitle("Search course");
		frmSearchCourse.setBounds(100, 100, 499, 331);
		//frmSearchCourse.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frmSearchCourse.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnSave = new JButton("Search");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(btnSave);
		
		JPanel panel = new JPanel();
		frmSearchCourse.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course ID");
		lblNewLabel.setBounds(53, 11, 97, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(53, 73, 97, 51);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Course_Passline");
		lblNewLabel_2.setBounds(53, 125, 97, 51);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Remarks");
		lblNewLabel_3.setBounds(53, 187, 97, 51);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(180, 26, 136, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 88, 136, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 140, 136, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 202, 136, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CourseDaoImpl impl = new CourseDaoImpl();
				
				String[] list = {textField.getText(), textField_1.getText(),  textField_2.getText(),  textField_3.getText()};
				int[] list2 = null;
				for (int i = 0; i < 4; i++){
					//System.out.println(i);
					if (list[i].isEmpty()){
						list[i] = "%";
					}else{
						list[i] = list[i].toString();
					}
				}//handle null value

					

					tempo =  impl.findByAnyInfo(list[0], list[1],list[2],list[3]);
					GUI_main.getInstance().drawTableByList(tempo);
				
					
				frmSearchCourse.dispose();
			
			}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(370, 87, 97, 89);
		panel.add(btnNewButton);
		
	
	
	}

}
