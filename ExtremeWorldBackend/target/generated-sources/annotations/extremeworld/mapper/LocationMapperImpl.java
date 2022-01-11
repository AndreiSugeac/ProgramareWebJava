package extremeworld.mapper;

import extremeworld.domain.Location;
import extremeworld.domain.Location.LocationBuilder;
import extremeworld.dto.LocationDTO;
import extremeworld.dto.LocationDTO.LocationDTOBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-07T23:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDTO mapToDto(Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDTOBuilder locationDTO = LocationDTO.builder();

        locationDTO.id( location.getId() );
        locationDTO.country( location.getCountry() );
        locationDTO.city( location.getCity() );
        locationDTO.postalCode( location.getPostalCode() );

        return locationDTO.build();
    }

    @Override
    public Location mapToEntity(LocationDTO locationDTO) {
        if ( locationDTO == null ) {
            return null;
        }

        LocationBuilder location = Location.builder();

        location.id( locationDTO.getId() );
        location.country( locationDTO.getCountry() );
        location.city( locationDTO.getCity() );
        location.postalCode( locationDTO.getPostalCode() );

        return location.build();
    }
}
