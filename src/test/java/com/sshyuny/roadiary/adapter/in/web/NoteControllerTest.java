package com.sshyuny.roadiary.adapter.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sshyuny.roadiary.adapter.dto.NoteReqDto;

@TestInstance(Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
public class NoteControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeAll
    void init() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void postThing_테스트() throws Exception {
        
        NoteReqDto noteReqDto = new NoteReqDto();
        noteReqDto.setContents("contents");
        noteReqDto.setStartTime(LocalDateTime.of(2024, 2, 2, 2, 2));
        noteReqDto.setEndTime(LocalDateTime.of(2024, 2, 2, 5, 2));

        String str = objectMapper.writeValueAsString(noteReqDto);

        mockMvc.perform(
            post("/note")
            .contentType(MediaType.APPLICATION_JSON)
            .content(str)
            )
        .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
