package org.tinos.node.ai.arffTransfer;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

import org.tinos.gui.osgi.*;
public class ArffTransferNodeInterface extends ObjectInterface{	
	public ArffTransferNodeInterface() throws IOException{
		thisIcon=new ImageIcon(this.getClass().getResource("1.jpg"));
		thisName=new String("arffTransfer");
		position=new String("BI");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisImage=img.getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	public void config(JTextPane jTextPane) throws IOException{
		thisView=new ArffTransferNodeView();
		thisRun=new ArffTransferNodeRun();
		thisPanel=new ArffTransferNodePanel((ArffTransferNodeRun) thisRun);
		thisPanel.config();
		showed=false;
	}
	public void execute(JTextPane jTextPane)  throws FileNotFoundException, IOException{
		((ArffTransferNodeRun) thisRun).run((ArffTransferNodeView) thisView);
	}
	public void view(JTextPane jTextPane)  throws Exception{
		thisView.view();
		showed=true;
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException {
		thisInterface = new ArffTransferNodeInterface();
		return thisInterface;  
	}
}
