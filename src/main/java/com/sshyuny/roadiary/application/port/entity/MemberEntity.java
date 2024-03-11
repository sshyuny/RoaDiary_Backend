package com.sshyuny.roadiary.application.port.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class MemberEntity {
    
    @Id @GeneratedValue
    private Long memberId;

    private String memberName;

    public static MemberEntity create(Long memberId) {
        return new MemberEntity(memberId);
    } 

    protected MemberEntity(Long memberId) {
        this.memberId = memberId;
    }

}
