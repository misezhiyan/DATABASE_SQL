package com.dTs.time;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dTs.service.dTsTimerJobService;

/**
 * @discription 该类用于 保存数据库连接存活
 * @author li.yuqing
 * @date 2018年7月17日 下午5:39:54
 */
public class dTsTimerJob extends MultiActionController {

	private dTsTimerJobService dTsTimerJobService;

	public dTsTimerJobService getdTsTimerJobService() {
		return dTsTimerJobService;
	}

	public void setdTsTimerJobService(dTsTimerJobService dTsTimerJobService) {
		this.dTsTimerJobService = dTsTimerJobService;
	}

	public void doBiz() {

		dTsTimerJobService.keepDataBaseConnectAlive();
	}
}
