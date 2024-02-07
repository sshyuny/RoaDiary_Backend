package com.sshyuny.roadiary.domain;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class NoteTest {
    
    @Test
    void 검증테스트_startTime이_endTime보다_느림() {
        LocalDateTime startTime = LocalDateTime.of(2024, 2, 7, 0, 0, 1);
        LocalDateTime endTime = LocalDateTime.of(2024, 2, 7, 0, 0, 0);

        Note note = Note.create("test", startTime, endTime);
        
        assertThat(note.isNotNormalStartAndEndTime()).isTrue();
        assertThat(note.isNotValid()).isTrue();
    }

    @Test
    void 검증테스트_startTime이_endTime과_동일() {
        LocalDateTime someTime = LocalDateTime.of(2024, 2, 7, 0, 0, 1);
        LocalDateTime sameTime = LocalDateTime.of(2024, 2, 7, 0, 0, 1);

        LocalDateTime startTime = someTime;
        LocalDateTime endTime = sameTime;

        Note note = Note.create("test", startTime, endTime);
        
        assertThat(note.isNotNormalStartAndEndTime()).isTrue();
        assertThat(note.isNotValid()).isTrue();
    }

    @Test
    void 검증테스트_endTime이_startTime보다_너무늦음() {
        LocalDateTime startTime = LocalDateTime.of(2024, 2, 7, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 2, 10, 0, 0, 1);

        Note note = Note.create("test", startTime, endTime);
        
        assertThat(note.isNotNormalStartAndEndTime()).isTrue();
        assertThat(note.isNotValid()).isTrue();
    }
}
