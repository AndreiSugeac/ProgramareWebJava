package extremeworld.mapper;

import extremeworld.domain.Location;
import extremeworld.dto.LocationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationDTO mapToDto(Location location);

    Location mapToEntity(LocationDTO locationDTO);
}
