package com.yz.dao;

import java.util.List;

import com.yz.model.Crane;


public interface ICraneDao {

	// 保存一条记录
	public abstract void save(Crane crane);

	// 保存一条记录
	public abstract Integer savereturn(Crane crane);

	// 删除一条记录
	public abstract void delete(Crane crane);

	// 根据ID删除一条记录
	public abstract void deleteById(int id);

	// 修改一条记录
	public abstract void update(Crane crane);

	// 根据hql语句、条件、条件值修改某些记录
	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	// 获得所有记录
	public abstract List<Crane> getCranes();

	// 根据hql语句来查询所有记录
	public abstract List<Crane> queryList(String queryString);
	
	public List<Crane> queryList(final String hql,final int maxSize);

	// 根据hql、条件值查询某些记录
	public abstract List<Crane> getObjectsByCondition(String queryString,
			Object[] p);

	// 根据hql语句、条件、条件值查询某些记录
	public abstract List<Crane> queryList(String queryString,
			String[] paramNames, Object[] values);

	// 根据hql、id列表查询某些记录
	public abstract List<Crane> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	// 根据hql语句、条件值、分页查询某些记录
	public abstract List<Crane> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	// 根据hql、条件值获得一个唯一值
	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	// 根据id查询一条记录
	public abstract Crane loadById(int id);

	// 根据hql语句、条件、值来查询一条记录
	public abstract Crane queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	// 根据hql语句、条件值来查询是否存在该记录
	public abstract boolean checkCraneExistsWithName(String queryString,
			Object[] p);

	// 根据hql批量修改
	public abstract int updateCraneByhql(String queryString, Object[] p);

}