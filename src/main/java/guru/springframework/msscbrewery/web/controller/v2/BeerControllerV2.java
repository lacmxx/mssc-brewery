package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.service.v2.BeerServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    // Remove this because the @RequiredArgsConstructor of Lombok
    /*
    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }
    */

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {
        val savedDto = beerService.saveNewBeer(beerDto);

        return ResponseEntity.created(
                URI.create(String.format("/api/v2/beer/%s", savedDto.getId()))).build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(
            @PathVariable("beerId") UUID id,
            @Valid @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(id, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId) {
        beerService.deleteBeerById(beerId);
    }

}
