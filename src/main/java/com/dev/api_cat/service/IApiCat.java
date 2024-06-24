package com.dev.api_cat.service;

import java.util.List;

import com.dev.api_cat.dto.CatBreedFullDataDto;
import com.dev.api_cat.persistence.models.CatBreedModel;

public interface IApiCat {

    /**
     * Busca en mongo cualquier coincidencia que se le pase por parametros
     * @return List<CatBreedModel>
     */
    List<CatBreedModel> searchByAnyField(String value, int limit);
    
    /** 
     * Returna la informacion detallada de la raza
     * @return CatBreedFullDataDto
    */
    CatBreedFullDataDto getBreedData(String uuid);

    /**
     * Listar todas las razas desde mongo
     * @return List<CatBreedModel>
     */
    List<CatBreedModel> listAll();

    /**
     * Llena la base de datos de mongo con los datos de la api external
     */
    void fillDataBase();

    /**
     * Limpia la base de datos de mongo
     */
    void dropDataBase();

}
