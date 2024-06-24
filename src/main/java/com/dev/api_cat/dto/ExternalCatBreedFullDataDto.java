package com.dev.api_cat.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalCatBreedFullDataDto {

    private String id;
    private String url;
    private Integer width;
    private Integer height;
    private List<ExternalCatDto> breeds;

}
