package com.dTs.po;

import java.util.ArrayList;
import java.util.List;

public class Sql {

	// 关键词
	public static final List<String> KEY_LIST = new ArrayList<String>();

	{
		KEY_LIST.add("SELECT");
		KEY_LIST.add("UPDATE");
		KEY_LIST.add("INSERT");
		KEY_LIST.add("CALL");

		KEY_LIST.add("FROM");

		KEY_LIST.add("WHERE");
		KEY_LIST.add("AND");
		KEY_LIST.add("OR");
		KEY_LIST.add("IN");
		KEY_LIST.add("AS");
		KEY_LIST.add("GROUP");
		KEY_LIST.add("ORDER");
		KEY_LIST.add("BY");
		KEY_LIST.add("ASC");
		KEY_LIST.add("DESC");

		KEY_LIST.add("CASE");
		KEY_LIST.add("WHEN");
		KEY_LIST.add("ELSE");
		KEY_LIST.add("END");

		KEY_LIST.add("ID");
	}

	public static void main(String[] args) throws Exception {

		// String sql = "SELECT T.ROW_ID, T.CUSTOMER_NAME, T.CUSTOMER_ID,
		// T.TELEPHONE1,"
		// + "T.TELEPHONE2, T.TELEPHONE3,CUSTOMER_PROD_ID," +
		// "T.PRODUCT_ID,T.MID_PRODUCT_ID, T.MID_PRODUCT_NAME,"
		// + "T.ADDRESS,T.FAULT_DESC, TO_CHAR(T.ENTER_TIME, 'yyyy-mm-dd
		// hh24:mi') AS" + "ENTER_TIME,"
		// + "TO_CHAR(T.REQUIRE_CALLBACK_DATE, 'yyyy-MM-dd hh24:mi') AS" +
		// "CALLBACK,T.SERVICE_TYPE_TROPESIS,"
		// + "T.SERVICE_MODE_TROPESIS,NVL(T.CALLBACK_TIMES,0) AS"
		// + "CALLBACK_TIMES,T.TURN_DEAL_STATUS,(SELECT DISTINCT"
		// + "B.ASSIGN_RESULT_DESC FROM WB_ASSIGN_BILL B WHERE B.WB_ID =
		// T.ROW_ID"
		// + "AND B.ASSIGN_RESULT_DESC IS NOT NULL AND ROWNUM = 1) AS" +
		// "ASSIGN_RESULT_DESC"
		// + "FROM WB_SERVICE_INFO T WHERE";

		String sql = "SELECT a.666, b.ccc as k6 FROM WB_SERVICE_INFO " + "a,WB_SERVICE_FEEDBACK b " + "WHERE " + "a.ROW_ID=b.ROW_ID(+) AND a.CUSTOMER_ID  = " + "#{CUSTOMER_ID}";

		List<Sql_table> formmatSql_select = formmatSql_select(sql);
		System.out.println();

	}

	public static List<Sql_table> formmatSql_select(String sql) throws Exception {

		sql = sql.replace("\r\n", " ").replace("	", " ");
		while (sql.contains("  "))
			sql = sql.replace("  ", " ");
		while (sql.contains(", "))
			sql = sql.replace(", ", ",");
		while (sql.contains(" ,"))
			sql = sql.replace(" ,", ",");

		sql = tick(sql);

		String sql_upper = sql.toUpperCase();
		int index_from = sql_upper.indexOf(" FROM ");
		int index_where = sql_upper.indexOf(" WHERE ");

		if (index_from < 0)
			throw new Exception("沒有抓到 FROM 关键字");

		if (index_where < 0)
			index_where = sql_upper.length();
		index_from = index_from + 6;

		String fromTablesStr = sql_upper.substring(index_from, index_where);

		String[] tableName_arr = fromTablesStr.split(",");

		List<Sql_table> tableLsit = new ArrayList<Sql_table>();
		for (String tableName : tableName_arr) {
			Sql_table sql_table = new Sql_table();
			sql_table.setTableName(tableName);
			tableLsit.add(sql_table);
		}

		int tablesSum = tableName_arr.length;
		List<Sql_table> list = new ArrayList<Sql_table>(tablesSum);
		if (tablesSum == 1) {
			Sql_table Sql_table = analyzeSqlOne(sql_upper, tableLsit);
			list.add(Sql_table);
		} else {
			List<Sql_table> Sql_table_list = analyzeSqlList(sql_upper, tableLsit);
			list.addAll(Sql_table_list);
		}

		return list;
	}

	private static List<Sql_table> analyzeSqlList(String sql, List<Sql_table> tableLsit) {
		int index = sql.indexOf("SELECT ");
		int index_from = sql.indexOf(" FROM ");
		index = index + 7;
		index_from = index_from < 0 ? sql.length() : index_from;
		String fieldsStr = sql.substring(index, index_from);
		fieldsStr = tick(fieldsStr);

		String[] fieldsArr = fieldsStr.split(",");
		List<Sql_field> sql_field_list = new ArrayList<Sql_field>();
		for (String field : fieldsArr) {

			field = tick(field);
			Sql_field sql_field = new Sql_field();
			sql_field.setName(field);
			sql_field_list.add(sql_field);
		}

		for (int i = 0; i < tableLsit.size(); i++) {
			Sql_table table = tableLsit.get(i);
			String shortName = table.getShortName();
			for (int j = 0; j < sql_field_list.size(); j++) {
				Sql_field sql_field = sql_field_list.get(j);
				String shortTableName = sql_field.getShortTableName();
				if (shortName == null) {

					System.out.println();
				}
				if (shortName.equals(shortTableName)) {
					List<Sql_field> fieldList = table.getFieldList();
					if (fieldList == null) {
						table.setFieldList(new ArrayList<Sql_field>());
						fieldList = table.getFieldList();
					}
					fieldList.add(sql_field);
				}
			}
		}

		return tableLsit;
	}

	private static Sql_table analyzeSqlOne(String sql, List<Sql_table> tableLsit) {

		int index = sql.indexOf("SELECT ");
		int index_from = sql.indexOf(" FROM ");
		index = index + 7;
		String fieldsStr = sql.substring(index, index_from);
		fieldsStr = tick(fieldsStr);

		String[] fieldsArr = fieldsStr.split(",");
		List<Sql_field> sql_field_list = new ArrayList<Sql_field>();

		Sql_table sql_table = tableLsit.get(0);
		String shortName = sql_table.getShortName();
		for (String field : fieldsArr) {

			field = tick(field);
			Sql_field sql_field = new Sql_field();
			sql_field.setName(field);
			sql_field.setShortName(shortName);
			sql_field_list.add(sql_field);
		}

		sql_table.setFieldList(sql_field_list);

		return sql_table;
	}

	private static String tick(String str) {

		while (str.startsWith(" "))
			str = str.substring(1);
		while (str.endsWith(" "))
			str = str.substring(0, str.length() - 1);

		return str;
	}

}
