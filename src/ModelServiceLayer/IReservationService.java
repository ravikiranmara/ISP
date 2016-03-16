package ModelServiceLayer;

import java.util.ArrayList;

import modelObject.Reservation;
import modelObject.User;

public interface IReservationService 
{
	public boolean addReservation(Reservation reservation) throws Exception;
	public boolean updateReservation(Reservation reservation) throws Exception;
	public Reservation getReservationById(int id);
	public boolean cancelReservation(Reservation reservation);
	public boolean cancelReservation(int reservationId);
	
	public ArrayList<Reservation> getReservationForUser(User user);
	public ArrayList<Reservation> getReservationForUser(int userId);
	ArrayList<Reservation> getReservationForHotel(int hotelId) throws Exception;
}
