package com.dTs.dao.base.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.dTs.dao.base.UpdateDao;

public class UpdateDaoImpl implements UpdateDao {

	private SqlSessionTemplate sqlSession_CSS;
	private SqlSessionTemplate sqlSession_CSS_ZHENGSHI;
	private SqlSessionTemplate sqlSession_CRM;
	private SqlSessionTemplate sqlSession_CRM_ZHENGSHI;

	public SqlSessionTemplate getSqlSession_CSS() {
		return sqlSession_CSS;
	}

	public void setSqlSession_CSS(SqlSessionTemplate sqlSession_CSS) {
		this.sqlSession_CSS = sqlSession_CSS;
	}

	public SqlSessionTemplate getSqlSession_CSS_ZHENGSHI() {
		return sqlSession_CSS_ZHENGSHI;
	}

	public void setSqlSession_CSS_ZHENGSHI(SqlSessionTemplate sqlSession_CSS_ZHENGSHI) {
		this.sqlSession_CSS_ZHENGSHI = sqlSession_CSS_ZHENGSHI;
	}

	public SqlSessionTemplate getSqlSession_CRM() {
		return sqlSession_CRM;
	}

	public void setSqlSession_CRM(SqlSessionTemplate sqlSession_CRM) {
		this.sqlSession_CRM = sqlSession_CRM;
	}

	public SqlSessionTemplate getSqlSession_CRM_ZHENGSHI() {
		return sqlSession_CRM_ZHENGSHI;
	}

	public void setSqlSession_CRM_ZHENGSHI(SqlSessionTemplate sqlSession_CRM_ZHENGSHI) {
		this.sqlSession_CRM_ZHENGSHI = sqlSession_CRM_ZHENGSHI;
	}


	public int insert_CSS(String statement, Object parameter) {

		return sqlSession_CSS.insert(statement, parameter);
	}

	public int update_CSS(String statement, Object parameter) {

		return sqlSession_CSS.update(statement, parameter);
	}

	public int insert_ZHENGSHI_CSS(String statement, Object parameter) {

		return sqlSession_CSS_ZHENGSHI.insert(statement, parameter);
	}

	public int update_ZHENGSHI_CSS(String statement, Object parameter) {

		return sqlSession_CSS_ZHENGSHI.update(statement, parameter);
	}

	public int insert_CRM(String statement, Object parameter) {

		return sqlSession_CRM.insert(statement, parameter);
	}

	public int update_CRM(String statement, Object parameter) {

		return sqlSession_CRM.update(statement, parameter);
	}

	public int insert_ZHENGSHI_CRM(String statement, Object parameter) {

		return sqlSession_CRM_ZHENGSHI.insert(statement, parameter);
	}

	public int update_ZHENGSHI_CRM(String statement, Object parameter) {

		return sqlSession_CRM_ZHENGSHI.update(statement, parameter);
	}
}
