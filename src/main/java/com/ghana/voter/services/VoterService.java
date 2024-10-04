package com.ghana.voter.services;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ghana.voter.models.VoterDetail;
import com.ghana.voter.models.Voters;
import com.ghana.voter.repositories.VoterPicInformationRepository;
import com.ghana.voter.repositories.VotersRepository;
import com.ghana.voter.solr.VoterESRepository;
import com.ghana.voter.solr.VoterSolr;
@Service
public class VoterService {

    @Autowired
    VoterPicInformationRepository voterPicInformationRepository;

    @Autowired
    VotersRepository votersRepository;
   
    @Autowired
    VoterESRepository repository;




    @Value("${html.location}")
    private String htmlLocation;

    public static void main(String[] args) {
       
    }

    public String saveFiles(List<String> files) {
        List<VoterDetail> voters = new ArrayList<>();

        for (String s : files) {

            voters.addAll(loadFile(s));
        }
System.err.println(voters.size() + " Voters added");
        return voters.size() + " Voters added";
    }

    public List<VoterDetail> loadFile(String file) {
        List<VoterDetail> voters = new ArrayList<>();
        try {
            Document doc = Jsoup.parse(new File(htmlLocation+file));
            Elements para = doc.getElementsByTag("p");

            String pollingStation = para.get(7).text();

            Elements newsHeadlines = doc.getElementsByTag("table");

            @SuppressWarnings("unused")
            int count = 0;
            for (Element headline : newsHeadlines) {
                Elements images = headline.getElementsByTag("img");
                String data = headline.text().replace("Tick", "");
                if (data.length() > 0) {
                    VoterDetail voter = new VoterDetail(data.strip().split(":"));
                    voter.setPicture(images.get(0).attr("src"));
                    voter.setPollingStation(pollingStation);
                    voters.add(voter);
                    //  '//+"-----"+);
                    count++;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        voterPicInformationRepository.saveAllAndFlush(voters);
        return voters;

    }

public void loadDB(){
List<Voters> voters = votersRepository.findAll();
List<VoterSolr> voteSolrs = new ArrayList<>();
voters.forEach(e ->{
VoterSolr s = new VoterSolr(e);
voteSolrs.add(s);

});


           
for (int i=0; i<Math.ceil(voteSolrs.size()/1000) ; i++){

    repository.saveAll( voteSolrs.subList(i*1000,(i*1000)+1000));
}



}


public Voters getVoterDetails(String voterid){
   Voters k= votersRepository.findByVoter(voterid).get();
   VoterDetail details = voterPicInformationRepository.findByVotersId(voterid).get();
  k.setDetail(details);
   return k;
}
  }
