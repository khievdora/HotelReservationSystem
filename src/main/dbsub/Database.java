package main.dbsub;

import java.sql.*;

/**
 * Created by Dora on 4/19/2017.
 */
public class Database implements IDatabase {

    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/hotelreservation";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private static Database database = null;

    private Connection connection;
    private Statement statement;

    private Database() {
        System.out.println("Database is instantiated!!!");
    }

    public synchronized static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    @Override
    public void openConnection() throws ClassNotFoundException, SQLException {
        // Register Driver
        Class.forName(DRIVER_NAME);

        // Open connection
        connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            openConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int executeUpdate(String sql) {
        int result = 0;
        try {
            openConnection();

            statement = connection.createStatement();
            result = statement.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
