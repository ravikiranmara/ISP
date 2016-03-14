package dataAccessObject;

import modelObject.Reservation;
import modelObject.Transaction;

import org.apache.log4j.Logger;

import dataTransferObjects.HotelReservationDTO;
import dataTransferObjects.TransactionDTO;

public class ReservationDAO 
{
static Logger logger = Logger.getLogger(TransactionDAO.class.getName());
	
	private void initializeDTOFromReservation(HotelReservationDTO hrdto, Reservation r)
	{
		hrdto.setId(r.getId());
		hrdto.setCheckInDate(r.getCheckInDate());
		hrdto.setCheckOutDate(r.getCheckOutDate());
		hrdto.setHotelId(r.getHotelId());
		hrdto.setNotes(r.getNotes());
		hrdto.setNumberOfRooms(r.getNumberOfRooms());
		hrdto.setStatus(r.getReservationStatus());
		hrdto.setUserId(r.getUserId());
		
		return;
	}
	
	private void initializeReservationFromDTO(Reservation r, HotelReservationDTO hrdto)
	{
		r.setId(hrdto.getId());
		r.setCheckInDate(hrdto.getCheckInDate());
		r.setCheckOutDate(hrdto.getCheckOutDate());
		r.setHotelId(hrdto.getHotelId());
		r.setNotes(hrdto.getNotes());
		r.setNumberOfRooms(hrdto.getNumberOfRooms());
		r.setReservationStatus(hrdto.getStatus());
		r.setUserId(hrdto.getUserId());
		
		return;
	}
	
	public boolean addReservation(Reservation reservation) throws Exception 
	{
		boolean status = false;
		HotelReservationDTO reservationDto = null;
		
		try
		{
			reservationDto = new HotelReservationDTO();
			
			// fetch user details
			logger.info("add reesrvation dao");
			this.initializeDTOFromReservation(reservationDto, reservation);
			reservationDto.addHotelReservation();
			
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to add reservation: ");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}

	public Reservation getReservationById(int tid) throws Exception 
	{
		HotelReservationDTO reservationDto = null;
		Reservation reservation = null;
		
		try
		{
			reservationDto = new HotelReservationDTO();
			
			// fetch user details
			logger.info("get reservation dao");
			reservationDto.getHotelReservationById(tid);
			reservation = new Reservation();
			this.initializeReservationFromDTO(reservation, reservationDto);
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get reservation: ");
			throw e;
		}
		finally
		{
		}
		
		return reservation;
	}

	public boolean updateReservation(Reservation reservation) throws Exception 
	{
		boolean status = false;
		HotelReservationDTO reservationDto = null;
		
		try
		{
			reservationDto = new HotelReservationDTO();
			
			// fetch user details
			logger.info("update reesrvation dao");
			this.initializeDTOFromReservation(reservationDto, reservation);
			reservationDto.addHotelReservation();
			
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to update reservation: ");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}
}
