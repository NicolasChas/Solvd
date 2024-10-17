package Classes;

import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

public class ConnectionPool {
    private static BasicDataSource ds=new BasicDataSource();

    static {
        ds=new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/products");
        ds.setUsername("root");
        ds.setPassword("");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    /*public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
*/
    public static DataSource getDataSource() {
        return ds;
    }
}
