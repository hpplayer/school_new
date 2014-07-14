package com.intern.project.gui.student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.JToolBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Component;
//import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.CourseDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;

public class AddWindow extends JFrame {
	JFrame frame;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField textField_1;
	//private JTextField textField_2;
	private JFormattedTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWindow frame = new AddWindow();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddWindow() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Save");
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student tempo = new Student ();
				tempo.setID(Long.valueOf(txtId.getText()));
				tempo.setName(textField_1.getText());
		
				SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");	
				Date date = null;
				try {
					date = sdf.parse(textField_2.getText());
				} catch (ParseException e) {
					System.out.println("date wrong");
				}
				tempo.setBir(date);
			
				//String Birth = "19000000";
				//Date date = Date.valueOf(textField_2.getText());
				tempo.setSex( (String)comboBox.getSelectedItem());
				tempo.setAdr( textField.getText());
				tempo.setRemarks(textField_3.getText());
				tempo.setMajor(textField_4.getText());
				ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_DaoImpl.xml");
				StudentDaoImpl impl = (StudentDaoImpl) ctx.getBean("StuImpl");
				try {
				impl.add(tempo);
				//System.out.println(stuImpl.findAll().size());
				main.getInstance().drawTable();
				//System.out.println(main.getInstance().tempo.get(3).getID());
				frame.dispose();
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(20, 36, 46, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(60, 5, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 8, 46, 14);
		panel.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(60, 33, 86, 20);
		panel.add(textField_1);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthdate.setBounds(204, 8, 60, 17);
		panel.add(lblBirthdate);
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		DateFormatter df = new DateFormatter(format);
		textField_2 = new JFormattedTextField(format);
		textField_2.setInputVerifier(new FormattedTextFieldVerifier());
		
		textField_2.setText("yyyy/MM/dd");
		//textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 5, 86, 20);
		panel.add(textField_2);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(204, 36, 46, 14);
		panel.add(lblSex);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setBounds(259, 33, 60, 20);
		panel.add(comboBox);
		
		JLabel lblAddr = new JLabel("Addr");
		lblAddr.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddr.setBounds(20, 61, 46, 14);
		panel.add(lblAddr);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(60, 58, 86, 20);
		panel.add(textField);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemarks.setBounds(20, 100, 126, 14);
		panel.add(lblRemarks);
		
		textField_3 = new JTextField();
		textField_3.setBounds(20, 125, 325, 72);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(204, 61, 46, 14);
		panel.add(lblClass);
		
		textField_4 = new JTextField();
		textField_4.setBounds(259, 58, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
	}
}
