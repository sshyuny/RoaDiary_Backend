package com.sshyuny.roadiary.application.port.service.converter;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;
import com.sshyuny.roadiary.application.port.entity.NoteEntity;
import com.sshyuny.roadiary.domain.Note;

public class NoteConverter {
    
    public static Note fromNoteReqDto(NoteReqDto noteReqDto, Long memberId) {
        Note note = Note.create(memberId, noteReqDto.getContents(), noteReqDto.getStartTime(), noteReqDto.getEndTime());
        return note;
    }

    public static NoteEntity fromDomainToEntity(Note note) {
        NoteEntity noteEntity = NoteEntity.create(note.getMemberId(), note.getContent(), note.getStartTime(), note.getEndTime());
        return noteEntity;
    }
}
