package com.sshyuny.roadiary.domain;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Note {
    
    private Long id;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Note create(String content, LocalDateTime startTime, LocalDateTime endTime) {
        Note note = new Note(content, startTime, endTime);
        return note;
    }

    private Note() {};
    private Note(String content, LocalDateTime startTime, LocalDateTime endTime) {
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isNotValid() {
        if (isNotNormalStartAndEndTime()) return true;
        if (isNotNormalContent()) return true;
        return false;
    }

    boolean isNotNormalStartAndEndTime() {
        if (startTime.isAfter(endTime)) return true;
        if (startTime.isEqual(endTime)) return true;
        if (endTime.minusHours(72).isAfter(startTime)) return true;
        return false;
    }

    boolean isNotNormalContent() {
        if (content.length() > 320) return true;
        return false;
    }

}
