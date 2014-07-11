package com.intern.project.gui.score;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoDataAvaiable {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void up() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoDataAvaiable window = new NoDataAvaiable();
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
	public NoDataAvaiable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 358, 164);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblInvalidCellSelection = new JLabel("Invalid Cell Selection!");
		lblInvalidCellSelection.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblInvalidCellSelection.setBounds(72, 11, 260, 42);
		panel.add(lblInvalidCellSelection);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnNewButton.setBounds(82, 64, 177, 36);
		panel.add(btnNewButton);
	}
}
