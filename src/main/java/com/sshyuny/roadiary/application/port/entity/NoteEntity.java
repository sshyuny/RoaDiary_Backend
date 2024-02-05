package com.sshyuny.roadiary.application.port.entity;

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

    public static NoteEntity create(String content) {
        NoteEntity noteEntity = new NoteEntity(content);
        return noteEntity;
    }
    protected NoteEntity() {};
    private NoteEntity(String content) {
        this.content = content;
    }

}
