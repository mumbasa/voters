package com.ghana.voter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ghana.voter.models.Voters;
@Repository
public interface VotersRepository  extends  JpaRepository<Voters, Long>{
    @Query(value="SELECT * FROM voters LIMIT 10",nativeQuery=true)
    List<Voters> findAllTen();

    @Query(value="SELECT * FROM voters where voters_id=?1",nativeQuery=true)
    Optional<Voters> findByVoter(String votersId);

}
