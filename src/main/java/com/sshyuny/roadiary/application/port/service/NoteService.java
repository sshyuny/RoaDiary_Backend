package com.sshyuny.roadiary.application.port.service;

import org.springframework.stereotype.Service;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;
import com.sshyuny.roadiary.application.port.converter.NoteConverter;
import com.sshyuny.roadiary.application.port.in.NoteUseCase;
import com.sshyuny.roadiary.domain.Note;

@Service
public class NoteService implements NoteUseCase {

    @Override
    public int addNote(NoteReqDto noteReqDto) {
        
        Note note = NoteConverter.fromNoteReqDto(noteReqDto);

        if (note.isNotValid()) throw new IllegalArgumentException();

        return 0;
    }
    
}
