package ModelServiceLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import utils.globals;

import dataAccessObject.HotelDAO;

import modelObject.Amenity;
import modelObject.Hotel;
import modelObject.Review;
import modelObject.Room;
import modelObject.SearchParameter;

public class HotelService implements IHotelServiceLayer 
{
	static Logger logger = Logger.getLogger(HotelService.class.getName());

	@Override
	public Hotel getHotelById(int id) throws Exception 
	{
		Hotel temp;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("get hotel by id");
			hdao = new HotelDAO();
			temp = hdao.getHotelById(id);
		}
		catch (Exception e)
		{
			logger.fatal("unable to get hotel by id");
			throw e;
		}
		
		return temp;
	}

	@Override
	public ArrayList<Hotel> getHotelForOwnerId(int ownerId) throws Exception 
	{
		HotelDAO hdao = null;
		ArrayList<Hotel> hlist = null;
		
		try
		{
			logger.info("get hotel by id");
			hdao = new HotelDAO();
			hlist = hdao.getHotelForOwner(ownerId);
		}
		catch (Exception e)
		{
			logger.fatal("unable to get hotel by id");
			throw e;
		}
		
		return hlist;
	}


	@Override
	public ArrayList<Hotel> getAllHotel() throws Exception 
	{
		HotelDAO hdao = null;
		ArrayList<Hotel> hlist = null;
		
		try
		{
			logger.info("get hotel by id");
			hdao = new HotelDAO();
			hlist = hdao.getAllHotel();
		}
		catch (Exception e)
		{
			logger.fatal("unable to get hotel by id");
			throw e;
		}
		
		return hlist;
	}

	@Override
	public boolean addHotel(Hotel hotel) throws Exception 
	{
		HotelDAO hdao = null;
		boolean status = false;

		try
		{
			logger.info("add hotel");
			hdao = new HotelDAO();
			status = hdao.addHotel(hotel);
		}
		catch (Exception e)
		{
			logger.fatal("unable to add hotel ");
			throw e;
		}
		
		return status;
	}

	@Override
	public boolean updateHotel(Hotel hotel) throws Exception 
	{
		HotelDAO hdao = null;
		boolean status = false;

		try
		{
			logger.info("update hotel");
			hdao = new HotelDAO();
			status = hdao.updateHotel(hotel);
		}
		catch (Exception e)
		{
			logger.fatal("unable to update hotel ");
			throw e;
		}
		
		return status;	
	}

	@Override
	public boolean deleteHotel(int hotelId) throws Exception 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAmenity(String name, String description) throws Exception 
	{
		HotelDAO hdao = null;
		boolean status = false;
		
		try
		{
			logger.info("add new amenity");
			hdao = new HotelDAO();
			hdao.addNewAmenity(name, description);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to new amenity");
			throw e;
		}
		
		return status;
	}

	// does nothing
	@Override
	public boolean updateAmenity(int aid, String name, String description) throws Exception 
	{
		HotelDAO hdao = null;
		boolean status = false;
		
		try
		{
			logger.info("update amenity");
			hdao = new HotelDAO();
			//hdao.addNewAmenity(name, description);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to update amenity");
			throw e;
		}
		
		return status;
	}

	@Override
	public HashMap<Integer, String[]> getAllAmenityType() throws Exception 
	{
		HashMap<Integer, String[]> alist = null;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("get all amenity");
			hdao = new HotelDAO();
			alist = hdao.getAllAmenity();
		}
		catch (Exception e)
		{
			logger.fatal("get all amenity");
			throw e;
		}
		
		return alist;
	}

	@Override
	public boolean addAmenityToHotel(Hotel hotel, Amenity amenity)
			throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("add hotel amenity");
			hdao = new HotelDAO();
			hdao.addHotelAmenity(hotel, amenity);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to add hotel amenity");
			throw e;
		}
		
		return status;
	}

	@Override
	public boolean deleteAmenitFromHotel(Hotel hotel, Amenity amenity)
			throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("remove hotel amenity");
			hdao = new HotelDAO();
			hdao.removeHotelAmenity(hotel, amenity);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to remove hotel amenity");
			throw e;
		}
		
		return status;
	}

	@Override
	public boolean addReviewForHotel(Hotel hotel, Review review)
			throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("add hotel review");
			hdao = new HotelDAO();
			hdao.addHotelReview(hotel, review);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to add hotel review");
			throw e;
		}
		
		return status;
	}

	@Override
	public boolean deleteReviewForHotel(Hotel hotel, Review review)
			throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("add hotel review");
			hdao = new HotelDAO();
			hdao.removeHotelReview(hotel, review);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to add hotel review");
			throw e;
		}
		
		return status;
	}

	@Override
	public boolean addHotelRoomToHotel(Hotel hotel, Room room) throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("add hotel room");
			hdao = new HotelDAO();
			hdao.addHotelRoom(hotel, room);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to update hotel room");
			throw e;
		}
		
		return status;
	}

	@Override
	public boolean updateRoomForHotel(Hotel hotel, Room room) throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("update hotel room");
			hdao = new HotelDAO();
			hdao.updateHotelRoom(hotel, room);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to update hotel room");
			throw e;
		}
		
		return status;
	}

	@Override
	public HashMap<Integer, String[]> getAllRoomTypes() throws Exception 
	{
		HashMap<Integer, String[]> roomtype = null;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("get hotel room type");
			hdao = new HotelDAO();
			roomtype = hdao.getAllHotelRoomTypes();
		}
		catch (Exception e)
		{
			logger.fatal("unable to get hotel room type");
			throw e;
		}
		
		return roomtype;
	}

	@Override
	public ArrayList<Hotel> serachForHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateHotelComplete(Hotel hotel) throws Exception 
	{
		boolean status = false;
		ArrayList<Room> rooms = null;
		ArrayList<Amenity> amenitylist = null;
		
		try
		{
			logger.info("update basic hotel");
			this.updateHotel(hotel);
			
			logger.info("update all rooms");
			rooms = hotel.getRoom();
			for (Room r : rooms)
			{
				 this.updateRoomForHotel(hotel, r);
			}
			
			/*
			logger.info("update all amenities");
			amenitylist = hotel.getAmenity();
			for(Amenity a : amenitylist)
			{
				this.updateAmenityToHotel(hotel, a);
			}
			*/

			// we are not doing review. 
		}
		catch(Exception ex)
		{
			
		}
		
		return status;
	}

	@Override
	public boolean updateAmenityToHotel(Hotel hotel, Amenity amenity)
			throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("add hotel amenity");
			hdao = new HotelDAO();
			hdao.updateHotelAmenity(hotel, amenity);
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("unable to add hotel amenity");
			throw e;
		}
		
		return status;
		
	}

	@Override
	public boolean isHotelMatchSearch (Hotel hotel, SearchParameter sp) throws Exception 
	{
		boolean status = false;
		HotelDAO hdao = null;
		
		try
		{
			logger.info("Check if hotel matches search criteria");
			
			logger.info("search for name : " + hotel.getName());
			String hotelName = sp.getHotelname();
			if(false == hotelName.isEmpty())
			{
				if(false == hotelName.equalsIgnoreCase(hotel.getName()))
				{
					throw new NoSuchElementException("name");
				}
			}
			
			logger.info("search city : " + hotel.getCity());
			String city = sp.getCity();
			if(false == city.isEmpty())
			{
				if(false == city.equalsIgnoreCase(hotel.getCity()))
				{
					throw new NoSuchElementException("city");
				}
			}
			
			logger.info("search state: " + hotel.getState());
			String state = sp.getState();
			if(false == state.isEmpty())
			{
				if(false == state.equalsIgnoreCase(hotel.getCity()))
				{
					throw new NoSuchElementException("state");
				}
			}
			
			logger.info("room type - " + sp.getRoomType());
			String roomType = sp.getRoomType();
			ArrayList<Room> roomlist = hotel.getRoom();
			ArrayList<Room> filterlist = new ArrayList<Room>();
			
			
			if(false == roomType.isEmpty())
			{
				for(Room r : roomlist)
				{
					if(true == roomType.equalsIgnoreCase(r.getRoomType()))
					{
						logger.info("found room type - " + r.getRoomType());
						if(r.getAvailableNumber() >= sp.getNumRooms())
						{
							filterlist.add(r);
						}
					}
				}
			}
			else
			{
				filterlist = roomlist;
			}
			
			if(0 == filterlist.size())
			{
				throw new NoSuchElementException("roomtype and available :" + filterlist.size());
			}
			
			roomlist = new ArrayList(filterlist);
			logger.info("roomtype and available :" + roomlist.size());
			filterlist = new ArrayList<Room>();
			Date checkin = sp.getCheckinDate();
			logger.info("Checkin checkout date - " + sp.getCheckinDate());
			if(false == checkin.equals(globals.invalidDate))
			{
				for(Room r : roomlist)
				{
					if(r.getStartDate().after(checkin) || r.getStartDate().equals(checkin)) 
					{
						filterlist.add(r);
					}
				}
			}
			else
			{
				filterlist = new ArrayList<Room>(roomlist);
			}
			
			logger.info("roomtype and available :" + filterlist.size());
			
			if(0 == filterlist.size())
			{
				throw new NoSuchElementException("checkin");
			}
			
			roomlist = new ArrayList<Room>(filterlist);
			filterlist.clear();
			logger.info("checkout date");
			Date checkout = sp.getCheckoutDate();
			if(false == checkout.equals(globals.invalidDate))
			{
				logger.info("at checkout");
				for(Room r : roomlist)
				{
					logger.info(r.getEndDate());
					if(r.getEndDate().after(checkout) || r.getEndDate().equals(checkout)) 
					{
						logger.info("add");
						filterlist.add(r);
					}
				}
			}
			else
			{
				filterlist = new ArrayList<Room>(roomlist);
			}
			
			if(0 == filterlist.size())
			{
				throw new NoSuchElementException("checkout");
			}
			
			logger.info("Check for amenities");
			
			status = true;
		}
		catch (NoSuchElementException ex)
		{
			logger.info("sarch failed at : " + ex.getMessage());
			status = false;
		}
		catch (Exception ex)
		{
			logger.info("unable to check if room meets search criteria");
			throw ex;
		}
		finally
		{
		}
		
		logger.info("Return - " + status);
		return status;
	}
	
	@Override
	public ArrayList<Hotel> SearchForHotel(SearchParameter sp) throws Exception 
	{
		ArrayList<Hotel> list = null;
		ArrayList<Hotel> temp = null;
		HotelDAO hotelDao = null;
		
		temp = new ArrayList<Hotel>();
		try
		{
			logger.info("search for hotel");
			hotelDao = new HotelDAO();
			list = hotelDao.getAllHotel();
			
			for(Hotel h : list)
			{
				if(true == this.isHotelMatchSearch(h, sp))
				{
					logger.info("match - " + h.getName());
					temp.add(h);
				}
			}
		}
		catch (Exception ex)
		{
			logger.info("unable to search");
			throw ex;
		}
		finally
		{
		}
		
		return temp;
	}
	
}
