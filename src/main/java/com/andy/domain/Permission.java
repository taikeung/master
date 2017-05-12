package com.andy.domain;

public class Permission {
    private Long id;

    private String perCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode == null ? null : perCode.trim();
    }
}