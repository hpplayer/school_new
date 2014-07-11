package com.intern.project.gui.student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

public class WrongDate {

	private JFrame frmWarning;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WrongDate window = new WrongDate();
					window.frmWarning.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WrongDate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWarning = new JFrame();
		frmWarning.setTitle("WARNING");
		frmWarning.setBounds(100, 100, 304, 149);
		frmWarning.setDefaultCloseOperation(frmWarning.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmWarning.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInvalidDateformat = new JLabel("Invalid DateFormat!!!");
		lblInvalidDateformat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInvalidDateformat.setBounds(52, 11, 226, 41);
		panel.add(lblInvalidDateformat);
		
		JLabel lblTheCorrectFormat = new JLabel("The correct format is Year/Month/Date");
		lblTheCorrectFormat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheCorrectFormat.setBounds(10, 48, 268, 37);
		panel.add(lblTheCorrectFormat);
	}
}
