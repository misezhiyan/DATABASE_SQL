package com.dTs.dao.base;

import java.util.List;

public interface QueryDao {

	public <T> T selectOne_CSS(String statement, Object parameter);

	public <E> List<E> selectList_CSS(String statement, Object parameter);

	public <T> T selectOne_CSS_ZHENGSHI(String statement, Object parameter);

	public <E> List<E> selectList_CSS_ZHENGSHI(String statement, Object parameter);

	public <T> T selectOne_CRM(String statement, Object parameter);

	public <E> List<E> selectList_CRM(String statement, Object parameter);

	public <T> T selectOne_CRM_ZHENGSHI(String statement, Object parameter);

	public <E> List<E> selectList_CRM_ZHENGSHI(String statement, Object parameter);

}
