package com.dTs.dao;

import java.util.List;

import com.dTs.po.Field;

public interface dTsDao {

	List<Field> getFieldList(String tableName) throws Exception;

	String getTableComment(String tableName) throws Exception;

}
