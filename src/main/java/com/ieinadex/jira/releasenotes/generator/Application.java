package com.ieinadex.jira.releasenotes.generator;

import com.ieinadex.jira.releasenotes.generator.configuration.CedentConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${com.ieinadex.jira.releasenotes.generator.jiraBaseUrl}")
    private String jiraBaseUrl;

    @Autowired
    private CedentConfiguration cedentConfiguration;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            logger.info("Project started");
//            WebClient client = WebClient.builder()
//                    .baseUrl(jiraBaseUrl)
//                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                    .build();

            logger.info("base URL: {}", jiraBaseUrl);
            logger.info("number of cedents {}", cedentConfiguration.getProjects().size());


        }
        catch (Exception ex) {
            logger.error("General error starting application: {}", ex.getMessage());
        }

    }
}
