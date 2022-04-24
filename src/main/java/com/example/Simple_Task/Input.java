package com.example.Simple_Task;

import java.sql.*;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Input {

    public String insert(Message message) throws ClassNotFoundException, SQLException {
        String status = "";
        String sql = "";
        String badRequest = "400 Bad request";

        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedb", "root", "password");
        System.out.println("Connection to database phonedb successful");

        statement = connection.createStatement();

        if ((!message.getMessage_type().equals("MSG")) && (!message.getMessage_type().equals("CALL"))) {
            status = badRequest;
        } else if ((message.getTimestamp() == 0) || (message.getOrigin() == 0) || (message.getDestination() == 0)) {
            return badRequest;
        } else {
            if (message.getMessage_type().equals("MSG")) {
                if ((!message.getMessage_status().equals("DELIVERED")) && (!message.getMessage_status().equals("SEEN"))) {
                    return badRequest;
                } else {
                    sql = String.format("INSERT INTO messages (message_type, timestamp, origin, destination, message_content, message_status) " +
                            "VALUES('%s', %d, %d, %d, '%s', '%s')", message.getMessage_type(), message.getTimestamp(), message.getOrigin(), message.getDestination(), message.getMessage_content(), message.getMessage_status());

                    status = "201 CREATED";

                    statement.executeUpdate(sql);
                }
            } else if (message.getMessage_type().equals("CALL")) {
                if ((message.getDuration() == 0) || (!message.getStatus_code().equals("OK")) && (!message.getStatus_code().equals("KO"))) {
                    return badRequest;
                } else {
                    sql = String.format("INSERT INTO messages (message_type, timestamp, origin, destination, duration, status_code, status_description) " +
                            "VALUES('%s', %d, %d, %d, %d, '%s', '%s')", message.getMessage_type(), message.getTimestamp(), message.getOrigin(), message.getDestination(), message.getDuration(), message.getStatus_code(), message.getStatus_description());

                    status = "200 OK";

                    statement.executeUpdate(sql);
                }
            } else {
                status = badRequest;
            }
        }

        return status;
    }

    public String counters() throws ClassNotFoundException, SQLException {
        String value = "";
        String sql = "";

        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedb", "root", "password");
        System.out.println("Connection to database phonedb successful");

        sql = "SELECT Count(*) as totalProcessedFiles, Count(*) as totalRows, " +
                "(SELECT COUNT(*) from messages where message_type like 'CALL') as totalCalls, " +
                "(SELECT COUNT(*) from messages where message_type like 'MSG') as totalMessages, " +
                "(SELECT COUNT(x.record) FROM (SELECT COUNT(*) as record from messages GROUP BY origin) as x) as totalDifferentOriginCodes, " +
                "(SELECT COUNT(x.record) FROM (SELECT COUNT(*) as record from messages GROUP BY destination) as x) as totalDifferentDestinationCodes " +
                " from messages ";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                value = "Total number of processed JSON files: " + rs.getString("totalProcessedFiles");
                value = value + "\n" + "Total number of rows: " + rs.getString("totalRows");
                value = value + "\n" + "Total number of calls: " + rs.getString("totalMessages");
                value = value + "\n" + "Total number of messages: " + rs.getString("totalCalls");
                value = value + "\n" + "Total number of different origin country codes: " + rs.getString("totalDifferentOriginCodes");
                value = value + "\n" + "Total number of different destination country codes: " + rs.getString("totalDifferentDestinationCodes");
            }
        } catch (SQLException ignored) {
        }

        return value;
    }

    public String counters(String date) throws ClassNotFoundException, SQLException, ParseException {
        String value = "";
        String sql = "";
        String year;
        String month;
        String day;
        String dateToConvert;
        Date convertedDate;
        Long timestamp;
        String timestampSubstring;

        if (!(date.length() == 6)) {
            return "400 Bad request";
        }

        year = "20" + (date.substring(0, 2));
        month = (date.substring(2, 4));
        day = (date.substring(4, 6));
        dateToConvert = day + "/" + month + "/" + year + " 00:00:00";
        convertedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dateToConvert);
        timestamp = convertedDate.getTime();
        timestampSubstring = timestamp.toString().substring(0, 10);
        timestamp = Long.parseLong(timestampSubstring);

        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedb", "root", "password");
        System.out.println("Connection to database phonedb successful");

        sql = String.format("SELECT Count(*) as totalProcessedFiles, Count(*) as totalRows, " +
                "(SELECT COUNT(*) from messages where message_type like 'CALL' AND timestamp <= %1$d) as totalCalls, " +
                "(SELECT COUNT(*) from messages where message_type like 'MSG' AND timestamp <= %1$d) as totalMessages, " +
                "(SELECT COUNT(x.record) FROM (SELECT COUNT(*) as record from messages WHERE timestamp <= %1$d GROUP BY origin) as x) as totalDifferentOriginCodes, " +
                "(SELECT COUNT(x.record) FROM (SELECT COUNT(*) as record from messages WHERE timestamp <= %1$d GROUP BY destination) as x) as totalDifferentDestinationCodes " +
                " from messages WHERE timestamp <= %1$d", timestamp);
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                value = "Total number of processed JSON files: " + rs.getString("totalProcessedFiles");
                value = value + "\n" + "Total number of rows: " + rs.getString("totalRows");
                value = value + "\n" + "Total number of calls: " + rs.getString("totalMessages");
                value = value + "\n" + "Total number of messages: " + rs.getString("totalCalls");
                value = value + "\n" + "Total number of different origin country codes: " + rs.getString("totalDifferentOriginCodes");
                value = value + "\n" + "Total number of different destination country codes: " + rs.getString("totalDifferentDestinationCodes");
            }
        } catch (SQLException ignored) {
        }

        return value;
    }
}
