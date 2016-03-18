package dataAccessObject;

import java.util.ArrayList;
import java.util.HashMap;

import dataTransferObjects.AmenityDTO;
import dataTransferObjects.CreditCardDTO;
import dataTransferObjects.HotelAmenityDTO;
import dataTransferObjects.HotelDTO;
import dataTransferObjects.HotelReviewDTO;
import dataTransferObjects.HotelRoomDTO;
import dataTransferObjects.HotelRoomTypeDTO;
import dataTransferObjects.UserDTO;
import modelObject.Amenity;
import modelObject.AmenityType;
import modelObject.CreditCard;
import modelObject.Hotel;
import modelObject.Review;
import modelObject.Room;
import modelObject.User;

public class HotelDAO implements IHotelDAO
{
	private void initializeReviewDtoFromReview(HotelReviewDTO reviewDto, Review review)
	{
		reviewDto.setHotelId(review.getHotelId());
		reviewDto.setRating(review.getRating());
		reviewDto.setReview(review.getReview());
		reviewDto.setReviewDate(review.getDate());
		reviewDto.setReviewerName(review.getReviewerName());
		reviewDto.setId(review.getId());
		
		return;
	}
	
	private void initializeReviewFromReviewDto(Review review, HotelReviewDTO reviewDto)
	{
		review.setHotelId(reviewDto.getHotelId());
		review.setRating(reviewDto.getRating());
		review.setReview(reviewDto.getReview());
		review.setDate(reviewDto.getReviewDate());
		review.setReviewerName(reviewDto.getReviewerName());
		review.setId(reviewDto.getId());
		
		return;
	}
	
	private void initializeHotelRoomFromDTO(Room room, HotelRoomDTO roomDto, HotelRoomTypeDTO roomTypeDto)
	{
		room.setRoomType(roomTypeDto.getRoomType());
		room.setHotelId(roomDto.getHotelId());
		room.setAvailableNumber(roomDto.getAvailableNumber());
		room.setDescription(roomTypeDto.getDescription());
		room.setPricePerNight(roomDto.getPricePerNight());
		room.setStartDate(roomDto.getStartDate());
		room.setEndDate(roomDto.getEndDate());
		room.setRoomTypeId(roomTypeDto.getId());
		room.setId(roomDto.getId());
		
		return;
	}
	
	private void initializeDTOFromHotelRoom(HotelRoomDTO roomDto, HotelRoomTypeDTO roomTypeDto, Room room)
	{
		roomTypeDto.setRoomType(room.getRoomType());
		roomDto.setHotelId(room.getHotelId());
		roomDto.setAvailableNumber(room.getAvailableNumber());
		roomTypeDto.setDescription(room.getDescription());
		roomDto.setPricePerNight(room.getPricePerNight());
		roomDto.setStartDate(room.getStartDate());
		roomDto.setEndDate(room.getEndDate());
		roomTypeDto.setId(room.getRoomTypeId());
		roomDto.setRoomTypeId(room.getRoomTypeId());
		roomDto.setId(room.getId());
		
		return;
	}
	
	private void initializeAmenityFromDTO(Amenity amenity, HotelAmenityDTO hotelAmenityDto, AmenityDTO amenityDto)
	{
		amenity.setamenityId(amenityDto.getId());
		amenity.setName(amenityDto.getName());
		amenity.setDescription(amenity.getDescription());
		amenity.setHotelId(hotelAmenityDto.getHotelId());
		amenity.setLinkId(hotelAmenityDto.getId());
		amenity.setValue(hotelAmenityDto.getValue());
	}
	
	private void initializeDTOFromAmenity(Amenity amenity, HotelAmenityDTO hotelAmenityDto, AmenityDTO amenityDto)
	{
		amenityDto.setId(amenity.getamenityId());		
		amenityDto.setName(amenity.getName());
		amenityDto.setDescription(amenity.getDescription());
		hotelAmenityDto.setHotelId(amenity.getHotelId());
		hotelAmenityDto.setId(amenity.getLinkId());
		hotelAmenityDto.setValue(amenity.getValue());
	}
	
	
	private void initializeHotelFromDto(Hotel hotel, HotelDTO hotelDto)
	{
		hotel.setId(hotelDto.getId());
		hotel.setName(hotelDto.getName());
		hotel.setCity(hotelDto.getCity());
		hotel.setState(hotelDto.getState());
		hotel.setOwnerUserId(hotelDto.getOwnerUserId());
		hotel.setDescription(hotelDto.getDescription());
		hotel.setNearestPoints(hotelDto.getNearestPoints());
		hotel.setAddress(hotelDto.getAddress());
		
		return;
	}
	
	private void initializeDtoFromHotel(Hotel hotel, HotelDTO hotelDto)
	{
		hotelDto.setId(hotel.getId());
		hotelDto.setName(hotel.getName());
		hotelDto.setCity(hotel.getCity());
		hotelDto.setState(hotel.getState());
		hotelDto.setOwnerUserId(hotel.getOwnerUserId());
		hotelDto.setDescription(hotel.getDescription());
		hotelDto.setNearestPoints(hotel.getNearestPoints());
		hotelDto.setAddress(hotel.getAddress());
		
		return;
	}
	
	@Override
	public Hotel getHotelById(int id) throws Exception 
	{
		HotelDTO hotelDto = null;
		HotelAmenityDTO hotelAmenityDto = null;
		AmenityDTO amenityDto = null;
		HotelRoomDTO hotelRoomDto = null;
		HotelRoomTypeDTO hotelRoomTypeDto = null;
		HotelReviewDTO hotelReviewDto = null;
		
		ArrayList<Amenity> amenityList = null;
		ArrayList<Room> roomList = null;
		ArrayList<Review> reviewList = null;
		HashMap<Integer, String[]> amenityHash = null;
		HashMap<Integer, String[]> roomTypeHash = null;
		ArrayList<Integer> listOfHotelAmenityId = null;
		ArrayList<Integer> listOfRoomId = null;
		
		Hotel tempHotel = null;
		Amenity tempAmenity = null;
		Room tempRoom = null;
		Review tempReview = null;

		try
		{
			tempHotel = new Hotel();
			hotelDto = new HotelDTO();
			
			// fetch user details
			logger.info("Get hotel details from dto");
			hotelDto.getHotelById(id);
			this.initializeHotelFromDto(tempHotel, hotelDto);
			
			logger.info("Getting list of all Amenities desc dto");
			amenityDto = new AmenityDTO();
			amenityHash = amenityDto.getAllAmenity();
			
			logger.info("Get list of Amenity from Hotel Dto");
			hotelAmenityDto = new HotelAmenityDTO();
			listOfHotelAmenityId = hotelAmenityDto.getHotelAmenityByHotelId(tempHotel.getId());
			
			if(null == listOfHotelAmenityId)
			{
				listOfHotelAmenityId = new ArrayList<Integer>();
			}
			
			logger.info("get list of amenities");
			amenityList = new ArrayList<Amenity>();
			for(Integer amenId : listOfHotelAmenityId)
			{
				tempAmenity = new Amenity();
				hotelAmenityDto.clear();
				hotelAmenityDto.getHotelAmenityById(amenId);
				amenityDto.initialize(hotelAmenityDto.getAmenityId(), 
						amenityHash.get(hotelAmenityDto.getAmenityId()));
				
				this.initializeAmenityFromDTO(tempAmenity, hotelAmenityDto, amenityDto);
				amenityList.add(tempAmenity);
			}
			
			// add amenit to temp hotel
			tempHotel.setAmenity(amenityList);
			
			logger.info("Get list of hotel reviews Ids");
			hotelReviewDto = new HotelReviewDTO();
			ArrayList<Integer> hotelReviewIdList = null;
			hotelReviewIdList = hotelReviewDto.getHotelReviewsForHotel(id);
			if(null == hotelReviewIdList)
			{
				hotelReviewIdList = new ArrayList<Integer>();
			}
			
			reviewList = new ArrayList<Review>();
			logger.info("For each id, get review from table");
			for (Integer rid : hotelReviewIdList)
			{
				tempReview = new Review();
				
				hotelReviewDto.clear();
				hotelReviewDto.getHotelReviewById(rid);
				this.initializeReviewFromReviewDto(tempReview, hotelReviewDto);
				reviewList.add(tempReview);
			}
			
			// hotel set reviews
			tempHotel.setReview(reviewList);
			
			logger.info("Get Hotel room Type list");
			hotelRoomTypeDto = new HotelRoomTypeDTO();
			roomTypeHash = hotelRoomTypeDto.getAllHotelRoomType();
			
			logger.info("Get Hotel Room list");
			hotelRoomDto = new HotelRoomDTO();
			listOfRoomId = hotelRoomDto.getHotelRoomIdByHotelId(id);
			if(null == listOfRoomId)
			{
				listOfRoomId = new ArrayList<Integer>();
			}
			
			logger.info("foreach room id, get room details");
			roomList = new ArrayList<Room>();
			HotelRoomTypeDTO tempRoomTypeDto = new HotelRoomTypeDTO();
			for (Integer rid : listOfRoomId)
			{
				tempRoom = new Room();
				
				hotelRoomDto.clear();
				logger.fatal("rid:" + rid);
				hotelRoomDto.getHotelRoomById(rid);
				
				tempRoomTypeDto.initialize(hotelRoomDto.getRoomTypeId(),
						roomTypeHash.get(hotelRoomDto.getRoomTypeId()));
				this.initializeHotelRoomFromDTO(tempRoom, hotelRoomDto, tempRoomTypeDto);
				
				roomList.add(tempRoom);
			}
			
			// set hotel rooms
			tempHotel.setRoom(roomList);
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
		
		return tempHotel;
	}

	@Override
	public boolean addHotel(Hotel hotel) throws Exception 
	{
		boolean status = false;
		HotelDTO hotelDto = null;
		
		ArrayList<Amenity> amenityList = null;
		ArrayList<Room> roomList = null;
		ArrayList<Review> reviewList = null;
		
		try
		{
			logger.info("Insert hotel details");
			hotelDto = new HotelDTO();
			this.initializeDtoFromHotel(hotel, hotelDto);
			hotelDto.addHotel();
			hotel.setId(hotelDto.getId());
			
			logger.info("insert amenities in case it does not exist");
			amenityList = hotel.getAmenity();
			for(Amenity amenity : amenityList)
			{
				this.addHotelAmenity(hotel, amenity);
			}
			
			logger.info("insert room types if it does not exist");
			roomList = hotel.getRoom();
			for(Room room : roomList)
			{
				this.addHotelRoom(hotel, room);
			}
			
			
			logger.info("Insert hotel reviews");
			reviewList = hotel.getReview();
			for(Review review : reviewList)
			{
				this.addHotelReview(hotel, review);
			}
			
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
		
		return status;
	}

	@Override
	public boolean removeHotel(Hotel hotel) throws Exception 
	{
		boolean status = false;
		HotelDTO hotelDto = null;
		
		ArrayList<Amenity> amenityList = null;
		ArrayList<Room> roomList = null;
		ArrayList<Review> reviewList = null;
		
		try
		{
			logger.info("Insert hotel reviews");
			reviewList = hotel.getReview();
			for(Review review : reviewList)
			{
				this.removeHotelReview(hotel, review);
			}
			
			logger.info("insert room types if it does not exist");
			roomList = hotel.getRoom();
			for(Room room : roomList)
			{
				this.removeHotelRoom(hotel, room);
			}
			
			logger.info("insert amenities in case it does not exist");
			amenityList = hotel.getAmenity();
			for(Amenity amenity : amenityList)
			{
				this.removeHotelAmenity(hotel, amenity);
			}
			
			logger.info("Insert hotel details");
			hotelDto = new HotelDTO();
			hotelDto.deleteHotelById(hotel.getId());
			
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
		
		return status;
	}

	// we update only the hotel details, and not the rooms, reviews
	// or other data. that needs to be done separately. 
	@Override
	public boolean updateHotel(Hotel hotel) throws Exception 
	{
		boolean status = false;
		HotelDTO hotelDto = null;
		
		try
		{
			logger.info("update hotel details");
			hotelDto = new HotelDTO();
			this.initializeDtoFromHotel(hotel, hotelDto);
			logger.info(hotel.getDescription());
			logger.info(hotelDto.getDescription());
			
			hotelDto.updateHotel();
		
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean addHotelAmenity(Hotel hotel, Amenity amenity) throws Exception 
	{
		boolean status = false;
		HotelAmenityDTO hotelAmenityDto = null;
		AmenityDTO amenityDto = null;
		
		try
		{
			logger.info("update hotel amenity");
			hotelAmenityDto = new HotelAmenityDTO();
			amenityDto = new AmenityDTO();
			
			this.initializeDTOFromAmenity(amenity, hotelAmenityDto, amenityDto);
			hotelAmenityDto.addHotelAmenity();
			amenity.setLinkId(hotelAmenityDto.getId());
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean removeHotelAmenity(Hotel hotel, Amenity amenity)
			throws Exception 
	{
		boolean status = false;
		HotelAmenityDTO hotelAmenityDto = null;
		
		try
		{
			logger.info("delete hotel amenity");
			hotelAmenityDto = new HotelAmenityDTO();
			
			hotelAmenityDto.deleteHotelAmenity(amenity.getLinkId());
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean updateHotelAmenity(Hotel hotel, Amenity amenity)
			throws Exception 
	{
		boolean status = false;
		HotelAmenityDTO hotelAmenityDto = null;
		AmenityDTO amenityDto = null;
		
		try
		{
			logger.info("update hotel amenity");
			hotelAmenityDto = new HotelAmenityDTO();
			amenityDto = new AmenityDTO();
			
			this.initializeDTOFromAmenity(amenity, hotelAmenityDto, amenityDto);
			hotelAmenityDto.updateHotelAmenity();
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	
	}

	@Override
	public boolean addHotelRoom(Hotel hotel, Room room) throws Exception 
	{
		boolean status = false;
		HotelRoomDTO hotelRoomDto = null;
		HotelRoomTypeDTO hotelRoomTypeDto = null;
		
		try
		{
			hotelRoomDto = new HotelRoomDTO();
			hotelRoomTypeDto = new HotelRoomTypeDTO();
			
			logger.info("add hotel room ");
			this.initializeDTOFromHotelRoom(hotelRoomDto, hotelRoomTypeDto, room);
			hotelRoomDto.addHotelRoom();
			room.setId(hotelRoomDto.getId());
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean removeHotelRoom(Hotel hotel, Room room) throws Exception 
	{
		boolean status = false;
		HotelRoomDTO hotelRoomDto = null;
		
		try
		{
			hotelRoomDto = new HotelRoomDTO();
			
			logger.info("remove hotel room ");
			hotelRoomDto.deleteHotelRoom(room.getId());
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean updateHotelRoom(Hotel hotel, Room room) throws Exception 
	{
		boolean status = false;
		HotelRoomDTO hotelRoomDto = null;
		HotelRoomTypeDTO hotelRoomTypeDto = null;
		
		try
		{
			hotelRoomDto = new HotelRoomDTO();
			hotelRoomTypeDto = new HotelRoomTypeDTO();
			
			logger.info("add hotel room ");
			this.initializeDTOFromHotelRoom(hotelRoomDto, hotelRoomTypeDto, room);
			hotelRoomDto.updateHotelRoom();
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean addHotelReview(Hotel hotel, Review review) throws Exception 
	{
		boolean status = false;
		HotelReviewDTO hotelReviewDto = null;
		
		try
		{
			hotelReviewDto = new HotelReviewDTO();
			
			logger.info("add hotel review ");
			this.initializeReviewDtoFromReview(hotelReviewDto, review);
			hotelReviewDto.addHotelReview();
			review.setId(hotelReviewDto.getId());
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean removeHotelReview(Hotel hotel, Review review)
			throws Exception 
	{
		boolean status = false;
		HotelReviewDTO hotelReviewDto = null;
		
		try
		{
			hotelReviewDto = new HotelReviewDTO();
			
			logger.info("add hotel review ");
			hotelReviewDto.deleteHotelReview(review.getId());
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public boolean updateHotelReview(Hotel hotel, Review review)
			throws Exception 
	{
		boolean status = false;
		HotelReviewDTO hotelReviewDto = null;
		
		try
		{
			hotelReviewDto = new HotelReviewDTO();
			
			logger.info("add hotel review ");
			this.initializeReviewDtoFromReview(hotelReviewDto, review);
			hotelReviewDto.updateHotelReview();
			
			// we are assuming that amenity already exists. 
			// if we made it till here, then all went well
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return status;
	}

	@Override
	public int addNewAmenity(String name, String description) throws Exception 
	{
		AmenityDTO amenityDto = null;
		int rval = -1;
		
		try
		{
			amenityDto = new AmenityDTO();
			
			logger.info("add hotel amenity");
			amenityDto.setName(name);
			amenityDto.setDescription(description);
			
			rval = amenityDto.addAmenity();
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return rval;
	}

	@Override
	public HashMap<Integer, String[]> getAllAmenity() throws Exception 
	{
		AmenityDTO amenityDto = null;
		HashMap<Integer, String[]> rval = null;
		
		try
		{
			logger.info("add hotel amenity");
			amenityDto = new AmenityDTO();
			rval = amenityDto.getAllAmenity();
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return rval;
	}

	@Override
	public int addNewHotelRoomType(String roomType, String description)
			throws Exception 
	{
		HotelRoomTypeDTO hotelRoomTypeDto = null;
		int rval = -1;
		
		try
		{
			hotelRoomTypeDto = new HotelRoomTypeDTO();
			
			logger.info("add hotel amenity");
			hotelRoomTypeDto.setRoomType(roomType);
			hotelRoomTypeDto.setDescription(description);
			
			rval = hotelRoomTypeDto.addHotelRoomType();
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return rval;
	}

	@Override
	public HashMap<Integer, String[]> getAllHotelRoomTypes() throws Exception 
	{
		HotelRoomTypeDTO hotelRoomTypeDto = null;
		HashMap<Integer, String[]> rval = null;
		
		try
		{
			logger.info("add hotel amenity");
			hotelRoomTypeDto = new HotelRoomTypeDTO();
			rval = hotelRoomTypeDto.getAllHotelRoomType();
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
	
		return rval;
	}

	@Override
	public ArrayList<Hotel> getHotelForOwner(int ownerId)
			throws Exception 
	{
		ArrayList<Hotel> hlist = null;
		HotelDTO hdto = null;
		ArrayList<Integer> hidlist = null;
		Hotel temp = null;
		
		try
		{
			logger.info("Get hotel for owner");
			hdto = new HotelDTO();
			
			hidlist = hdto.getHotelByOwnerId(ownerId);
			
			hlist = new ArrayList<Hotel>();
			for(Integer id : hidlist)
			{
				temp = new Hotel();
				hdto.clear();
				
				temp = this.getHotelById(id);
				hlist.add(temp);
			}
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to get hotel for owner");
			throw ex;
		}
		
		return hlist;
	}
	
	@Override
	public ArrayList<Hotel> getAllHotel()
			throws Exception 
	{
		ArrayList<Hotel> hlist = null;
		HotelDTO hdto = null;
		ArrayList<Integer> hidlist = null;
		Hotel temp = null;
		
		try
		{
			logger.info("Get hotel for owner");
			hdto = new HotelDTO();
			
			hidlist = hdto.getAllHotel();
			
			hlist = new ArrayList<Hotel>();
			for(Integer id : hidlist)
			{
				temp = new Hotel();
				hdto.clear();
				
				temp = this.getHotelById(id);
				hlist.add(temp);
			}
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to get hotel for owner");
			throw ex;
		}
		
		return hlist;
	}

}
