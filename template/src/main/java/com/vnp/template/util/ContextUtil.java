package com.vnp.template.util;

import javax.servlet.http.HttpServletRequest;

public class ContextUtil {
    public static String getRemoteIp(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Forwarded-For");
        if (remoteAddr == null || remoteAddr.isEmpty()) remoteAddr = request.getRemoteAddr();
        if (remoteAddr != null && remoteAddr.contains(",")) remoteAddr = remoteAddr.split(",")[0];
        return remoteAddr;
    }

}
