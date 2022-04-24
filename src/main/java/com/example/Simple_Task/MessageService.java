package com.example.Simple_Task;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;

@Service
public class MessageService {
    Input input = new Input();

    public String getCounters() throws SQLException, ClassNotFoundException {
        return input.counters();
    }

    public String getCounters(String date) throws SQLException, ClassNotFoundException, ParseException {
        return input.counters(date);
    }

    public String addMessage(Message newMessage) throws SQLException, ClassNotFoundException {
        return input.insert(newMessage);
    }
}
