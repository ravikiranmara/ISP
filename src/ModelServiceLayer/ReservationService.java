package ModelServiceLayer;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import dataAccessObject.ReservationDAO;
import dataTransferObjects.CreditCardDTO;
import dataTransferObjects.HotelReservationDTO;

import modelObject.Reservation;
import modelObject.User;

public class ReservationService implements IReservationService 
{
	static Logger logger = Logger.getLogger(ReservationService.class.getName());
	
	@Override
	public boolean addReservation(Reservation reservation) throws Exception 
	{
		boolean status = false;
		ReservationDAO rdao = null;
		
		try
		{
			logger.info("Adding reservation");
			rdao = new ReservationDAO(); 
			status = rdao.addReservation(reservation);
		}
		catch (Exception e)
		{
			logger.fatal("unable to add reservation");
		}
		finally
		{}
		
		return status;
	}

	@Override
	public boolean updateReservation(Reservation reservation) throws Exception 
	{
		boolean status = false;
		ReservationDAO rdao = null;
		
		try
		{
			logger.info("update reservation");
			rdao = new ReservationDAO(); 
			status = rdao.updateReservation(reservation);
		}
		catch (Exception e)
		{
			logger.fatal("unable to update reservation");
		}
		finally
		{}
		
		return status;
	}

	@Override
	public Reservation getReservationById(int id) 
	{
		Reservation reservation = null;
		
		return reservation;
	}

	@Override
	public boolean cancelReservation(Reservation reservation) 
	{
		return this.cancelReservation(reservation.getId());
	}

	@Override
	public boolean cancelReservation(int reservationId) 
	{
		boolean status = false;
		ReservationDAO rdao = null;
		
		try
		{
			logger.info("cancel reservation");
			
			// remove transaction and remt money
			rdao = new ReservationDAO(); 
			rdao.deleteReservation(reservationId);
		}
		catch (Exception e)
		{
			logger.fatal("unable to update reservation");
		}
		finally
		{}
		
		
		return status;
	}

	@Override
	public ArrayList<Reservation> getReservationForUser(User user) 
	{
		return this.getReservationForUser(user.getUserId());
	}

	@Override
	public ArrayList<Reservation> getReservationForUser(int userId) 
	{
		ArrayList<Reservation> reservationList = null;
		ReservationDAO reservationDao = new ReservationDAO();
		
		try
		{
			logger.info("get reservations for user");
			reservationList = reservationDao.getReservationsForUser(userId);
			HotelReservationDTO hdto = new HotelReservationDTO();
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to get reservations for user");
		}
		finally
		{}
		
		return reservationList;
	}

	@Override
	public ArrayList<Reservation> getReservationForHotel(int hotelId) throws Exception
	{
		ArrayList<Reservation> reservationList = null;
		ReservationDAO reservationDao = new ReservationDAO();
		
		try
		{
			logger.info("get reservations for hotel");
			reservationList = reservationDao.getReservationsForHotel(hotelId);
			HotelReservationDTO hdto = new HotelReservationDTO();
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to get reservations for hotel");
		}
		finally
		{}
		
		return reservationList;
	}

}
