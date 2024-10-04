package com.ghana.voter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ghana.voter.models.Voters;
import com.ghana.voter.services.VoterService;

@RestController
public class VoterController {

    @Autowired
    VoterService service;

    @GetMapping("/voter/information")
    public Voters getVoterDetail(@RequestParam String number){
    
        return  service.getVoterDetails(number);

        
    }

}
