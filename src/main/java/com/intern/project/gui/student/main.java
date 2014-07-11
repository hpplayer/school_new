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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;




import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.StudentDaoImpl;
import java.awt.Window.Type;


public class main {

	private JFrame frmStudentInfoTable;
	private static JTable table;
	public static JTable table_1;
	private static final main window = new main();
	List<Student> tempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentInfoTable = new JFrame();
		frmStudentInfoTable.setTitle("Student Info Table");
		frmStudentInfoTable.setBounds(100, 100, 658, 437);
		frmStudentInfoTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmStudentInfoTable.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPrint = new JMenuItem("print");
		mntmPrint.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("BEEEEEP");
			}
		});
		mnNewMenu.add(mntmPrint);
		
		JMenu menu = new JMenu("New menu");
		menuBar.add(menu);
		
		
		
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
				StudentDaoImpl stuImpl = new StudentDaoImpl();
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
		table_1 = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmStudentInfoTable.getContentPane().add(scrollPane, BorderLayout.CENTER);

	}
	
	
	public void drawTable(){
		//System.out.println("Im here");
		StudentDaoImpl stuImpl2 = new StudentDaoImpl();
		try {
			tempo = stuImpl2.findAll();
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
