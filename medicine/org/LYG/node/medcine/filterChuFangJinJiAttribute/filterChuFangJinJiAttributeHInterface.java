package org.LYG.node.medcine.filterChuFangJinJiAttribute;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

import org.LYG.GUI.Flash.ThisCanvas;
import org.LYG.GUI.OSGI.*;
public class filterChuFangJinJiAttributeHInterface extends ObjectInterface{	
	JTextPane text;
	Object[][] tableData_old;
	public filterChuFangJinJiAttributeHInterface(Object[][] tableData_old, JTextPane text) throws IOException{
		this.text = text;
		this.tableData_old = tableData_old;
		thisIcon = new ImageIcon(this.getClass().getResource("editPaneReader.jpg"));
		thisName = new String("����ҩ���������ҩ����");
		position = new String("MEDCINE");
		Image img = ((ImageIcon) thisIcon).getImage();
		Image newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		thisImage = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane, ThisCanvas canvas) throws IOException{
		thisView = new filterChuFangJinJiAttributeHView();
		thisRun = new filterChuFangJinJiAttributeHRun();
		thisPanel = new filterChuFangJinJiAttributeHPanel((filterChuFangJinJiAttributeHRun) thisRun, this.text, this.tableData_old);
		thisPanel.config();
		showed = false;
	}
	public void execute(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((filterChuFangJinJiAttributeHRun) thisRun).run((filterChuFangJinJiAttributeHView) thisView);
	}
	public void view(JTextPane jTextPane)  throws Exception{
		thisView.view();
		showed = true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException{
		thisInterface = new filterChuFangJinJiAttributeHInterface(this.tableData_old, this.text);   
		return thisInterface;  
	}
}
