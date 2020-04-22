package thread;
import java.awt.Container;
import java.io.IOException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import org.tinos.engine.analysis.Analyzer;

import sample.AppBoot;
import sample.zynkx.zynkx;
public class MakeContainerZYNKFJ extends Thread implements Runnable{
	public Container jpanelSecond;
	public AppBoot u;
	public JTabbedPane jTabbedpane;
	public String[] tabNames;
	public Analyzer analyzer;
	public Map<String, String> pos;
	public Map<String, String> pose;
	public Map<String, String> etc;
	public Map<String, String> cte;
	public MakeContainerZYNKFJ(Analyzer analyzer,AppBoot u2, JTabbedPane jTabbedpane, String[] tabNames
			, Map<String, String> pos, Map<String, String> pose, Map<String, String> etc
			, Map<String, String> cte) {
		super();
		this.u = u2;
		this.tabNames = tabNames;
		this.jTabbedpane = jTabbedpane;
		this.analyzer=analyzer;
		this.pos = pos;
		this.pose = pose;
		this.etc = etc;
		this.cte = cte;
	}
	public void run(){ 
		try {
			jTabbedpane.validate();
			Thread.sleep(1000*20);
			//jTabbedpane.setMnemonicAt(5, KeyEvent.VK_5);// ���õ�һ��λ�õĿ�ݼ�Ϊ0  
			u.jpanel7 = new zynkx(u.text, this.analyzer,pos, pose, etc, cte, u, jTabbedpane);
			jTabbedpane.addTab(tabNames[6],new ImageIcon() , u.jpanel7, "��ҽ�ڿƷ���");// �����һ��ҳ��  
			//	jTabbedpane.setMnemonicAt(6, KeyEvent.VK_6);// ���õ�һ��λ�õĿ�ݼ�Ϊ0  
			jTabbedpane.validate();
		} catch (IOException e) {
			jTabbedpane.validate();
		} catch (InterruptedException e) {
			jTabbedpane.validate();
		} 	
	}
}