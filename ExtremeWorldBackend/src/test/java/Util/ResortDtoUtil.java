package Util;

import extremeworld.domain.Resort;
import extremeworld.dto.ResortDTO;

public class ResortDtoUtil {
    public static ResortDTO generateResortDTO(String resortName) {
        return ResortDTO.builder()
                .resortName(resortName)
                .build();
    }
}
