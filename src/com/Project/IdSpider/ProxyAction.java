package com.Project.IdSpider;

/**
 * edited by AndersonKim
 * at 2017/9/1
 */


import com.Util.PropertiesUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * get ip proxy from target site also change the proxy to connect site
 * run before spider
 */
public class ProxyAction {
    ArrayList<MyProxy> proxyArrayList = new ArrayList<MyProxy>();
    Properties properties = new Properties();


    public void getProxyAndPort() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.xicidaili.com/nn/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements proxys = doc.select("tr");
        for (int i=1;i<proxys.size();i++){
            Element proxy=proxys.get(i);

            int _id=i;
            String _ip=proxy.child(1).text();
            int _port=Integer.parseInt(proxy.child(2).text());

            proxyArrayList.add(new MyProxy(_id,_ip,_port));
        }
        System.out.println(proxyArrayList.size()+" proxy harvest complete");
    }

    public void setProxyAndPort() {
        for (MyProxy proxy:proxyArrayList){
            PropertiesUtil.writeProperties(proxy.getKeyName(),proxy.getKeyValue());
        }
        System.out.println("proxy config complete");
    }

    @Test
    public void test(){
        getProxyAndPort();
        setProxyAndPort();
    }
}
