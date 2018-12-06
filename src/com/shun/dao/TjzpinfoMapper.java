package com.shun.dao;

import com.shun.pojo.Tjzpinfo;
import com.shun.pojo.TjzpinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TjzpinfoMapper {
    int countByExample(TjzpinfoExample example);

    int deleteByExample(TjzpinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tjzpinfo record);

    int insertSelective(Tjzpinfo record);

    List<Tjzpinfo> selectByExample(TjzpinfoExample example);

    Tjzpinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tjzpinfo record, @Param("example") TjzpinfoExample example);

    int updateByExample(@Param("record") Tjzpinfo record, @Param("example") TjzpinfoExample example);

    int updateByPrimaryKeySelective(Tjzpinfo record);

    int updateByPrimaryKey(Tjzpinfo record);
}
