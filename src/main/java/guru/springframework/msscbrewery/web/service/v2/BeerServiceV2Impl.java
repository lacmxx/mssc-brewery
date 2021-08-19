package guru.springframework.msscbrewery.web.service.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id( UUID.randomUUID() )
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id( UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDtoV2 beerDto) {
        // TODO impl
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a beer (v2) " + beerId);
        // TODO impl
    }
}
