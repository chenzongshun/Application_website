package com.shun.dao;

import com.shun.pojo.Ipaddresscount;
import com.shun.pojo.IpaddresscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Ip地址表的方法
 * @author Administrator
 *
 */
public interface IpaddresscountMapper {
    int countByExample(IpaddresscountExample example);

    int deleteByExample(IpaddresscountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Ipaddresscount record);

    int insertSelective(Ipaddresscount record);

    List<Ipaddresscount> selectByExample(IpaddresscountExample example);

    Ipaddresscount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Ipaddresscount record, @Param("example") IpaddresscountExample example);

    int updateByExample(@Param("record") Ipaddresscount record, @Param("example") IpaddresscountExample example);

    int updateByPrimaryKeySelective(Ipaddresscount record);

    int updateByPrimaryKey(Ipaddresscount record);
}
