package extremeworld.controller;

import extremeworld.dto.ActivityDTO;
import extremeworld.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO activityDTO) {
        return ResponseEntity
                .ok()
                .body(activityService.create(activityDTO));
    }

    @PostMapping("/resort/{id}")
    public ResponseEntity<ActivityDTO> addActivityToResort(@PathVariable Long id, @RequestBody ActivityDTO activityDTO) {
        return ResponseEntity
                .ok()
                .body(activityService.addActivityToResort(id, activityDTO));
    }
}
