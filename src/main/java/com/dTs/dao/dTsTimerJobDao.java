package com.dTs.dao;

import java.util.Date;

public interface dTsTimerJobDao {

	Date keepAlive_CSS() throws Exception;

	Date keepAlive_CSS_ZHENGSHI() throws Exception;

	Date keepAlive_CRM() throws Exception;

	Date keepAlive_CRM_ZHENGSHI() throws Exception;

}
