package java.dbsub;

import java.sql.ResultSet;

/**
 * Created by Dora on 4/19/2017.
 */
public enum Database implements IDatabase {

    INSTANCE;

    private final String DRIVER_NAME = "";
    private final String DATABASE_NAME = "";
    private final String USERNAME = "";
    private final String PASSWORD = "";

    private static Database database = null;

    @Override
    public void openConnection() {

    }

    @Override
    public void closeConnection() {

    }

    @Override
    public ResultSet executeQuery(String sql, String... values) {
        return null;
    }
}
