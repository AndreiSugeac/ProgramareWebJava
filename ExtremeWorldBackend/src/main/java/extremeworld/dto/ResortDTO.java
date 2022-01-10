package extremeworld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResortDTO {

    private Long id;

    private String resortName;

    private String country;

    private String city;

    private String postalCode;
    //private LocationDTO locationDTO;
}
