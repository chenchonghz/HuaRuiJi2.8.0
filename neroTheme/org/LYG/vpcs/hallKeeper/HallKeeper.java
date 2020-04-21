package org.LYG.vpcs.hallKeeper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JTextPane;

import org.LYG.GUI.Flash.ThisCanvas;
import org.LYG.GUI.nodeEdit.LinkList;
import org.LYG.GUI.nodeView.NodeShow;
import org.LYG.document.neroCell.BootNeroDoc;
import org.LYG.vpcs.sets.Sets;
import org.LYG.vpcs.skivvy.Skivvy;
import org.LYG.vpcs.vision.Pillow;
import org.LYG.vpcs.vision.Vision;
public class HallKeeper{
	public static Map<Long, BootNeroDoc> hallKeeper;
	public static void vpcsRegister(LinkList first, String fileCurrentpath, NodeShow nodeView
			, JTextPane rightBotJTextPane, ThisCanvas canvas) {
		if(null== hallKeeper) {
			hallKeeper= new ConcurrentHashMap<>();
		}
		
		if(200> hallKeeper.size()) {
			try {
				BootNeroDoc bootNeroDoc= new BootNeroDoc(first, fileCurrentpath, nodeView
						, rightBotJTextPane, canvas);
				Sets.register(bootNeroDoc.getId());//sets ��sleeper����ʱ��������Է�����������ݡ�
				Pillow.register(bootNeroDoc);//pillow����Щ���ݵķ���洢��
				Vision.registerVision(bootNeroDoc);//vision��sleeper���еľ����ξ���
				hallKeeper.put(bootNeroDoc.getId(), bootNeroDoc);
				bootNeroDoc.start();
			}catch(Exception e) {
				Skivvy.working(hallKeeper, e);//skivvy����vision�� pillow��sets��sleeper ȫ�̹���ͷ�����
			}
		}
	}
}