package com.Util;

import java.util.Map;

/**
 * edited by AndersonKim
 * at 2019/3/19
 */
public class CollectionsUtils {

    //根据value值获取map中对应的key值
    public static Object getKeyFromValue(Map map, String value){
        for(Object key:map.keySet()){
            if(map.get(key).equals(value)){
                return key;
            }
        }
        return null;
    }

    //根据值从map中删除对应的key记录
    public static void removeFromMap(Map map, String value){
        for(Object key:map.keySet()){
            if(map.get(key).equals(value)){
                map.remove(key);
            }
        }
    }
}
