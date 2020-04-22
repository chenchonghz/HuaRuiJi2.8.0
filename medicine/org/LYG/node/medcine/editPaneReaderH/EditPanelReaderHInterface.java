package org.LYG.node.medcine.editPaneReaderH;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

import org.LYG.GUI.Flash.ThisCanvas;
import org.LYG.GUI.OSGI.*;
public class EditPanelReaderHInterface extends ObjectInterface{	
	JTextPane text;
	public EditPanelReaderHInterface(JTextPane text) throws IOException{
		this.text = text;
		thisIcon = new ImageIcon(this.getClass().getResource("editPaneReader.jpg"));
		thisName = new String("��ȡ�༭ҳ����������");
		position = new String("MEDCINE");
		Image img = ((ImageIcon) thisIcon).getImage();  
		Image newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		thisImage = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH );
		thisIcon = new ImageIcon(newimg);
	}
	
	public void config(JTextPane rightBotJTextPane, ThisCanvas canvas) throws IOException{
		try {
			thisView = new EditPanelReaderHView();
			thisRun = new EditPanelReaderHRun();
			thisPanel = new EditPanelReaderHPanel((EditPanelReaderHRun) thisRun, this.text);
			thisPanel.config();
			showed = false;
		}catch(Exception e1) {
			rightBotJTextPane.setText("<��ȡ�༭ҳ����������> �ڵ�����ʧ����ע���Ƿ�������ȷ��");
			rightBotJTextPane.validate();
		} 
	}
	public void execute(JTextPane rightBotJTextPane) throws FileNotFoundException, IOException{
		try {
			((EditPanelReaderHRun) thisRun).run((EditPanelReaderHView) thisView);
		}catch(Exception e1) {
			rightBotJTextPane.setText("<��ȡ�༭ҳ����������> �ڵ�����ʧ����ע���Ƿ�������ȷ��");
			rightBotJTextPane.validate();
		} 
	}
	public void view(JTextPane rightBotJTextPane) throws Exception{
		try {
			thisView.view();
			showed = true;
		}catch(Exception e1) {
			rightBotJTextPane.setText("<��ȡ�༭ҳ����������> �ڵ�鿴ʧ����ע���Ƿ�������ȷ��");
			rightBotJTextPane.validate();
		} 
	}
	public ObjectInterface luoyaoguang() throws CloneNotSupportedException, IOException{
		thisInterface = new EditPanelReaderHInterface(this.text);   
		return thisInterface;  
	}
}
