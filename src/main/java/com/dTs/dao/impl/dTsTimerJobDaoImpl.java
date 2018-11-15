package com.dTs.dao.impl;

import java.util.Date;

import com.dTs.dao.dTsTimerJobDao;

public class dTsTimerJobDaoImpl extends dTsDaoBase implements dTsTimerJobDao {


	public Date keepAlive_CSS() throws Exception {

		return selectOne("keepAlive", null, CSS, CESHI);
	}

	public Date keepAlive_CSS_ZHENGSHI() throws Exception {

		return selectOne("keepAlive", null, CSS, ZHENGSHI);
	}

	public Date keepAlive_CRM() throws Exception {

		return selectOne("keepAlive", null, CRM, CESHI);
	}

	public Date keepAlive_CRM_ZHENGSHI() throws Exception {

		return selectOne("keepAlive", null, CRM, ZHENGSHI);
	}


}
