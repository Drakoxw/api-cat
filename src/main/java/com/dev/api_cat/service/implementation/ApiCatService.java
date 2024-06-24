package com.dev.api_cat.service.implementation;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dev.api_cat.dto.CatBreedDto;
import com.dev.api_cat.dto.CatBreedFullDataDto;
import com.dev.api_cat.dto.ExternalCatBreedFullDataDto;
import com.dev.api_cat.dto.ExternalCatDto;
import com.dev.api_cat.persistence.models.CatBreedModel;
import com.dev.api_cat.persistence.repository.CatBreedRepository;
import com.dev.api_cat.service.IApiCat;
import com.dev.api_cat.service.IExternalCatApi;

@Service
public class ApiCatService implements IApiCat {

    @Autowired
    private CatBreedRepository catBreedRepository;

    @Autowired
    private IExternalCatApi externalCatApiService;
    
    @Override
    public CatBreedFullDataDto getBreedData(String uuid)  {
        CatBreedModel catBreed = catBreedRepository.findById(uuid).orElse(null);
        if (catBreed == null) {
            return null;
        }

        ExternalCatBreedFullDataDto externalCat = externalCatApiService.findCatByBreedApi(catBreed.getReferenceImageId());
        ExternalCatDto externalBreed = externalCat.getBreeds().get(0);

        CatBreedDto breed = new CatBreedDto();
        breed.setUuid(uuid);
        breed.setName(externalBreed.getName());
        breed.setAltNames(externalBreed.getAltNames());
        breed.setDescription(externalBreed.getDescription());
        breed.setExternalid(externalBreed.getId());
        breed.setLifeSpan(externalBreed.getLifeSpan());
        breed.setOrigin(externalBreed.getOrigin());
        breed.setReferenceImageId(externalBreed.getReferenceImageId());

        CatBreedFullDataDto catBreedFullData = new CatBreedFullDataDto();

        catBreedFullData.setId(uuid);
        catBreedFullData.setBreed(breed);
        catBreedFullData.setAdaptability(externalBreed.getAdaptability());
        catBreedFullData.setChildFriendly(externalBreed.getChildFriendly());
        catBreedFullData.setDogFriendly(externalBreed.getDogFriendly());
        catBreedFullData.setEnergyLevel(externalBreed.getEnergyLevel());
        catBreedFullData.setIntelligence(externalBreed.getIntelligence());
        catBreedFullData.setSocialNeeds(externalBreed.getSocialNeeds());
        catBreedFullData.setStrangerFriendly(externalBreed.getStrangerFriendly());
        catBreedFullData.setTemperament(externalBreed.getTemperament());
        catBreedFullData.setUrl(externalCat.getUrl());
        catBreedFullData.setWikipediaUrl(externalBreed.getWikipediaUrl());

        return catBreedFullData;
    }

    @Override
    public List<CatBreedModel> listAll() {
        return catBreedRepository.findAll();
    }

    @Override
    public void fillDataBase() {
        List<ExternalCatDto> catBreeds = externalCatApiService.listCatsApi();

        List<CatBreedModel> catBreedList = catBreeds.stream().map(externalCat -> {

            CatBreedModel catBreed = new CatBreedModel();

            catBreed.setUuid(UUID.randomUUID().toString());
            catBreed.setExternalid(externalCat.getId());
            catBreed.setName(externalCat.getName());
            catBreed.setDescription(externalCat.getDescription());
            catBreed.setOrigin(externalCat.getOrigin());
            catBreed.setAltNames(externalCat.getAltNames());
            catBreed.setLifeSpan(externalCat.getLifeSpan());
            catBreed.setReferenceImageId(externalCat.getReferenceImageId());

            return catBreed;
        }).collect(Collectors.toList());

        catBreedRepository.saveAll(catBreedList);
    }

    @Override
    public void dropDataBase() {
        catBreedRepository.deleteAll();
    }

    @Override
    public List<CatBreedModel> searchByAnyField(String value, int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        Page<CatBreedModel> pageResult = catBreedRepository.findByAnyField(value, pageRequest);
        return pageResult.getContent();
    }

}
