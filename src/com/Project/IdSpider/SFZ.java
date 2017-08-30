package com.Project.IdSpider;

/**
 * bean for id of PRC
 */
public class SFZ {
    String name;
    String id;
    String sex;
    int age;
    String location;

    public SFZ(String name, String id, String sex, int age, String location) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
