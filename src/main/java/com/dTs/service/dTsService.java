package com.dTs.service;

import java.util.List;

import com.dTs.po.Table;

public interface dTsService {

	Table getTableMessage(String tableName) throws Exception;

	List<Table> getTableMessageFromSql(String sql) throws Exception;

	Table getTableMessageByTable(String tableName, String fieldsLine) throws Exception;

}
