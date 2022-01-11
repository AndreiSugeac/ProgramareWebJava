package extremeworld.mapper;

import extremeworld.domain.Activity;
import extremeworld.domain.Activity.ActivityBuilder;
import extremeworld.dto.ActivityDTO;
import extremeworld.dto.ActivityDTO.ActivityDTOBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T22:50:56+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public ActivityDTO mapToDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDTOBuilder activityDTO = ActivityDTO.builder();

        activityDTO.id( activity.getId() );
        activityDTO.activityName( activity.getActivityName() );

        return activityDTO.build();
    }

    @Override
    public Activity mapToEntity(ActivityDTO activityDTO) {
        if ( activityDTO == null ) {
            return null;
        }

        ActivityBuilder activity = Activity.builder();

        activity.id( activityDTO.getId() );
        activity.activityName( activityDTO.getActivityName() );

        return activity.build();
    }
}
