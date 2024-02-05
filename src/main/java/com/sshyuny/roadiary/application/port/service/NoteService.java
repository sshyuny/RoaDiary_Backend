package com.sshyuny.roadiary.application.port.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;
import com.sshyuny.roadiary.application.port.entity.NoteEntity;
import com.sshyuny.roadiary.application.port.in.NoteUseCase;
import com.sshyuny.roadiary.application.port.out.NoteOutPort;
import com.sshyuny.roadiary.application.port.service.converter.NoteConverter;
import com.sshyuny.roadiary.domain.Note;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService implements NoteUseCase {

    private final NoteOutPort noteOutPort;

    @Override
    public int addNote(NoteReqDto noteReqDto) {
        
        Note note = NoteConverter.fromNoteReqDto(noteReqDto);

        if (note.isNotValid()) throw new IllegalArgumentException();

        NoteEntity noteEntity = NoteConverter.fromDomainToEntity(note);

        noteOutPort.addNote(noteEntity);

        return 1;
    }
    
}
