package com.dev.api_cat.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import com.dev.api_cat.persistence.models.CatBreedModel;

public interface CatBreedRepository  extends MongoRepository<CatBreedModel, String> {

    @Query("{ '$or': [ { 'uuid': ?0 }, { 'externalid': ?0 }, { 'name': ?0 }, { 'origin': ?0 }, { 'description': ?0 }, { 'altNames': ?0 }, { 'lifeSpan': ?0 }, { 'referenceImageId': ?0 } ] }")
    Page<CatBreedModel> findByAnyField(String value, Pageable pageable);
    
}
