package com.sshyuny.roadiary.application.port.in;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;

public interface NoteUseCase {
    
    void addNote(NoteReqDto noteReqDto, Long memberId);

}
