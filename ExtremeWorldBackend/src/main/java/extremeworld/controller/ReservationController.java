package extremeworld.controller;

import extremeworld.dto.ReservationDTO;
import extremeworld.service.ReservationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<ReservationDTO> create(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity
                .ok()
                .body(reservationService.create(reservationDTO));
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletResponse response) {
        int res = reservationService.deleteReservation(id);

        if(res == 1) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return "Successfully removed reservation!";
        }
        else {
            response.setStatus(404);
            return "Reservation could not be removed!";
        }
    }


}
