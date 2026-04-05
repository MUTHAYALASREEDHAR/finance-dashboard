package com.example.finance_dashboard.security;

import jakarta.servlet.http.HttpServletRequest;

public class AuthUtil {

    public static void checkAdmin(HttpServletRequest req) {
        String role = (String) req.getAttribute("role");

        if (role == null) {
            throw new RuntimeException("No Role Found (Token Missing)");
        }

        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("Access Denied");
        }
    }
}