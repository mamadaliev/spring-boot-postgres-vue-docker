package com.company.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "humans")
public class HumanEntity {

    @Basic
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "nickname")
    private String nickname;

    @Basic
    @Column(name = "age")
    private int age;

    public HumanEntity() {
    }

    public HumanEntity(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
