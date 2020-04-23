package sample;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import SP.jp;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.BadLocationException;

import org.LYG.sets.stable.StableData;
import org.deta.tinos.string.StringSwap;
import org.tinos.engine.analysis.Analyzer;
import org.tinos.engine.base.translator.Translator;
import org.tinos.engine.base.translator.imp.TranslatorImp;
import org.tinos.rest.medicine.RestMedicinePortImpl;
import org.tinos.view.obj.Verbal;
import org.tinos.view.obj.WordFrequency;

import biProcessor.coAuthorForWord;
import cap.Monitor;
import comp.jbutton.DetaButton;
import comp.jtextfield.cfxTextField;
import comp.jtextpane.cfxTextPane;
import disk.GetDisk;
import mapProcessor.VtoV;
import sample.cecil.cecil;
import sample.editPane.editPane;
import sample.fu.chan.ke.xue.FuChanKeXue;
import sample.gu.ji.jing.dian.GuJiJingDian;
import sample.ji.zhen.ke.xue.JiZhenKeXue;
import sample.wai.shang.ke.xue.WaiShangKeXue;
import sample.wkx.WaiKeXue;
import sample.xi.yi.nei.ke.xue.XiYiNeiKe;
import sample.xi.yi.yao.xue.XiYiYaoXue;
import sample.zhong.yi.nei.ke.xue.ZhongYiNeiKeXue;
import sample.zhong.yi.sheng.zhi.ZhongYiShengZhi;
import sample.zhong.yi.zhen.duan.xue.ZhongYiZhenDuanXue;
import sort.Quick6DLYGWithStringSwap;
public class AppBoot extends JApplet implements MouseListener, KeyListener, ActionListener, ChangeListener{	
	private static final long serialVersionUID= 1L;
	public int row= 0;
	public jp jp1;
	public int col= 0;
	public boolean disableCursor= true;
	public Translator ts;
	public JTextPane text;
	public String key;
	public JFrame frame;
	public String hint;
	public AppSearch appSearch;
	public Analyzer analyzer;
	public coAuthorForWord app;
	public Monitor m;
	public Map<String, String> pos;
	public Map<String, String> posec;
	public Map<String, String> pose;
	public Map<String, String> posFullec;
	public Map<String, String> posFullce;
	public Map<String, String> etc;
	public Map<String, String> cte;
	public Map<String, String> pinyin;
	public Map<String, String> ctk;
	public Map<String, String> ctj;
	public Map<String, String> ctt;
	public JCheckBox risk_filter_box;
	public JCheckBox feel_filter_box;
	public JCheckBox jingmai_filter_box;
	public JCheckBox gongxiao_filter_box;
	public JCheckBox zonghe_filter_box;
	public JCheckBox shuming_filter_box;
	public List<String> sets;
	public XiYiNeiKe jpanel6;
	public ZhongYiNeiKeXue jpanel7;
	public ZhongYiZhenDuanXue jpanel8;
	public GuJiJingDian jpanel9;
	public ZhongYiShengZhi jpanel10;
	public FuChanKeXue jpanel11;
	public JiZhenKeXue jpanel12;
	public WaiKeXue jpanel13;
	public WaiShangKeXue jpanel14;
	public XiYiYaoXue jpanel15;
	public cecil jpanel17;
	public editPane jpanel16;
	public JLabel label0001;
	public JTextPane data;
	public JPanel panel_yt;
	public JTextField name;
	public JTextField name_filter;
	public javax.swing.JTable table;  
	public Object[][] tableData_old;
	public DefaultTableModel newTableModel= null;
	public List<String> dic_list;
	public List<String> copy;
	public Map<String, Object> dic_map= new HashMap<>();
	public Map<String, Object> dic_li= new HashMap<>();
	public Map<String, Object> dic_hai= new HashMap<>();
	public Map<String, Object> dic_xz= new HashMap<>();
	public Map<String, Object> dic_ya= new HashMap<>();
	public Map<String, Object> dic_jm= new HashMap<>();
	public Map<String, Object> dic_xw= new HashMap<>();
	public Map<String, Object> dic_cy= new HashMap<>();
	public Map<String, Object> dic_cj= new HashMap<>();
	public Map<String, Object> dic_jj= new HashMap<>();
	public Map<String, Object> dic_zf= new HashMap<>();
	public Map<String, Object> dic_yl= new HashMap<>();
	public Map<String, Object> dic_yw= new HashMap<>();
	public JPanel panel= new JPanel(); 
	public JButton buttonCTE;
	public JButton buttonFRS;
	public JButton buttonETC;
	public JButton buttonADD;
	public JButton buttonGXB;
	public JButton buttonBCJ;
	public JFrame frameTag;
	public TagSearch tagSearch;
	public ImageIcon logo= new ImageIcon(getClass().getResource("logo.png"));  
	public ImageIcon pnga= new ImageIcon(getClass().getResource("sc/a.png")); 
	public ImageIcon pngo= new ImageIcon(getClass().getResource("sc/o.png")); 
	public ImageIcon pnge= new ImageIcon(getClass().getResource("sc/e.png")); 
	public ImageIcon pngi= new ImageIcon(getClass().getResource("sc/i.png")); 
	public ImageIcon pngu= new ImageIcon(getClass().getResource("sc/u.png")); 
	public ImageIcon shoujueyin= new ImageIcon(getClass().getResource("�������İ���.png")); 
	public ImageIcon shoushaoyang= new ImageIcon(getClass().getResource("������������.png"));  
	public ImageIcon shoushaoyin= new ImageIcon(getClass().getResource("�������ľ�.png"));  
	public ImageIcon shoutaiyang= new ImageIcon(getClass().getResource("��̫��С����.png"));  
	public ImageIcon shoutaiyin= new ImageIcon(getClass().getResource("��̫���ξ�.png"));  
	public ImageIcon shouyangmin= new ImageIcon(getClass().getResource("�������󳦾�.png"));  
	public ImageIcon zujueyin= new ImageIcon(getClass().getResource("�������ξ�.png"));  
	public ImageIcon zushaoyang= new ImageIcon(getClass().getResource("����������.png"));
	public ImageIcon zushaoyin= new ImageIcon(getClass().getResource("����������.png"));  
	public ImageIcon zutaiyang= new ImageIcon(getClass().getResource("��̫�����׾�.png"));  
	public ImageIcon zutaiyin= new ImageIcon(getClass().getResource("��̫��Ƣ��.png"));  
	public ImageIcon zuyangmin= new ImageIcon(getClass().getResource("������θ��.png"));  
	public ImageIcon png88 = new ImageIcon(getClass().getResource("bagua.png"));  
	public ImageIcon wsp = new ImageIcon(getClass().getResource("wsp.png"));  
	public ImageIcon wwp = new ImageIcon(getClass().getResource("wwp.png"));  
	public ImageIcon wxp = new ImageIcon(getClass().getResource("wxp.png"));
	public ImageIcon shun = new ImageIcon(getClass().getResource("shun.png"));  
	public ImageIcon bagua_bgbz= new ImageIcon(getClass().getResource("bagua_bgbz.png"));  
	public ImageIcon bagua_ljbz= new ImageIcon(getClass().getResource("bagua_ljbz.png"));  
	public ImageIcon bagua_sjbz= new ImageIcon(getClass().getResource("bagua_sjbz.png"));
	public ImageIcon bagua_qxbz= new ImageIcon(getClass().getResource("bagua_qxbz.png"));  
	public ImageIcon bagua_gzxs= new ImageIcon(getClass().getResource("bagua_gzxs.png"));  
	public ImageIcon bagua_skch= new ImageIcon(getClass().getResource("bagua_skch.png"));  
	public ImageIcon qp4= new ImageIcon(getClass().getResource("4qp.png"));  
	public ImageIcon pngy_2_1= new ImageIcon(getClass().getResource("yc/2_1.png"));  
	public Object[] columnTitle= {"ID", "���", "��ҩ����", "�ʼ�ԭ��", "��Ч", "���չ��", "����/��, ��������������ע"
			, "��ζ", "����/����", "��ҽ��ҩ��", "����", "��Դ", "�ް�", "����", "����ҩ"};
	private cfxTextField name_filter_not_have;
	public Map<String, String> ctr;
	private cfxTextField name_feel_filter;
	public JScrollPane jsp_name= null;
	public boolean ready= false;
	public AppBoot appInstance;
	public void init(){
		if(!new GetDisk().getKey().replaceAll(" ", "").contains("1152661394")) {
			//System.out.println(new GetDisk().getKey());
			//return;
		}
		//stop cursor
		appInstance= this;
		new Init().init(appInstance);
	}
	
	public JTextField name_feel_filter() {
		name_feel_filter= new cfxTextField(null, 0, 0, null);  
		name_feel_filter.setBounds(180-50, 50, 380, 80);
		name_feel_filter.setBackground(Color.white);
		name_feel_filter.addKeyListener(this);
		return name_feel_filter;
	}

	public JPanel panel() throws IOException{
		panel_yt= new JPanel();
		panel_yt.setBackground(Color.white);
		pngy_2_1= new ImageIcon(getClass().getResource("yc/2_1.png"));
		label0001= new JLabel(pngy_2_1);
		panel_yt.add(label0001);
		return panel_yt;
	}

	public JTextPane data() throws IOException {
		data= new cfxTextPane("����", 1350, 2980, null);  
		data.setBounds(850, 150, 1350, 2980);	
		data.setBackground(Color.white);
		Box buttonBoxLineTwo= new Box(BoxLayout.X_AXIS);  
//		buttonBoxLineTwo.add(buttonGXB);
//		buttonBoxLineTwo.add(buttonBCJ);
		buttonBoxLineTwo.setBounds(0, 22, 450, 20);
		//container.add(buttonBox);
		//container.add(buttonBoxLineTwo);
		return data; 
	}
	
	public Box getBox() {	
    	buttonADD= new DetaButton("��ӵ��༭ҳ", 100, 50, Color.red);
		buttonADD.setBounds(295-15, 0, 135, 30);
		buttonADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sets== null) {
					return;
				}
				if(text.getText().length()>5000) {
					return;
				}
				StringBuilder page= new StringBuilder();
				List<String> setsForGet= sets;
				Iterator<String> iterator= setsForGet.iterator();
					while(iterator.hasNext()) {
						String setOfi= iterator.next();
						page.append(setOfi); 
					}
					if(!text.getText().isEmpty()) {
						text.setText(text.getText() +"\r\n\r\n"+ page.toString());
					}else {
						text.setText(page.toString());
					}
					text.validate();
			}
		});
		buttonCTE= new DetaButton("Ӣ��ע��", 100, 50, Color.orange);
		buttonCTE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sets== null) {
					return;
				}
				StringBuilder page= new StringBuilder();
				List<String> setsForGet = sets;
				Iterator<String> iterator = setsForGet.iterator();
				Here:
					while(iterator.hasNext()) {
						String setOfi = iterator.next();
						if(pos.get(setOfi) == null) {
							page.append("<span style=\"background:#F1F1F1\"><font color=\"black\" size=\"5\">" + setOfi +(cte.containsKey(setOfi)?":("+cte.get(setOfi)+")":"") + "</font></span>");
							continue Here;
						}
						if (!setOfi.equals("")) {
							if(key.contains(setOfi)&&(pos.get(setOfi).contains("��")||pos.get(setOfi).contains("��")||pos.get(setOfi).contains("��"))) {
								page.append("<span style=\"background:red\"><font color=\"white\" size=\"5\">" + setOfi +(posFullce.containsKey(setOfi)?":("+posFullce.get(setOfi)+")":"") + "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(255, 245, 255)+ "\"><font color=\"black\" size=\"5\">"+ "<A href=\"http://localhost:8000/search?word="+ setOfi+"\">"
										+ setOfi+ "</A>" + (posFullce.containsKey(setOfi)?":("+posFullce.get(setOfi)+")":"")+ "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(245, 255, 245)+"\"><font color=\"black\" size=\"5\">" + setOfi +(posFullce.containsKey(setOfi)?":("+posFullce.get(setOfi)+")":"") + "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(255, 255, 245)+"\"><font color=\"black\" size=\"5\">" + setOfi +(posFullce.containsKey(setOfi)?":("+posFullce.get(setOfi)+")":"") + "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:#F1FFFF\"><font color=\"black\" size=\"5\">" + setOfi +(posFullce.containsKey(setOfi)?":("+posFullce.get(setOfi)+")":"") + "</font></span>");
								continue Here;
							} 
							page.append("<span style=\"background:white\"><font color=\"black\" size=\"5\">" + setOfi +(posFullce.containsKey(setOfi)?":("+posFullce.get(setOfi)+")":"") + "</font></span>");			 
						}}
				data.setText(page.toString());
				data.addHyperlinkListener(new HyperlinkListener(){
						@SuppressWarnings({ "deprecation", "hiding" })
						@Override
						public void hyperlinkUpdate(HyperlinkEvent e) {
							//.........
							//��������hyperlinkUpdate ��ʽ ������https://blog.csdn.net/nullpointer2008/article/details/7998986 ���¡�
							//20200323 �������޸�
							//��Ȩ����������ΪCSDN��������ָ��1996����ԭ�����£���ѭ CC 4.0 BY-SA ��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
							//ԭ�����ӣ�https://blog.csdn.net/nullpointer2008/article/details/7998986);
							//.........
							if (e.getEventType()!= HyperlinkEvent.EventType.ACTIVATED) 
								return;
							URL linkUrl= e.getURL();
							String string; System.out.println(linkUrl.getFile());
							try {
								string= StringSwap.charsetSwap(linkUrl.getFile().toString(), "GBK", "GBK");
								String[] value= string.split("=");
								if(value.length> 1) {
									VtoV.ObjectToJsonString(RestMedicinePortImpl.doSearch(appInstance, value[1]));
								}
							} catch (UnsupportedEncodingException e2) {
								e2.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							//����
							//1 �õ�����
							//2 ���ֱ�ע�����ַ���
							//3 ����frame
							if(null== frameTag) {
								tagSearch= new TagSearch();
								tagSearch.init(name);
								tagSearch.setBounds(0, 0, 435, 355);
								tagSearch.setVisible(true);
								tagSearch.show();
								frameTag= new JFrame("��ʾ��");
								//frame.setLayout(null);
								frameTag.setSize(430, 350);
								//ժ�Ե�37�� https://blog.csdn.net/code_better/article/details/53505962
								Point point= java.awt.MouseInfo.getPointerInfo().getLocation();
								//
								frameTag.setLocation(point.x, point.y);
								frameTag.setResizable(false);
								frameTag.add(tagSearch);
								frameTag.setVisible(true);
								frameTag.show();
								frameTag.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
							}else {
								Point point= java.awt.MouseInfo.getPointerInfo().getLocation();
								frameTag.setLocation(point.x, point.y);
								frameTag.setVisible(true);
								frameTag.show();
							}
						}
				});
				data.setEditable(false);
				data.setSelectionStart(0);
				data.setSelectionEnd(0);
				data.validate();
			}
		});
		
		buttonFRS= new DetaButton("���Ĵʻ�ԭ", 100, 50, Color.green);
		buttonFRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sets== null) {
					return;
				}
				StringBuilder page= new StringBuilder();
				List<String> setsForGet= sets;
				Iterator<String> iterator= setsForGet.iterator();
				Here:
					while(iterator.hasNext()) {
						String setOfi = iterator.next();
						if(pos.get(setOfi) == null) {
							page.append("<span style=\"background:#F1F1F1\"><font color=\"black\" size=\"5\">" + setOfi + "</font></span>");
							continue Here;
						}
						if (!setOfi.equals("")) {
							if(key.contains(setOfi)&&(pos.get(setOfi).contains("��")||pos.get(setOfi).contains("��")||pos.get(setOfi).contains("��"))) {
								page.append("<span style=\"background:red\"><font color=\"white\">"+setOfi +"</font></span>");
								continue Here;
						}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(255, 245, 255)+"\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(245, 255, 245)+"\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(255, 255, 245)+"\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:#F1FFFF\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>");
								continue Here;
							}
							page.append("<span style=\"background:white\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>");			 
						}
					}	
				data.setText(page.toString());
				data.setSelectionStart(0);
				data.setSelectionEnd(0);
				data.validate();
			}
		});
		
		buttonETC= new DetaButton("ͬ�������", 100, 50, Color.pink);
		//buttonETC.setBounds(200-15, 0, 88, 30);
		buttonETC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sets==null) {
					return;
				}
				StringBuilder page= new StringBuilder();
				List<String> setsForGet = sets;
				Iterator<String> iterator = setsForGet.iterator();
				Here:
					while(iterator.hasNext()) {
						String setOfi = iterator.next();
						if(pos.get(setOfi) == null) {
							page.append("<span style=\"background:#F1F1F1\"><font color=\"black\" size=\"5\">" + setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") + "</font></span>");
							continue Here;
						}
						if (!setOfi.equals("")) {
							if(key.contains(setOfi)&&(pos.get(setOfi).contains("��")||pos.get(setOfi).contains("��")||pos.get(setOfi).contains("��"))) {
								page.append("<span style=\"background:red\"><font color=\"white\">"+ setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") +  "</font></span>");
			    				continue Here;
			    			}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(255, 245, 255)+"\"><font color=\"black\" size=\"5\">" + setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") + "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(245, 255, 245)+"\"><font color=\"black\" size=\"5\">"+ setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") + "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:"+new imageProcessor.ColorProcessor().Processor(255, 255, 245)+"\"><font color=\"black\" size=\"5\">" + setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") + "</font></span>");
								continue Here;
							}
							if(pos.get(setOfi).contains("��")) {
								page.append("<span style=\"background:#F1FFFF\"><font color=\"black\" size=\"5\">" + setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") +  "</font></span>");
								continue Here;
							} 
							page.append("<span style=\"background:white\"><font color=\"black\" size=\"5\">"+ setOfi +(cte.containsKey(setOfi)?(etc.containsKey(cte.get(setOfi))?":("+etc.get(cte.get(setOfi))+")" : "") : "") +  "</font></span>");			 
						}
					}	
				data.setText(page.toString());
				data.setSelectionStart(0);
				data.setSelectionEnd(0);
				data.validate();
			}
		});
		
		buttonGXB= new JButton("���µ����");
		buttonETC.setBounds(200 - 15, 0, 88, 30);
		buttonGXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sets== null) {
					return;
				}
				String temp = null;
				try {
					temp = data.getDocument().getText(0, data.getDocument().getLength());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setValueAt(temp, row, col);
				System.out.println(temp);
			}
		});

		buttonBCJ= new JButton("������ƪ����ȫ��");
		//buttonETC.setBounds(200 - 15, 0, 88, 30);
		buttonBCJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				FileWriter fw = null;
//				try {
//					fw= new FileWriter("C:/Users/Administrator/Desktop/���ƽ���Ŀ/bcqj.txt", true);
//					for(int i=0;i<table.getRowCount();i++){
//						fw.write("ժҪ");
//						for(int j=0;j<table.getColumnCount();j++){
//							fw.write("\r\n");
//							fw.write("["+table.getColumnName(j)+"]");
//							if(table.getValueAt(i, j)!=null) {
//								if(j==3) {
//									fw.write(table.getValueAt(i, j).toString().replaceAll("\\[()\\]", ""));
//								}else {
//									fw.write(table.getValueAt(i, j).toString());
//								}
//							}
//							fw.write("\r\n");
//						}
//					}
//					fw.write("\r\n");
//					fw.write("ժҪ");
//					fw.close();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}	
				//һ��һ�еĲ���
				boolean mod= true;
				for(int i= 0; i< table.getRowCount(); i++){
					String plsql= "setRoot:C:/DetaDB;";
					   plsql+= "baseName:ZYY;"; 
					   plsql+= "tableName:zybc:insert;" +
						   		"culumnValue:ID:"+ table.getValueAt(i, 0).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:���:"+ table.getValueAt(i, 1).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:��ҩ����:"+ table.getValueAt(i, 2).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:�ʼ�ԭ��:"+ table.getValueAt(i, 3).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:��Ч:"+ table.getValueAt(i, 4).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:���չ��:"+ table.getValueAt(i, 5).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:����:"+ table.getValueAt(i, 6).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:��ζ:"+ table.getValueAt(i, 7).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:����:"+ table.getValueAt(i, 8).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:��ҽ��ҩ��:"+ table.getValueAt(i, 9).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:����:"+ table.getValueAt(i, 10).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:��Դ:"+ table.getValueAt(i, 11).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:�ް�:"+ table.getValueAt(i, 12).toString().replace(":", "@biky@")+ ";" + 
						   		"culumnValue:����:"+ table.getValueAt(i, 13).toString().replace(":", "@biky@")+ ";" +  
						   		"culumnValue:����ҩ:"+ table.getValueAt(i, 14).toString().replace(":", "@biky@")+ ";";
					try {
						org.plsql.db.plsql.imp.ExecPLSQLImp.ExecPLSQL(plsql, mod);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
    	
    	
    	Box buttonBox= new Box(BoxLayout.X_AXIS);
		buttonBox.add(buttonCTE);
		buttonBox.add(buttonFRS);
		buttonBox.add(buttonETC);
		//buttonBox.add(buttonBCJ);
		buttonBox.add(buttonADD);
		buttonBox.setBounds(0, 0, 445, 20);
		
	//	Box buttonBoxLineTwo= new Box(BoxLayout.X_AXIS);  
	//	buttonBoxLineTwo.add(buttonGXB);
	//	buttonBoxLineTwo.add(buttonBCJ);
	//	buttonBoxLineTwo.setBounds(0, 22, 450, 20);
	//	container.add(buttonBoxLineTwo);
		return buttonBox;
    } 
    
	public JTextField name() throws IOException {
		name= new cfxTextField(null, 0, 0, null);  
		name.setBounds(180-50, 50, 380, 80);
		name.setBackground(Color.white);
		name.addKeyListener(this);
		return name;
	}	

	public JTextField name_filter() throws IOException {
		name_filter= new cfxTextField(null, 0, 0, null);  
		name_filter.setBounds(180-50, 50, 380, 80);
		name_filter.setBackground(Color.white);
		name_filter.addKeyListener(this);
		return name_filter;
	}	
	
	public JTextField name_filter_not_have() throws IOException {
		name_filter_not_have= new cfxTextField(null, 0, 0, null);  
		name_filter_not_have.setBounds(180-50, 50, 380, 80);
		name_filter_not_have.setBackground(Color.white);
		name_filter_not_have.addKeyListener(this);
		return name_filter_not_have;
	}	
	
	@SuppressWarnings({"serial"})
	public javax.swing.JTable jTable() throws IOException {
		dictionaryFromDB d= new dictionaryFromDB();
		dic_list= d.txtToList();
		dic_map= d.listToMap(dic_yw, dic_li, dic_hai, dic_xz, dic_ya, dic_jm
				, dic_xw, dic_cy, dic_jj, dic_zf, dic_cj, dic_yl);
//		dic_yw= d.mapToMap_yw(dic_map);
//		dic_li= d.mapToMap_li(dic_map);
//		dic_hai= d.mapToMap_hai(dic_map);
//		dic_xz= d.mapToMap_xz(dic_map);
//		dic_ya= d.mapToMap_ya(dic_map);
//		dic_jm= d.mapToMap_jm(dic_map);
//		dic_xw= d.mapToMap_xw(dic_map);
//		dic_cy= d.mapToMap_cy(dic_map);
//		dic_jj= d.mapToMap_jj(dic_map);
//		dic_zf= d.mapToMap_zf(dic_map);
//		dic_cj= d.mapToMap_cj(dic_map);
//		dic_yl= d.mapToMap_yl(dic_map,dic_xw,dic_li,dic_xz,dic_jm);
		tableData_old= new Object[dic_map.size()][14];
		Object[][] tableData_old_for_model= new Object[dic_map.size()][14];
		Iterator<String> iter= dic_map.keySet().iterator();
		copy= new ArrayList<>();
		int cc=0;
		while (iter.hasNext()) {
			String temp= iter.next();
			copy.add(temp);
		}
		System.out.println(cc);
		for(int i = 0; i < copy.size(); i++) {
			tableData_old[i]= new Object[]{""+(i+1),""+0,copy.get(i).trim(),
					dic_yw.get(copy.get(i)).toString().replaceAll("\\s*", "") , 
					dic_li.get(copy.get(i)).toString().replaceAll("\\s*", ""),
					(dic_hai.get(copy.get(i))==null?"����ο��ʼ�ԭ����":dic_hai.get(copy.get(i))
							.toString().replaceAll("\\s*", "").equalsIgnoreCase("")
							?"����ο��ʼ�ԭ����":dic_hai.get(copy.get(i)).toString().replaceAll("\\s*", "")), 
					(dic_yl.get(copy.get(i))==null?"":dic_yl.get(copy.get(i))).toString()
					.replaceAll("\\s*", ""),
					dic_xw.get(copy.get(i)).toString().replaceAll("\\s*", "") ,
					dic_jm.get(copy.get(i)).toString().replaceAll("\\s*", "") ,
					(dic_xz.get(copy.get(i))==null?"":dic_xz.get(copy.get(i))).toString()
					.replaceAll("\\s*", "") , 
					(dic_jj.get(copy.get(i))==null?"":dic_jj.get(copy.get(i))).toString()
					.replaceAll("\\s*", "") , 
					(dic_cy.get(copy.get(i))==null?"":dic_cy.get(copy.get(i))).toString()
					.replaceAll("\\s*", "") ,
					(dic_ya.get(copy.get(i))==null?"":dic_ya.get(copy.get(i))).toString()
					.replaceAll("\\s*", "") , 
					(dic_zf.get(copy.get(i))==null?"":dic_zf.get(copy.get(i))).toString()
					.replaceAll("\\s*", ""),
					(dic_cj.get(copy.get(i))==null?"":dic_cj.get(copy.get(i))).toString()
					.replaceAll("\\s*", "")};
			tableData_old_for_model[i]=tableData_old[i].clone();
		}	
		table= new javax.swing.JTable();  
		newTableModel= new DefaultTableModel(tableData_old_for_model,columnTitle){  
			@Override  
			public boolean isCellEditable(int row,int column){  
				return false;  
			}  
		};  
		TableSorterWithLYG4DQS4D sorter= new TableSorterWithLYG4DQS4D(newTableModel); //ADDE
		sorter.setTableHeader(table.getTableHeader());
		table.setModel(sorter); 
		table.setRowHeight(35);                                        //���ø߶�
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("����", Font.PLAIN, 18));// ���ñ������
		table.addMouseListener(this);
		table.getColumnModel().getColumn(3).setPreferredWidth(80+30);
		table.getColumnModel().getColumn(4).setPreferredWidth(80+130);
		table.getColumnModel().getColumn(5).setPreferredWidth(80+130);
		table.getColumnModel().getColumn(6).setPreferredWidth(80+130);
		table.getColumnModel().getColumn(7).setPreferredWidth(80+130);
		table.getColumnModel().getColumn(8).setPreferredWidth(80+130);
		table.getColumnModel().getColumn(9).setPreferredWidth(80+130);
		table.getColumnModel().getColumn(10).setPreferredWidth(80+30);
		table.getColumnModel().getColumn(11).setPreferredWidth(80+30);
		table.getColumnModel().getColumn(12).setPreferredWidth(80+30);
		table.getColumnModel().getColumn(14).setPreferredWidth(300+60);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		table.validate();
		table.setVisible(true);
		colorTableRender tcr= new colorTableRender();  
		table.setDefaultRenderer(Object.class, tcr);	
		return table;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(disableCursor) {
			return;
		}
		key= name.getText();
		if(key!= null && !key.replace(" ", "").equals("") && key.length()>20) {
			key= key.substring(0, 20);
		}
		if(key== null) {
			key= "";	
		}
		row= table.getSelectedRow();
		col= table.getSelectedColumn();
		try {
			app.bootClassificationMap(table.getValueAt(row, 2).toString(), false);
		}catch(Exception e) {
			this.validate();
		}
		try {
			String value = table.getValueAt(row, col).toString();
			data.setSize(500, 800);
			sets = analyzer.parserMixedString(value);//���Է���
			data.setContentType("text/html");
			String page="";
			Iterator<String> iterator = sets.iterator();
			Here:
				while(iterator.hasNext()) {
					String setOfi = iterator.next();
					if(pos.get(setOfi) == null) {
						page += ("<span style=\"background:#FEFEFE\"><font color=\"black\" size=\"5\">" 
					+ setOfi + "</font></span>");
						continue Here;
					}
					if (!setOfi.equals("")) {
						if(key.contains(setOfi)&&(pos.get(setOfi).contains("��")||pos.get(setOfi)
								.contains("��")||pos.get(setOfi).contains("��"))) {
							page+="<span style=\"background:red\"><font color=\"white\">"+setOfi
									+"</font></span>";
							continue Here;
						}
						if(pos.get(setOfi).contains("��")) {
							page+="<span style=\"background:"+new imageProcessor.ColorProcessor()
									.Processor(255, 245, 255)+"\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>";
							continue Here;
						}
						if(pos.get(setOfi).contains("��")) {
							page+="<span style=\"background:"+new imageProcessor.ColorProcessor()
									.Processor(245, 255, 245)+"\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>";
							continue Here;
						}
						if(pos.get(setOfi).contains("��")) {
							page+="<span style=\"background:"+new imageProcessor.ColorProcessor()
									.Processor(255, 255, 245)+"\"><font color=\"black\" size=\"5\">"+setOfi+"</font></span>";
							continue Here;
						}
						if(pos.get(setOfi).contains("��")) {
							page+="<span style=\"background:#F1FFFF\"><font color=\"black\" size=\"5\">"+setOfi
									+"</font></span>";
							continue Here;
						} 
						page+="<span style=\"background:white\"><font color=\"black\" size=\"5\">"+setOfi
								+"</font></span>";				 
					}
				}
			data.setText(page);
			data.setSelectionStart(0);
			data.setSelectionEnd(0);
			data.validate();
		}catch(Exception e){	
			e.printStackTrace();
		}          
		//add graph
		try {
			panel_yt.removeAll();
			label0001.removeAll();
			String value_temp= table.getValueAt(row, 2).toString().replace("\\s+", "");
			pngy_2_1= new ImageIcon(getClass().getResource("yc/"+ value_temp+ ".png"));
			label0001.setIcon(pngy_2_1);
			label0001.validate();
			panel_yt.add(label0001);
			panel_yt.validate();
			panel_yt.updateUI();
		}catch(Exception e) {
			JLabel temp= new JLabel("�ף�û�ҵ�~~");
			panel_yt.add(temp);
			panel_yt.validate();
			panel_yt.updateUI();
		}
		this.panel.removeAll();
		this.panel.setLayout(new GridLayout(1, 1));
		//add jingmai
		String value_jingmai = "";
		try {
			for(int i = 0; i < table.getColumnCount(); i++) {
				if(table.getValueAt(row, i)!=null) {
					String temp = table.getValueAt(row, i).toString();
					if(temp.length()<30) {
						value_jingmai += temp;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			int c = 0;
			Box jingMaiBox= new Box(BoxLayout.Y_AXIS);
			if(!value_jingmai.equals("")) {
				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("��")) {
					JLabel label1= new JLabel(this.shouyangmin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("����")) {
					JLabel label1= new JLabel(this.shoushaoyang);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("��")
						||value_jingmai.contains("��")) {
					JLabel label1= new JLabel(this.shoushaoyin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("��̫��")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("С��")) {
					JLabel label1= new JLabel(this.shoutaiyang);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("��̫��")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("��")
						||value_jingmai.contains("��")) {
					JLabel label1= new JLabel(this.shoutaiyin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("�İ�")) {
					JLabel label1= new JLabel(this.shoujueyin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("θ")) {
					JLabel label1= new JLabel(this.zuyangmin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("��")) {
					JLabel label1= new JLabel(this.zushaoyang);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("��")
						||value_jingmai.contains("��")||value_jingmai.contains("��")) {
					JLabel label1= new JLabel(this.zushaoyin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("��̫��")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("����")) {
					JLabel label1= new JLabel(this.zutaiyang);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("��̫��")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("Ƣ")) {
					JLabel label1= new JLabel(this.zutaiyin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}

				if(value_jingmai.contains("������")||value_jingmai.contains("ͨ��ʮ��")
						||value_jingmai.contains("��")
						||value_jingmai.contains("��")) {
					JLabel label1= new JLabel(this.zujueyin);
					//this.panel.add(label1);
					jingMaiBox.add(label1);
					c=1;
				}
			}
			if(c==0){
				JLabel temp= new JLabel("�ף�û�ҵ�~~");
				//this.panel.add(temp);
				jingMaiBox.add(temp);
			}
			
			//box, button, 
			//panel add box
			this.panel.add(jingMaiBox);
			this.panel.updateUI();
		}catch(Exception e) {
			e.printStackTrace();
			this.panel.updateUI();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@SuppressWarnings("unused")
	@Override
	public void keyReleased(KeyEvent arg0) {
		String zhongyao="";
		key= name.getText();
		String forE = key.toLowerCase().toString();
		if(key != null && !key.replace(" ", "").equals("") && key.length()>50) {
			key = key.substring(0, 50);
		}
		if(forE != null && !forE.replace(" ", "").equals("") && forE.length()>110) {
			forE = forE.substring(0, 110);
		}
		key = key.length()==0?"":ts.MixedStringToChineseString(analyzer, key);
		if(key.replaceAll("\\s+", " ").equalsIgnoreCase(" ")){
			key="";
		}
		zhongyao= key.toString();
		Here:
			for(int i= 0; i< key.length(); i++) {
				if(StableData.feng.contains(""+ key.charAt(i))) {
					key+= "��";
					continue Here;
				}
				if(StableData.han.contains(""+ key.charAt(i))) {
					key+= "�纮";
					continue Here;
				}
				if(StableData.hot.contains(""+ key.charAt(i))) {
					key+= "����";
					continue Here;
				}
				if(StableData.shi.contains(""+ key.charAt(i))) {
					key+= "��ʪ";
					continue Here;
				}
				if(StableData.huo.contains(""+ key.charAt(i))) {
					key+= "��";
					continue Here;
				}
				if(StableData.zao.contains(""+ key.charAt(i))) {
					key+= "��";
					continue Here;
				}
				if(StableData.liuYin.contains(""+ key.charAt(i))) {
					key+= "����";
					continue Here;
				}
				if(StableData.qiQing.contains(""+ key.charAt(i))) {
					key+= "����";
					continue Here;
				}
				if(StableData.wangYang.contains(""+ key.charAt(i))) {
					key+= "����";
					continue Here;
				}
				if(StableData.wangYin.contains(""+ key.charAt(i))) {
					key+= "����";
					continue Here;
				}
				if(StableData.jiBaoShiChang.contains(""+ key.charAt(i))) {
					key+= "����ʧ��";
					continue Here;
				}
				if(StableData.yinShiBuJie.contains(""+ key.charAt(i))) {
					key+= "��ʳ����";
					continue Here;
				}
				if(StableData.tiaoShiPianShe.contains(""+ key.charAt(i))) {
					key+= "��ʳƫʳ";
					continue Here;
				}
				if(StableData.biaoHan.contains(""+ key.charAt(i))) {
					key+= "��";
					continue Here;
				}
				if(StableData.biaoRe.contains(""+ key.charAt(i))) {
					key+= "����";
					continue Here;
				}
				if(StableData.yuXue.contains(""+ key.charAt(i))) {
					key+= "��";
				}
			}
		if(jpanel6!= null) {
			this.jpanel6.key= zhongyao.toString();
			this.jpanel6.keyReleased(null);
		}
		if(jpanel7!= null) {
			this.jpanel7.key= zhongyao.toString();
			this.jpanel7.keyReleased(null);
		}
		if(jpanel8!= null) {
			this.jpanel8.key= zhongyao.toString();
			this.jpanel8.keyReleased(null);
		}
		if(jpanel9!= null) {
			this.jpanel9.key= zhongyao.toString();
			this.jpanel9.keyReleased(null);
		}
		if(jpanel10!= null) {
			this.jpanel10.key= zhongyao.toString();
			this.jpanel10.keyReleased(null);
		}
		if(jpanel11!= null) {
			this.jpanel11.key= zhongyao.toString();
			this.jpanel11.keyReleased(null);
		}
		if(jpanel12!= null) {
			this.jpanel12.key= zhongyao.toString();
			this.jpanel12.keyReleased(null);
		}
		if(jpanel13!= null) {
			this.jpanel13.key= zhongyao.toString();
			this.jpanel13.keyReleased(null);
		}
		if(jpanel14!= null) {
			this.jpanel14.key= zhongyao.toString();
			this.jpanel14.keyReleased(null);
		}
		if(jpanel15!= null) {
			this.jpanel15.key= zhongyao.toString();
			this.jpanel15.keyReleased(null);
		}
		if(jpanel16!= null) {
			this.jpanel16.key= zhongyao.toString();
			this.jpanel16.keyReleased(null);
		}
		Translator ts= new TranslatorImp();
		try {
			ts.init(analyzer);
		} catch (IOException e) {
		} 
		List<Verbal> verbals= ts.index(analyzer, forE);
		if(jpanel17!= null) {
			this.jpanel17.verbals= verbals;
			this.jpanel17.keyReleased(null);
		}
		String[] score= new String[copy.size()];
		int[] score_code= new int[copy.size()];
		double []reg= new double[copy.size()];
		int count= 0;
		Map<String, WordFrequency> mapSearchWithoutSort= null;
		Map<Integer, WordFrequency> mapSearchWithSort= null;
		if(dic_map.containsKey(zhongyao.replaceAll(" ", ""))) {
			mapSearchWithoutSort= analyzer.parserMixStringByReturnFrequencyMap(zhongyao);	
		}else {
			if(key.split(" ")[0].length()> 5) {
				mapSearchWithoutSort= analyzer.parserMixStringByReturnFrequencyMap(key);
			}else {
				mapSearchWithoutSort= analyzer.parserMixStringByReturnFrequencyMap(zhongyao);	
			}
		}	
		Iterator<String> iteratorForCopy= copy.iterator();	
		int copyCount= 0;
		while(iteratorForCopy.hasNext()) {
			String iteratorForCopyString= iteratorForCopy.next();
			score[copyCount]= iteratorForCopyString;
			String temps= dic_map.get(iteratorForCopyString).toString();
			String tempsPCA= dic_li.get(iteratorForCopyString).toString();
			Iterator<String> iteratorWordFrequency= mapSearchWithoutSort.keySet().iterator();
			Here:
				while(iteratorWordFrequency.hasNext()) {  
					String mapSearchaAtII = iteratorWordFrequency.next();
					WordFrequency wordFrequencySearch = mapSearchWithoutSort.get(mapSearchaAtII);
					if(temps.contains(mapSearchaAtII)) {
						if(reg[copyCount] == 0){
							count += 1;
						}
						if(score[copyCount].contains(zhongyao.replace(" ", ""))) {
							reg[copyCount]+= 1000;
						}
						score[copyCount]= iteratorForCopyString;
						if(!pos.containsKey(mapSearchaAtII)) {
							reg[copyCount]+= 1;
							score_code[copyCount]+= 1<< mapSearchaAtII.length()
									<< wordFrequencySearch.getFrequency() ;
							if(tempsPCA.contains(mapSearchaAtII)) {
								score_code[copyCount] *= 2;
							}
							if(score[copyCount].contains(mapSearchaAtII)) {
								reg[copyCount]+= 1000;
							}
							continue Here;
						}
						if(pos.get(mapSearchaAtII).contains("��")|| pos.get(mapSearchaAtII).contains("��")
								|| pos.get(mapSearchaAtII).contains("��")|| pos.get(mapSearchaAtII).contains("ν")) {
							reg[copyCount]+= 2;
							if(tempsPCA.contains(mapSearchaAtII)) {
								reg[copyCount]*= 2;
							}
						}
						reg[copyCount] += 1;
						score_code[copyCount] += (iteratorForCopyString.contains(mapSearchaAtII) ? 2 : 1) 
							* (!pos.get(mapSearchaAtII).contains("��") ? pos.get(mapSearchaAtII).contains("��")? 10 : 1 : 150) 
								<< mapSearchaAtII.length() * wordFrequencySearch.getFrequency();
						if(score[copyCount].contains(mapSearchaAtII)) {
							reg[copyCount]+= 1000;
						}
						continue Here;
					}
					if(mapSearchaAtII.length()>1) {
						for(int j=0;j<mapSearchaAtII.length();j++) {
							if(temps.contains(String.valueOf(mapSearchaAtII.charAt(j)))) {
								if(reg[copyCount] == 0){
									count += 1;
								}
								score[copyCount] = iteratorForCopyString;
								score_code[copyCount]+=1;
								if(pos.containsKey(String.valueOf(mapSearchaAtII.charAt(j)))&&(
										pos.get(String.valueOf(mapSearchaAtII.charAt(j))).contains("��")
										||pos.get(String.valueOf(mapSearchaAtII.charAt(j))).contains("��")
										||pos.get(String.valueOf(mapSearchaAtII.charAt(j))).contains("��")
										||pos.get(String.valueOf(mapSearchaAtII.charAt(j))).contains("ν")
										)) {
									reg[copyCount] += 2;
								}
								reg[copyCount] += 1;
								if(score[copyCount].contains(mapSearchaAtII)) {
									reg[copyCount]+= 1000;
								}
								continue Here;
							}
						}
					}
				}
			score_code[copyCount] = score_code[copyCount] * (int)reg[copyCount];
			if(jingmai_filter_box.isSelected()) {
				score_code[copyCount] *= count;	
			}
			copyCount++;
		}
		LABEL2:
			new Quick6DLYGWithStringSwap().sort(score_code, score);
			int max= score_code[0];
			Object[][] tableData= new Object[count][13];
			int new_count = 0;
			newTableModel.getDataVector().clear();
			if(null== key|| key.equals("")) {
				for(int i= 0; i < tableData_old.length; i++) {
					newTableModel.insertRow(i, tableData_old[i]);
				}		
				newTableModel.fireTableDataChanged();	
				return;
			}
			Here:
				for(int i = copy.size()-1; i > -1; i--) {
					if(score_code[i]< 1){
						continue Here;
					}
					if(risk_filter_box.isSelected()) {
						String hai= (dic_hai.get(score[i])==null?"null."
								:dic_hai.get(score[i]).toString().replaceAll("\\s*", "")
								.equalsIgnoreCase("")?"null":dic_hai.get(score[i]).toString()
										.replaceAll("\\s*", ""));
						String temp= name_filter.getText();
						for(int j=0;j<temp.length();j++) {
							if(hai.contains(""+ temp.charAt(j))) {
								continue Here;
							}	
						}
					}
					if(feel_filter_box.isSelected()) {
						String wei= dic_xw.get(score[i]).toString().replaceAll("\\s*", "");
						String temp= name_feel_filter.getText();
						for(int j=0;j<temp.length();j++) {
							if(wei.contains(""+ temp.charAt(j))) {
								continue Here;
							}	
						}
					}
					if(null!= name_filter_not_have.getText()) {
						if(!name_filter_not_have.getText().replace(" ", "").isEmpty()) {
							String wei= dic_jm.get(score[i]).toString().replaceAll("\\s*", "");
							String temp= name_filter_not_have.getText();
							for(int j=0;j<temp.length();j++) {
								if(!wei.contains(""+ temp.charAt(j))) {
									continue Here;
								}	
							}
						}
					}
					if(shuming_filter_box.isSelected()) {
						String wei= score[i];
						String temp= name_filter.getText();
						for(int j=0;j<temp.length();j++) {
							if(wei.contains(""+ temp.charAt(j))) {
								continue Here;
							}	
						}
					}
					String temp= dic_map.get(score[i]).toString();
					if(tableData.length<= new_count) {
						continue Here;
					}
					tableData[new_count]= new Object[]{new_count+1, score_code[i], score[i],
							dic_yw.get(score[i]).toString(),
							dic_li.get(score[i]).toString().replaceAll("\\s*", ""),
							(dic_hai.get(score[i])==null?"����ο��ʼ�ԭ����: ��ҩ���ֶ�, ��ҩ������. ʳ�������, �ڼ��೤��.":dic_hai.get(score[i]).toString().replaceAll("\\s*", "").equalsIgnoreCase("")?"����ο��ʼ�ԭ����":dic_hai.get(score[i]).toString().replaceAll("\\s*", "")), 				
							(dic_yl.get(score[i])==null?"":dic_yl.get(score[i])).toString()
							.replaceAll("\\s*", ""),
							dic_xw.get(score[i]).toString().replaceAll("\\s*", "") ,
							dic_jm.get(score[i]).toString().replaceAll("\\s*", "") ,
							(dic_xz.get(score[i])==null?"":dic_xz.get(score[i])).toString()
							.replaceAll("\\s*", "") , 
							(dic_jj.get(score[i])==null?"":dic_jj.get(score[i])).toString()
							.replaceAll("\\s*", ""), 
							(dic_cy.get(score[i])==null?"":dic_cy.get(score[i])).toString()
							.replaceAll("\\s*", ""),
							(dic_ya.get(score[i])==null?"":dic_ya.get(score[i])).toString()
							.replaceAll("\\s*", "") , 
							(dic_zf.get(score[i])==null?"":dic_zf.get(score[i])).toString()
							.replaceAll("\\s*", ""),
							(dic_cj.get(score[i])==null?"":dic_cj.get(score[i])).toString()
							.replaceAll("\\s*", "")};
					if(zhongyao.contains("�纮")) {
						if(temp.contains("�纮")) {
							newTableModel.insertRow(new_count, tableData[new_count]);
							new_count += 1;
						}
					}else if(zhongyao.contains("����")){
						if(temp.contains("����")) {
							newTableModel.insertRow(new_count, tableData[new_count]);
							new_count += 1;
						}		
					}else {
						newTableModel.insertRow(new_count, tableData[new_count]);
						new_count+=1;
					}		 
				}	
			newTableModel.fireTableDataChanged();				
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//if(arg0.getID())
	}

	public class colorTableRender extends DefaultTableCellRenderer { 
		private static final long serialVersionUID = 1L;
		public Component getTableCellRendererComponent(JTable table,Object value
				, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (isSelected && hasFocus && row == table.getSelectedRow() && column 
					== table.getSelectedColumn()) {
				//2.���õ�ǰCell����ɫ
				Component c = super.getTableCellRendererComponent(table, value, isSelected
						, hasFocus, row, column);
				c.setBackground(Color.CYAN);//���ñ���ɫ
				c.setForeground(Color.gray);//����ǰ��ɫ
				return c;
			} else {
				//3.���õ����У�ż���е���ɫ
				if (row % 3 == 0) {//ż����ʱ����ɫ
					setBackground(new Color(253,233,254));
				}else if (row % 3 == 1) {//���õ����е���ɫ
					setBackground(new Color(233,254,234));
				}else if (row % 3 == 2) {//���õ����е���ɫ
					setBackground(new Color(255,251,232));
				}
				return super.getTableCellRendererComponent(table, value,
						isSelected, hasFocus, row, column);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(zonghe_filter_box.isSelected()) {
			for(int i = 0; i < newTableModel.getRowCount(); i++){
					for(int j = 0; j < newTableModel.getRowCount(); j++){
						if(i!= j) {
							if(newTableModel.getValueAt(i, 5).toString()
									.contains(newTableModel.getValueAt(j, 2).toString())) {
								newTableModel.removeRow(j);
								j-= 1;
							}
						}
					}
				}
			newTableModel.fireTableDataChanged();
		}else {
			this.keyReleased(null);;
		}
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(null!= jp1) {
			jp1.reg= 0;
			if(null!= jp1.waveJpanel) {
				jp1.waveJpanel.reg= 0;	
			}
			this.validate();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				this.validate();
			}
		}
		// TODO Auto-generated method stub
		
	}
}