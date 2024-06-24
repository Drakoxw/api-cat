package com.dev.api_cat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalCatDto {
    private String id;
    private String name;
    @JsonProperty("cfa_url")
    private String cfaUrl;
    @JsonProperty("vetstreet_url")
    private String vetstreetUrl;
    @JsonProperty("vcahospitals_url")
    private String vcahospitalsUrl;
    private String temperament;
    private String origin;
    @JsonProperty("country_codes")
    private String countryCodes;
    @JsonProperty("country_code")
    private String countryCode;
    private String description;
    @JsonProperty("life_span")
    private String lifeSpan;
    private Integer indoor;
    private Integer lap;
    @JsonProperty("alt_names")
    private String altNames;
    private Integer adaptability;
    @JsonProperty("affection_level")
    private Integer affectionLevel;
    @JsonProperty("child_friendly")
    private Integer childFriendly;
    @JsonProperty("dog_friendly")
    private Integer dogFriendly;
    @JsonProperty("energy_level")
    private Integer energyLevel;
    private Integer grooming;
    @JsonProperty("health_issues")
    private Integer healthIssues;
    private Integer intelligence;
    @JsonProperty("shedding_level")
    private Integer sheddingLevel;
    @JsonProperty("social_needs")
    private Integer socialNeeds;
    @JsonProperty("stranger_friendly")
    private Integer strangerFriendly;
    private Integer vocalisation;
    private Integer experimental;
    private Integer hairless;
    private Integer natural;
    private Integer rare;
    private Integer rex;
    @JsonProperty("suppressed_tail")
    private Integer suppressedTail;
    @JsonProperty("short_legs")
    private Integer shortLegs;
    @JsonProperty("wikipedia_url")
    private String wikipediaUrl;
    private Integer hypoallergenic;
    @JsonProperty("reference_image_id")
    private String referenceImageId;
}
