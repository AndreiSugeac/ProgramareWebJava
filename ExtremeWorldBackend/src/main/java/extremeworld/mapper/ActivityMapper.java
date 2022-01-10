package extremeworld.mapper;

import extremeworld.domain.Activity;
import extremeworld.dto.ActivityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityDTO mapToDto(Activity activity);

    Activity mapToEntity(ActivityDTO activityDTO);
}
