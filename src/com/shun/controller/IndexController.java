package com.shun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shun.dao.IpaddresscountMapper;
import com.shun.pojo.Ipaddresscount;
import com.shun.pojo.IpaddresscountExample;
import com.shun.pojo.IpaddresscountExample.Criteria;
import com.shun.pojo.Tjzpinfo;
import com.shun.service.TjzpinfoService;
import com.shun.utils.ObjUtils;

/**
* @author czs
* @version 创建时间：2018年6月22日 下午11:05:28 
*/
@Controller
public class IndexController {
	
	@Autowired
	private TjzpinfoService tjzpinfoService;
	@Autowired
	private IpaddresscountMapper ipaddresscountMapper;

	/**
	 * 访问首页
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request){
//		IP记录异常，并且IP记录了没有人来提意见啥的，就做个静态网站好了
		jlip(request);
		return "index";
	}
	
	/**
	 * 招聘方提交的信息
	 * @return
	 */
	@RequestMapping("tjzpfxx")
	public void tjzpfxx(Tjzpinfo tjzpinfo,HttpServletRequest reqest){
		Long ipid = (Long) reqest.getSession().getAttribute("ipid");
		tjzpinfo.setIpid(ipid);
		tjzpinfo.setCreatedate(ObjUtils.getCurrentDateTime());
		tjzpinfoService.insertTjzpinfo(tjzpinfo);
	}
	
	/**
	 * 访问网站的人留下的建议
	 * @return
	 */
	@RequestMapping("tjjy")
	public void tjjy(HttpServletRequest reqest,String yijian){
		Long ipid = (Long) reqest.getSession().getAttribute("ipid");
		tjzpinfoService.insertJy(ipid, yijian);
	}
	
	/*
	 * 记录ip地址
	 */
	public void jlip(HttpServletRequest request){
		// 记录当前访问者的ip地址
		String currentIpAddress = request.getRemoteAddr();
		// 格式化本机访问地址，适用于windows环境下
		if (currentIpAddress.equals("0:0:0:0:0:0:0:1")) {
			currentIpAddress = "127.0.0.1";
		}

		// 根据ip获得真实的地址
//		GetClientIpAddress getClientIpAddress = new GetClientIpAddress(currentIpAddress);
//		String address = getClientIpAddress.getAddress();
		String address = ObjUtils.getTrueIpAddrees(currentIpAddress);
				
		// 获取最新的时间
		String currentDate = ObjUtils.getCurrentDateTime();
		// 是不是手机在访问？
		boolean mobileDevice = ObjUtils.isMobileDevice(request);		

		// 创建查询条件，查看是否有对应的IP已经记录在了数据库
		IpaddresscountExample example = new IpaddresscountExample();
		Criteria criteria = example.createCriteria();
		criteria.andIpEqualTo(currentIpAddress);
		// 查询数据库
		List<Ipaddresscount> ipaddresscounts = ipaddresscountMapper.selectByExample(example);
		// 如果查询记录不空，并且记录大于0，说明ip和地址记录存在，存在就需要就加一个访问量
		if (ipaddresscounts != null && ipaddresscounts.size() > 0) {
			for (Ipaddresscount ipaddresscount : ipaddresscounts) {
				ipaddresscount.setTotal(ipaddresscount.getTotal() + 1); // 更新访问次数
				ipaddresscount.setAccesstime(currentDate);// 更新访问
				ipaddresscount.setIsmobil(mobileDevice ? "是" : "否");
				ipaddresscountMapper.updateByPrimaryKey(ipaddresscount);
			}
		} else {
			// 封装字段开始插入新的IP记录到数据库
			Ipaddresscount ipaddresscount = new Ipaddresscount();
			ipaddresscount.setIp(currentIpAddress);
			ipaddresscount.setAddress(address);
			ipaddresscount.setAccesstime(currentDate);
			ipaddresscount.setTotal(1);
			ipaddresscount.setIsmobil(mobileDevice ? "是" : "否");
			ipaddresscountMapper.insert(ipaddresscount);
		}
		HttpSession session = request.getSession();
		session.setAttribute("ipid", currentIpAddress);
	}
}
