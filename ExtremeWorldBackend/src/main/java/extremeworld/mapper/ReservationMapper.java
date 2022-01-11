package extremeworld.mapper;

import extremeworld.domain.Reservation;
import extremeworld.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")
    @Mapping(target = "activityId", source = "activity.id")
    @Mapping(target = "activityName", source = "activity.activityName")
    ReservationDTO mapToDto(Reservation reservation);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "user.firstName", source = "firstName")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "activity.id", source = "activityId")
    @Mapping(target = "activity.activityName", source = "activityName")
    Reservation mapToEntity(ReservationDTO reservationDTO);
}
