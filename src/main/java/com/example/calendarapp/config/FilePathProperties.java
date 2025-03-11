package com.example.calendarapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "file.path")
public class FilePathProperties {
    private String meeting;
    private String noDisturbance;
    private String outOfOffice;
    private String todo;
}
