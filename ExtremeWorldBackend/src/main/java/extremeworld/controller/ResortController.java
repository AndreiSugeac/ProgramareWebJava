package extremeworld.controller;

import extremeworld.dto.LocationDTO;
import extremeworld.dto.ResortDTO;
import extremeworld.service.ResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resorts")
public class ResortController {

    @Autowired
    private ResortService resortService;

    @PostMapping("/resort")
    public ResponseEntity<ResortDTO> createResort(@RequestBody ResortDTO resortDTO) {
        return ResponseEntity
                .ok()
                .body(resortService.create(resortDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResortDTO> getById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(resortService.getResortById(id));
    }
}
