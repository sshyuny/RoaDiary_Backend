package com.sshyuny.roadiary.domain;

import lombok.Getter;

@Getter
public class Note {
    
    private Long Id;

    public boolean isNotValid() {
        return false;
    }

}
