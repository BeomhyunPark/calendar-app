package com.example.calendarapp;

import com.example.calendarapp.config.FilePathProperties;
import com.example.calendarapp.event.*;
import com.example.calendarapp.reader.EventCsvReader;
import com.example.calendarapp.reader.RawCsvReader;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CalendarAppApplication implements CommandLineRunner {

    private final FilePathProperties filePathProperties;

    public static void main(String[] args) {
        SpringApplication.run(CalendarAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        Schedule schedule = new Schedule();
        EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());

        List<Meeting> meetings = csvReader.readMeetings(filePathProperties.getMeeting());
        meetings.forEach(schedule::add);

        List<NoDisturbance> noDisturbances = csvReader.readNoDisturbance(filePathProperties.getNoDisturbance());
        noDisturbances.forEach(schedule::add);

        List<OutOfOffice> outOfOffices = csvReader.readOutOfOffice(filePathProperties.getOutOfOffice());
        outOfOffices.forEach(schedule::add);

        List<Todo> todos = csvReader.readTodo(filePathProperties.getTodo());
        todos.forEach(schedule::add);

        schedule.printAll();
    }
}