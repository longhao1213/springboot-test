package com.lh.model;

public class Role {
    private Integer rId;

    private String rDescription;

    private String rKeyword;

    private String rName;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }

    public String getrKeyword() {
        return rKeyword;
    }

    public void setrKeyword(String rKeyword) {
        this.rKeyword = rKeyword == null ? null : rKeyword.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }
}