package com.dev.api_cat.service;

import java.util.List;

import com.dev.api_cat.dto.ExternalCatBreedFullDataDto;
import com.dev.api_cat.dto.ExternalCatDto;

public interface IExternalCatApi {

    /**
     * Busca en la api de `https://thecatapi.com/` las razas de los gatos
     *
     * @return un listado ExternalCatDto con toda la data que devuelve la api
     */
    List<ExternalCatDto> listCatsApi();

    /**
     * Busca en la api de `https://thecatapi.com/` la raza de los gatos
     *
     * @param referenceId referenceId > `CatBreedModel.referenceImageId`
     * @return ExternalCatBreedFullDataDto con toda la data que devuelve la api
     */
    ExternalCatBreedFullDataDto findCatByBreedApi(String referenceId);

}
