package com.hillel.ua.db;

import com.hillel.ua.common.data.PropertiesReader;
import com.hillel.ua.logging.Logger;

import java.sql.*;
import java.util.Objects;

public class DataBaseUtils {

    private static Connection connection; // объект Connection

    private DataBaseUtils() {  //что-бы не создавать объект статического класса
    }

    private static void initConnection() {

        final PropertiesReader propertiesReader = new PropertiesReader();

        final String userName = propertiesReader.getProperty("sql.server.username");
        final String password = propertiesReader.getProperty("sql.server.password");
        final String connectionUrl = String.format(propertiesReader.getProperty("sql.server.connection.string"),
                userName, password);

        try {
            Logger.out.debug("Trying init connection to the SQL Server");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // зарегали jdbc-driver|динамическая загрузка (переносимость)
            connection = DriverManager.getConnection(connectionUrl);
            Logger.out.debug("Connection has successfully established!");
        } catch (final SQLException | ClassNotFoundException e) {
            throw new IllegalStateException("Unable to connect to the sever!", e);
        }
    }

    public static void executeQuery(final String query) {  // выполнить запрос
        try {
            if (Objects.isNull(connection) || connection.isClosed()) {
                Logger.out.debug("Connection is closed. Perform reconnecting!");
                initConnection();
            }
            final Statement statement = connection.createStatement();  //объект Statement (позволяет выполнить запрос к БД)
            Logger.out.debug(String.format("Connection is established. Executing following query [%s]!", query));
            final ResultSet resultSet = statement.executeQuery(query); //объект ResultSet (данные которые пришли с таблицы) -получить
            Logger.out.debug(String.format("Following query [%s] is successfully executed!", query));
        } catch (final SQLException e) {
            throw new IllegalStateException("Unable to execute query!", e);
        }
    }
}

