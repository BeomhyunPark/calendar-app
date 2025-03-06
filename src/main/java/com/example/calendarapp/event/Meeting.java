package com.example.calendarapp.event;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.logging.Logger;

public class Meeting extends AbstractEvent{

    Logger logger = Logger.getLogger(getClass().getName());

    private Set<String> participants;
    private String meetingRoom;
    private String agenda;

    public Meeting(int id, String title,
                   ZonedDateTime startAt, ZonedDateTime endAt,
                   Set<String> participants, String meetingRoom, String agenda) {
        super(id, title, startAt, endAt);

        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }

    @Override
    public void print() {
        logger.info("Meeting" + getTitle());
    }
}
