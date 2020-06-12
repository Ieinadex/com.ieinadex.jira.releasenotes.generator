package com.ieinadex.jira.releasenotes.generator;

import com.ieinadex.jira.releasenotes.generator.configuration.CedentConfiguration;
import com.ieinadex.jira.releasenotes.generator.service.JiraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${com.ieinadex.jira.releasenotes.generator.jiraBaseUrl}")
    private String jiraBaseUrl;

    @Autowired
    private CedentConfiguration cedentConfiguration;

    @Autowired
    private JiraService jiraService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            logger.info("Project started");

            jiraService.getTicketInfo("RUS-1115");


            logger.info("number of cedents {}", cedentConfiguration.getProjects().size());


        }
        catch (Exception ex) {
            logger.error("General error starting application: {}", ex.getMessage());
        }

    }
}
