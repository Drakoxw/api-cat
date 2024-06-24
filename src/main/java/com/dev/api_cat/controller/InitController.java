package com.dev.api_cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api_cat.persistence.models.CatBreedModel;
import com.dev.api_cat.service.IApiCat;

@RestController
@RequestMapping("/test")
public class InitController {

    @Autowired
    private IApiCat apiCatService;

    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/breeds")
    public ResponseEntity<List<CatBreedModel>> listBreeds() {
        return new ResponseEntity<List<CatBreedModel>>(apiCatService.listAll(), HttpStatus.OK);
    }

}
