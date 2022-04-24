package com.example.Simple_Task;

public class Message {
    private String id;
    private String name;
    private String message_type;
    private Long timestamp;

 /*   public Message(String id, String name) {
        this.id = id;
        this.name = name;
    }*/

    public String getID() {
        return id;
    }

    public String getname() {
        return name;
    }

    public String getMessage_type() {
        return message_type;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
