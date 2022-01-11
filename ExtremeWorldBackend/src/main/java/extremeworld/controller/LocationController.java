package extremeworld.controller;

import extremeworld.dto.LocationDTO;
import extremeworld.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        return ResponseEntity.
                ok()
                .body(locationService.create(locationDTO));
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(locationService.getById(id));
    }
}
