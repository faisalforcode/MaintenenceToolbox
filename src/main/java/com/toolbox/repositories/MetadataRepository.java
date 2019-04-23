package com.toolbox.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.toolbox.model.Metadata;

@Repository
public interface MetadataRepository extends ElasticsearchRepository<Metadata, Integer> {

}
