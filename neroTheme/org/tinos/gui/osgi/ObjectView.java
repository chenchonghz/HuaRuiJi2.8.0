package org.tinos.gui.osgi;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JFrame;
import javax.swing.JTable;

import movieProcessor.LYGFileIO;

public class ObjectView extends JFrame implements Cloneable{
	private static final long serialVersionUID = 1L;
	public ObjectView objectView;
	public ScrollPane scrollPane;
	public Panel panel;
	public int h;
	public int w;
	public boolean close= false;
	public JTable tableout;
	public Map<String, Integer> topMapOut;
	public int[][] gout;
	public AudioInputStream aisout;
	public AudioInputStream aiscurout;
	public LYGFileIO lygout;
	public BufferedImage imageout;
	public ObjectView() {
	}
	public void view() throws Exception{
	}
	public ObjectView clone() {  	
		return objectView;  
	}  
}
