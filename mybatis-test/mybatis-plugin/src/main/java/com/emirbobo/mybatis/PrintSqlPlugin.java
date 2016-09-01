package com.emirbobo.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;

import java.util.List;
import java.util.Properties;

/**
 * Created by xijingbo on 2016-08-31.
 */
@Intercepts(@Signature(method = "update",args = {MappedStatement.class,Object.class},type = Executor.class))
public class PrintSqlPlugin implements Interceptor {

    private Properties properties;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = null;
        if(invocation.getArgs().length > 1){
            parameter = invocation.getArgs()[1];
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);

        logSqlInfo(boundSql);

        return invocation.proceed();
    }

    private void logSqlInfo(BoundSql boundSql) {

        System.out.println("PrintSqlPlugin:"+boundSql.getSql());

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if(parameterMappings != null)
        {
            int i=0;
            for(ParameterMapping parameterMapping : parameterMappings)
            {
                System.out.println("ParameterMapping["+(i++)+"]:"+parameterMapping);
            }
        }
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties0) {
        this.properties = properties0;
    }
}
