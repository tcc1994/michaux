package com.tcc.main.manager.base;

import org.apache.ibatis.annotations.Param;

import com.tcc.main.manager.base.BaseManager;

import java.io.Serializable;
import java.util.List;

/**
 * @Description BaseManagerImpl
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月29日 下午1:14:19
 */
public abstract class BaseManagerImpl<T, E, PK extends Serializable> implements BaseManager<T, E, PK> {

	public abstract BaseManager<T, E, PK> getManager();

	public T searchByPrimaryKey(final PK pk) {
		return this.getManager().searchByPrimaryKey(pk);
	}

	public List<T> searchByExample(E example) {
		return this.getManager().searchByExample(example);
	}

	public List<T> searchByExampleWithBLOBs(E example) {
		return this.getManager().searchByExampleWithBLOBs(example);
	}

	public Integer countByExample(E example) {
		return this.getManager().countByExample(example);
	}

	public int insert(T record) {
		return this.getManager().insertSelective(record);
	}

	public int insertSelective(@Param("record") T record) {
		return this.getManager().insertSelective(record);
	}

	public int updateByExampleSelective(@Param("record") T record,@Param("example") E example) {
		return this.getManager().updateByExampleSelective(record, example);
	}

	public int updateByExample(@Param("record") T record,@Param("example") E example) {
		return this.getManager().updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(T record) {
		return this.getManager().updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		return this.getManager().updateByPrimaryKey(record);
	}

	public int deleteByExample(E example) {
		return this.getManager().deleteByExample(example);
	}

	public int deleteByPrimaryKey(PK pk) {
		return this.getManager().deleteByPrimaryKey(pk);
	}
}