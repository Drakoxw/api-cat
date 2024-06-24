package com.dev.api_cat.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dev.api_cat.dto.ExternalCatBreedFullDataDto;
import com.dev.api_cat.dto.ExternalCatDto;
import com.dev.api_cat.service.IExternalCatApi;

@Service
public class ExternalCatApiService implements IExternalCatApi {

    private static final String API_URL = "https://api.thecatapi.com";
    private static final String API_KEY = "live_JBT0Ah0Nt12iyl2IpjQVLDWjcLk0GQwf4zI9wBMfmfejKmcC31mOJp4yJz5TsOUP";
    
    private static WebClient webClient = WebClient.builder().baseUrl(API_URL).build();


    @Override
    public List<ExternalCatDto> listCatsApi() {
        String API_ENDPOINT = "/v1/breeds";
        List<ExternalCatDto> response = webClient
                .get()
                .uri(API_ENDPOINT)
                .header("x-api-key", API_KEY)
                .retrieve()
                .bodyToFlux(ExternalCatDto.class)
                .collectList()
                .block();
        return response;
    }


    @Override
    public ExternalCatBreedFullDataDto findCatByBreedApi(String referenceId) {
        ExternalCatBreedFullDataDto response = webClient
                .get()
                .uri("/v1/images/" + referenceId)
                .header("x-api-key", API_KEY)
                .retrieve()
                .bodyToMono(ExternalCatBreedFullDataDto.class)
                .block();
        return response;
    }
    
}
