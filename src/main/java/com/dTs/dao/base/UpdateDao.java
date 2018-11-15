package com.dTs.dao.base;

public interface UpdateDao {

	public int insert_CSS(String statement, Object parameter);

	public int update_CSS(String statement, Object parameter);

	public int insert_ZHENGSHI_CSS(String statement, Object parameter);

	public int update_ZHENGSHI_CSS(String statement, Object parameter);

	public int insert_CRM(String statement, Object parameter);

	public int update_CRM(String statement, Object parameter);

	public int insert_ZHENGSHI_CRM(String statement, Object parameter);

	public int update_ZHENGSHI_CRM(String statement, Object parameter);
}
