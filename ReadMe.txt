http://localhost:8022/DATABASE_SQL/dTs/getTableMessage.do?tableName=WB_SERVICE_INFO


获取包体Sql
SELECT TEXT FROM ALL_SOURCE
WHERE TYPE = 'PACKAGE BODY' AND
OWNER = 'SYSTEM'
ORDER BY NAME, LINE;

Procedure,Function, Package, Trigger这些数据库对象的定义都可以用类似的方法得到。