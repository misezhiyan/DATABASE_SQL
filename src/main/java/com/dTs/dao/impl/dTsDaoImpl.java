package com.dTs.dao.impl;

import java.util.List;

import com.dTs.dao.dTsDao;
import com.dTs.po.Field;

public class dTsDaoImpl extends dTsDaoBase implements dTsDao {

	public List<Field> getFieldList(String tableName) throws Exception {

		return selectList("com.dTs.mapper.dTsMapper_CRM.getFieldList", tableName, CRM, CESHI);
		// return selectList("com.dTs.mapper.dTsMapper_CSS.getFieldList", tableName, CSS, CESHI);
	}

	public String getTableComment(String tableName) throws Exception {

		return selectOne("com.dTs.mapper.dTsMapper_CRM.getTableComment", tableName, CRM, CESHI);
		// return selectOne("com.dTs.mapper.dTsMapper_CSS.getTableComment", tableName, CSS, CESHI);
	}

}
