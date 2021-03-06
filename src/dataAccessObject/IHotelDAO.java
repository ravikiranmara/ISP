package dataAccessObject;

import java.util.ArrayList;
import java.util.HashMap;

import modelObject.Amenity;
import modelObject.Hotel;
import modelObject.Review;
import modelObject.Room;
import org.apache.log4j.Logger;


public interface IHotelDAO
{
	Hotel getHotelById(int id) throws Exception;
	ArrayList<Hotel> getHotelForOwner(int ownerId) throws Exception;
	
	boolean addHotel(Hotel hotel) throws Exception;
	boolean removeHotel(Hotel hotel) throws Exception;
	boolean updateHotel(Hotel hotel) throws Exception;
	
	boolean addHotelAmenity(Hotel hotel, Amenity amenity) throws Exception;
	boolean removeHotelAmenity(Hotel hotel, Amenity amenity) throws Exception;
	boolean updateHotelAmenity(Hotel hotel, Amenity amenity) throws Exception;
	
	boolean addHotelRoom(Hotel hotel, Room room) throws Exception;
	boolean removeHotelRoom(Hotel hotel, Room room) throws Exception;
	boolean updateHotelRoom(Hotel hotel, Room room) throws Exception;
	
	boolean addHotelReview(Hotel hotel, Review review) throws Exception;
	boolean removeHotelReview(Hotel hotel, Review review) throws Exception;
	boolean updateHotelReview(Hotel hotel, Review review) throws Exception;
	
	int addNewAmenity(String name, String description) throws Exception;
	HashMap<Integer, String[]> getAllAmenity() throws Exception;
	
	int addNewHotelRoomType(String roomType, String description) throws Exception;
	HashMap<Integer, String[]> getAllHotelRoomTypes() throws Exception;
	
	// Logger
	static Logger logger = Logger.getLogger(IHotelDAO.class.getName());

	ArrayList<Hotel> getAllHotel() throws Exception;
}
