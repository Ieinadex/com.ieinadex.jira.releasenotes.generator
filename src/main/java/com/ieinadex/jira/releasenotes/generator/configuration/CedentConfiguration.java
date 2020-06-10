package com.ieinadex.jira.releasenotes.generator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("cedent")
@PropertySource("classpath:cedent_projects.properties")
public class CedentConfiguration {

    public List<Projects> getProjects() {
        return projects;
    }

    private List<Projects> projects = new ArrayList<>();

    public static class Projects {
        private String name;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
