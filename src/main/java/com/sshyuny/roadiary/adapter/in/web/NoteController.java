package com.sshyuny.roadiary.adapter.in.web;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;
import com.sshyuny.roadiary.application.port.in.NoteUseCase;
import com.sshyuny.roadiary.common.SessionManager;
import com.sshyuny.roadiary.exception.RoaDiaryIllegalArgumentException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteUseCase noteUseCase;
    
    @PostMapping("/note")
    public Object postThing(@Validated @RequestBody NoteReqDto noteReqDto, BindingResult bindingResult, HttpServletRequest request,
            HttpSession session) {

        if (bindingResult.hasErrors()) {
            log.info("error={}", bindingResult);
            throw new RoaDiaryIllegalArgumentException();
        }

        Long memberId = SessionManager.getMemberIdFromSession(session);

        noteUseCase.addNote(noteReqDto, memberId);

        return null;
    }
    
}
