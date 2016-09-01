package com.emirbobo.mybatis.myshard;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/9/1.
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class MyShardingPlugin implements Interceptor
{

	public static final String SHARD_TABLE_PROFIX = "T_";
	public static final int SHARD_MOD = 50;

	private static final Field DELEGATE_FIELD = ReflectionUtils.findField(RoutingStatementHandler.class, "delegate");
	private static final Field MAPPEDSTATEMENT_FIELD = ReflectionUtils.findField(BaseStatementHandler.class, "mappedStatement");
	public static final Field SQL_FIELD = ReflectionUtils.findField(BoundSql.class, "sql");
	private Properties properties;

	private Connection unwrapMybatisConnection(Connection connection) {
        if (Proxy.isProxyClass(connection.getClass())) {
            InvocationHandler handler = Proxy.getInvocationHandler(connection);
            if (handler instanceof ConnectionLogger) {
                return ((ConnectionLogger) handler).getConnection();
            }
        }
        return connection;
    }

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		Connection conn = (Connection) invocation.getArgs()[0];
		Connection realConn = unwrapMybatisConnection(conn);

		//youkuShard(invocation);
		rewriteSql(invocation);

		return invocation.proceed();
	}

	private void rewriteSql(Invocation invocation) {

		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();

		Object parameterObject = boundSql.getParameterObject();
		if (parameterObject == null) {
			log("parameterObject is null");
		}

		String sqlStr = boundSql.getSql();
		if (StringUtils.isBlank(sqlStr))
			return;

		String[] sqls = sqlStr.split(" ");
		if (sqls == null || sqls.length == 0)
			return;
		StringBuffer newsql = new StringBuffer();
		for (String sqlsplit : sqls) {
			sqlsplit = sqlsplit.trim();
			//如果是指定前缀开头的，认为是表名，就需要替换
			if (sqlsplit.toUpperCase().startsWith(SHARD_TABLE_PROFIX))
			{
				sqlsplit += "_" + 0;
			}
			newsql.append(sqlsplit.trim());
			newsql.append(" ");
		}
		if (newsql.length() > 0)
		{
			log("Old SQL : " + boundSql.getSql());
			ReflectionUtils.makeAccessible(SQL_FIELD);
			ReflectionUtils.setField(SQL_FIELD, boundSql, newsql.toString());
			log("Replace SQL To : " + boundSql.getSql());
		}
	}

	private void youkuShard(Invocation invocation)
		{
//			StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//			MappedStatement mappedStatement;
//			if (statementHandler instanceof RoutingStatementHandler) {
//				StatementHandler delegate = (StatementHandler) ReflectionUtils.getField(DELEGATE_FIELD, statementHandler);
//				mappedStatement = (MappedStatement) ReflectionUtils.getField(MAPPEDSTATEMENT_FIELD, delegate);
//			} else {
//				mappedStatement = (MappedStatement) ReflectionUtils.getField(MAPPEDSTATEMENT_FIELD, statementHandler);
//			}
//			if (mappedStatement == null) {
//				throw new IllegalStateException();
//			}
//			ShardingMybatisConnectionInvocationHandler shardingMybatisHandler = (ShardingMybatisConnectionInvocationHandler) handler;
//			ParameterHandler parameterHandler = statementHandler.getParameterHandler();
//			shardingMybatisHandler.setParameter(parameterHandler.getParameterObject());
//			shardingMybatisHandler.setMappedStatement(mappedStatement);
//
//			// 分表处理
//			if (shardingMybatisHandler.getDataSource() instanceof ReadWriteSplittingMybatisDataSourceProxy) {
//				ReadWriteSplittingMybatisDataSourceProxy dataSource = (ReadWriteSplittingMybatisDataSourceProxy) shardingMybatisHandler.getDataSource();
//				BoundSql boundSql = statementHandler.getBoundSql();
//				ShardingTable shardingTable = dataSource.getShardingTable();
//				if (shardingTable != null) shardingTable.shard(boundSql);
//			}
//		}
	}


	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties0) {
		this.properties = properties0;
	}
	public void log(String s)
	{
		System.out.println("MyShardingPlugin-Log : "+s);
	}
}
