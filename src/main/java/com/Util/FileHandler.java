package com.Util;

import java.io.File;
import java.util.ArrayList;

public class FileHandler {

    public static void main(String [] args){
        FileHandler.recursiveFiles("");
    }

    /**
     * 获取指定路径下的所有文件的名称
     * @param path
     * @return
     */
    public static ArrayList<String> getFiles(String path){
        ArrayList<String> files=new ArrayList<String>();
        File file=new File(path);
        File[] tempList=file.listFiles();
        for(int i=0;i<tempList.length;i++){
            if(tempList[i].isFile()){
                System.out.println("文    件："+tempList[i]);
                files.add(tempList[i].toString());
            }
            if(tempList[i].isDirectory()){
                System.out.println("文   件   夹："+tempList[i]);
            }
        }
        return files;
    }

    /**
     * 遍历文件夹中的所有文件：包括子目录
     * @param path
     */
    private static void recursiveFiles(String path){
        // 创建 File对象
        File file = new File(path);
        // 取 文件/文件夹
        File files[] = file.listFiles();
        // 对象为空 直接返回
        if(files == null){
            return;
        }
        // 目录下文件
        if(files.length == 0){
            System.out.println(path + "该文件夹下没有文件");
        }
        // 存在文件 遍历 判断
        for (File f : files) {
            // 判断是否为 文件夹
            if(f.isDirectory()){
                //System.out.print("文件夹: ");
                //System.out.println(f.getAbsolutePath());
                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath());
                // 判断是否为 文件
            } else if(f.isFile()){
                //对文件进行过滤
                if(notUseful(f)){
                    continue;
                }else if(true){
                    //System.out.print("文件: ");
                    //System.out.println(f.getAbsolutePath());
                    String fileAbsPath=f.getAbsolutePath();
                    boolean monthHaveDotInDay=true;
                    String year="";
                    String month="";
                    String day="";
                    if(fileAbsPath.substring(fileAbsPath.indexOf("月")+4,fileAbsPath.indexOf("月")+5).equals(".")){
                        monthHaveDotInDay=true;
                    }else{
                        monthHaveDotInDay=false;
                    }
                    year=fileAbsPath.substring(fileAbsPath.indexOf("年")-4,fileAbsPath.indexOf("年"));
                    month=fileAbsPath.substring(fileAbsPath.indexOf("月")-2,fileAbsPath.indexOf("月"));
                    if(monthHaveDotInDay){
                        day= fileAbsPath.substring(fileAbsPath.indexOf("月")+5,fileAbsPath.indexOf("月")+7);
                    }else{
                        day= fileAbsPath.substring(fileAbsPath.indexOf("月")+4,fileAbsPath.indexOf("月")+6);

                    }

                    String time=year+"年"+month+"月"+day+"日";
                    String subject=fileAbsPath.substring(fileAbsPath.lastIndexOf("\\")+1,fileAbsPath.lastIndexOf("."));

                    System.out.println(time+"\t"+subject);
                }
            } else {
                System.out.print("未知错误文件");
            }
        }
    }
    private static boolean notUseful(File file){
        if(file.getAbsolutePath().endsWith(".mp3"))
            return true;
        else
            return false;
    }

}
