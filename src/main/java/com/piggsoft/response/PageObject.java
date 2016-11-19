package com.piggsoft.response;

import java.util.List;

/**
 * Created by piggs on 2016/10/23.
 */
public class PageObject {
    private long count;
    private List<Object> items;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
}
