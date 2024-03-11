package com.sshyuny.roadiary.application.port.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NOTE")
public class NoteEntity {
    
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
    
    private String content;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static NoteEntity create(Long memberId, String content, LocalDateTime startTime, LocalDateTime endTime) {
        MemberEntity memberEntity = MemberEntity.create(memberId);
        NoteEntity noteEntity = new NoteEntity(memberEntity, content, startTime, endTime);
        return noteEntity;
    }

    protected NoteEntity() {};
    private NoteEntity(MemberEntity memberEntity, String content, LocalDateTime startTime, LocalDateTime endTime) {
        this.member = memberEntity;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
