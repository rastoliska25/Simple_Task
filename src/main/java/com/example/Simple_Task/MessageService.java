package com.example.Simple_Task;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    Input input = new Input();

    public List<Message> getAllProducts() {
        List<Message> listOfMessages = new ArrayList<>();
        //listOfMessages.add(new Message("123", "iphone X"));
        //listOfMessages.add(new Message("251", "samsung Y"));
        return listOfMessages;
    }

    public String addMessage(Message newMessage) throws SQLException, ClassNotFoundException {
        return input.insert(newMessage);
    }
}
