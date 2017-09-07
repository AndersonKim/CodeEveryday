package com.Project.Pagination;

import com.Project.IdSpider.SFZ;

/**
 * edited by AndersonKim
 * at 2017/9/7
 */
public class XXForm {
    SFZ sfz;
    XXCondition xxCondition=new XXCondition();

    public SFZ getSfz() {
        return sfz;
    }

    public void setSfz(SFZ sfz) {
        this.sfz = sfz;
    }

    public XXCondition getXxCondition() {
        return xxCondition;
    }

    public void setXxCondition(XXCondition xxCondition) {
        this.xxCondition = xxCondition;
    }
}
