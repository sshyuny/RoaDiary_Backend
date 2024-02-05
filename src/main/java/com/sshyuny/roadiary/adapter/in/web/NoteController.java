package com.sshyuny.roadiary.adapter.in.web;

import com.sshyuny.roadiary.adapter.dto.NoteReqDto;
import com.sshyuny.roadiary.application.port.in.NoteUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteUseCase noteUseCase;
    
    @PostMapping("/note")
    public Object postThing(@Validated @RequestBody NoteReqDto noteReqDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("error={}", bindingResult);
        }

        long notedNum = noteUseCase.addNote(noteReqDto);

        if (notedNum == 0) return null;

        return null;
    }
    
}
