package org.tinos.node.image.GuassianFilter;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import org.tinos.gui.osgi.*;
public class GuassianFilterInterface extends ObjectInterface{	
	public GuassianFilterInterface() throws IOException{
		thisIcon=new ImageIcon(this.getClass().getResource("gaosi.jpg"));
		thisName=new String("GuassianFilter");
		position=new String("IMAGE");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		thisView=new GuassianFilterView();
		thisRun=new GuassianFilterRun();
		thisPanel=new GuassianFilterPanel((GuassianFilterRun) thisRun);
		thisPanel.config();
		showed=false;
	}
	public void execute(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((GuassianFilterRun) thisRun).run((GuassianFilterView) thisView);
	}
	public void view(JTextPane jTextPane)  throws Exception{
		thisView.view();
		showed=true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException {  
		thisInterface = new GuassianFilterInterface();   
		return thisInterface;  
	}
}
