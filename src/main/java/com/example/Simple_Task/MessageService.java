package com.example.Simple_Task;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    Input input = new Input();

    public String getCounters(String date) throws SQLException, ClassNotFoundException {
        return input.counters(date);
    }

    public String addMessage(Message newMessage) throws SQLException, ClassNotFoundException {
        return input.insert(newMessage);
    }
}
