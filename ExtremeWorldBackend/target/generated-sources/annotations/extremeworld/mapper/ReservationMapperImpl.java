package extremeworld.mapper;

import extremeworld.domain.Activity;
import extremeworld.domain.Activity.ActivityBuilder;
import extremeworld.domain.Reservation;
import extremeworld.domain.Reservation.ReservationBuilder;
import extremeworld.domain.User;
import extremeworld.domain.User.UserBuilder;
import extremeworld.dto.ReservationDTO;
import extremeworld.dto.ReservationDTO.ReservationDTOBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-11T11:51:48+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDTO mapToDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTOBuilder reservationDTO = ReservationDTO.builder();

        reservationDTO.userId( reservationUserId( reservation ) );
        reservationDTO.username( reservationUserUsername( reservation ) );
        reservationDTO.firstName( reservationUserFirstName( reservation ) );
        reservationDTO.lastName( reservationUserLastName( reservation ) );
        reservationDTO.activityId( reservationActivityId( reservation ) );
        reservationDTO.activityName( reservationActivityActivityName( reservation ) );
        reservationDTO.id( reservation.getId() );
        reservationDTO.date( reservation.getDate() );

        return reservationDTO.build();
    }

    @Override
    public Reservation mapToEntity(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        ReservationBuilder reservation = Reservation.builder();

        reservation.user( reservationDTOToUser( reservationDTO ) );
        reservation.activity( reservationDTOToActivity( reservationDTO ) );
        reservation.id( reservationDTO.getId() );
        reservation.date( reservationDTO.getDate() );

        return reservation.build();
    }

    private Long reservationUserId(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        User user = reservation.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String reservationUserUsername(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        User user = reservation.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String reservationUserFirstName(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        User user = reservation.getUser();
        if ( user == null ) {
            return null;
        }
        String firstName = user.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String reservationUserLastName(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        User user = reservation.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Long reservationActivityId(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        Activity activity = reservation.getActivity();
        if ( activity == null ) {
            return null;
        }
        Long id = activity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String reservationActivityActivityName(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }
        Activity activity = reservation.getActivity();
        if ( activity == null ) {
            return null;
        }
        String activityName = activity.getActivityName();
        if ( activityName == null ) {
            return null;
        }
        return activityName;
    }

    protected User reservationDTOToUser(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( reservationDTO.getUserId() );
        user.username( reservationDTO.getUsername() );
        user.firstName( reservationDTO.getFirstName() );
        user.lastName( reservationDTO.getLastName() );

        return user.build();
    }

    protected Activity reservationDTOToActivity(ReservationDTO reservationDTO) {
        if ( reservationDTO == null ) {
            return null;
        }

        ActivityBuilder activity = Activity.builder();

        activity.id( reservationDTO.getActivityId() );
        activity.activityName( reservationDTO.getActivityName() );

        return activity.build();
    }
}
