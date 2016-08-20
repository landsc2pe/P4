package com.example.homin.p4.base.util;

/**
 * Created by HOMIN on 2016-07-20.
 */
public class ClickEvent {
    ClickEventID id;
    Object[] params;

    public ClickEvent(ClickEventID id, Object... params) {
        this.id = id;
        this.params = params;
    }

    public ClickEventID getId() {
        return id;
    }

    public Object[] getParams() {
        return params;
    }
}
