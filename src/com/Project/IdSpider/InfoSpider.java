package com.Project.IdSpider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * get info into object of SFZ
 * 1.get info from web
 * 2.put info inti object
 */
public class InfoSpider {
    /**
     * harvest the info into object list
     *
     * @return
     * @throws IOException
     */
    public ArrayList<SFZ> getWebInfo() throws IOException {
        ArrayList<SFZ> SFZList = new ArrayList<SFZ>();
        Document doc = Jsoup.connect("http://i.8684.com/").get();
        String title = doc.title();
        System.out.println("reaching:" + title);

        //get all sensitive data
        Elements tables = doc.select("tr.date_tr2");

        for (Element each : tables) {
            //get info from each node
            String nameAndId = String.valueOf(each.childNode(0).childNode(0));
            String[] mix = nameAndId.split(" ");
            String name = mix[0];
            String id = mix[1];
            String sex = String.valueOf(each.childNode(1).childNode(0));
            String age = String.valueOf(each.childNode(2).childNode(0));
            String location = String.valueOf(each.childNode(3).childNode(0).childNode(0));

            System.out.println(": " + name + "'s info get complete.");
            SFZList.add(new SFZ(name, id, sex, Integer.parseInt(age), location));

        }
        return SFZList;
    }

    @Test
    public void test() throws IOException {
        InfoSpider i = new InfoSpider();
        ArrayList<SFZ> a = i.getWebInfo();
        System.out.println(a.size());
    }
}
