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
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

import javax.swing.SwingConstants;

public class GUI_update {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	//private CourseDaoImpl impl;
	private	int ID2;

	/**
	 * Launch the application.
	 */
	public static void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_update window = new GUI_update();
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
	public GUI_update() {
		initialize();
		ID2 = Integer.valueOf(GUI_main.getInstance().table.getValueAt(GUI_main.getInstance().table.getSelectedRow(), 0).toString());
		String name2 = GUI_main.getInstance().table.getValueAt(GUI_main.getInstance().table.getSelectedRow(), 1).toString();
		int PL2 = Integer.valueOf(GUI_main.getInstance().table.getValueAt(GUI_main.getInstance().table.getSelectedRow(), 2).toString());
		String Remarks2 = GUI_main.getInstance().table.getValueAt(GUI_main.getInstance().table.getSelectedRow(), 3).toString();
		
		textField.setText(ID2+"");
		textField_1.setText(name2);
		textField_2.setText(PL2+"");
		textField_3.setText(Remarks2);
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 331);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnSave = new JButton("update");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(btnSave);
		//toolBar.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnSave}));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
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
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CourseDaoImpl impl = new CourseDaoImpl();
					//impl.deleteById(ID2);
					int ID = Integer.valueOf(textField.getText());
					String name = textField_1.getText();
					int PL = Integer.valueOf(textField_2.getText());
					String remarks = textField_3.getText();
					Course tempo = new Course().CreateAccount(ID, name, PL, remarks);
					//System.out.print(tempo.getCourseID());
					//impl.add(tempo);
					impl.update(tempo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GUI_main.getInstance().drawTable();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(370, 87, 97, 89);
		panel.add(btnNewButton);
		//panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, lblNewLabel, textField_1, textField_2, textField_3, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, btnNewButton}));
	}
}
