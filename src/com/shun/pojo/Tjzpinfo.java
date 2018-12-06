package com.shun.pojo;

import java.io.Serializable;

/**
 * 评价建议表
 * @author Administrator
 *
 */
public class Tjzpinfo implements Serializable {
    private Integer id;

    private Long ipid;

    private String name;

    private String phone;

    private String email;

    private String createdate;

    private String jianyi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIpid() {
        return ipid;
    }

    public void setIpid(Long ipid) {
        this.ipid = ipid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getJianyi() {
        return jianyi;
    }

    public void setJianyi(String jianyi) {
        this.jianyi = jianyi == null ? null : jianyi.trim();
    }
}
