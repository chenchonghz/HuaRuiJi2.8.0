package org.tinos.document.nero.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTextPane;

import org.tinos.gui.ext.osgi.OSGI_chansfer;
import org.tinos.gui.flash.ThisCanvas;
import org.tinos.gui.node.edit.LinkNode;
public class BootNeroCell{
	public static void bootCell(LinkNode linkNode, JTextPane rightBotJTextPane, ThisCanvas canvas) throws IOException
	, UnsupportedAudioFileException, InterruptedException {
		Map<String, LinkNode> bootMaps= new HashMap<>();
		LinkNode currentNode= linkNode;
		while(null!= currentNode) {
			bootMaps.put(currentNode.primaryKey, currentNode);
			currentNode= currentNode.next;
		}
		Map<String, Boolean> bootedMaps= new HashMap<>();
		//׼��д����������������������ȸ����°汾 1.0.3_beta, �⼸�����ơ�20190617 8��28 ������
		Iterator<String> iterator;
		while(0< bootMaps.size()) {
			iterator= bootMaps.keySet().iterator();
			Here:
				while(iterator.hasNext()) {
					currentNode= bootMaps.get(iterator.next());
					if(bootedMaps.containsKey(currentNode.primaryKey)) {
						continue Here;
					}
					if(currentNode.tBeconnect&& !bootedMaps.containsKey(currentNode.tBeconnectPrimaryKey)) {
						continue Here;
					}
					if(currentNode.mBeconnect&& !bootedMaps.containsKey(currentNode.mBeconnectPrimaryKey)) {
						continue Here;
					}
					if(currentNode.dBeconnect&& !bootedMaps.containsKey(currentNode.dBeconnectPrimaryKey)) {
						continue Here;
					}
					if(null!= currentNode.thisFace&& currentNode.thisFace.isConfiged) {
						//���ûظ�
						currentNode.thisFace.memoryRecovery(rightBotJTextPane);
						//ȡֵ
						new OSGI_chansfer(currentNode, linkNode);
						//����
						currentNode.thisFace.execute(rightBotJTextPane);
						bootedMaps.put(currentNode.primaryKey, true);
						bootMaps.remove(currentNode.primaryKey);
					}else {
						//��û�������쳣������������壻
						currentNode.thisFace.config(rightBotJTextPane, canvas);
						currentNode.thisFace.thisPanel.setLocation(currentNode.x, currentNode.y);
						currentNode.thisFace.thisPanel.setSize(300, 300);
						currentNode.thisFace.thisPanel.setResizable(true);
						currentNode.thisFace.thisPanel.scrollPane.setBounds(0, 0, currentNode.thisFace.thisPanel.getWidth()-10
								, currentNode.thisFace.thisPanel.getHeight()-45);
						currentNode.thisFace.thisPanel.panel.setPreferredSize(new Dimension(800, 600));
						currentNode.thisFace.thisPanel.setBackground(Color.BLUE);
						currentNode.thisFace.thisPanel.setVisible(true);
						currentNode.thisFace.thisPanel.validate();
						return;
					}
				}
		}
	}
}