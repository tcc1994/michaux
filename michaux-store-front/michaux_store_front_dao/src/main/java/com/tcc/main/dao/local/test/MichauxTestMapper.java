package com.tcc.main.dao.local.test;

import com.tcc.main.domain.local.test.MichauxTest;
import com.tcc.main.domain.local.test.MichauxTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MichauxTestMapper {
    int countByExample(MichauxTestExample example);

    int deleteByExample(MichauxTestExample example);

    int deleteByPrimaryKey(Long mtId);

    int insert(MichauxTest record);

    int insertSelective(MichauxTest record);

    List<MichauxTest> selectByExample(MichauxTestExample example);

    MichauxTest selectByPrimaryKey(Long mtId);

    int updateByExampleSelective(@Param("record") MichauxTest record, @Param("example") MichauxTestExample example);

    int updateByExample(@Param("record") MichauxTest record, @Param("example") MichauxTestExample example);

    int updateByPrimaryKeySelective(MichauxTest record);

    int updateByPrimaryKey(MichauxTest record);
}