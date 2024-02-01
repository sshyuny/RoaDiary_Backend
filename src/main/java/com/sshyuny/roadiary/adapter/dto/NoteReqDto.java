package com.sshyuny.roadiary.adapter.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class NoteReqDto {
    
    @NotBlank
    private String contents;

    @Max(200)
    private Integer maxInt;
}
