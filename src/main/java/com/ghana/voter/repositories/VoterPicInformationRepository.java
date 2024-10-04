package com.ghana.voter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ghana.voter.models.VoterDetail;
@Repository
public interface VoterPicInformationRepository extends JpaRepository<VoterDetail, Long> {

    Optional<VoterDetail> findByVotersId(String votersId);
}
