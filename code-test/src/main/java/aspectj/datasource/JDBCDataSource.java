package aspectj.datasource;

/**
 * Created by emirbobo on 2016/11/26.
 */
public class JDBCDataSource {

    public String getDataSource(){
        System.out.println("now getDataSource");
        String dataSource = dataSource();
        return dataSource;
    }

    public String dataSource(){
        return "dataSource";
    }
}
