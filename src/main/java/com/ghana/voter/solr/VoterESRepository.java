
package com.ghana.voter.solr;
import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VoterESRepository extends ElasticsearchRepository<VoterSolr, String> {

    List<VoterSolr> findByFullName(String name);
}
