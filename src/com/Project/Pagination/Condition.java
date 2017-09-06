package com.Project.Pagination;

/**
 * edited by AndersonKim
 * at 2017/9/6
 */

/**
 * 分页条件
 */
public class Condition {
    int current=1;
    int size=10;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
