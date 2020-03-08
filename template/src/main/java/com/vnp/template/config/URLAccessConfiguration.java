package com.vnp.template.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author quangtt
 */
@Component
@ConfigurationProperties("ses.security")
public class URLAccessConfiguration {

    private List<URLAccessEntity> authorizations;
    private String ignoring;

    public List<URLAccessEntity> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<URLAccessEntity> authorizations) {
        this.authorizations = authorizations;
    }

    public String getIgnoring() {
        return ignoring;
    }

    public void setIgnoring(String ignoring) {
        this.ignoring = ignoring;
    }

}
