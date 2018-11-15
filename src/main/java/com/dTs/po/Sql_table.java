package com.dTs.po;

import java.util.List;

import com.dTs.StringUtil;

public class Sql_table {

	private String tableName;
	private String shortName;
	private List<Sql_field> fieldList;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {

		tableName = StringUtil.tick(tableName);

		String[] split = tableName.split(" ");
		String tablename = split[0];
		this.tableName = tablename.toUpperCase();
		if (split.length > 1) {

			String shortname = split[1];
			this.shortName = shortname;
		}

	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<Sql_field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<Sql_field> fieldList) {
		this.fieldList = fieldList;
	}

}
