package Util;

import extremeworld.dto.ReservationDTO;

import java.time.LocalDate;

public class ReservationDtoUtil {

    public static ReservationDTO generateReservationDTO(String data) {
        return ReservationDTO.builder()
                .date(LocalDate.parse(data))
                .username("Test")
                .firstName("User")
                .lastName("Hello")
                .activityName("Skiing")
                .build();
    }
}
