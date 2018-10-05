package com.xiaowu.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoCode
 * @since 2018-10-05
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String groupname;

    private String company;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Users{" +
        "id=" + id +
        ", username=" + username +
        ", groupname=" + groupname +
        ", company=" + company +
        "}";
    }
}
