package com.sshyuny.roadiary.common;

import com.sshyuny.roadiary.exception.RoaDiaryIllegalArgumentException;

import jakarta.servlet.http.HttpSession;

public class SessionManager {

    private static final String MEMBER_ID = "memberId";
    
    public static Long getMemberIdFromSession(HttpSession session) {
        Object memberId = session.getAttribute(MEMBER_ID);
        if (memberId == null) throw new RoaDiaryIllegalArgumentException("not logined");
        return (Long) memberId;
    }

    public static boolean isLoginStatus(HttpSession session) {
        Object memberId = session.getAttribute(MEMBER_ID);
        if (memberId == null) return false;
        return true;
    }
}
