package com.Util;

import java.io.*;
import java.util.ArrayList;

/**
 * 通过遍历指定的根目录获取指定后缀的文件中的敏感词所在的行内容
 * @Title: FileFilter.java 
 * @author yuantao01@wondersgroup.com
 * @date 2017-12-7
 */
public class FileFilter {

	ArrayList<File> targetFiles=new ArrayList<File>();
	/**
	 * 过滤获取指定根目录下的所有的指定后缀字符串的文件
	 * author:yuantao01@wondersgroup.com
	 * time:2017-12-7
	 * @param path	根目录
	 * @param suffix	指定后缀
	 */
	public void traverseFolderWithFilter(String path, String suffix) {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				//System.out.println("文件夹是空的!"); 
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						//System.out.println("文件夹:" + file2.getAbsolutePath());
						traverseFolderWithFilter(file2.getAbsolutePath(),suffix);							
					} else {
//						System.out.println("文件:" + file2.getName());
						if(file2.getName().contains(suffix)){
							targetFiles.add(file2);
						}
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}
	
	public ArrayList<File> getTargetFiles() {
		this.traverseFolderWithFilter("Y:/WondersCode/gsyth/src/com/wondersgroup","Controller");
		return targetFiles;
	}  
	/**
	 * 读取指定文件中的敏感字符所在的行内容
	 * author:yuantao01@wondersgroup.com
	 * time:2017-12-7
	 * @param file
	 * @param mapping
	 */
	public void readFilesOutMapping(File file, String mapping){
        BufferedReader reader = null;
        try {
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	if(tempString.contains(mapping)){
            		System.out.println(tempString);
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
	
	
	
	/**
	 * 获取指定文件夹下的所有以Controller结尾的文件中@RequestMapping所在行的内容
	 * author:yuantao01@wondersgroup.com
	 * time:2017-12-7
	 * @param args
	 */
	public static void main(String[] args){
		FileFilter fileFilter=new FileFilter();
		for(File file:fileFilter.getTargetFiles()){
			fileFilter.readFilesOutMapping(file, "@RequestMapping");
		}
		
	}
}
