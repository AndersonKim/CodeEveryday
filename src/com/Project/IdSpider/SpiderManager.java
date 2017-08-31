package com.Project.IdSpider;

import java.util.ArrayList;

/**
 * start spider
 * stop spider
 * manage spider,task,visited
 */
public class SpiderManager {

    public void run() {
        InfoPersistence infoPersistence = new InfoPersistence();
        ArrayList<SFZ> sfzArrayList = new ArrayList<SFZ>();
        synchronized (this) {
            //better IO using 5000  cache
            while (sfzArrayList.size() < 5000) {
                InfoSpider infoSpider = new InfoSpider();
                Thread a = new Thread(infoSpider);
                a.run();
                sfzArrayList.addAll(infoSpider.getSfzArrayList());
            }
            infoPersistence.batch(sfzArrayList);
        }


    }
}
