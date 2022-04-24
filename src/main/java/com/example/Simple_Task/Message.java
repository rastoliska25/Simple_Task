package com.example.Simple_Task;

import java.util.Optional;

public class Message {
    private String message_type;
    private Long timestamp;
    private Long origin;
    private Long destination;
    private Long duration;
    private String status_code;
    private String status_description;
    private String message_content;
    private String message_status;

    public String getMessage_type() {
        return Optional.ofNullable(message_type).orElse("");
    }

    public Long getTimestamp() {
        return Optional.ofNullable(timestamp).orElse((long) 0);
    }

    public Long getOrigin() {
        return Optional.ofNullable(origin).orElse((long) 0);
    }

    public Long getDestination() {
        return Optional.ofNullable(destination).orElse((long) 0);
    }

    public Long getDuration() {
        return Optional.ofNullable(duration).orElse((long) 0);
    }

    public String getStatus_code() {
        return Optional.ofNullable(status_code).orElse("");
    }

    public String getStatus_description() {
        return Optional.ofNullable(status_description).orElse("");
    }

    public String getMessage_content() {
        return Optional.ofNullable(message_content).orElse("");
    }

    public String getMessage_status() {
        return Optional.ofNullable(message_status).orElse("");
    }
}
