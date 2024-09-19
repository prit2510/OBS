package com.OBS.OBS.helper;

import org.springframework.security.core.Authentication;

public class Helper {
    public static String getaccountNumberOfLoggedInUser(Authentication authentication) {
        System.out.println("Getting data from local database");
        return authentication.getName();
    }
}
