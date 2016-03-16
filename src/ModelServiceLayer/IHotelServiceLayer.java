package ModelServiceLayer;

import java.util.ArrayList;
import java.util.HashMap;

import modelObject.Amenity;
import modelObject.Hotel;
import modelObject.Review;
import modelObject.Room;

public interface IHotelServiceLayer 
{
	Hotel getHotelById(int id) throws Exception;
	ArrayList<Hotel> getHotelForOwnerId(int ownerId) throws Exception;
	ArrayList<Hotel> getAllHotel() throws Exception;
	
	ArrayList<Hotel> serachForHotel(Hotel hotel) throws Exception;
	
	boolean addHotel(Hotel hotel) throws Exception;
	boolean updateHotel(Hotel hotel)  throws Exception;
	boolean deleteHotel(int hotelId)  throws Exception;
	
	boolean addAmenity(String name, String description) throws Exception;
	boolean updateAmenity(int aid, String name, String description) throws Exception;
	HashMap<Integer, String[]> getAllAmenityType() throws Exception;
	
	boolean addAmenityToHotel(Hotel hotel, Amenity amenity) throws Exception;
	boolean deleteAmenitFromHotel(Hotel hotel, Amenity amenity) throws Exception;
	
	boolean addReviewForHotel(Hotel hotel, Review review) throws Exception;
	boolean deleteReviewForHotel(Hotel hotel, Review review) throws Exception;
	
	boolean addHotelRoomToHotel(Hotel hotel, Room room) throws Exception;
	boolean updateRoomForHotel(Hotel hotel, Room room) throws Exception;
	HashMap<Integer, String[]> getAllRoomTypes() throws Exception;
}
