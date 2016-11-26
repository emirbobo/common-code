package aspectj.datasource;

/**
 * Created by emirbobo on 2016/11/26.
 */
public final class DataSourceFactory {


    public void executeSql(){
        JDBCDataSource jdbcDataSource = new JDBCDataSource();
        System.out.println(jdbcDataSource.getDataSource());
    }
}
