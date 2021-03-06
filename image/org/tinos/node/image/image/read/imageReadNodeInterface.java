package org.tinos.node.image.image.read;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import org.tinos.gui.osgi.*;
public class imageReadNodeInterface extends ObjectInterface{	
	public imageReadNodeInterface() throws IOException{
		thisIcon=new ImageIcon(this.getClass().getResource("imageread.jpg"));
		thisName=new String("ImageRead");
		position=new String("IMAGE");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		thisView=new imageReadNodeView();
		thisRun=new imageReadNodeRun();
		thisPanel=new imageReadNodePanel((imageReadNodeRun) thisRun);
		thisPanel.config();
		showed=false;
	}
	public void execute(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((imageReadNodeRun) thisRun).run((imageReadNodeView) thisView);
	}
	public void view(JTextPane jTextPane)  throws Exception{
		thisView.view();
		showed=true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException {  
		thisInterface = new imageReadNodeInterface();   
		return thisInterface;  
	}
}
