package com.Project.IdSpider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * get info into object of SFZ
 * 1.get info from web
 * 2.put info inti object
 */
public class InfoSpider implements Runnable {
    private ArrayList<SFZ> sfzArrayList = null;
    private InfoPersistence infoPersistence = null;

    public InfoSpider() {

    }

    public InfoSpider(InfoPersistence _infoPersistence) {
        this.infoPersistence = _infoPersistence;
    }

    public InfoSpider(ArrayList<SFZ> _sfzArrayList) {
        this.sfzArrayList = _sfzArrayList;
    }

    @Override
    public void run() {
        getWebInfo();
    }
    /**
     * harvest the info into object list
     *
     * @return
     * @throws IOException
     */
    private synchronized void getWebInfo() {
        sfzArrayList = new ArrayList<SFZ>();
        Document doc = null;
        try {
            doc = Jsoup.connect("http://i.8684.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String title = doc.title();
        //System.out.println("reaching:" + title);

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

            //System.out.println(": " + name + "'s info get complete.");
            sfzArrayList.add(new SFZ(name, id, sex, Integer.parseInt(age), location));

        }
    }


    public ArrayList<SFZ> getSfzArrayList() {
        return sfzArrayList;
    }
}
