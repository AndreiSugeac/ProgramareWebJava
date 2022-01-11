package extremeworld.service;

import extremeworld.domain.Activity;
import extremeworld.domain.Reservation;
import extremeworld.domain.User;
import extremeworld.dto.ReservationDTO;
import extremeworld.exceptions.ReservationExceptions;
import extremeworld.mapper.ReservationMapper;
import extremeworld.repository.ActivityRepository;
import extremeworld.repository.ReservationRepository;
import extremeworld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ReservationMapper reservationMapper;

    public ReservationDTO create(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.mapToEntity(reservationDTO);
        User user = userRepository.getById(reservation.getUser().getId());

        if(user.getLoggedStatus() != 1) {
            throw new ReservationExceptions("The reservation can't be made by a user that is not logged in!");
        }

        reservation.setUser(user);

        Activity activity = activityRepository.getActivityById(reservation.getActivity().getId());

        if(activity == null) {
            throw new ReservationExceptions("The requested activity for the reservation could not be found!");
        }

        reservation.setActivity(activity);

        Reservation savedReservation = reservationRepository.save(reservation);

        return reservationMapper.mapToDto(savedReservation);
    }

    @Transactional
    public int deleteReservation(Long id) {
        Reservation reservation = reservationRepository.getById(id);
        if(reservation == null) {
            return -1;
        }
        User user = userRepository.getById(reservation.getUser().getId());
        if(user.getLoggedStatus() == 1) {
            reservationRepository.deleteReservationUser(id);
            reservationRepository.deleteReservationActivity(id);
            reservationRepository.deleteReservation(id);

            return 1;
        }

        return 0;
    }
}
