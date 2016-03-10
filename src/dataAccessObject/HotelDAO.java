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
import modelObject.CreditCard;
import modelObject.Hotel;
import modelObject.Review;
import modelObject.Room;
import modelObject.User;

public class HotelDAO implements IHotelDAO
{
	private void initializeReviewDtoFromReview(HotelReviewDTO reviewDto, Review review )
	{
		reviewDto.setHotelId(review.getHotelId());
		reviewDto.setRating(review.getRating());
		reviewDto.setReview(review.getReview());
		reviewDto.setReviewDate(review.getDate());
		reviewDto.setReviewerName(review.getReviewerName());
		
		return;
	}
	
	private void initializeReviewFromReviewDto(Review review, HotelReviewDTO reviewDto)
	{
		review.setHotelId(reviewDto.getHotelId());
		review.setRating(reviewDto.getRating());
		review.setReview(reviewDto.getReview());
		review.setDate(reviewDto.getReviewDate());
		review.setReviewerName(reviewDto.getReviewerName());
		
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
		
		return;
	}
	
	private void initializeAmenityFromDTO(Amenity amenity, HotelAmenityDTO hotelAmenityDto, AmenityDTO amenityDto)
	{
		amenity.setamenityId(amenityDto.getId());
		amenity.setName(amenityDto.getName());
		amenity.setHotelId(hotelAmenityDto.getHotelId());
		amenity.setLinkId(hotelAmenityDto.getId());
		amenity.setValue(hotelAmenityDto.getValue());
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
		hotelDto.setDescription(hotelDto.getDescription());
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
		
		ArrayList<Amenity> amenityList = null;
		ArrayList<Room> roomList = null;
		ArrayList<Review> reviewList = null;
		HashMap<Integer, String[]> amenityHash = null;
		ArrayList<Integer> listOfHotelAmenityId = null;
		
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
			
			creditCard = new ArrayList<CreditCard>();
			for (String number : creditCardNumber)
			{
				// lets get the dto and initialize
				temp = new CreditCard();
				creditCardDto.Clear();
				creditCardDto.getCreditCardByCreditCardNumber(number);
				
				this.initializeCreditCardFromDTO(temp, creditCardDto);
				creditCard.add(temp);
			}
			
			// no exceptions so make final assignment
			tempUser.setCreditCard(creditCard);
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get User : ");
			throw e;
		}
		finally
		{
			
		}
		
		return tempUser;

		
		return null;
	}

	@Override
	public boolean addHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotelAmenity(Hotel hotel, Amenity amenity)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHotelAmenity(Hotel hotel, Amenity amenity)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelAmenity(Hotel hotel, Amenity amenity)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotelRoom(Hotel hotel, Room room) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHotelRoom(Hotel hotel, Room room) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelRoom(Hotel hotel, Room room) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHotelReview(Hotel hotel, Review review) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeHotelReview(Hotel hotel, Review review)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelReview(Hotel hotel, Review review)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
