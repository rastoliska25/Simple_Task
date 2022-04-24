package com.example.Simple_Task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;


@RestController
public class MessageRestController {

    @Autowired
    MessageService messageService;

    @GetMapping("/metrics")
    public List<Message> getAllProducts() {

        return messageService.getAllProducts();
    }

  /*  @PostMapping("/product")
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    public Message addProduct(@RequestBody Message newMessage) {
        return messageService.addProduct(newMessage);
    }*/

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
    public String test(@RequestBody Message newMessage) throws SQLException, ClassNotFoundException {
        return messageService.addMessage(newMessage);
    }
}
