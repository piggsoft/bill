package com.piggsoft.request;

import java.util.Date;

/**
 * Created by piggs on 2016/11/15.
 */
public class BillSearchRequest {

    /**
     * 搜索日期
     */
    private Date date;
    /**
     * 日期类型，1-天，2-周, 3-月，4-季度，5-年
     */
    private int type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
