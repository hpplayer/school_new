package com.intern.project.gui.score;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.intern.project.POJO.Course;
import com.intern.project.POJO.Score;
import com.intern.project.POJO.Student;
import com.intern.project.daoImpl.CourseDaoImpl;
import com.intern.project.daoImpl.ScoreDaoImpl;
import com.intern.project.daoImpl.StudentDaoImpl;
import com.intern.project.gui.course.GUI_main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class main {
	private static final main window = new main();
	private JFrame frmTranscript;
	public static JTable table;
	List<Score> tempo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmTranscript.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static main getInstance(){
		return window;
	}
	
	public void drawTable(List<Score> sc, List<Long> stuList){
		StudentDaoImpl impl2 = new StudentDaoImpl();
		for (int r = 0; r < 23; r++){
			for (int c = 0; c < 11; c++){
				table.setValueAt(null, r, c);
			}
		}

		try{
		for (int i = 0; i < stuList.size(); i++){
			List<Score> scoreList = new ArrayList<Score>();
			Long ID = stuList.get(i);
			String name = impl2.findByID(ID).getName();

			table.setValueAt(ID, i, 0);
			table.setValueAt(name, i, 1);
			for (int j = 0; j < sc.size(); j++){
				if (stuList.get(i) == sc.get(j).getStudent_ID()){
					scoreList.add(sc.get(j));
				}
			}
			
			for (int z = 0; z < scoreList.size(); z++){
				int score = scoreList.get(z).getScore();
				long crsID = scoreList.get(z).getCourse_ID();
				
				int col = 0;
				switch((int) crsID){
				case 1101:{
					col = 2;
					break;
				}
				case 1102:{
					col = 3;
					break;
				}
				case 1103:{
					col = 4;
					break;
				}
				case 1104:{
					col = 5;
					break;
				}
				case 1105:{
					col = 6;
					break;
				}
				case 1106:{
					col = 7;
					break;
				}
				case 1107:{
					col =8;
					break;
				}
				case 1108:{
					col = 9;
					break;
				}
				case 1109:{
					col = 10;
					break;
				}
				default:{
					//do nothing
					break;
				}
				
				
				
			}//end switch
			
			
			
				table.setValueAt(score, i, col);
			
		}//end z loop
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public void drawTable(){
		//System.out.println("Im here");
		ScoreDaoImpl impl = new ScoreDaoImpl();
		StudentDaoImpl impl2 = new StudentDaoImpl();
		long NumOfStu = impl.CountStudent();
		
		for (int r = 0; r < 23; r++){
			for (int c = 0; c < 11; c++){
				table.setValueAt(null, r, c);
			}
		}
		List<Long> stuList = impl.ReturnStuList();//list to store student_ID in score table
	
		try{
		for (int i = 0; i < stuList.size(); i++){
			List<Long> crsList= new ArrayList<Long>();//list to store course in score table
			List<Integer> scoList = new ArrayList<Integer>();//list to store score in score table
			
			List<String> displaylist = new ArrayList<String>();//list to store display data
			Student student =impl2.findByID(stuList.get(i));
			String ID = stuList.get(i).toString();
			String name = student.getName();
			int numOfscore = impl.findByStudentID(stuList.get(i)).size();
			//System.out.println("numOfscore: " + numOfscore);
			//System.out.println("stuList.size(): " + stuList.size());
			displaylist.add(ID);
			displaylist.add(name);
			
			for (int z = 0; z < numOfscore; z++){
				scoList.add(impl.findByStudentID(stuList.get(i)).get(z).getScore());
				crsList.add(impl.findByStudentID(stuList.get(i)).get(z).getCourse_ID());
				displaylist.add(impl.findByStudentID(stuList.get(i)).get(z).getScore()+"");
				//System.out.println("add " + crsList.get(z));
				
			}
			
		
			table.setValueAt(displaylist.get(0), i, 0);
			table.setValueAt(displaylist.get(1), i, 1);
			for ( int j = 2; j < displaylist.size(); j ++){
				int col = j;
				switch((int) (long) crsList.get(j-2)){
				case 1101:{
					col = 2;
					break;
				}
				case 1102:{
					col = 3;
					break;
				}
				case 1103:{
					col = 4;
					break;
				}
				case 1104:{
					col = 5;
					break;
				}
				case 1105:{
					col = 6;
					break;
				}
				case 1106:{
					col = 7;
					break;
				}
				case 1107:{
					col =8;
					break;
				}
				case 1108:{
					col = 9;
					break;
				}
				case 1109:{
					col = 10;
					break;
				}
				default:{
					//do nothing
					break;
				}
				}
				//System.out.println(crsList.get(j-2) + " at " + col);
				table.setValueAt(displaylist.get(j), i, col);
			}
			
		}
			
			
	} catch (Exception ex){
		ex.printStackTrace();
	}
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
		frmTranscript = new JFrame();
		frmTranscript.setResizable(false);
		frmTranscript.setTitle("Transcript\r\n");
		frmTranscript.setBounds(100, 100, 900, 451);
		frmTranscript.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frmTranscript.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton(" Search ");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Query().up();
			}
		});
		toolBar.add(btnNewButton_1);
		
		JButton btnAdd = new JButton(" Add ");
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNewScore().up();
			}
		});
		toolBar.add(btnAdd);
		
		JButton btnNewButton = new JButton(" List All ");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoreDaoImpl impl = new ScoreDaoImpl();
				try {
					drawTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnDelete = new JButton(" Delete ");
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getValueAt(table.getSelectedRow(),table.getSelectedColumn())== null ){
					JOptionPane.showMessageDialog(null, "Empty input found");
				}
				else if (table.getSelectedColumn() == 0){
					JOptionPane.showMessageDialog(null, "Cant delete student ID!");
				}
				else if (table.getSelectedColumn() == 1){
					JOptionPane.showMessageDialog(null, "Cant delete student name!");
				}
				else{
				long stuID = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				String stuName = table.getValueAt(table.getSelectedRow(), 1).toString();
				int col = Integer.valueOf(table.getSelectedColumn());
				int score = Integer.valueOf(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString());
				long courseNum = 0;
				switch(col){
				case 2:{
					courseNum = 1101;
					break;
				}
				case 3:{
					courseNum = 1102;
					break;
				}
				case 4:{
					courseNum = 1103;
					break;
				}
				case 5:{
					courseNum = 1104;
					break;
				}
				case 6:{
					courseNum = 1105;
					break;
				}
				case 7:{
					courseNum = 1106;
					break;
				}
				case 8:{
					courseNum =1107;
					break;
				}
				case 9:{
					courseNum = 1108;
					break;
				}
				case 10:{
					courseNum = 1109;
					break;
				}
				default:{
					//do nothing
					break;
				}
				}//end switch
				
			CourseDaoImpl impl = new CourseDaoImpl();
			try {
				String crsName = impl.findByID(courseNum).getCourseName();
				new Delete(stuID, stuName, courseNum, crsName, score); 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//end catch
			
				}
			}
		});
		toolBar.add(btnDelete);
		
		JButton btnEdit = new JButton(" Edit ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (table.getValueAt(table.getSelectedRow(),table.getSelectedColumn())== null ){
					JOptionPane.showMessageDialog(null, "Empty input found");
				}
				else if (table.getSelectedColumn() == 0){
					JOptionPane.showMessageDialog(null, "Cant Edit student ID!");
				}
				else if (table.getSelectedColumn() == 1){
					JOptionPane.showMessageDialog(null, "Cant Eidt student name!");
				}
				else{
				long stuID = Long.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
				String stuName = table.getValueAt(table.getSelectedRow(), 1).toString();
				int col = Integer.valueOf(table.getSelectedColumn());
				int score = Integer.valueOf(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString());
				long courseNum = 0;
				switch(col){
				case 2:{
					courseNum = 1101;
					break;
				}
				case 3:{
					courseNum = 1102;
					break;
				}
				case 4:{
					courseNum = 1103;
					break;
				}
				case 5:{
					courseNum = 1104;
					break;
				}
				case 6:{
					courseNum = 1105;
					break;
				}
				case 7:{
					courseNum = 1106;
					break;
				}
				case 8:{
					courseNum =1107;
					break;
				}
				case 9:{
					courseNum = 1108;
					break;
				}
				case 10:{
					courseNum = 1109;
					break;
				}
				default:{
					//do nothing
					break;
				}
				}//end switch
				
			CourseDaoImpl impl = new CourseDaoImpl();
			try {
				String crsName = impl.findByID(courseNum).getCourseName();
				new Edit(stuID, stuName, courseNum, crsName, score); 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//end catch
			
				}
			}
			
		
		});
		btnEdit.setBackground(SystemColor.activeCaption);
		toolBar.add(btnEdit);
		
		JScrollPane scrollPane = new JScrollPane();
		frmTranscript.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point pnt = e.getPoint();
				int row = table.rowAtPoint(pnt);
				int col = table.columnAtPoint(pnt);
				if (e.getClickCount() == 2){
					if ( table.getValueAt(row, col) == null|| col == 0 ||col ==1){
						//new NoDataAvaiable().up();
						JOptionPane.showMessageDialog(null, "Invalid score!");
			
					}else{			
					new Double_clicked(row, col);
					}
					//System.out.println("double clicked");
				}
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Stu_ID", "Stu_name", "course 1101", "course 1102", "course 1103", "course 1104", "course 1105", "course 1106", "course 1107", "course 1108", "course 1109"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}

}
