package com.ieinadex.jira.releasenotes.generator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class JiraService {

    @Value("${com.ieinadex.jira.releasenotes.generator.jiraBaseUrl}")
    private String jiraBaseUrl;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public JiraService() {
        logger.info("base URL: {}", jiraBaseUrl);
    }

    public String getTicketInfo(String JiraTicketID) {
        String jsonData = "";
        StringBuilder url = new StringBuilder(jiraBaseUrl);
        url.append(String.format("/jira/rest/api/2/issue/{}", JiraTicketID));

        WebClient client = WebClient.builder()
                .baseUrl(url.toString())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return jsonData;
    }
}
