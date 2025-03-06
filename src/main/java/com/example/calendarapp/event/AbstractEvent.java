package com.example.calendarapp.event;

import com.example.calendarapp.exception.InvalidEventException;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;

public abstract class AbstractEvent implements Event {
    private final int id;
    private String title;

    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private Duration duration;

    private final ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;

    private boolean deletedYn;

    protected AbstractEvent (int id, String title,
                             ZonedDateTime startAt, ZonedDateTime endAt) {
        if (startAt.isAfter(endAt)) {
            throw new InvalidEventException("startAt must be after endAt");
        }

        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.duration = Duration.between(startAt, endAt);

        ZonedDateTime now = ZonedDateTime.now();
        this.createdAt = now;
        this.modifiedAt = now;

        this.deletedYn = false;
    }
    public String getTitle() {
        return this.title;
    }
    public ZonedDateTime getStartAt() {
        return this.startAt;
    }
    public ZonedDateTime getEndAt() {
        return this.endAt;
    }
}
