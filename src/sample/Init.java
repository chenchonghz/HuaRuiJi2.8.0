package sample;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import org.tinos.engine.analysis.imp.CogsBinaryForestAnalyzerImp;
import org.tinos.engine.base.translator.imp.TranslatorImp;
import org.tinos.vpcs.restServer.restServer;

import comp.jbutton.cfxButton;
import thread.MakeContainerBianJiYe;
import thread.MakeContainerGuJiJingDian;
import thread.MakeContainerHaLiSen;
import thread.MakeContainerQiMenDunJia;
import thread.MakeContainerShuJuFenXi;
import thread.MakeContainerXiYiFuChan;
import thread.MakeContainerXiYiChuFang;
import thread.MakeContainerXiYiJiZhen;
import thread.MakeContainerXiYiNeiKe;
import thread.MakeContainerXiYiWaiKe;
import thread.MakeContainerZhiNengShengZhen;
import thread.MakeContainerZhiNengXiangZhen;
import thread.MakeContainerZhongYiFuChan;
import thread.MakeContainerZhongYiNeiKeFangJi;
import thread.MakeContainerZhongYiWaiShang;
import thread.MakeContainerZhongYiZhenDuan;
import thread.MakeContainerZhongYao;

public class Init{
	public void init(AppBoot appInstance){
		appInstance.analyzer= new CogsBinaryForestAnalyzerImp();
		JTabbedPane jTabbedpane= new JTabbedPane();// ���ѡ������
		try {
			restServer rest= new restServer(appInstance);
			rest.start();
			while(!appInstance.ready) {
				Thread.sleep(3000);
			}
			Thread.sleep(10000);
			appInstance.analyzer.initMixed();
			appInstance.pos= appInstance.analyzer.getPosCnToCn();
			appInstance.pose= appInstance.analyzer.getPosEnToEn();
			appInstance.posec= appInstance.analyzer.getPosEnToCn();
			appInstance.etc= appInstance.analyzer.getEnToCn();
			appInstance.cte= appInstance.analyzer.getFullCnToEn();
			appInstance.posFullec= appInstance.analyzer.getFullEnToCn();
			appInstance.posFullce= appInstance.analyzer.getFullCnToEn();
			appInstance.pinyin= appInstance.analyzer.getPinYin();
			appInstance.ctt= appInstance.analyzer.getCtT();
			appInstance.ctk= appInstance.analyzer.getCtA();
			appInstance.ctr= appInstance.analyzer.getCtR();
			appInstance.ctj= appInstance.analyzer.getCtJ();
			appInstance.ts= new TranslatorImp();
			appInstance.ts.init(appInstance.analyzer);
			appInstance.text= new JTextPane();
			System.setProperty("java.library.path", new File("").getCanonicalPath() + "\node");
			System.out.println(new File("").getCanonicalPath()+ "\node");
			UIManager.put("ScrollBarUI", "org.LYG.GUI.platForm.UnicornScrollBarUI");	
			jTabbedpane.setBounds(0, 60, 1490, 980);
			String[] tabNames= {"��ҩ����", "���ݷ���", "��������", "��������", "���Ŷݼ�", "��ҽ�ڿ�", "��ҽ�ڿƷ���", "��ҽ���", "�ż�����", 
					"��ҽ��ֳ", "��ҽ����", "��ҽ����", "�����", "��ҽ����", "��ҩ����", "�༭ҳ", "����ɭ���ڿ�"};

			appInstance.jsp_name= new JScrollPane(appInstance.name());
			appInstance.jsp_name.setBounds(10+50, 6, 580- 300, 50);
			
			comp.jbutton.DetaButton jlabel_button= new comp.jbutton.DetaButton("��:");
			jlabel_button.setBounds(2, 6, 56, 50);
			jlabel_button.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					if(null== appInstance.frame) {
						appInstance.appSearch= new AppSearch();
						appInstance.appSearch.init(appInstance.name);
						appInstance.appSearch.setBounds(0, 0, 785, 655);
						appInstance.appSearch.setVisible(true);
						appInstance.appSearch.show();
						appInstance.frame= new JFrame("���ӻ���վ V1.1.0");
						//frame.setLayout(null);
						appInstance.frame.setSize(780, 650);
						appInstance.frame.setLocation(300, 300);
						appInstance.frame.setResizable(false);
						appInstance.frame.add(appInstance.appSearch);
						appInstance.frame.setVisible(true);
						appInstance.frame.show();
						appInstance.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
					}else {
						appInstance.frame.setVisible(true);
						appInstance.frame.show();
					}
				}
			});
			//filter
			JLabel jlabel_filter= new JLabel("��������:");  
			jlabel_filter.setForeground(Color.WHITE); 
			jlabel_filter.setBounds(10+350, 6, 100, 25);
			JScrollPane jsp_name_filter= null;
			jsp_name_filter= new JScrollPane(appInstance.name_filter());
			jsp_name_filter.setBounds(30+350+40, 6, 580- 356, 24);
			
			JLabel jlabel_filter_not_have= new JLabel("�йؾ���:");  
			jlabel_filter_not_have.setForeground(Color.WHITE); 
			jlabel_filter_not_have.setBounds(60+15+7+585+ 100, -6, 100, 50);
			//jlabel_filter_not_have.setBounds(10+350, 6+25, 100, 25);
			JScrollPane jsp_name_filter_not_have= null;
			jsp_name_filter_not_have= new JScrollPane(appInstance.name_filter_not_have());
			jsp_name_filter_not_have.setBounds(60+15+30+580+ 100+ 40, 8, 580- 455, 22);	
			//jsp_name_filter_not_have.setBounds(40+350+40, 6+28, 580- 465, 22);
			
			JLabel risk_filter= new JLabel("���չ���:");  
			risk_filter.setForeground(Color.WHITE);
			risk_filter.setBounds(10+350, 20, 100, 50);
			
			JLabel feel_filter= new JLabel("�޹���ζ:"); 
			feel_filter.setForeground(Color.WHITE);
			feel_filter.setBounds(60+15+7+585+ 100, 20, 100, 50);
			
			appInstance.risk_filter_box= new JCheckBox();
			appInstance.risk_filter_box.setBounds(10+350+60, 33, 20, 20);
			JScrollPane jsp_name_feel_filter= null;
			jsp_name_feel_filter= new JScrollPane(appInstance.name_feel_filter());
			jsp_name_feel_filter.setBounds(60+15+30+580+ 100+ 40, 6+28, 580- 455, 22);
			
			
			JLabel jingmai_filter= new JLabel("���Թ۲�:");  
			jingmai_filter.setForeground(Color.WHITE);
			jingmai_filter.setBounds(60+15+7+585, -6, 100, 50);
			//jingmai_filter.setBounds(60+15+7+585+ 100, -6, 100, 50);
			
			JLabel xingwei_filter= new JLabel("��ζ����:");  
			xingwei_filter.setForeground(Color.WHITE); 
			xingwei_filter.setBounds(60+15+7+585, 20, 100, 50);
			
			appInstance.jingmai_filter_box= new JCheckBox();
			appInstance.jingmai_filter_box.setBounds(60+15+30+580+40, 8, 20, 20);
			//jingmai_filter_box.setBounds(60+15+30+580+ 100+ 40, 8, 20, 20);
			appInstance.feel_filter_box= new JCheckBox();
			appInstance.feel_filter_box.setBounds(60+15+30+580+40, 33, 20, 20);
			
			JLabel zonghe_filter= new JLabel("�������:");  
			zonghe_filter.setForeground(Color.WHITE); 
			zonghe_filter.setBounds(50+15+7+485+7, 20, 100, 50);

			JLabel shuming_filter= new JLabel("��������:");  
			shuming_filter.setForeground(Color.WHITE); 
			shuming_filter.setBounds(1+350+100+10, 20, 100, 50);
			
			appInstance.zonghe_filter_box= new JCheckBox();
			appInstance.zonghe_filter_box.setBounds(50+15+7+485+60+7, 33, 20, 20);
			//zonghe_filter_box.setBounds(60+15+30+580+ 200+ 40, 8, 20, 20);
			appInstance.zonghe_filter_box.addActionListener(appInstance);
			appInstance.shuming_filter_box= new JCheckBox();
			appInstance.shuming_filter_box.setBounds(1+350+100+60+10, 33, 20, 20);
		
			JButton addChuFang= new cfxButton("����ҽԺ", 100, 50, Color.red); 
			//addChuFang.setBounds(60+ 760- 100- 50, 6, 100, 50);
			addChuFang.setBounds(50+50+760+130+130-100-50, 6, 100, 50);
			addChuFang.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					String preAdd= "������֢Ԥ���Ƽ���������ҽ���η�������ӵ��ҽʦ�ʸ�֤��Ա���ط������飬����֤�������лл!";
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "���ۺ�֤�������";
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					//��ҽ��ϣ�
					preAdd+= "��ҽ��ϣ�\r\n\r\n";
					for(int i=0;i<5;i++) {
						preAdd+= "֤������"+ (null==appInstance.jpanel8.table.getValueAt(i, 2)?"":appInstance.jpanel8.table.getValueAt(i, 2).toString())
							//	+ "֤�����ݣ�"+	(null==jpanel8.table.getValueAt(i, 5)?"":jpanel8.table.getValueAt(i, 5).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel8.table.getValueAt(i, 1)?"":appInstance.jpanel8.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "�ڿ���ϣ�\r\n\r\n";
					//�ڿƷ�����
					for(int i=0;i<5;i++) {
						preAdd+= "֤������"+ (null==appInstance.jpanel6.table.getValueAt(i, 2)?"":appInstance.jpanel6.table.getValueAt(i, 2).toString())
							//	+ "֤�����壺"+	(null==jpanel6.table.getValueAt(i, 9)?"":jpanel6.table.getValueAt(i, 9).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel6.table.getValueAt(i, 1)?"":appInstance.jpanel6.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "��ҽ��ϣ�\r\n\r\n";
					//��ҽ���
					for(int i=0;i<5;i++) {
						preAdd+= "֤������"+ (null==appInstance.jpanel12.table.getValueAt(i, 2)?"":appInstance.jpanel12.table.getValueAt(i, 2).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel12.table.getValueAt(i, 1)?"":appInstance.jpanel12.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "�����ϣ�\r\n\r\n";
					//��Ʒ�����
					for(int i=0;i<5;i++) {
						preAdd+= "֤�����ݣ�"+ (null==appInstance.jpanel13.table.getValueAt(i, 2)?"":appInstance.jpanel13.table.getValueAt(i, 2).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel13.table.getValueAt(i, 1)?"":appInstance.jpanel13.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "Сר��ϵͳ�����ϣ���ѡ����";
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "������ϣ�\r\n\r\n";
					//���׷�����
					for(int i=0;i<5;i++) {
						preAdd+= "֤�����ݣ�"+ (null==appInstance.jpanel11.table.getValueAt(i, 2)?"":appInstance.jpanel11.table.getValueAt(i, 2).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel11.table.getValueAt(i, 1)?"":appInstance.jpanel11.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					
					preAdd+= "�˿ƣ�\r\n\r\n";
					//�˿Ʒ�����
					for(int i=0;i<5;i++) {
						preAdd+= "֤�����ݣ�"+ (null==appInstance.jpanel14.table.getValueAt(i, 2)?"":appInstance.jpanel14.table.getValueAt(i, 2).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel14.table.getValueAt(i, 1)?"":appInstance.jpanel14.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "����ҽ�����ҩ������򣨿�ѡ����";
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "��ҩ�Ƽ���\r\n\r\n";
					//������
					for(int i=0;i<10;i++) {
						preAdd+= "�Ƽ�����"+ (null==appInstance.jpanel15.table.getValueAt(i, 2)?"":appInstance.jpanel15.table.getValueAt(i, 2).toString())
								+ "��Ӧ���ݣ�"+	(null==appInstance.jpanel15.table.getValueAt(i, 8)?"":appInstance.jpanel15.table.getValueAt(i, 8).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel15.table.getValueAt(i, 1)?"":appInstance.jpanel15.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "�����Ƽ���\r\n\r\n";
					//����������
					for(int i=0;i<5;i++) {
						preAdd+= "�Ƽ�����"+ (null==appInstance.jpanel7.table.getValueAt(i, 2)?"":appInstance.jpanel7.table.getValueAt(i, 2).toString())
								+ "�Ƽ����ݣ�"+(null==appInstance.jpanel7.table.getValueAt(i, 4)?"":appInstance.jpanel7.table.getValueAt(i, 4).toString())
								+ "�����ԣ�"+	(null==appInstance.jpanel7.table.getValueAt(i, 1)?"":appInstance.jpanel7.table.getValueAt(i, 1).toString());
						preAdd+= "\r\n\r\n";
					}
					preAdd+= "\r\n\r\n";
					//
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "������ҩ�Ƽ�����������Ȩ��������ӵ�д���Ȩְҵҩʦ���ط���ҩ����ݲ�������޸ġ�лл!";
					preAdd+= "\r\n\r\n *************************************************\r\n\r\n";
					preAdd+= "\r\n\r\n";
					for(int r= 0; r< (appInstance.newTableModel.getRowCount()< 30? appInstance.newTableModel.getRowCount(): 30); r++) {
						if(appInstance.newTableModel.getValueAt(r, 2)!= null&& !appInstance.newTableModel.getValueAt(r, 2).toString().isEmpty()) {
							preAdd+= appInstance.newTableModel.getValueAt(r, 2);
						}
						preAdd+= "/";
						if(appInstance.newTableModel.getValueAt(r, 6)!= null&&!appInstance.newTableModel.getValueAt(r, 6).toString().isEmpty()) {
							String temp= appInstance.newTableModel.getValueAt(r, 6).toString();
							String value= "";
							for(int i = 0; i < temp.length(); i++){
								if(temp.charAt(i)<128 || temp.charAt(i)=='��') {
									value+=temp.charAt(i);
								}else {
									value+=" ";
								}
							}
							String[] temps = value.replaceAll("\\s+", " ").split(" ");
							if(temps.length>0 && temps[0].split("��").length > 1) {
								value = temps[0].split("��")[1];
								value += "g;";
							}else {
								value = "���������;";
							}
							preAdd += value;
						}else {
							preAdd += "���������;";
						}
						if(r%2!=0) {
							preAdd += "\r\n\r\n";
						}else {
							preAdd += "    ";
						}
					}
					if(appInstance.text.getText().length()< 8000) {
						if(preAdd.length()< 8000) {
							if(!appInstance.text.getText().isEmpty()) {
								appInstance.text.setText(appInstance.text.getText() +"\r\n\r\n"+ preAdd);
							}else {
								appInstance.text.setText(preAdd);
							}
						}
					}
					appInstance.text.validate();
				}
			});

			JButton button2= new cfxButton("��������", 100, 50, Color.cyan); 
			//button2.setBounds(60+ 760+ 130- 100- 50, 6, 100, 50);
			button2.setBounds(30+60+760+130+130+130-100-50, 6, 100, 50);
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String link= "http://tinos.qicp.vip/data.html";
						Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+link);
					} catch (IOException e1) {	
						jTabbedpane.validate();
					}
				}
			});

//			JButton button3= new cfxButton("��ҽ��ѧ", 100, 50, Color.yellow); 
//			button3.setBounds(60+760+130+130-100-50, 6, 100, 50);
//			button3.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//						String link = "http://qkzzs.hnucm.edu.cn/";
//						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+link);
//					} catch (IOException e1) {	
//						jTabbedpane.validate();
//					}
//				}
//			});

//			JButton button4= new cfxButton("��ҽ��ѧԺ",100,50, Color.green); 
//			button4.setBounds(60+760+130+130+130-100-50, 6, 100, 50);
//			button4.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//						String link="http://www.cintcm.com/opencms/opencms/index.html";
//						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+link);
//					} catch (IOException e1) {	
//					}
//				}
//			});

			JButton button5= new cfxButton("����ί",100,50, Color.orange); 
			button5.setBounds(10+70+760+130+130+130+130-100-50, 6, 100, 50);
			button5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String link="http://www.nhc.gov.cn";
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+link);
					} catch (IOException e1) {	
						jTabbedpane.validate();
					}
				}
			});	
			JPanel jp= new JPanel();
			jp.setLayout(null);
			jp.setBounds(0, 0, 1470, 980);
			jp.setBackground(Color.BLACK);
			jp.add(addChuFang);
			jp.add(button2);
			//jp.add(button3);
			//jp.add(button4);
			jp.add(button5);
			jp.add(jlabel_button);
			jp.add(appInstance.jsp_name);
			jp.add(jsp_name_filter);
			jp.add(jlabel_filter);
			jp.add(jsp_name_filter_not_have);
			jp.add(jlabel_filter_not_have);
			jp.add(jTabbedpane);
			jp.add(risk_filter);
			jp.add(feel_filter);
			jp.add(xingwei_filter);
			jp.add(appInstance.risk_filter_box);
			jp.add(jsp_name_feel_filter);
			jp.add(jingmai_filter);
			jp.add(appInstance.feel_filter_box);
			jp.add(appInstance.jingmai_filter_box);
			jp.add(zonghe_filter);
			jp.add(shuming_filter);
			jp.add(appInstance.zonghe_filter_box);
			jp.add(appInstance.shuming_filter_box);
			jp.setPreferredSize(new Dimension(1330, 730+ 40));
			JScrollPane js= new JScrollPane(jp);
			js.setBounds(0, 0, 1335, 730+ 50);	
			appInstance.setLayout(null);  
			appInstance.getContentPane().add(js);
			js.setViewportView(jp);
			appInstance.setBounds(0, 0, 1345, 770+ 25);
			appInstance.setVisible(true);
			Container jpanelFirst= new Container();
			MakeContainerZhongYao c1= null;
			c1= new MakeContainerZhongYao(appInstance.analyzer, jpanelFirst, appInstance, tabNames, appInstance.pos);

			c1.start();
			jTabbedpane.addTab(tabNames[0], new ImageIcon(), jpanelFirst, "first");
			jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0); 
			jTabbedpane.addChangeListener(appInstance);
			Container jpanelSecond= new Container();  
			MakeContainerShuJuFenXi c2=new MakeContainerShuJuFenXi(appInstance.tableData_old, appInstance.text, appInstance.analyzer
					,jpanelSecond, appInstance,jTabbedpane,tabNames, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c2.start();
			Thread.sleep(20);
			Container jpanelThird= new Container();  

			MakeContainerZhiNengXiangZhen c3= new MakeContainerZhiNengXiangZhen(appInstance.analyzer, jpanelThird, appInstance, jTabbedpane, tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c3.start();
			Thread.sleep(20);
			Container jpanelFourth= new Container();
			MakeContainerZhiNengShengZhen c4=new MakeContainerZhiNengShengZhen(appInstance.analyzer,jpanelFourth,appInstance,jTabbedpane, tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c4.start();
			Thread.sleep(20);
			Container jpanel5= new Container();  
			MakeContainerQiMenDunJia c5= new MakeContainerQiMenDunJia(appInstance.analyzer, jpanel5, appInstance, jTabbedpane, tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c5.start();
			Thread.sleep(20);
			MakeContainerXiYiNeiKe c6= new MakeContainerXiYiNeiKe(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c6.start();
			Thread.sleep(20);
			MakeContainerZhongYiNeiKeFangJi c7= new MakeContainerZhongYiNeiKeFangJi(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c7.start();
			Thread.sleep(20);
			MakeContainerZhongYiZhenDuan c8= new MakeContainerZhongYiZhenDuan(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c8.start();
			Thread.sleep(20);
			MakeContainerGuJiJingDian c9= new MakeContainerGuJiJingDian(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c9.start();
			Thread.sleep(20);
			MakeContainerZhongYiFuChan c10= new MakeContainerZhongYiFuChan(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c10.start();
			Thread.sleep(20);
			MakeContainerXiYiFuChan c11= new MakeContainerXiYiFuChan(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c11.start();
			Thread.sleep(20);
			MakeContainerXiYiJiZhen c12= new MakeContainerXiYiJiZhen(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c12.start();
			Thread.sleep(20);
			MakeContainerXiYiWaiKe c13= new MakeContainerXiYiWaiKe(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					,appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c13.start();
			Thread.sleep(20);
			MakeContainerZhongYiWaiShang c14= new MakeContainerZhongYiWaiShang(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c14.start();	
			Thread.sleep(20);
			MakeContainerXiYiChuFang c15= new MakeContainerXiYiChuFang(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					, appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte);
			c15.start();
			Thread.sleep(20);
			MakeContainerBianJiYe c16= new MakeContainerBianJiYe(appInstance.analyzer,appInstance,jTabbedpane,tabNames, appInstance.pos, appInstance.pose, appInstance.etc
					,appInstance.cte,appInstance.pinyin,appInstance.ctj,appInstance.ctt,appInstance.ctk, appInstance.ctr);
			c16.start();	
			Thread.sleep(20);
			MakeContainerHaLiSen c17= new MakeContainerHaLiSen(appInstance.analyzer,appInstance,jTabbedpane,tabNames
					,   appInstance.pos, appInstance.pose, appInstance.etc, appInstance.cte, appInstance.posec, appInstance.posFullec);
			c17.start();
			appInstance.disableCursor= false;
		} catch (IOException | InterruptedException e4) {
			jTabbedpane.validate();
			e4.printStackTrace();
		}
	}
}