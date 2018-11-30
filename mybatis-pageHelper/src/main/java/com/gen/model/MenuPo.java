package com.gen.model;

import java.util.List;

/**
 * Created by 龙浩 on 2018/7/10.
 */
public class MenuPo {
    private String id;

    private String username;

    private String parentId;

    private String url;

    private String icon;

    private Byte ordersort;
    private List<MenuPo> childMenus;

    public List<MenuPo> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuPo> childMenus) {
        this.childMenus = childMenus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Byte getOrdersort() {
        return ordersort;
    }

    public void setOrdersort(Byte ordersort) {
        this.ordersort = ordersort;
    }
}
