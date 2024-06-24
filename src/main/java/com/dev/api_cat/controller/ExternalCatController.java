package com.dev.api_cat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api_cat.dto.ExternalCatBreedFullDataDto;
import com.dev.api_cat.dto.ExternalCatDto;
import com.dev.api_cat.dto.ResponseDto;
import com.dev.api_cat.service.IExternalCatApi;

@RestController
@RequestMapping("/api/external-cat")
public class ExternalCatController {

    @Autowired
    private IExternalCatApi externalCatApiService;
    

    @GetMapping
    List<ExternalCatDto> listCatsApi() {
        return externalCatApiService.listCatsApi();
    }

    @GetMapping("/breed/{referenceId}")
    ResponseEntity<?> getBreed(@PathVariable String referenceId) {
        try {
            ExternalCatBreedFullDataDto data = externalCatApiService.findCatByBreedApi(referenceId);
            return new ResponseEntity<ExternalCatBreedFullDataDto>(data, HttpStatus.OK);
        } catch (Exception e) {
            ResponseDto response = new ResponseDto();
            response.setMessage(e.getMessage());
            response.setSuccess(false);
            return new ResponseEntity<ResponseDto>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
