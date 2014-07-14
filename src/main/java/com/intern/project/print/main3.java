package com.intern.project.print;


import java.awt.print. *;
import java.awt. *;
import javax.print. *;
import javax.print.attribute. *;
import javax.swing. *;
import javax.swing.table. *;

public class main3 implements Printable {
private TableModel table;
private String title;

public main3 (JTable table, String title) {
this.table = table.getModel ();
this.title = title;
PrintService [] services = PrintServiceLookup.lookupPrintServices (
DocFlavor.SERVICE_FORMATTED.PRINTABLE, null
);

PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet ();
PrintService service = ServiceUI.printDialog (null, 50,50, services, services [0], null, attributes);
if (service!= null) {
DocPrintJob job = service.createPrintJob ();
try {
Doc doc = new SimpleDoc (this, DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);
job.print (doc, attributes);
} catch (PrintException  pe) {
pe.printStackTrace ();
}
}
}

public int print ( Graphics g, PageFormat pf, int pageIndex) {
if (pageIndex == 0) {
Graphics2D g2d = (Graphics2D) g;
g2d.translate (pf.getImageableX (), pf.getImageableY ()); ;
g2d.setColor (Color.black);
g2d.drawString (title, 0,20); ;
for (int i = 0; i <table.getColumnCount (); i ++) {
g2d.drawString (table. getColumnName (i), i * 100,40);
	//g2d.drawString (table. getColumnName (i), i*72,40);
}
for (int i = 0; i < table.getRowCount (); i ++) {
for (int ii = 0; ii <table.getColumnCount (); ii ++) {
String cell;
Object original = table.getValueAt (i, ii);
if (original == null) cell = "";
else cell = original.toString ( );
g2d.drawString (cell, ii * 100,60 + i * 20);
	//g2d.drawString (cell, ii * 74,80 + i * 20);
}
}
return Printable.PAGE_EXISTS;
} else return Printable.NO_SUCH_PAGE;
}
} 