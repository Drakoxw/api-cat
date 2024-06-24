package com.dev.api_cat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.api_cat.dto.CatBreedFullDataDto;
import com.dev.api_cat.dto.ResponseDto;
import com.dev.api_cat.persistence.models.CatBreedModel;
import com.dev.api_cat.service.IApiCat;

@Controller
public class GraphQLController {

    @Autowired
    private IApiCat apiCatService;

    @QueryMapping(name = "searchBreedList")
    public List<CatBreedModel> search(@Argument String query, @Argument String limit) {
        return apiCatService.searchByAnyField(query, Integer.parseInt(limit));
    }

    @QueryMapping(name = "getBreedDetail")
    public CatBreedFullDataDto getBreedData(@Argument String uuid) {
        return apiCatService.getBreedData(uuid);
    }

    @QueryMapping(name = "getBreedList")
    public List<CatBreedModel> listBreeds() {
        return apiCatService.listAll();
    }

    @MutationMapping(name = "resetDataBase")
    public ResponseDto updateDataBase() {

        apiCatService.dropDataBase();
        apiCatService.fillDataBase();

        ResponseDto response = new ResponseDto();
        response.setMessage("Base de datos actualizada");
        response.setSuccess(true);

        return response;

    }

}
