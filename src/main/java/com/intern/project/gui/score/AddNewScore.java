package com.intern.project.gui.score;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JEditorPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Score;
import com.intern.project.daoImpl.CourseDaoImpl;
import com.intern.project.daoImpl.ScoreDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;
import com.intern.project.gui.course.GUI_main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddNewScore {

	public static JFrame frmScoreDetails;
	public static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private JButton btnNewButton;
	private static final AddNewScore windows = new AddNewScore();

	
	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewScore window = new AddNewScore();
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
	public AddNewScore() {
		initialize();


	}

	
	public static AddNewScore getInstance(){
		return windows;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScoreDetails = new JFrame();
		frmScoreDetails.setResizable(false);
		frmScoreDetails.setTitle("Add New Score");
		frmScoreDetails.setBounds(100, 100, 302, 410);
		frmScoreDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmScoreDetails.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 30, 105, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseId.setBounds(53, 110, 105, 27);
		panel.add(lblCourseId);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblScore.setBounds(53, 194, 105, 27);
		panel.add(lblScore);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int KeyChar = e.getKeyChar();

			 if(textField_3.getText().length()>10&&e.getKeyChar()!='\b')
				{
				      e.setKeyChar('\0');
				     JOptionPane.showMessageDialog(null, "Max Length Reached");
			    }
	
		
				if (KeyChar >=KeyEvent.VK_0 && KeyChar <=KeyEvent.VK_9){
			
		}else{
            //JOptionPane.showMessageDialog(null, "Only number is allowed");
			e.consume();
		}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					//frmScoreDetails.dispose();
					frmScoreDetails.getRootPane().setDefaultButton(btnNewButton);
				}
			}
		});
		textField_3.setBackground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBounds(53, 67, 181, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					int KeyChar = e.getKeyChar();
					 if(textField_4.getText().length()>10&&e.getKeyChar()!='\b')
						{
						      e.setKeyChar('\0');
						     JOptionPane.showMessageDialog(null, "Max Length Reached");
					    }
			
				
						if (KeyChar >=KeyEvent.VK_0 && KeyChar <=KeyEvent.VK_9){
					
				}else{
		           // JOptionPane.showMessageDialog(null, "Only number is allowed");
					e.consume();
				}
			}
		});
		textField_4.setBackground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBounds(53, 151, 181, 32);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int KeyChar = e.getKeyChar();
				 if(textField_5.getText().length() > 2 && e.getKeyChar()!='\b')
					{
					      e.setKeyChar('\0');
					     JOptionPane.showMessageDialog(null, "Max Length Reached");
				    }
		
			
					if (KeyChar >=KeyEvent.VK_0 && KeyChar <=KeyEvent.VK_9){
				
			}else{
	            //JOptionPane.showMessageDialog(null, "Only number is allowed");
				e.consume();
			}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					frmScoreDetails.getRootPane().setDefaultButton(btnNewButton);
				}
			}
		});
		textField_5.setBackground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBounds(53, 232, 181, 32);
		panel.add(textField_5);
		
		btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText().isEmpty()||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()){
					   JOptionPane.showMessageDialog(null, "Empty input found");
				}else{
				long stuID = Long.valueOf(textField_3.getText());
				long corID = Long.valueOf(textField_4.getText());
				int score = Integer.valueOf(textField_5.getText());
				
				String tempo = textField_3.getText();
				
				StudentDaoImpl impl = new StudentDaoImpl();
				CourseDaoImpl impl2 = new CourseDaoImpl(); 
				try{
			
				
				if (impl.findByID(stuID) != null && impl2.findByID(corID) != null){
					Score scr = new Score();
					scr.setCourse_ID(corID);
					scr.setStudent_ID(stuID);
					scr.setScore(score);
					ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_DaoImpl.xml");
					ScoreDaoImpl impl3 = (ScoreDaoImpl) ctx.getBean("ScoreImpl");
					//ScoreDaoImpl impl3 = new ScoreDaoImpl();
					impl3.add(scr);
				}else{
					if (impl.findByID(stuID) == null){
						//System.out.println("no data");
						new StuID_NA().up();
					}
					
					else if(impl2.findByID(corID) == null){
						new CorID_NA().up();
					}
				}
				
				//textField_3.setText(tempo);
				//System.out.println(tempo);
				}catch(Exception ex){
					
				}finally{
					
				}
				
				
				main.getInstance().drawTable();
				frmScoreDetails.dispose();
			}
			}
		});
		btnNewButton.setBounds(67, 307, 145, 27);
		panel.add(btnNewButton);
	}
}
