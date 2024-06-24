package com.dev.api_cat.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import com.dev.api_cat.persistence.models.CatBreedModel;

public interface CatBreedRepository  extends MongoRepository<CatBreedModel, String> {

    @Query("{ '$or': [ { 'uuid': { $regex: ?0, $options: 'i' } }, { 'externalid': { $regex: ?0, $options: 'i' } }, { 'name': { $regex: ?0, $options: 'i' } }, { 'origin': { $regex: ?0, $options: 'i' } }, { 'description': { $regex: ?0, $options: 'i' } }, { 'altNames': { $regex: ?0, $options: 'i' } }, { 'lifeSpan': { $regex: ?0, $options: 'i' } }, { 'referenceImageId': { $regex: ?0, $options: 'i' } } ] }")
    Page<CatBreedModel> findByAnyField(String value, Pageable pageable);
    
}
