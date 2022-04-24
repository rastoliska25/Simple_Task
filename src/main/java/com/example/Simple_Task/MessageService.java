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

    public String addProduct(Message newMessage) throws SQLException, ClassNotFoundException {
        //newProduct.setID("126");
        //return new Message("458", "peees");
        return input.insertt(newMessage);
    }





   /* public Product getProductById(String id){
        Predicate byId = p -> p.getId().equals(id);
        return filterProducts(byId);
    }

    private Product filterProducts(Predicate strategy) {
        return getAllProducts().stream().filter((java.util.function.Predicate<? super Product>) strategy).findFirst().orElse(null);
    }
/*
    public Product addProduct(Product newProduct) {
        newProduct.setId("126");
        return newProduct;
    }  */
}
