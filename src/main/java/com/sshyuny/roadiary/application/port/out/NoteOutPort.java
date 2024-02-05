package com.sshyuny.roadiary.application.port.out;

import com.sshyuny.roadiary.application.port.entity.NoteEntity;

public interface NoteOutPort {
    
    public void addNote(NoteEntity noteEntity);
    
}
