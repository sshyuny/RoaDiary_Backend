package com.sshyuny.roadiary.application.port.service.converter;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;
import com.sshyuny.roadiary.application.port.entity.NoteEntity;
import com.sshyuny.roadiary.domain.Note;

public class NoteConverter {
    
    public static Note fromNoteReqDto(NoteReqDto noteReqDto) {
        Note note = Note.create(noteReqDto.getContents());
        return note;
    }

    public static NoteEntity fromDomainToEntity(Note note) {
        NoteEntity noteEntity = NoteEntity.create(note.getContent());
        return noteEntity;
    }
}
