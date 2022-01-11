package extremeworld.service;

import extremeworld.domain.Activity;
import extremeworld.dto.ActivityDTO;
import extremeworld.mapper.ActivityMapper;
import extremeworld.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityMapper activityMapper;

    public ActivityDTO create(ActivityDTO activityDTO) {
        Activity activity = activityMapper.mapToEntity(activityDTO);
        Activity savedActivity = activityRepository.save(activity);

        return activityMapper.mapToDto(savedActivity);
    }

    public ActivityDTO addActivityToResort(Long id, ActivityDTO activityDTO) {
        Activity activity = activityMapper.mapToEntity(activityDTO);

        return activityMapper.mapToDto(activityRepository.addActivityToResort(id, activity));
    }

    public ActivityDTO getActivityById(Long id) {
        Activity activity = activityRepository.getActivityById(id);

        return activityMapper.mapToDto(activity);
    }
}
