package com.Util;
import org.junit.Test;

import java.util.ArrayList;

//gen simple data for ztree
public class JsonGen {
    public String genJsonStr() {
        JsonNode a = new JsonNode("A", true, true);
        a.children = new ArrayList<JsonNode>();
        a.children.add(new JsonNode("A-1", false, false));
        a.children.add(new JsonNode("A-2", false, false));
        a.children.add(new JsonNode("A-3", false, false));
        a.children.add(new JsonNode("A-4", false, false));
        a.children.add(new JsonNode("A-5", false, false));
        a.children.add(new JsonNode("A-6", false, false));
        a.children.add(new JsonNode("A-7", false, false));
        a.children.add(new JsonNode("A-8", false, false));
        return a.toString();


    }

    @Test
    public void test() {
        JsonGen a = new JsonGen();
        System.out.println(a.genJsonStr());
    }
}

class JsonNode {
    public String name;
    public Boolean open;
    public Boolean parent;
    public ArrayList<JsonNode> children;

    public JsonNode(String name, Boolean open, Boolean parent) {
        this.name = name;
        this.open = open;
        this.parent = parent;
    }

    public JsonNode() {

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        //using \" represent " in java String
        sb.append("{name:\"" + name + "\", isParent:" + parent + ",open:" + open);

        if (children.size() > 0) {
            sb.append(",children:");
            //formating children string
            StringBuffer childStr = new StringBuffer();
            for (JsonNode child : children) {
                childStr.append("{name:\"" + child.name + "\"},");
            }
            childStr.insert(0, "[");
            int lastQutoPos = childStr.lastIndexOf(",");
            childStr.deleteCharAt(lastQutoPos);
            childStr.append("]");
            sb.append(childStr);
        }
        sb.append("}");


        return sb.toString();
    }


}
