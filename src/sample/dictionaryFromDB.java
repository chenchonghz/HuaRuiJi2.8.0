package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressWarnings("unused")
public class dictionaryFromDB{	
//	public List<String> dic_list;
//	public Map<String,Object> dic_map;
//	public Map<String,Object> dic_li;
//	public Map<String,Object> dic_hai;
//	public Map<String,Object> dic_xz;
//	public Map<String,Object> dic_xw;
//	public Map<String,Object> dic_jm;
//	public Map<String,Object> dic_ya;
//	public Map<String,Object> dic_cy;
//	public Map<String,Object> dic_cj;
//	public Map<String,Object> dic_jj;
//	public Map<String,Object> dic_zf;
	public List<String> txtToList() throws IOException{
		List<String> dic_list= new ArrayList<>();
	
		return dic_list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public Map<String, Object> listToMap(List<String> dic_list) throws IOException{
		Map<String, Object> dic_map= new ConcurrentHashMap<String, Object>();
		Map<String, Object> map = null;
		//for(int i=0; i<)
		String plsql= "setRoot:C:/DetaDB;" + 
				"baseName:ZYY;" + 
				"tableName:zybc:select;" +
				"condition:or:ID|<=|3000;";
				//"condition:or:ID|==|2;";
		try {
			map= org.plsql.db.plsql.imp.ExecPLSQLImp.ExecPLSQL(plsql, true);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		ArrayList list= (ArrayList) map.get("obj");
		Iterator<HashMap<String, Object>> iterator= list.iterator();
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> listToMap(Map<String, Object> dic_yw, Map<String, Object> dic_li,
			Map<String, Object> dic_hai, Map<String, Object> dic_xz, Map<String, Object> dic_ya, 
			Map<String, Object> dic_jm, Map<String, Object> dic_xw, Map<String, Object> dic_cy, 
			Map<String, Object> dic_jj, Map<String, Object> dic_zf, Map<String, Object> dic_cj, 
			Map<String, Object> dic_yl) {
		Map<String, Object> dic_map= new ConcurrentHashMap<String, Object>();
		Map<String, Object> map = null;
		//for(int i=0; i<)
		String plsql= "setRoot:C:/DetaDB;" + 
				"baseName:ZYY;" + 
				"tableName:zybc:select;" +
				"condition:or:ID|<=|3000;";
				//"condition:or:ID|==|2;";
		try {
			map= org.plsql.db.plsql.imp.ExecPLSQLImp.ExecPLSQL(plsql, true);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		ArrayList list= (ArrayList) map.get("obj");
		Iterator<HashMap<String, Object>> iterator= list.iterator();
		while(iterator.hasNext()) {
			HashMap<String,Object> hashmap= iterator.next();
			StringBuilder stringBuilder=new StringBuilder();
			if(hashmap.containsKey("rowValue")) {
				HashMap<String, Object> rowValue= (HashMap<String, Object>) hashmap.get("rowValue");
				String keyName = null;
				if(rowValue.containsKey("��ҩ����")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("��ҩ����");
					keyName= temp.get("culumnValue").toString();
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("����ҩ")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("����ҩ");
					dic_cj.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("����")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("����");
					dic_zf.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("�ް�")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("�ް�");
					dic_ya.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("��Դ")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("��Դ");
					dic_cy.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("����")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("����");
					dic_jj.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("����")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("����");
					dic_jm.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("��ζ")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("��ζ");
					dic_xw.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("����")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("����");
					dic_yl.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("���չ��")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("���չ��");
					dic_hai.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("��Ч")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("��Ч");
					dic_li.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("�ʼ�ԭ��")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("�ʼ�ԭ��");
					dic_yw.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				if(rowValue.containsKey("��ҽ��ҩ��")) {
					HashMap<String, Object> temp= (HashMap<String, Object>) rowValue.get("��ҽ��ҩ��");
					dic_xz.put(keyName, temp.get("culumnValue").toString().replace("@biky@", ":"));
					stringBuilder.append(temp.get("culumnValue").toString());
				}
				dic_map.put(keyName, stringBuilder.toString().replace("@biky@", ":"));
			}
		}
		return dic_map;
	}	
}