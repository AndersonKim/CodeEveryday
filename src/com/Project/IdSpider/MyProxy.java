package com.Project.IdSpider;

import java.io.Serializable;

/**
 * edited by AndersonKim
 * at 2017/9/1
 */
public class MyProxy {
    int id;
    String ip;
    int port;

    public MyProxy(int _id,String _ip,int _port){
        id=_id;
        ip=_ip;
        port=_port;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getKeyName(){
        return "id"+getId();
    }
    public String getKeyValue(){
        return getIp()+":"+getPort();
    }

    @Override
    //return string in this form id1=192.168.1.1:9999
    public String toString() {
        return "id"+id+"="+getIp()+":"+getPort();
    }
}
