package guru.springframework.msscbrewery.web.mapper;

import guru.springframework.msscbrewery.domain.Beer;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses=DateMapper.class)
public interface BeerMapper {

    public BeerDto toDto(Beer beer);

    public Beer toDomain(BeerDto dto);

}
