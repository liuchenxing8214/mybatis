package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {

    private static final long serialVersionUID = 1329583632038623746L;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
