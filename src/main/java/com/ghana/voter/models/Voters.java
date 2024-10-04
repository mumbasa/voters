package com.ghana.voter.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Voters {
   
    private String photo;
    private String fullName;
    private String fatherName;
    private String motherName;
    @Id
    @Column(name="voters_id")
    private String id;
    private String tel;
    private Integer age;
    private String dob;
    private String gender;
    private String town;
    private String idNumber;
    private String regYear;
    private String polCode;
    private String polStationName;
    private String electArea;
    private String zones;
    private String affiliation;
    private String livingStatus;
    private String religion;
    private String resident;
    private String dateDeleted;
    private String isDeleted;
    @Transient 
    private VoterDetail detail;
   

}
