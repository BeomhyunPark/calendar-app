package com.example.calendarapp.event;

import com.example.calendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class Todo extends AbstractEvent{

    private String description;

    public Todo(int id, String title,
                ZonedDateTime StartAt, ZonedDateTime endAt,
                String description) {
        super(id, title, StartAt, endAt);
        this.description = description;
    }

    @Override
    public void print() {
        System.out.printf("[할 일] %s : %s%n", getTitle(), description);
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.TO_DO;

    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }
}
