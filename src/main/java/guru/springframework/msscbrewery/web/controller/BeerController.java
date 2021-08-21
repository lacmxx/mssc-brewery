package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // TODO add hostname for location
        headers.add("Location", String.format("/api/v1/beer/%s", savedDto.getId().toString()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(
            @PathVariable("beerId") UUID id,
            @Valid @RequestBody BeerDto beerDto) {
        beerService.updateBeer(id, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteBeerById(beerId);
    }

}
