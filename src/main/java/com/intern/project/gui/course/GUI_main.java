package com.intern.project.gui.course;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intern.project.POJO.Course;
import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.CourseDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class GUI_main {

	public JFrame frmCourseInfoTable;
	public static JTable table;
	private static final GUI_main window = new GUI_main();
	List<Course> tempo;

	/**
	 * Launch the application.
	 */
	
	public void up() {
		frmCourseInfoTable.setVisible(true);
		/*
		 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frmCourseInfoTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}

	public void drawTableByList(List<Course> tempo){
		for (int r = 0; r < 16; r++){
			for (int c = 0; c < 4; c++){
				table.setValueAt(null, r, c);
			}
		}
		for (int i = 0; i < tempo.size(); i++){
			String[] tempo2 = {tempo.get(i).getCourseID()+"",tempo.get(i).getCourseName(),tempo.get(i).getPassline()+"",tempo.get(i).getRemarks()};
			for ( int j = 0; j < tempo2.length; j++){
				table.setValueAt(tempo2[j], i, j);
			}
	}
	}
	
	public void drawTable(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:E:/workspace/school_new/src/main/java/com/intern/project/resources/Spring_DaoImpl.xml");
		CourseDaoImpl impl = (CourseDaoImpl) ctx.getBean("CourseImpl");
		
		try {
			tempo = impl.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int r = 0; r < 16; r++){
			for (int c = 0; c < 4; c++){
				table.setValueAt(null, r, c);
			}
		}
		
		for (int i = 0; i < tempo.size(); i++){
			String[] tempo2 = {tempo.get(i).getCourseID()+"",tempo.get(i).getCourseName(),tempo.get(i).getPassline()+"",tempo.get(i).getRemarks()};
			for ( int j = 0; j < tempo2.length; j++){
				table.setValueAt(tempo2[j], i, j);
			}
			
		}
	}
	
	/**
	 * Create the application.
	 */
	
	public void Drawtable(Course tempo, int i){
	
	
		
		
			table.setValueAt(tempo.getCourseID(), i, 0);
			table.setValueAt(tempo.getCourseName(), i, 1);
			table.setValueAt(tempo.getPassline(), i, 2);
			table.setValueAt(tempo.getRemarks(), i, 3);
	
		
		//table.setValueAt("testtesttest", 5, 3);
		//System.out.println(tempo.getName());
	
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public GUI_main() {
		initialize();
	}
	

	
	
	
	public static GUI_main getInstance(){
		return window;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCourseInfoTable = new JFrame();
		frmCourseInfoTable.setResizable(false);
		frmCourseInfoTable.setTitle("Course Info Table");
		frmCourseInfoTable.setBounds(100, 100, 597, 361);
		frmCourseInfoTable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCourseInfoTable.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 591, 23);
		frmCourseInfoTable.getContentPane().add(toolBar);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GUI_insert().up();
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GUI_update().up();
			}
		});
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int getID = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				String getName = table.getValueAt(table.getSelectedRow(), 1).toString();
				new GUI_delete_confirm(getID, getName).up();
			}
		});
		toolBar.add(btnNewButton_2);
		
		JButton btnQuery = new JButton("Query");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GUI_query().up();
				//while (tempo == null){
				
				//}
		

					
				//System.out.println(.getID());
			}
		});
		toolBar.add(btnQuery);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new com.intern.project.print.main3(table, "course");
			}
		});
		toolBar.add(btnPrint);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 24, 591, 318);
		frmCourseInfoTable.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Course_ID", "Course_Name", "Course_Passline", "Remarks"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}

}
