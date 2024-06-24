package com.dev.api_cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatBreedDto {

    private String uuid;
    private String externalid;
    private String name;
    private String origin;
    private String description;
    private String altNames;
    private String lifeSpan;
    private String referenceImageId;

}
