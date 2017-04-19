package java.dbsub;

import java.sql.ResultSet;

/**
 * Created by Dora on 4/19/2017.
 */
public interface IDatabase {

    public void openConnection();
    public void closeConnection();
    public ResultSet executeQuery(String sql, String... values);

}
