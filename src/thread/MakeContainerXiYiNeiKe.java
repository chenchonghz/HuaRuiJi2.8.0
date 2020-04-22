package thread;
import java.awt.Container;
import java.io.IOException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import org.tinos.engine.analysis.Analyzer;

import sample.AppBoot;
import sample.xi.yi.nei.ke.xue.xynk;
public class MakeContainerXiYiNeiKe extends Thread implements Runnable{
	public Container jpanelSecond;
	public AppBoot u;
	public JTabbedPane jTabbedpane;
	public String[] tabNames;
	public Analyzer analyzer;
	public Map<String, String> pos;
	public Map<String, String> pose; 
	public Map<String, String> etc;
	public Map<String, String> cte;
	public MakeContainerXiYiNeiKe(Analyzer analyzer,AppBoot u2, JTabbedPane jTabbedpane, String[] tabNames
			, Map<String, String> pos, Map<String, String> pose, Map<String, String> etc
			, Map<String, String> cte) {
		super();
		this.u = u2;
		this.tabNames = tabNames;
		this.jTabbedpane = jTabbedpane;
		this.analyzer = analyzer;
		this.pos = pos;
		this.pose = pose;
		this.etc = etc;
		this.cte = cte;
	}
	public void run(){ 
		try {
			jTabbedpane.validate();
			Thread.sleep(1000*45);
			u.jpanel6= new xynk(u.text, this.analyzer, pos, pose, etc, cte, u, jTabbedpane);
			jTabbedpane.addTab(tabNames[5],new ImageIcon() , u.jpanel6, "��ҽ�ڿ�ѧ");// �����һ��ҳ��  
			jTabbedpane.validate();
		} catch (IOException e) {
			jTabbedpane.validate();
		} catch (InterruptedException e) {
			jTabbedpane.validate();
		}  	
	}
}