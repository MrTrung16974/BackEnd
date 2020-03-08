package com.vnp.template.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    private RequestCache requestCache = new HttpSessionRequestCache();
    private static final String DISABLE_URL = "notification";
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String referer = request.getHeader("referer");
        logger.debug("Login success. Username: {}, IP: {}, Refer: {}", authentication.getName(), request.getRemoteAddr(), referer);
        referer = referer.substring(0, referer.lastIndexOf("/"));
        logger.debug("Referer: {}", referer);

        if (authentication.getAuthorities().size() == 0) {
            response.sendRedirect(referer + "/home");
            return;
        }  else {
            SavedRequest savedRequest = requestCache.getRequest(request, response);
            if (savedRequest == null) {
                response.sendRedirect(referer + "/");
                return;
            }
            String targetUrlParameter = getTargetUrlParameter();
            if (isAlwaysUseDefaultTargetUrl()
                    || (targetUrlParameter != null && StringUtils.hasText(request
                    .getParameter(targetUrlParameter)))) {
                requestCache.removeRequest(request, response);
                super.onAuthenticationSuccess(request, response, authentication);
                return;
            }

            clearAuthenticationAttributes(request);

            // Use the DefaultSavedRequest URL
            String targetUrl = savedRequest.getRedirectUrl();
            if (targetUrl.contains(DISABLE_URL)) {
                response.sendRedirect(referer + "/");
                return;
            }
            logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
        }
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}
