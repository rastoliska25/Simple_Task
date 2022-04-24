package com.example.Simple_Task;

import java.sql.*;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Input {

    public String insertt(Message message) {
        if (message.getID().equals("1")) {
            return "je to 1";
        } else
            return "nie je to 1";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String insert(Message message) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedb", "root", "password");
        System.out.println("You are now connected to database");

        statement = connection.createStatement();

        String sql = "INSERT INTO messages (message_type) " +
                "VALUES('test')";

        statement.executeUpdate(sql);

        return "vlozene";
    }


};
