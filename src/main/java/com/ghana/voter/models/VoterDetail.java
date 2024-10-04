package com.ghana.voter.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(name="voter_details")
@Entity
public class VoterDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    private String contact;
    @Column(columnDefinition="text")
    private String picture;
  
    @Column(name = "voters_id")
    private String votersId;
    private String gender;
    private String pollingStation;
    @OneToOne
    private Voters voters;

    public VoterDetail(String data[]) {
        name = data[4].strip();
        gender = data[3].strip().split("\\s")[0];
        age = Integer.parseInt(data[2].strip().split("\\s")[0]);
        votersId = data[1].strip().split("\\s")[0];
        System.err.println();
    }
    public VoterDetail(){

    }
}
