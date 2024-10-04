package com.ghana.voter;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ghana.voter.services.VoterService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.ghana.voter.repositories")
@EnableElasticsearchRepositories(basePackages="com.ghana.voter.solr")
public class VoterApplication {

    @Autowired
    VoterService voterService;


    public static void main(String[] args) {
        SpringApplication.run(VoterApplication.class, args);
    }

	@PostConstruct
    public void loadData() {
        String[] files = {"voter.html", "voter2.html"};
        voterService.saveFiles(Arrays.asList(files));

    }

	//@PostConstruct
    public void loadDataDB() {
       
        voterService.loadDB();

    }
}
