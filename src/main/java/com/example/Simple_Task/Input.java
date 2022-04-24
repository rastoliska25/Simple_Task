package com.example.Simple_Task;

import java.sql.*;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Input {

    public String insert(Message message) throws ClassNotFoundException, SQLException {
        String status = "";
        String sql = "";

        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedb", "root", "password");
        System.out.println("Connection to database phonedb successful");

        statement = connection.createStatement();

        if (message.getMessage_type().equals("MSG")) {
            sql = String.format("INSERT INTO messages (message_type, timestamp, origin, destination, message_content, message_status) " +
                    "VALUES('%s', %d, %d, %d, '%s', '%s')", message.getMessage_type(), message.getTimestamp(), message.getOrigin(), message.getDestination(), message.getMessage_content(), message.getMessage_status());
            status = "201 CREATED";

            statement.executeUpdate(sql);
        } else if (message.getMessage_type().equals("CALL")) {
            sql = String.format("INSERT INTO messages (message_type, timestamp, origin, destination, duration, status_code, status_description) " +
                    "VALUES('%s', %d, %d, %d, %d, '%s', '%s')", message.getMessage_type(), message.getTimestamp(), message.getOrigin(), message.getDestination(), message.getDuration(), message.getStatus_code(), message.getStatus_description());
            status = "200 OK";

            statement.executeUpdate(sql);
        } else {
            status = "400 Bad request";
        }

        return status;
    }


};
