package com.dTs.dao.impl;

import java.util.List;

import com.dTs.dao.base.QueryDao;
import com.dTs.dao.base.UpdateDao;

public class dTsDaoBase {

	public static final String CSS = "CSS";
	public static final String CRM = "CRM";
	public static final String CESHI = "CESHI";
	public static final String ZHENGSHI = "ZHENGSHI";
	public static final String CSS_MAPPER_NAMESPACE = "com.dTs.mapper.dTsMapper_CSS.";
	public static final String CRM_MAPPER_NAMESPACE = "com.dTs.mapper.dTsMapper_CRM.";

	private QueryDao queryDao;
	private UpdateDao updateDao;

	public QueryDao getQueryDao() {
		return queryDao;
	}

	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	public UpdateDao getUpdateDao() {
		return updateDao;
	}

	public void setUpdateDao(UpdateDao updateDao) {
		this.updateDao = updateDao;
	}

	protected <E> List<E> selectList(String statement, Object params, String xiangmu, String huanjing) throws Exception {
		if (CSS.equals(xiangmu)) {
			if (CESHI.equals(huanjing))
				return queryDao.selectList_CSS(statement, params);
			if (ZHENGSHI.equals(huanjing))
				return queryDao.selectList_CSS_ZHENGSHI(statement, params);
		}
		if (CRM.equals(xiangmu)) {
			if (CESHI.equals(huanjing))
				return queryDao.selectList_CRM(statement, params);
			if (ZHENGSHI.equals(huanjing))
				return queryDao.selectList_CRM_ZHENGSHI(statement, params);
		}
		throw new Exception("项目或环境错误");
	}

	protected <E> E selectOne(String statement, Object params, String xiangmu, String huanjing) throws Exception {
		if (CSS.equals(xiangmu)) {
			if (CESHI.equals(huanjing))
				return queryDao.selectOne_CSS(statement, params);
			if (ZHENGSHI.equals(huanjing))
				return queryDao.selectOne_CSS_ZHENGSHI(statement, params);
		}
		if (CRM.equals(xiangmu)) {
			if (CESHI.equals(huanjing))
				return queryDao.selectOne_CRM(statement, params);
			if (ZHENGSHI.equals(huanjing))
				return queryDao.selectOne_CRM_ZHENGSHI(statement, params);
		}
		throw new Exception("项目或环境错误");
	}

}
