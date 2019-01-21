package com.wondersgroup;

import com.Util.FileHandler;
import org.junit.Test;

import java.io.*;
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
            System.out.println(file.getName());
            processFileWithPath(file);
        }



    }

    /**
     * edit by AndersonKim
     * @Date：2019/1/21
     * @Description：读取输入文件的每行的内容并将@Path的内容提取出来
     */
    private void processFileWithPath(File file) {
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while(true) {
                String nextLine=bufferedReader.readLine();
                if(nextLine==null)
                    break;
                //System.out.println("got:"+nextLine);
                webServiceLineFilter(nextLine);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * edit by AndersonKim
     * @Date：2019/1/21
     * @Description：将改行中@Path的路由输出
     */
    private void webServiceLineFilter(String nextLine) {
        if(nextLine.contains("@Path(\"")){
            int firstPos=nextLine.indexOf("\"");
            int lastPos=nextLine.lastIndexOf("\"");
            System.out.println(nextLine.substring(firstPos+1,lastPos));
        }
    }

    @Test
    public void testProcessFileWithPath() {
        WebServiceSweaper webServiceSweaper=new WebServiceSweaper();
        webServiceSweaper.getWebServicePath("filpath");

    }

    /**
     * edit by AndersonKim
     * @Date：2019/1/21
     * @Description：获取指定文件夹中的所有webservice的Java原文件
     */
    private File[] getFileList(String root) {
        File rootFile=new File(root);
        return rootFile.listFiles();
    }
}
