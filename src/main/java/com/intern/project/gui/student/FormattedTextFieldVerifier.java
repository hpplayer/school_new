package com.intern.project.gui.student;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

public class FormattedTextFieldVerifier extends InputVerifier{

	@Override
	public boolean verify(JComponent arg0) {
		// TODO Auto-generated method stub
		JFormattedTextField field = (JFormattedTextField) arg0;
		if (field.isEditValid() == false){

				 new WrongDate().up();

			
			
		}
		return field.isEditValid();
	}

}
