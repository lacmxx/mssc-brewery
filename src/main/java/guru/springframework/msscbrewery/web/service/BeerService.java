package guru.springframework.msscbrewery.web.service;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID id, BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}