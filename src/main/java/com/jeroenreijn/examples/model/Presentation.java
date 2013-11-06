package com.jeroenreijn.examples.model;

import java.util.Date;

/**
 * Simple representation of a Presentation
 * @author Jeroen Reijn
 */
public class Presentation {

    private Long id;
    private String title;
    private String speakerName;
    private String summary;
    private String room;
    private Date startTime;
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(final String speakerName) {
        this.speakerName = speakerName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(final String room) {
        this.room = room;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(final Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }
}
