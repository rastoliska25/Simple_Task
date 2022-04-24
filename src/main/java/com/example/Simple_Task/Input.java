package com.example.Simple_Task;

import java.sql.*;
import java.sql.DriverManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;


public class Input {

 /*   private static ObjectMapper objectMapper = new ObjectMapper();

    public static String parse(String json) throws URISyntaxException, IOException {
        JsonNode node = objectMapper.readTree(json);

        if (node.isArray()) {
            for (JsonNode jsonNode : node) {
                String title = jsonNode.get("title").asText();
                System.out.println(title);
            }
        }

        return null;
    }*/


    public String insertt(Message message){
        if (message.getID().equals("1")){
            return "je to 1";
        } else
            return "nie je to 1";
    }


    public String insert(Message message) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonedb","root", "");
        System.out.println("You are now connected to database");

        statement = connection.createStatement();

        String sql = "INSERT INTO messages (message_type) " +
                "VALUES('test')";


        statement.executeUpdate(sql);

        return "vlozene";
    }




};
