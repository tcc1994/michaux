package com.tcc.main.manager.base;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Description BaseManager
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月29日 下午1:09:26
 */
public interface BaseManager<T, E, PK extends Serializable> {

	T searchByPrimaryKey(final PK id);

	List<T> searchByExample(E example);

	List<T> searchByExampleWithBLOBs(E example);

	Integer countByExample(E example);

	int insert(T record);

	int insertSelective(@Param("record") T record);

	int updateByExampleSelective(@Param("record") T record,@Param("example") E example);

	int updateByExample(@Param("record") T record, @Param("example") E example);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	int deleteByExample(E example);

	int deleteByPrimaryKey(PK pk);
}