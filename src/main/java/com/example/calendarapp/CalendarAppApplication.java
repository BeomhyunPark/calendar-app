package com.example.calendarapp;

import com.example.calendarapp.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CalendarAppApplication {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        HashSet<String> participants = new HashSet<>();
        participants.add("John");
        Meeting meeting1 = new Meeting(
                1, "meeting1",
                ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants, "meetingRoomA", "agenda"
        );

        schedule.add(meeting1);

        Todo todo1 = new Todo (
                2, "todo1",
                ZonedDateTime.now().plusHours(3), ZonedDateTime.now().plusHours(24),
                "항릴"
        );
        schedule.add(todo1);

        schedule.printAll();
    }

}
