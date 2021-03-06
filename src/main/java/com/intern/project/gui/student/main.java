package com.intern.project.gui.student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Point;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import java.util.List;
import java.util.Locale;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.StudentDaoImpl;



public class main {
	
	ApplicationContext ctx;
	private JFrame frmStudentInfoTable;
	public static JTable table_1;
	private static final main window = new main();
	List<Student> tempo;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmStudentInfoTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static main getInstance(){
		return window;
	}
	
	/**
	 * Create the application.
	 */
	public main() {
		ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_DaoImpl.xml");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentInfoTable = new JFrame();
		frmStudentInfoTable.setTitle("Student Info Table");
		frmStudentInfoTable.setBounds(100, 100, 658, 437);
		frmStudentInfoTable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmStudentInfoTable.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPrint = new JMenuItem("print");
		mntmPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new com.intern.project.print.main4(table_1, "Student");
			}
		});
		mnNewMenu.add(mntmPrint);
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frmStudentInfoTable.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("insert");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddWindow().up();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String getID = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
				//StudentDaoImpl stuImpl = new StudentDaoImpl();
				StudentDaoImpl stuImpl = (StudentDaoImpl) ctx.getBean("StuImpl");
				try {
					stuImpl.deleteById(Long.valueOf(getID));
					drawTable();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(Color.PINK);
		toolBar.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("query");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawTable();
			}
		});
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getValueAt(table_1.getSelectedRow(), 0) == null ){
					JOptionPane.showMessageDialog(null, "Invalid data!");
				}else{
				long stuID = Long.valueOf(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				String stuName = table_1.getValueAt(table_1.getSelectedRow(), 1).toString();
				String Sex = table_1.getValueAt(table_1.getSelectedRow(), 2).toString();
				/*
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);	
				Date date = null;
				try {
					date = sdf.parse(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());


				} catch (ParseException ex) {
					System.out.println("date wrong");
				};
			*/
				Date date = Date.valueOf(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
				String major = table_1.getValueAt(table_1.getSelectedRow(), 4).toString();
				String Adr = table_1.getValueAt(table_1.getSelectedRow(), 5).toString();
				String RMKs = table_1.getValueAt(table_1.getSelectedRow(), 6).toString();
				
				Student tempo = new Student();
				tempo.setID(stuID);
				tempo.setName(stuName);
				tempo.setSex(Sex);
				tempo.setBir(date);
				tempo.setMajor(major);
				tempo.setAdr(Adr);
				tempo.setRemarks(RMKs);
				
				new EditWindow(tempo);
				
			}
			}
		});
		btnNewButton_3.setBackground(new Color(176, 224, 230));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Print");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.intern.project.print.main4(table_1, "Student");
			}
		});
		btnNewButton_4.setBackground(new Color(123, 104, 238));
		toolBar.add(btnNewButton_4);
		
	
		String[] ColName=  {
				"ID", "Name", "Sex", "Birthdate", "Class", "Address", "Comments"
			};
		Object[][] data =  {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			};
		DefaultTableModel model = new DefaultTableModel(data, ColName){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table_1 = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Sex", "Birthdate", "Class", "Address", "Comments"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point pnt = e.getPoint();
				int row = table_1.rowAtPoint(pnt);
				int col = table_1.columnAtPoint(pnt);
				if (e.getClickCount() == 2){
					if ( table_1.getValueAt(row, col) == null){
						//new NoDataAvaiable().up();
						JOptionPane.showMessageDialog(null, "Invalid data!");
			
					}else{			
						
						StudentDaoImpl impl = (StudentDaoImpl) ctx.getBean("StuImpl");
						
						long StuID = Long.valueOf(table_1.getValueAt(row, 0).toString());
						//System.out.println(StuID);
						try {
							Student tempo = impl.findByID(StuID);
							System.out.println(tempo.getName());
							new Double_clicked(tempo);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
					}
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmStudentInfoTable.getContentPane().add(scrollPane, BorderLayout.CENTER);

	}
	
	
	public void drawTable(){
		//System.out.println("Im here");
		StudentDaoImpl stuImpl2 =  (StudentDaoImpl) ctx.getBean("StuImpl");
		try {
			tempo = stuImpl2.findAll();
			//System.out.println(tempo.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int r = 0; r < 16; r++){
			for (int c = 0; c < 7; c++){
				table_1.setValueAt(null, r, c);
			}
		}
		
		for (int i = 0; i < tempo.size(); i++){
			String[] tempo2 = {tempo.get(i).getID()+"",tempo.get(i).getName(),tempo.get(i).getSex(),tempo.get(i).getBir().toString(),tempo.get(i).getMajor(), tempo.get(i).getAdr(), tempo.get(i).getRemarks()};
			for ( int j = 0; j < tempo2.length; j++){
				table_1.setValueAt(tempo2[j], i, j);
			}
			
		}
	}

}
