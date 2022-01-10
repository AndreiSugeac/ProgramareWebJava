package extremeworld.mapper;

import extremeworld.domain.Location;
import extremeworld.domain.Resort;
import extremeworld.dto.LocationDTO;
import extremeworld.dto.ResortDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResortMapper {

    @Mapping(target = "country", source = "location.country")
    @Mapping(target = "city", source = "location.city")
    @Mapping(target = "postalCode", source = "location.postalCode")
    ResortDTO mapToDto(Resort resort);

    @Mapping(target = "location.country", source = "country")
    @Mapping(target = "location.city", source = "city")
    @Mapping(target = "location.postalCode", source = "postalCode")
    Resort mapToEntity(ResortDTO resortDTO);
}
