package org.tinos.node.medcine.ChuFangWuXingShow;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.tinos.gui.osgi.*;
public class ChuFangWuXingShowHView extends ObjectView{
	private static final long serialVersionUID = 1L;
	public JButton button;
	public String path;
	public ChuFangWuXingShowHView(){
		super();
	}
	public void view() throws Exception{
		try {
			scrollPane = new ScrollPane();
			panel=new Panel(){
				private static final long serialVersionUID = 1L;
				public void paint(Graphics g){
					ImageIcon image =new ImageIcon(getClass().getResource("bagua_ljbz.png"));
					Image im = image.getImage();
					g.drawImage(im,0,0,this);
					g.drawString(""+((topMapOut.containsKey("������")?topMapOut.get("������"):0)
							+(topMapOut.containsKey("������")?topMapOut.get("������"):0)
							+(topMapOut.containsKey("������")?topMapOut.get("������"):0)
							+(topMapOut.containsKey("��̫��")?topMapOut.get("��̫��"):0)
							), 320-30, 15);	
					
					g.drawString(""+((topMapOut.containsKey("������")?topMapOut.get("������"):0)
							
							), 20, 70);	 
					
					g.drawString(""+((topMapOut.containsKey("������")?topMapOut.get("������"):0)

							), 20, 210);	 
					
					g.drawString(""+((topMapOut.containsKey("������")?topMapOut.get("������"):0)
							+(topMapOut.containsKey("������")?topMapOut.get("������"):0)
							), 50, 350);	 
					
					
					g.drawString(""+((topMapOut.containsKey("������")?topMapOut.get("������"):0)
							+(topMapOut.containsKey("��̫��")?topMapOut.get("��̫��"):0)
							+(topMapOut.containsKey("������")?topMapOut.get("������"):0)
							), 320-30, 300);	 
					
					g.drawString(""+((topMapOut.containsKey("������")?topMapOut.get("������"):0)
							), 500, 300);	 
					
					g.drawString(""+((topMapOut.containsKey("��̫��")?topMapOut.get("��̫��"):0)
							), 550, 210);	 
					
					g.drawString(""+((topMapOut.containsKey("��̫��")?topMapOut.get("��̫��"):0)
							), 500-30, 70);	 
				}	
			};	
			scrollPane.add(panel);
			add(scrollPane);
			close = false;
			
		}catch(Exception e) {
		}
		
	}
	@Override
	public ObjectView clone() {
		objectView = (ObjectView)super.clone();  
		return objectView;  
	}  
}
