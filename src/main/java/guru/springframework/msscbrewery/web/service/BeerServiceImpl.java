package guru.springframework.msscbrewery.web.service;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.mapper.BeerMapper;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.toDto(Beer.builder()
                .id( beerId )
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build());
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        Beer beer = beerMapper.toDomain(beerDto);
        beer.setId( UUID.randomUUID() );
        return beerMapper.toDto( beer );
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        // TODO impl
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a beer " + beerId);
        // TODO Impl
    }
}
