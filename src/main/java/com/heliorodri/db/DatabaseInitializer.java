package com.heliorodri.db;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseInitializer {

    public static final String CHANGELOG_FILE = "changelog.xml";

    private DatabaseInitializer() {
    }

    public static Connection initialize(String url, String username, String password) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        Liquibase liquibase = getLiquibase(connection);
        liquibase.update("");

        return connection;
    }

    private static Liquibase getLiquibase(Connection connection) throws DatabaseException {
        return new Liquibase(CHANGELOG_FILE, new ClassLoaderResourceAccessor(), getDatabaseImplementation(connection));
    }

    private static Database getDatabaseImplementation(Connection connection) throws DatabaseException {
        return DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
    }

}
