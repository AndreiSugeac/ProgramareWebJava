package extremeworld.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private Long id;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    private Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private Long activityId;

    @Size(min = 3)
    private String activityName;
}
