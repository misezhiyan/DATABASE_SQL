<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>table</title>
</head>
<body>
	<div style="margin-left: 30px; margin-right: 60px">

		<c:forEach items="${tableList}" var="table">
		表名:${table.tableName} &nbsp;&nbsp;表注释:${table.tableComment}
		<table border="solid">
				<tr>
					<th>列名</th>
					<th>数据类型</th>
					<th>长度</th>
					<th>是否可为空值</th>
					<th>注释</th>
				</tr>
				<c:forEach items="${table.fieldList }" var="list">
					<tr>
						<td>${list.COLUMN_NAME }</td>
						<td>${list.DATA_TYPE }</td>
						<td>${list.DATA_LENGTH }</td>
						<td>${list.NULLABLE }</td>
						<td>${list.COMMENTS }</td>
					</tr>
				</c:forEach>
			</table>
		</c:forEach>
	</div>
	<br>
	<br>
	<br>

	<div style="margin-left: 30px; margin-right: 60px">
		<form
			action="http://localhost:8022/DATABASE_SQL/dTs/getTableMessageFromSql.do">
			从简单SQL中获取字段 <input type="submit"><br> <br>
			<textarea rows="10" cols="30" name="sql">${sql }</textarea>
			<input type="hidden" name="tableName" value="${table.tableName }">
		</form>
	</div>
	<br>
	<div style="margin-left: 30px; margin-right: 60px">
		<form
			action="http://localhost:8022/DATABASE_SQL/dTs/getTableMessageByTable.do">
			从表中获取字段 <input type="submit"> 表名:<br> <input type="text"
				name="tableName" value="${table.tableName}"><br> 字段按行:<br>
			<textarea rows="10" cols="30" name="fieldsLine"
				value="${fieldsLine }"></textarea>
		</form>
	</div>
	<div style="margin-left: 30px; margin-right: 60px">
		<form
			action="http://localhost:8022/DATABASE_SQL/dTs/getTableMessage.do">
			查看表全字段 <input type="submit"> 表名:<br>
			<textarea rows="10" cols="30" name="tablesName">${tablesName }</textarea>
		</form>
	</div>
</body>
</html>