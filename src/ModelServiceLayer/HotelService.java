package ModelServiceLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

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
	static Logger logger = Logger.getLogger(PaymentService.class.getName());

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
	public HashMap<Integer, String[]> getAllRoomTypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Hotel> serachForHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Hotel> SearchForHotel(SearchParameter sp) throws Exception 
	{
		ArrayList<Hotel> list = null;
		ArrayList<Hotel> temp = null;
		HotelDAO hotelDao = null;
		
		try
		{
			hotelDao = new HotelDAO();
			list = new ArrayList<Hotel>();
			
			
			list = hotelDao.getAllHotel();
			
			// search for name
			String hotelName = sp.getHotelname();
			if(false != hotelName.isEmpty())
			{
				temp = new ArrayList<Hotel>();
				for (Hotel h : list)
				{
					if(h.getName().equalsIgnoreCase(hotelName))
					{
						temp.add(h);
					}
				}
				
				list = temp;
			}
			
			// city
			String city = sp.getCity();
			if(false != city.isEmpty())
			{
				temp = new ArrayList<Hotel>();
				for (Hotel h : list)
				{
					if(h.getCity().equalsIgnoreCase(city))
					{
						temp.add(h);
					}
				}
				
				list = temp;
			}
			
			// state
			String state = sp.getState();
			if(false != state.isEmpty())
			{
				temp = new ArrayList<Hotel>();
				for (Hotel h : list)
				{
					if(h.getState().equalsIgnoreCase(state))
					{
						temp.add(h);
					}
				}
				
				list = temp;
			}
			
			// room type
			String roomType = sp.getRoomType();
			if(false != roomType.isEmpty())
			{
				temp = new ArrayList<Hotel>();
				for (Hotel h : list)
				{
					ArrayList<Room> room = null;
					ArrayList<Room> temproom = new ArrayList<Room>();
					room = h.getRoom();
					
					for(Room r : room)
					{
						if(r.getRoomType().equalsIgnoreCase(roomType))
						{
							temproom.add(r);
							break;
						}						
					}
					
					if(false == temproom.isEmpty())
					{
						h.setRoom(temproom);
						temp.add(h);
					}
				}
				
				list = temp;
			}
			
			// check in date
			Date checkin = sp.getCheckinDate();
			if(0 <= checkin.compareTo(globals.invalidDate))
			{
				temp = new ArrayList<Hotel>();
				for (Hotel h : list)
				{
					ArrayList<Room> room = null;
					ArrayList<Room> temproom = new ArrayList<Room>();
					room = h.getRoom();
					
					for(Room r : room)
					{
						if(r.getStartDate().before(checkin) || r.getStartDate().equals(checkin))
						{
							temproom.add(r);
						}						
					}
					
					if(false == temproom.isEmpty())
					{
						h.setRoom(temproom);
						temp.add(h);
					}
				}
				
				list = temp;
			}

			// check out date
			Date checkout = sp.getCheckoutDate();
			if(0 <= checkin.compareTo(globals.invalidDate))
			{
				temp = new ArrayList<Hotel>();
				for (Hotel h : list)
				{
					ArrayList<Room> room = null;
					ArrayList<Room> temproom = new ArrayList<Room>();
					room = h.getRoom();
					
					for(Room r : room)
					{
						if(r.getEndDate().after(checkout) || r.getEndDate().equals(checkout))
						{
							temproom.add(r);
						}						
					}
					
					if(false == temproom.isEmpty())
					{
						h.setRoom(temproom);
						temp.add(h);
					}
				}
				
				list = temp;
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
		
		return list;
	}
}
