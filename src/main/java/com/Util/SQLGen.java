package com.Util;

import org.junit.Test;

/**
 * 用于生成常见的sql，结合行政区划代码比对类(CompareCode)使用
 */
public class SQLGen {
    //INSERT INTO "DIC"."DIC_BUSINESS_CATEGORY"("BUSINESS_CODE", "BUSINESS_NAME")
    //VALUES('123', '123')
    //GO

    /**
     * 插入数据
     * @param tableName 目标表
     * @param columnNames 目标字段
     * @param params 目标字段对应的值
     * @return
     */
    public String insert(String tableName, String[] columnNames, String[] params){
        StringBuffer buffer=new StringBuffer();
        buffer.append("INSERT INTO "+tableName.toUpperCase()+"(");
        //设置插入的列
        for(String col:columnNames){
            buffer.append("\""+col.toUpperCase()+"\",");
        }
        buffer.delete(buffer.length()-1,buffer.length());
        buffer.append(")\n");
        buffer.append("VALUES(");
        //设置插入的值
        for(String param:params){
            buffer.append("\'"+param+"\',");
        }
        buffer.delete(buffer.length()-1,buffer.length());
        buffer.append(")\n");
        buffer.append("GO\n");
        return buffer.toString();
    }

    //UPDATE "DIC"."DIC_BUSINESS_CATEGORY"
    //SET "BUSINESS_NAME"='种植养殖类1'
    //WHERE "BUSINESS_CODE"='0110'
    //GO

    /**
     * 使用指定字段更新值
     * @param tableName 表名
     * @param pk 主键名称
     * @param pkValue 主键值
     * @param col 更新字段名称
     * @param colValue 更新字段值
     * @return
     */
    public String update(String tableName, String pk, String pkValue, String col, String colValue){
        StringBuffer buffer=new StringBuffer();
        buffer.append("UPDATE "+tableName.toUpperCase()+" \n");
        buffer.append("SET "+"\""+col.toUpperCase()+"\"="+"\'"+colValue+"\'"+"\n");
        buffer.append("WHERE "+"\""+pk.toUpperCase()+"\"="+"\'"+pkValue+"\'"+"\n");
        buffer.append("GO\n");
        return buffer.toString();
    }
    //DELETE FROM "DIC"."DIC_BUSINESS_CATEGORY"
    //WHERE "BUSINESS_CODE"='0120'
    //GO

    /**
     * 删除指定记录
     * @param tableName 表名
     * @param pk 主键名称
     * @param pkValue 主键值
     * @return
     */
    public String delete(String tableName, String pk, String pkValue){
        StringBuffer buffer=new StringBuffer();
        buffer.append("DELETE FROM "+tableName.toUpperCase()+" \n");
        buffer.append("WHERE "+"\""+pk.toUpperCase()+"\"="+"\'"+pkValue+"\'"+"\n");
        buffer.append("GO\n");
        return buffer.toString();
    }

    @Test
    public void testInsert(){
        String[] col={"id","name","iftop","valid"};
        //注意：若id以00结尾iftop为0
        String[] parms={"532600","文山州商务局","1","1"};
        String string=insert("dic.dic_stadep",col,parms);
        System.out.println(string);

    }
}
