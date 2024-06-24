package com.dev.api_cat.persistence.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "catBreeds")
public class CatBreedModel {

    @Id
    private String uuid;
    private String externalid;
    private String name;
    private String origin;
    private String description;
    private String altNames;
    private String lifeSpan;
    private String referenceImageId;

}
