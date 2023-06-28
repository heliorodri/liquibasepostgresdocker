package com.heliorodri.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseVerification {

    public static boolean tableExists(Connection connection, String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = '" + tableName + "')");
            resultSet.next();
            return resultSet.getBoolean(1);
        }
    }

}
