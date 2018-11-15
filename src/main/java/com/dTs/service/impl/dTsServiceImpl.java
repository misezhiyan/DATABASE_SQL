package com.dTs.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dTs.StringUtil;
import com.dTs.dao.dTsDao;
import com.dTs.po.Field;
import com.dTs.po.Sql;
import com.dTs.po.Sql_field;
import com.dTs.po.Sql_table;
import com.dTs.po.Table;
import com.dTs.service.dTsService;

public class dTsServiceImpl implements dTsService {

	private dTsDao dTsDao;

	public dTsDao getdTsDao() {
		return dTsDao;
	}

	public void setdTsDao(dTsDao dTsDao) {
		this.dTsDao = dTsDao;
	}

	public Table getTableMessage(String tableName) throws Exception {

		List<Field> list = dTsDao.getFieldList(tableName);
		String tableComment = dTsDao.getTableComment(tableName);

		Table table = new Table();
		table.setTableName(tableName);
		table.setTableComment(tableComment);
		table.setFieldList(list);

		return table;
	}

	public List<Table> getTableMessageFromSql(String sql) throws Exception {

		List<Table> resultList = new ArrayList<Table>();

		List<Sql_table> formmatSql = Sql.formmatSql_select(sql);
		for (Sql_table sql_table : formmatSql) {

			List<Sql_field> fieldList = sql_table.getFieldList();
			if (null == fieldList)
				continue;// 参数未参与简单sql 参数列

			String tableName = sql_table.getTableName();
			List<Field> list = dTsDao.getFieldList(tableName);
			String tableComment = dTsDao.getTableComment(tableName);

			Table table = new Table();
			List<Field> needList = new ArrayList<Field>();
			for (Sql_field sql_field : fieldList) {
				String name = sql_field.getName();
				for (Field field : list) {
					String COLUMN_NAME = field.getCOLUMN_NAME();
					if (null == name) {

						System.out.println();
					}

					if (name.equals(COLUMN_NAME))
						needList.add(field);
				}
			}
			table.setTableName(tableName);
			table.setFieldList(needList);
			table.setTableComment(tableComment);

			resultList.add(table);
		}

		return resultList;
	}

	public Table getTableMessageByTable(String tableName, String fieldsLine) throws Exception {

		while (fieldsLine.contains("\r\n"))
			fieldsLine = fieldsLine.replace("\r\n", " ");
		while (fieldsLine.startsWith(" "))
			fieldsLine = fieldsLine.substring(1);
		while (fieldsLine.endsWith(" "))
			fieldsLine = fieldsLine.substring(0, fieldsLine.length() - 1);

		String[] split = fieldsLine.split(" ");

		List<Field> list = dTsDao.getFieldList(tableName);
		String tableComment = dTsDao.getTableComment(tableName);

		List<Field> fieldList = new ArrayList<Field>();
		for (String fieldTemp : split) {
			fieldTemp = fieldTemp.toUpperCase();
			fieldTemp = StringUtil.tick(fieldTemp);
			for (Field field : list) {
				String COLUMN_NAME = field.getCOLUMN_NAME();
				if (COLUMN_NAME.equals(fieldTemp))
					fieldList.add(field);
			}
		}

		Table table = new Table();
		table.setTableName(tableName);
		table.setTableComment(tableComment);
		table.setFieldList(fieldList);

		return table;
	}

}
