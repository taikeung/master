package com.andy.domain;

public class User {
    private Long id;

    private String name;

    private Integer age;

    private String pers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPers() {
        return pers;
    }

    public void setPers(String pers) {
        this.pers = pers == null ? null : pers.trim();
    }
}