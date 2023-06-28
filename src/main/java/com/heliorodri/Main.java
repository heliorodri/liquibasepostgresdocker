package com.heliorodri;


import com.heliorodri.db.DatabaseInitializer;
import com.heliorodri.db.DatabaseVerification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "mysecretpassword";

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseInitializer.initialize(URL, USERNAME, PASSWORD);

            if (DatabaseVerification.tableExists(connection, "users")) {
                log.info("Database initialized");
            } else {
                log.warn("Database could not be initialized");
            }
        } catch (Exception e) {
            log.error("Could not initialize DB", e);
        }
    }
}