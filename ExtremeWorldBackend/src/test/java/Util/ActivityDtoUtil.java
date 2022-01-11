package Util;

import extremeworld.dto.ActivityDTO;
import extremeworld.dto.LocationDTO;

public class ActivityDtoUtil {

    public static ActivityDTO generateActivityDto(String activityName) {
        return ActivityDTO.builder()
                .activityName(activityName)
                .build();
    }
}
