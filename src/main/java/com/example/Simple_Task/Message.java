package com.example.Simple_Task;

public class Message {
    private String message_type;
    private Long timestamp;
    private Long origin;
    private Long destination;
    private int duration;
    private String status_code;
    private String status_description;
    private String message_content;
    private String message_status;

    public String getMessage_type() {
        return message_type;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Long getOrigin() {
        return origin;
    }

    public Long getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public String getStatus_code() {
        return status_code;
    }

    public String getStatus_description() {
        return status_description;
    }

    public String getMessage_content() {
        return message_content;
    }

    public String getMessage_status() {
        return message_status;
    }
}
