package com.dev.api_cat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatBreedFullDataDto {

    private String id;
    private String url;
    private String temperament;
    private Integer adaptability;
    private Integer childFriendly;
    private Integer dogFriendly;
    private Integer energyLevel;
    private Integer intelligence;
    private Integer strangerFriendly;
    private Integer socialNeeds;
    private String wikipediaUrl;
    private CatBreedDto breed;

}
