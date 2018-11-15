package com.dTs.dao.base.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dTs.dao.base.QueryDao;

public class QueryDaoImpl implements QueryDao {

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

	public <T> T selectOne_CSS(String statement, Object parameter) {

		return sqlSession_CSS.selectOne(statement, parameter);
	}

	public <E> List<E> selectList_CSS(String statement, Object parameter) {

		return sqlSession_CSS.selectList(statement, parameter);
	}

	public <T> T selectOne_CSS_ZHENGSHI(String statement, Object parameter) {

		return sqlSession_CSS_ZHENGSHI.selectOne(statement, parameter);
	}

	public <E> List<E> selectList_CSS_ZHENGSHI(String statement, Object parameter) {

		return sqlSession_CSS_ZHENGSHI.selectList(statement, parameter);
	}

	public <T> T selectOne_CRM(String statement, Object parameter) {

		return sqlSession_CRM.selectOne(statement, parameter);
	}

	public <E> List<E> selectList_CRM(String statement, Object parameter) {

		return sqlSession_CRM.selectList(statement, parameter);
	}

	public <T> T selectOne_CRM_ZHENGSHI(String statement, Object parameter) {

		return sqlSession_CRM_ZHENGSHI.selectOne(statement, parameter);
	}

	public <E> List<E> selectList_CRM_ZHENGSHI(String statement, Object parameter) {

		return sqlSession_CRM_ZHENGSHI.selectList(statement, parameter);
	}
}
