package com.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * edit by AndersonKim
 * @Date：2019/3/18
 * @Description：用于比较旧的行政区划代码和现有的新行政区划代码之间的区别
 */
public class CompareCode {
    //需要比对的行政区划开头代码，四川是51，贵州是52，云南53
	private static String areaCode="53";
	//新行政区划代码
	private static Map<String,String> newCode=new HashMap<String,String>();
	//旧的行政区划代码
	private static Map<String,String> oldCode=new HashMap<String,String>();

	//使用代码作为主键的增加的行政区划代码
	private static Map<String,String> addCode=new HashMap<String,String>();
	//使用代码作为主键的修改名称的行政区划
	private static Map<String,String> modCode=new HashMap<String,String>();
	//使用代码作为主键的删除的行政区划
	private static Map<String,String> delCode=new HashMap<String,String>();

    //使用名称作为主键的变更代码的行政区划
    private static Map<String,String> modCodeDis=new HashMap<String,String>();
    //使用名称作为主键的变更代码以及名称的行政区划
    private static Map<String,String> modNameCodeDis=new HashMap<String,String>();




    /**
	 * edit by AndersonKim
	 * @Date：2019/3/18
	 * @Description：从文件中读取行政区划的代码并载入到map中
	 */
	public static void loadDataFromFile(String file1, Map<String,String> data){
        File file = new File(file1);
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String[] array=tempString.split(",");
                //只比对县级以上的代码以及名称
                if(array[0].length()==6){
                    data.put(array[0].trim(),array[1].trim());
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

	public static void main(String[] args){
        //loadDataFromFile("C://Users//yuantao01//Desktop//2019年3月15日-dic数据库行政区划代码更新//gz-n.txt",oldCode);
        loadDataFromFile("C://Users//Anderson//Desktop//2019年6月10日-云南DIC更新/yn-w.txt",oldCode);
        loadDataFromFile("C://Users//Anderson//Desktop//2019年6月10日-云南DIC更新/new.txt",newCode);
		compare();
		System.out.println("增加的区县（"+areaCode+"开头的）有"+addCode.size()+"个:\n"+addCode.toString());
		//printCode(addCode);
        System.out.println("删除的区县（"+areaCode+"开头的）有"+delCode.size()+"个:\n"+delCode.toString());
        //printCode(delCode);
        System.out.println("修改名称的区县（"+areaCode+"开头的）有"+modCode.size()+"个:\n"+modCode.toString());
		//printCode(modCode);
        System.out.println("变更代码的区县（"+areaCode+"开头的）有"+modCodeDis.size()+"个:\n"+modCodeDis.toString());
		//System.out.println("变更名称以及代码的区县（"+areaCode+"开头的）有"+modNameCodeDis.size()+"个:\n"+modNameCodeDis.toString());

        SQLGen sqlGen=new SQLGen();
        String tableName="dic.dic_stadep";
        String[] col={"id","name","iftop","valid"};
        //增加的sql
        for(String s:addCode.keySet()){
            String sql = sqlGen.insert(
                    tableName,
                    col,
                    //最后结尾为0000的才设置为iftop为0
                    new String[]{s,addCode.get(s),s.endsWith("0000")?"0":"1","1"}
                    );
            System.out.println(sql);
        }
        //删除的sql
        String pk="id";
        for(String s:delCode.keySet()){
            String sql = sqlGen.delete(tableName,pk,s);
            System.out.println(sql);
        }
        //修改名称的sql
        String colName="name";
        for(String s:modCode.keySet()){
            String[] afterStr=modCode.get(s).split("改为");
            String sql = sqlGen.update(tableName,pk,s,colName,afterStr[1].trim());
            System.out.println(sql);
        }
        //修改代码的sql
        colName="id";
        for(String s:modCodeDis.keySet()){
            //修改代码的sql需要将key值区分
            String[] afterCode=s.split("->");
            String sql = sqlGen.update(tableName,pk,afterCode[0].trim(),colName,afterCode[1].trim());
            System.out.println(sql);
        }
	}

	private static void printCode(Map<String, String> addCode2) {
		System.out.println("______________________");
		for(String key:addCode2.keySet()){
			System.out.println("'"+key+"',");
		}
		
	}
	/**
	 * edit by AndersonKim
	 * @Date：2019/3/19
	 * @Description：比较两个文件中的行政区划代码
	 */
	private static void compare() {

		//addCode：行政代码为主键，新的行政代码文本中有，旧的没有，是为新增的行政区划
		for(String key:newCode.keySet()){
			if(!oldCode.containsKey(key)){
				if(key.startsWith(areaCode)){
				    //云南的行政区划代码长度和其他各地不一致，需要在全国标准的后面加上00
					addCode.put(key+"00", newCode.get(key));
				}
			}
		}
		//modCode：行政代码作为主键，新老行政代码中有，但是名称不一样，是为行政区划名称修改
		for(String key:newCode.keySet()){
			if(oldCode.containsKey(key)){
				if(!(oldCode.get(key).equals(newCode.get(key)))){
					if(key.startsWith(areaCode)){
					    modCode.put(key+"00", "从 "+oldCode.get(key)+" 改为  "+newCode.get(key));
					}
				}
			}
		}
		//delCode：行政代码作为主键，旧的行政代码中有，新的没有，是为删除的行政区划
		for(String key:oldCode.keySet()){
			if(!newCode.containsKey(key)){
				if(key.startsWith(areaCode)){
				    delCode.put(key+"00",oldCode.get(key));
				}
			}
		}

        //version1 逻辑
		//modCodeDis：增加中有的，在删除中查询是否有对应的，
        // 名称相同就是变更了代码，名称前两个字相同就是变更代码以及名称的
        ArrayList<String> removeAddList=new ArrayList<String>();
        ArrayList<String> removeDelList=new ArrayList<String>();
        for(String key:addCode.keySet()){
            if(delCode.containsValue(addCode.get(key))){
                //删除的行政区划中有一样的值，需要删除冗余
				String formerCode=String.valueOf(CollectionsUtils.getKeyFromValue(delCode,addCode.get(key)));
                modCodeDis.put(formerCode+"->"+key,addCode.get(key));
                //从增加的行政区划以及删除的行政区划中移除该部分
                removeAddList.add(key);
                removeDelList.add(String.valueOf(CollectionsUtils.getKeyFromValue(delCode,addCode.get(key))));
            }else{
                //前两个字是一致的但是代码不同
                String pre2StrName=addCode.get(key).substring(0,2);
                for(String str:delCode.keySet()){
                    if(pre2StrName.equals(delCode.get(str).substring(0,2))&&!str.equals(key)){
                        modNameCodeDis.put(str+"->"+key,delCode.get(str)+"->"+addCode.get(key));
                        removeAddList.add(key);
                        removeDelList.add(str);
                    }
                }
            }
        }


        //删除掉新增以及删除的冗余的行政区划代码
        for(String key:removeAddList){
            addCode.remove(key);
        }
        for(String key:removeDelList){
            delCode.remove(key);
        }

        //version2 逻辑


    }
}
