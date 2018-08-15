package com.dity.springboot.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author:yuhang
 * @Date:2018/7/23
 */
public class Emp {

    @NotBlank(message = "name不能为null",groups = Adult.class)
    private String name;

//    @NotBlank(message = "sex不能为空")
    private String sex;

//    @Email()
    private String email;

//    @Digits(integer = 0,fraction = 150,message = "年龄不符合规范")
    private Integer age;

//    @Past(message = "生日只能是过去")
    private Date birth;


    /**
     * 引入对象时 要想对象的校验生效 需要加@Valid
     */
    @NotNull(message = "team不能为空")
    @Valid
    private Team team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    public interface Adult{}

    public interface Minor{}
}
