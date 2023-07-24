package org.luna.bean;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String profile;
    private int root;
    private int sex;

    public User() {
    }

    public User(int id, String name, String password, String profile, int root, int sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.profile = profile;
        this.root = root;
        this.sex = sex;
    }

    public User(String name, String password, String profile, int root, int sex) {
        this.name = name;
        this.password = password;
        this.profile = profile;
        this.root = root;
        this.sex = sex;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
