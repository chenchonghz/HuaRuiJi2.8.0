package org.LYG.node.medcine.ChuFangWuXingShow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import org.LYG.GUI.OSGI.*;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Color;
@SuppressWarnings("unused")
public class ChuFangWuXingShowHPanel extends ObjectPanel{
	private static final long serialVersionUID = 1L;
	private JTextPane textTemp;
	private Object[][] tableData_old;
	public ChuFangWuXingShowHPanel(final ChuFangWuXingShowHRun thisRun, JTextPane text
			, Object[][] tableData_old){
		this.textTemp = text;
		this.tableData_old = tableData_old;
		setLayout(null);
		scrollPane = new ScrollPane();
		add(scrollPane);
		panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		JButton button = new JButton("���");
		button.setBounds(0, 0, 150, 30);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println(e.getSource());
				close = true;
				thisRun.value = 1;
			}
		});
		panel.add(button);
		JButton readfile = new JButton("����������������");
		readfile.setBounds(0, 35, 150, 65);
		readfile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					thisRun.topMapIn = new ConcurrentHashMap<>();
					for(int i=0;i<thisRun.toptablein.getRowCount();i++) {
						if(null != thisRun.toptablein.getValueAt(i, 5)) {
							String temp = thisRun.toptablein.getValueAt(i, 5).toString();
							if(temp.contains("��̫��")||temp.contains("ͨ��ʮ��")||temp.contains("Ƣ")) {
								if(thisRun.topMapIn.containsKey("��̫��")) {
									thisRun.topMapIn.put("��̫��", thisRun.topMapIn.get("��̫��"));
								}else {
									thisRun.topMapIn.put("��̫��", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("��")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("��")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("��̫��")||temp.contains("ͨ��ʮ��")||temp.contains("����")) {
								if(thisRun.topMapIn.containsKey("��̫��")) {
									thisRun.topMapIn.put("��̫��", thisRun.topMapIn.get("��̫��"));
								}else {
									thisRun.topMapIn.put("��̫��", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("��")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("θ")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("��̫��")||temp.contains("ͨ��ʮ��")||temp.contains("��")) {
								if(thisRun.topMapIn.containsKey("��̫��")) {
									thisRun.topMapIn.put("��̫��", thisRun.topMapIn.get("��̫��"));
								}else {
									thisRun.topMapIn.put("��̫��", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("��")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("�İ�")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("��̫��")||temp.contains("ͨ��ʮ��")||temp.contains("С��")) {
								if(thisRun.topMapIn.containsKey("��̫��")) {
									thisRun.topMapIn.put("��̫��", thisRun.topMapIn.get("��̫��"));
								}else {
									thisRun.topMapIn.put("��̫��", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("����")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
							if(temp.contains("������")||temp.contains("ͨ��ʮ��")||temp.contains("��")) {
								if(thisRun.topMapIn.containsKey("������")) {
									thisRun.topMapIn.put("������", thisRun.topMapIn.get("������"));
								}else {
									thisRun.topMapIn.put("������", 1);
								}
							}
						}
					}
				}catch(Exception e) {		
				}
			}
		});
		panel.add(readfile);
		scrollPane.add(panel);
		close= false;
		
	}
	public void config(){
		System.out.println("configued");
	}
}
