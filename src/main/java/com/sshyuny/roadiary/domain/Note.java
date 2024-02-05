package com.sshyuny.roadiary.domain;

import lombok.Getter;

@Getter
public class Note {
    
    private Long Id;

    private String content;

    public static Note create(String content) {
        Note note = new Note(content);
        return note;
    }

    private Note() {};
    private Note(String content) {
        this.content = content;
    }

    public boolean isNotValid() {
        return false;
    }

}
