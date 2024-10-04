package com.ghana.voter.solr;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.ghana.voter.models.Voters;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Document(indexName = "voters" )
@Data
@Setter
@Getter
public class VoterSolr {
    @Id
    private long id;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String fullName;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String fatherName;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String motherName;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String votersId;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String tel;
    private Integer age;
    @Field(type = FieldType.Text)
    private String dob;
    private String gender;
    @Field(type = FieldType.Text, analyzer = "standard")

    private String town;
    private String idNumber;
    private String regYear;
    private String polCode;
    @Field(type = FieldType.Text, analyzer = "standard")

    private String polStationName;
    @Field(type = FieldType.Text, analyzer = "standard")

    private String electArea;
    private String zones;
    private String affiliation;
    private String livingStatus;
    private String religion;
    private String resident;
    private String dateDeleted;
    private String isDeleted;

    public VoterSolr(Voters voters){
        fullName=voters.getFullName();
        tel=voters.getTel();
        idNumber=voters.getIdNumber();
        gender=voters.getGender();
        dob=voters.getDob();
        town=voters.getTown();
        electArea=voters.getElectArea();
        polStationName=voters.getPolStationName();

    }



}
