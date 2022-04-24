package com.example.Simple_Task;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.text.ParseException;

@RestController
public class MessageRestController {

    @Autowired
    MessageService messageService;

    @PostMapping("/metrics")
    public String test() throws SQLException, ClassNotFoundException {
        return messageService.getCounters();
    }

    @PostMapping("/metrics/date")
    public String test(@RequestParam("YYMMDD") String date) throws SQLException, ClassNotFoundException, ParseException {
        return messageService.getCounters(date);
    }

    @PostMapping("/messages")
    public String test(@RequestBody Message newMessage) throws SQLException, ClassNotFoundException {
        return messageService.addMessage(newMessage);
    }
}
