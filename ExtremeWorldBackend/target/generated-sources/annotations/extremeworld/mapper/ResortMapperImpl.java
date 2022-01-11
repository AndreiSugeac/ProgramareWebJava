package extremeworld.mapper;

import extremeworld.domain.Location;
import extremeworld.domain.Location.LocationBuilder;
import extremeworld.domain.Resort;
import extremeworld.domain.Resort.ResortBuilder;
import extremeworld.dto.ResortDTO;
import extremeworld.dto.ResortDTO.ResortDTOBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-11T03:30:37+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ResortMapperImpl implements ResortMapper {

    @Override
    public ResortDTO mapToDto(Resort resort) {
        if ( resort == null ) {
            return null;
        }

        ResortDTOBuilder resortDTO = ResortDTO.builder();

        resortDTO.country( resortLocationCountry( resort ) );
        resortDTO.city( resortLocationCity( resort ) );
        resortDTO.postalCode( resortLocationPostalCode( resort ) );
        resortDTO.id( resort.getId() );
        resortDTO.resortName( resort.getResortName() );

        return resortDTO.build();
    }

    @Override
    public Resort mapToEntity(ResortDTO resortDTO) {
        if ( resortDTO == null ) {
            return null;
        }

        ResortBuilder resort = Resort.builder();

        resort.location( resortDTOToLocation( resortDTO ) );
        resort.id( resortDTO.getId() );
        resort.resortName( resortDTO.getResortName() );

        return resort.build();
    }

    private String resortLocationCountry(Resort resort) {
        if ( resort == null ) {
            return null;
        }
        Location location = resort.getLocation();
        if ( location == null ) {
            return null;
        }
        String country = location.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    private String resortLocationCity(Resort resort) {
        if ( resort == null ) {
            return null;
        }
        Location location = resort.getLocation();
        if ( location == null ) {
            return null;
        }
        String city = location.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    private String resortLocationPostalCode(Resort resort) {
        if ( resort == null ) {
            return null;
        }
        Location location = resort.getLocation();
        if ( location == null ) {
            return null;
        }
        String postalCode = location.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        return postalCode;
    }

    protected Location resortDTOToLocation(ResortDTO resortDTO) {
        if ( resortDTO == null ) {
            return null;
        }

        LocationBuilder location = Location.builder();

        location.country( resortDTO.getCountry() );
        location.city( resortDTO.getCity() );
        location.postalCode( resortDTO.getPostalCode() );

        return location.build();
    }
}
