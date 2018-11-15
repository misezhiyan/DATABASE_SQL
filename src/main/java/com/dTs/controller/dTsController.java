package com.dTs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.dTs.StringUtil;
import com.dTs.po.Table;
import com.dTs.service.dTsService;

public class dTsController extends MultiActionController {

	private dTsService dTsService;

	public dTsService getdTsService() {
		return dTsService;
	}

	public void setdTsService(dTsService dTsService) {
		this.dTsService = dTsService;
	}

	public ModelAndView getTableMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String tablesName = request.getParameter("tablesName");
		if (!StringUtil.isEmpty(tablesName)) {
			Table table = dTsService.getTableMessage(tablesName);
			request.setAttribute("table", table);
			request.setAttribute("tablesName", tablesName);
		}

		return new ModelAndView("/table_constructure");
	}

	public ModelAndView getTableMessageFromSql(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String sql = request.getParameter("sql");

		List<Table> tableList = dTsService.getTableMessageFromSql(sql);

		request.setAttribute("tableList", tableList);
		request.setAttribute("sql", sql);

		return new ModelAndView("/table_fromsql");
	}

	public ModelAndView getTableMessageByTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String tableName = request.getParameter("tableName");
		String fieldsLine = request.getParameter("fieldsLine");

		Table table = dTsService.getTableMessageByTable(tableName, fieldsLine);

		request.setAttribute("table", table);
		request.setAttribute("fieldsLine", fieldsLine);

		return new ModelAndView("/table_fromtable");
	}

}
