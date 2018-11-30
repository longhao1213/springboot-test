package com.gen.model;

import java.util.List;

/**
 * Created by 龙浩 on 2018/7/11.
 */
public class CategoryPo {
    private Integer id;

    private Integer parentId;

    private String name;

    private List<CategoryPo> categoryPoList;

    public List<CategoryPo> getCategoryPoList() {
        return categoryPoList;
    }

    public void setCategoryPoList(List<CategoryPo> categoryPoList) {
        this.categoryPoList = categoryPoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
