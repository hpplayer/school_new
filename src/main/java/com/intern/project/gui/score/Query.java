package com.intern.project.gui.score;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import com.intern.project.POJO.Score;
import com.intern.project.daoImpl.ScoreDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Query {

	private JFrame frmScoreLookUp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query window = new Query();
					window.frmScoreLookUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Query() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScoreLookUp = new JFrame();
		frmScoreLookUp.setTitle("Score Look Up");
		frmScoreLookUp.setResizable(false);
		frmScoreLookUp.setBounds(100, 100, 463, 311);
		frmScoreLookUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmScoreLookUp.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(42, 38, 86, 27);
		frmScoreLookUp.getContentPane().add(lblNewLabel);
		
		JLabel lblCourseId = new JLabel("Course ID:");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseId.setBounds(42, 104, 75, 27);
		frmScoreLookUp.getContentPane().add(lblCourseId);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setBounds(42, 173, 75, 27);
		frmScoreLookUp.getContentPane().add(lblScore);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					frmScoreLookUp.getRootPane().setDefaultButton(btnNewButton);
				}
			}
		});
		textField.setBounds(160, 41, 86, 20);
		frmScoreLookUp.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(318, 41, 86, 20);
		frmScoreLookUp.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 109, 86, 20);
		frmScoreLookUp.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(318, 105, 86, 20);
		frmScoreLookUp.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 178, 86, 20);
		frmScoreLookUp.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(318, 174, 86, 20);
		frmScoreLookUp.getContentPane().add(textField_5);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTo.setBounds(278, 44, 30, 14);
		frmScoreLookUp.getContentPane().add(lblTo);
		
		JLabel label = new JLabel("to");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(278, 108, 30, 14);
		frmScoreLookUp.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("to");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(278, 177, 30, 14);
		frmScoreLookUp.getContentPane().add(label_1);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()){
					  JOptionPane.showMessageDialog(null, "Empty input found");
				}else{
					Long StuIDMin = Long.valueOf(textField.getText());
					Long StuIDMax = Long.valueOf(textField_1.getText());
					Long crsIDMin = Long.valueOf(textField_2.getText());
					Long crsIDMax = Long.valueOf(textField_3.getText());
					int scrMin = Integer.valueOf(textField_4.getText());
					int scrMax = Integer.valueOf(textField_5.getText());
				ScoreDaoImpl impl = new ScoreDaoImpl();
				List<Long> stuID= new ArrayList<Long>();
				List<Score> results= new ArrayList<Score>();
				try{
					stuID = impl.findStulistWlimit(StuIDMax, StuIDMin, crsIDMax, crsIDMin, scrMax, scrMin);
					results = impl.findByStuIDWLimit(StuIDMax, StuIDMin, crsIDMax, crsIDMin, scrMax, scrMin);
					if (results.size() ==0){
						  JOptionPane.showMessageDialog(null, "No results found!");
					}
					//System.out.println(stuID.size());
					//System.out.println(results.size());
					main.getInstance().drawTable(results, stuID);
				}catch(Exception ex){
					ex.printStackTrace();
				}
				frmScoreLookUp.dispose();
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(160, 224, 141, 37);
		frmScoreLookUp.getContentPane().add(btnNewButton);
	}
}
