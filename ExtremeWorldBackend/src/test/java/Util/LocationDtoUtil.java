package Util;

import extremeworld.dto.LocationDTO;

public class LocationDtoUtil {

    public static LocationDTO generateLocationDto(String country) {
        return LocationDTO.builder()
                .country(country)
                .city("Bran")
                .postalCode("123456")
                .build();
    }
}
