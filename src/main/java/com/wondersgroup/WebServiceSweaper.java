package com.wondersgroup;

import com.Util.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * edited by AndersonKim
 * at 2019/1/18
 * 用于从源码文件中提取出webservice的path路径并根据文件名称归类
 */
public class WebServiceSweaper {
    public List<File> fileList;
    /**
     * edit by AndersonKim
     * @Date：2019/1/18
     * @Description：从根目录的文件中提取webservice的path路径
     * 1.获取文件列表
     * 2.按行读取文件列表读取@path注解关键字
     * 3.读取到关键字的行读取括号匹配中的结果
     */
    public void getWebServicePath(String root){
        //1
        fileList=new ArrayList<File>(Arrays.asList(getFileList(root)));
        //2.3
        for (File file:fileList){
            processFileWithPath(file);
        }



    }

    private void processFileWithPath(File file) {
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private File[] getFileList(String root) {
        File rootFile=new File(root);
        return rootFile.listFiles();
    }
}
