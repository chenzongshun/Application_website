package com.shun.pojo;

import java.io.Serializable;

/**
* @author czs
* @version 创建时间：2018年11月5日 下午4:16:20 
*/
public class IP地址格式化BEAN implements Serializable {

	@Override
	public String toString() {
		return "IP地址格式化BEAN [country=" + country + ", region=" + region + ", city=" + city + ", isp=" + isp + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
	private String region;
	private String city;
	private String isp;

	/**
	 * 国家
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 国家
	 * @return
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 省份
	 * @return
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * 省份
	 * @return
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * 城市
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 城市
	 * @return
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 运营商
	 * @return
	 */
	public String getIsp() {
		return isp;
	}

	/**
	 * 运营商
	 * @return
	 */
	public void setIsp(String isp) {
		this.isp = isp;
	}

}
