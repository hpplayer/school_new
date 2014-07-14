package com.intern.project.gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.StudentDaoImpl;

public class Double_clicked {
	private JPanel contentPane;
	private JFrame frame;
	//private int row;
	//private int col;
	private Student tempo;
	private JTextField txtId;
	private JTextField textField_Name;
	private JFormattedTextField textField_Birthdate;
	private JTextField textField_Addr;
	private JTextField textField_Remarks;
	private JComboBox comboBox;
	private JTextField textField_Class;
	/**
	 * Launch the application.
	 */
	
	public Double_clicked(Student tempo) {
		this.tempo = tempo;
		initialize();
		frame.setVisible(true);
		
		//this.row = row;
		//this.col = col;
	
	//	System.out.println(row);
		//System.out.println(col);
 }
	
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Double_clicked window = new Double_clicked(tempo);
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

	
		

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		
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
		
		JButton btnNewButton = new JButton("backup");
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student tempo = new Student ();
				tempo.setID(Long.valueOf(txtId.getText()));
				tempo.setName(textField_Name.getText());
				//Date date = Date.valueOf(textField_Birthdate.getText());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");	
				Date date = null;
				try {
					date = sdf.parse(textField_Birthdate.getText());
				} catch (ParseException e) {
					System.out.println("date wrong");
				}
				
				tempo.setBir(date);
				//String Birth = "19000000";
				tempo.setSex( (String)comboBox.getSelectedItem());
				tempo.setAdr( textField_Addr.getText());
				tempo.setRemarks(textField_Remarks.getText());
				tempo.setMajor(textField_Class.getText());
				
				
				ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_DaoImpl.xml");
				StudentDaoImpl stuImpl = (StudentDaoImpl) ctx.getBean("StuImpl");
				
				//StudentDaoImpl stuImpl = new StudentDaoImpl();
				
				try {
				stuImpl.update(tempo);
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
		txtId.setEditable(false);
		txtId.setBackground(new Color(169, 169, 169));
		txtId.setBounds(60, 5, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 8, 46, 14);
		panel.add(lblId);
		
		textField_Name = new JTextField();
		textField_Name.setBackground(new Color(192, 192, 192));
		textField_Name.setEditable(false);
		textField_Name.setColumns(10);
		textField_Name.setBounds(60, 33, 86, 20);
		panel.add(textField_Name);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthdate.setBounds(204, 8, 60, 17);
		panel.add(lblBirthdate);
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd" );
		//DateFormatter df = new DateFormatter(format);
		textField_Birthdate = new JFormattedTextField(format);
		textField_Birthdate.setBackground(new Color(192, 192, 192));
		textField_Birthdate.setEditable(false);
		textField_Birthdate.setInputVerifier(new FormattedTextFieldVerifier());
		//textField_2 = new JTextField();
		textField_Birthdate.setText("yyyy/MM/dd");
		textField_Birthdate.setColumns(10);
		textField_Birthdate.setBounds(259, 5, 86, 20);
		panel.add(textField_Birthdate);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(204, 36, 46, 14);
		panel.add(lblSex);
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setBounds(259, 33, 60, 20);
		panel.add(comboBox);
		
		JLabel lblAddr = new JLabel("Addr");
		lblAddr.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddr.setBounds(20, 61, 46, 14);
		panel.add(lblAddr);
		
		textField_Addr = new JTextField();
		textField_Addr.setBackground(new Color(192, 192, 192));
		textField_Addr.setEditable(false);
		textField_Addr.setColumns(10);
		textField_Addr.setBounds(60, 58, 86, 20);
		panel.add(textField_Addr);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemarks.setBounds(20, 100, 126, 14);
		panel.add(lblRemarks);
		
		textField_Remarks = new JTextField();
		textField_Remarks.setBackground(new Color(192, 192, 192));
		textField_Remarks.setEditable(false);
		textField_Remarks.setBounds(20, 125, 325, 72);
		panel.add(textField_Remarks);
		textField_Remarks.setColumns(10);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(204, 61, 46, 14);
		panel.add(lblClass);
		
		textField_Class = new JTextField();
		textField_Class.setBackground(new Color(192, 192, 192));
		textField_Class.setEditable(false);
		textField_Class.setBounds(259, 58, 86, 20);
		panel.add(textField_Class);
		textField_Class.setColumns(10);
		
		frame.setVisible(true);
		long stuID = tempo.getID();
		String stuName = tempo.getName();
		String Sex = tempo.getSex();
		Date date = tempo.getBir();
		String major =tempo.getMajor();
		String Adr = tempo.getAdr();
		String RMKs = tempo.getRemarks();
		txtId.setText(stuID+"");
		textField_Name.setText(stuName);
		String date2 =  new SimpleDateFormat("yyyy/MM/dd").format(date);
		textField_Birthdate.setText(date2);
		int index = 0;
		if (Sex.equals("M")){
			index = 0;
		}else{
			index = 1;
		}
		comboBox.setSelectedIndex(index);
		textField_Addr.setText(Adr);
		textField_Remarks.setText(RMKs);
		textField_Class.setText(major);
	}

}
