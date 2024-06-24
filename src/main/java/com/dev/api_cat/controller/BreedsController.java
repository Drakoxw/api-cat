package com.dev.api_cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api_cat.dto.CatBreedFullDataDto;
import com.dev.api_cat.dto.ResponseDto;
import com.dev.api_cat.persistence.models.CatBreedModel;
import com.dev.api_cat.service.IApiCat;

@RestController
@RequestMapping("/api/breeds")
public class BreedsController {

    @Autowired
    private IApiCat apiCatService;

    @GetMapping("/search")
    public ResponseEntity<List<CatBreedModel>> search(@RequestParam String value, @RequestParam(defaultValue = "10") int limit) {
        List<CatBreedModel> results = apiCatService.searchByAnyField(value, limit);
        return ResponseEntity.ok(results);
    }


    @GetMapping("/breed-id/{uuid}")
    public ResponseEntity<?> getBreedData(@PathVariable String uuid) {
        ResponseDto response = new ResponseDto();
        response.setSuccess(false);

        try {
            CatBreedFullDataDto data = apiCatService.getBreedData(uuid);

            if (data == null) {
                response.setMessage(String.format("No se encontro la raza solicitada: %s", uuid));
                return new ResponseEntity<ResponseDto>(response, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<CatBreedFullDataDto>(data , HttpStatus.OK);
            
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return new ResponseEntity<ResponseDto>(response, HttpStatus.BAD_REQUEST);
        }
        
    }

    @GetMapping
    public ResponseEntity<List<CatBreedModel>> listBreeds() {
        return new ResponseEntity<List<CatBreedModel>>(apiCatService.listAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseDto> updateDataBase() {
        ResponseDto response = new ResponseDto();
        response.setMessage("Iniciando");
        response.setSuccess(false);
        try {
            apiCatService.dropDataBase();
            apiCatService.fillDataBase();

            response.setMessage("Base de datos actualizada");
            response.setSuccess(true);
    
            return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
            
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
        }

    }

}
