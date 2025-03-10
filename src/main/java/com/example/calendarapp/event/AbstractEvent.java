package com.example.calendarapp.event;

import com.example.calendarapp.event.update.AbstractAuditableEvent;
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

    public void validateAndUpdate(AbstractAuditableEvent update) {
        if (deletedYn == true) {
            throw new InvalidEventException("Event has already been deleted");
        }

        defaultUpdate(update);
        update(update);
    }

    private void defaultUpdate(AbstractAuditableEvent update) {
        this.title = update.getTitle();
        this.startAt = update.getStartAt();
        this.endAt = update.getEndAt();
        this.duration = Duration.between(this.startAt, this.endAt);
        this.modifiedAt = ZonedDateTime.now();
    }

    protected abstract void update(AbstractAuditableEvent update);

    public void delete(boolean deletedYn) {
        this.deletedYn = deletedYn;
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
