package com.dTs.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dTs.dao.dTsTimerJobDao;
import com.dTs.service.dTsTimerJobService;

public class dTsTimerJobServiceImpl implements dTsTimerJobService {

	private dTsTimerJobDao dTsTimerJobDao;

	public dTsTimerJobDao getdTsTimerJobDao() {
		return dTsTimerJobDao;
	}

	public void setdTsTimerJobDao(dTsTimerJobDao dTsTimerJobDao) {
		this.dTsTimerJobDao = dTsTimerJobDao;
	}

	public synchronized void keepDataBaseConnectAlive() {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		try {
			Date date = dTsTimerJobDao.keepAlive_CSS();
			System.err.println("CSS 存活: " + "服务器时间" + format.format(date) + " ,本地时间" + format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CSS 连接失败: " + format.format(new Date()));
		}
		try {
			Date date = dTsTimerJobDao.keepAlive_CSS_ZHENGSHI();
			System.err.println("CSS 正式库存活: " + "服务器时间" + format.format(date) + " ,本地时间" + format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CSS 正式库连接失败: " + format.format(new Date()));
		}
		try {
			Date date = dTsTimerJobDao.keepAlive_CRM();
			System.err.println("CRM 存活: " + "服务器时间" + format.format(date) + " ,本地时间" + format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CRM 连接失败: " + format.format(new Date()));
		}
		try {
			Date date = dTsTimerJobDao.keepAlive_CRM_ZHENGSHI();
			System.err.println("CRM 正式库存活: " + "服务器时间" + format.format(date) + " ,本地时间" + format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CRM 正式库连接失败: " + format.format(new Date()));
		}
	}

}
