package com.dity.springboot.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author:yuhang
 * @Date:2018/7/23
 */
public class Team {
    @NotBlank(message = "组名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String str="s172";
        System.out.println(str.substring(1,4));
    }
}
