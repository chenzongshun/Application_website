package com.shun.pojo;

import java.io.Serializable;

/**
 * IP地址统计表
 * @author Administrator
 *
 */
public class Ipaddresscount implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String ip;

    private String address;

    private String accesstime;

    private String ismobil;

    private Integer total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(String accesstime) {
        this.accesstime = accesstime == null ? null : accesstime.trim();
    }

    public String getIsmobil() {
        return ismobil;
    }

    public void setIsmobil(String ismobil) {
        this.ismobil = ismobil == null ? null : ismobil.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
