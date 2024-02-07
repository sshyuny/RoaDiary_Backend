package com.sshyuny.roadiary.application.port.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "NOTE")
public class NoteEntity {
    
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;
    
    private String content;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static NoteEntity create(String content, LocalDateTime startTime, LocalDateTime endTime) {
        NoteEntity noteEntity = new NoteEntity(content, startTime, endTime);
        return noteEntity;
    }
    protected NoteEntity() {};
    private NoteEntity(String content, LocalDateTime startTime, LocalDateTime endTime) {
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
