package com.shun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shun.dao.TjzpinfoMapper;
import com.shun.pojo.Tjzpinfo;
import com.shun.utils.ObjUtils;

/**
* @author czs
* @version 创建时间：2018年6月23日 下午12:57:59 
*/
@Service
public class TjzpinfoService {

	@Autowired
	private TjzpinfoMapper tjzpinfoMapper;
	
	/**
	 * 添加一个招聘者发来的信息
	 * @param tjzpinfo
	 */
	public void insertTjzpinfo(Tjzpinfo tjzpinfo){
		tjzpinfoMapper.insert(tjzpinfo);
	}

	/**
	 * 添加建议一个
	 * @param ipid 列表中访问过的ip的id
	 * @param jy 对方发来的建议
	 */
	public void insertJy(Long ipid, String jy) {
		// 取出对应的记录
		Tjzpinfo tjzpinfo = tjzpinfoMapper.selectByPrimaryKey(new Integer(ipid.intValue()));
		// 如果记录不为空就直接插入
		if (tjzpinfo != null) {
			tjzpinfo.setJianyi(jy);
			// 更新时间
			tjzpinfo.setCreatedate(ObjUtils.getCurrentDateTime());
			tjzpinfoMapper.updateByPrimaryKey(tjzpinfo);
			return;
		}
		// 如果记录为空就造一个 
		tjzpinfo = new Tjzpinfo();
		// 填充字段
		tjzpinfo.setCreatedate(ObjUtils.getCurrentDateTime());
		tjzpinfo.setIpid(ipid);
		tjzpinfo.setJianyi(jy);
		tjzpinfoMapper.insert(tjzpinfo);
	}
}
