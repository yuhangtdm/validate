package com.dity.springboot.entity;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author:yuhang
 * @Date:2018/9/18
 */
public class User implements Serializable {

    private Long id;

    private String name;

    private String[] loves;

    private Team team;

    private Woman[] women;

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
        this.name = name;
    }

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Woman[] getWomen() {
        return women;
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loves=" + Arrays.toString(loves) +
                '}';
    }
}
