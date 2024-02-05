package com.sshyuny.roadiary.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.sshyuny.roadiary.application.port.entity.NoteEntity;
import com.sshyuny.roadiary.application.port.out.NoteOutPort;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class NoteRepository implements NoteOutPort {

    private final EntityManager em;
    
    @Override
    public void addNote(NoteEntity noteEntity) {
        em.persist(noteEntity);
    }
}
