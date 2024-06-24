package com.dev.api_cat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api_cat.persistence.models.CatBreedModel;

@RestController
@RequestMapping("/test")
public class InitController {


    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/breeds")
    public ResponseEntity<CatBreedModel> listBreeds() {
        CatBreedModel data = new CatBreedModel();
        data.setAltNames("");
        data.setDescription("lorem");
        data.setExternalid("1");
        data.setLifeSpan("1 - 2");
        data.setOrigin("lorem");
        data.setReferenceImageId("https://api-cat-production.up.railway.app/api/breeds");
        data.setUuid("131df561d6f5g46s5r");
        return ResponseEntity.ok(data);
    }

}
