package reservation.service;

import java.util.List;

import com.meiit.webalk.reservation.domain.*;

public interface ReservationService {

	void saveBookingPerson(BookingPerson a);
	void checkIn();

	void checkOut();


	BookingPerson findBookingPerson();

	List<Hotel> findAllHotels();

	void saveReservation(Reservation r);

	List<Reservation> findAllReservations();

	
}
