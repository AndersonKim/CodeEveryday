package com.Project.IdSpider;

import org.junit.Test;

import java.util.ArrayList;

/**
 * start spider
 * stop spider
 * manage spider,task,visited
 */
//todo
public class SpiderManager {
    //how many record can spider hold
    private static final int MAX_RECORD=100;

    public void run() {
        InfoPersistence infoPersistence = new InfoPersistence();
        ArrayList<SFZ> sfzArrayList = new ArrayList<SFZ>();

        synchronized (this) {
            //better IO using MAX_RECORD  cache
            while (sfzArrayList.size() < MAX_RECORD) {
                InfoSpider infoSpider = new InfoSpider();
                Thread a = new Thread(infoSpider);
                a.run();
                sfzArrayList.addAll(infoSpider.getSfzArrayList());
            }
            infoPersistence.batch(sfzArrayList);

        }
    }

    public void __on__(){
        while(true){
            run();
        }
    }
}
