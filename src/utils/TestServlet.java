package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;

import modelObject.Amenity;
import modelObject.CreditCard;
import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.Review;
import modelObject.Room;
import modelObject.SearchParameter;
import modelObject.User;

import dataAccessObject.HotelDAO;
import dataAccessObject.ReservationDAO;
import dataAccessObject.UserDAO;
import dataTransferObjects.AmenityDTO;
import dataTransferObjects.CreditCardDTO;
import dataTransferObjects.HotelDTO;
import dataTransferObjects.HotelRoomDTO;
import dataTransferObjects.UserDTO;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
	    
		out.println("begin");
		
		this.dumpSearch(out);
		
	    out.println("end");
	}
	
	private void dumpSearch(PrintWriter out) throws Exception
	{
		IHotelServiceLayer hs = new HotelService();
		SearchParameter sp = new SearchParameter();
		ArrayList<Hotel> hl = null;
		
		sp.setHotelname("sss-towers");
		sp.setCity("city");
		
		hl = hs.SearchForHotel(sp);
		
		for(Hotel h : hl)
		{
			out.println("----- hotel -----");
			out.println(h.getId());
			out.println(h.getName());
		}
		
	}
	
	private void dumpgetHotelForOwner(PrintWriter out) throws Exception
	{
		HotelDAO hd = new HotelDAO();
		ArrayList<Hotel> hotels = null;
		
		hotels = hd.getHotelForOwner(24);
		for(Hotel h : hotels)
		{
			out.println("----- hotel -----");
			out.println(h.getId());
			out.println(h.getName());
			
			ArrayList<Review> reviews = null;
			reviews = h.getReview();
			
			out.println("Review");
			for(Review r : reviews)
			{
				out.println(r.getReview());
				out.println(r.getId());
			}
		
			out.println("amenities");
			ArrayList<Amenity> amenities = null;
			amenities = h.getAmenity();
			for(Amenity a : amenities)
			{
				out.println(a.getName());
				out.println(a.getDescription());
				out.println(a.getValue());
			}
			
			out.println("Hotel rooms");
			ArrayList<Room> rooms = null;
			rooms = h.getRoom();
			for(Room r : rooms)
			{
				out.println(r.getId());
				out.println(r.getRoomType());
				out.println(r.getAvailableNumber());
				out.println(r.getStartDate());
				out.println(r.getEndDate());
			}
			
		}
		
		return;
	}
	
	private void dumpHotelDao(PrintWriter out) throws Exception
	{
		HotelDAO hd = new HotelDAO();
		Hotel h = null;
		
		h = hd.getHotelById(1);
		
		out.println(h.getId());
		out.println(h.getName());
		
		ArrayList<Review> reviews = null;
		reviews = h.getReview();
		
		out.println("Review");
		for(Review r : reviews)
		{
			out.println(r.getReview());
			out.println(r.getId());
		}
		
		out.println("Hotel rooms");
		ArrayList<Room> rooms = null;
		rooms = h.getRoom();
		for(Room r : rooms)
		{
			out.println(r.getId());
			out.println(r.getRoomType());
			out.println(r.getAvailableNumber());
			out.println(r.getStartDate());
			out.println(r.getEndDate());
		}
	}
	
	private void dumpHotelByUserId(PrintWriter out) throws Exception
	{
		HotelDTO hd = new HotelDTO();
		ArrayList<Integer> hl = new ArrayList<Integer>(); 
		
		hl = hd.getHotelByOwnerId(24);
		
		for(int i : hl)
		{
			out.println(i);
		}
	}
	
	private void dumpAllHotels(PrintWriter out) throws Exception
	{
		HotelDTO hd = new HotelDTO();
		ArrayList<Integer> hl = new ArrayList<Integer>(); 
		
		hl = hd.getAllHotel();
		
		for(int i : hl)
		{
			out.println(i);
		}
	}
	
	private void dumpHotel(PrintWriter out) throws Exception
	{
		HotelDTO hd = new HotelDTO();
		
		hd.getHotelById(1);
		
		out.println(hd.getName());
		out.println(hd.getOwnerUserId());
	}
	
	private void hotelRoomDtotest(PrintWriter out) throws Exception
	{
		
		HotelRoomDTO hotelroomdto = new HotelRoomDTO();
		
		/*
		hotelroomdto.setRoomTypeId(2);
		hotelroomdto.setHotelId(3);
		hotelroomdto.setAvailableNumber(15);
		hotelroomdto.setPricePerNight(250);
		hotelroomdto.setStartDate(java.sql.Date.valueOf( "2015-01-01"));
		hotelroomdto.setEndDate(java.sql.Date.valueOf( "2017-01-01"));
		
		hotelroomdto.addHotelRoom();
		
		out.println("id : " + hotelroomdto.getId());
		*/
		
		//out.println(hotelroomdto.getAvailableNumber());
		//out.println(hotelroomdto.getStartDate());
		//out.println(hotelroomdto.getEndDate());
				
		
		/*HashMap<Integer, String[]> list = amindto.getAllAmenity();
		
		for(Integer i : list.keySet())
		{
			out.println(i);
			String[] values = list.get(i);
			out.println("name" + values[0]);
			out.println("desc" + values[1]);
		}
		*/
		return;
	}
	
	private void dumpReservation(PrintWriter out) throws Exception
	{
		ReservationDAO reservationDao = new ReservationDAO(); 
		Reservation reservation = reservationDao.getReservationById(2);
		
		out.println(reservation.getId());
		out.println(reservation.getTransactionId());
		
		return;
	}

	private void dumpAmenity(PrintWriter out) throws Exception
	{
		AmenityDTO amenityDto = new AmenityDTO();
		
		HashMap<Integer, String[]> list = amenityDto.getAllAmenity();
		for(Integer i : list.keySet())
		{
			out.println(i);
			String[] values = list.get(i);
			out.println("name" + values[0]);
			out.println("desc" + values[1]);
		}
	}
	
	private void dumpUserDto(PrintWriter out) throws Exception
	{
		UserDTO userDto = new UserDTO();
		userDto.getUserByUsername("sss");
		//userDto.getUserById(1);
		
		out.println(userDto.getUsername());
		out.println(userDto.getPassword());
	    
	}

	private void insertDeleteUser(PrintWriter out) throws Exception
	{
		UserDTO userDto = new UserDTO();
		UserDTO userDto2 = new UserDTO();
		userDto.setFirstName("ttt");
		userDto.setLastName("tll");
		userDto.setAddressLine1("adr1");
		userDto.setAddressLine2("adr2");
		userDto.setUsername("ttt");
		userDto.setPassword("ttt");
		userDto.setType(0);
		userDto.setCity("city");
		userDto.setState("State");
		userDto.setPostalCode("987654");
		userDto.setStatus(0);
		
		userDto.addNewUser();
		
		userDto2.getUserByUsername("ttt");
		//userDto.getUserById(1);
		
		int id = userDto2.getId();
		out.println(userDto2.getId());
		out.println(userDto2.getUsername());
		out.println(userDto2.getPassword());
		out.println(userDto2.getAddressLine1());

		userDto2.setAddressLine1("addr11");
		userDto2.updateUser();
		
		userDto2.getUserById(id);
		out.println(userDto2.getAddressLine1());

		// now insert credit card
		CreditCardDTO ccd = new CreditCardDTO();
		ccd.setBalance((float)100.0);
		ccd.setCardHolderName(userDto2.getFirstName());
		ccd.setCardNickName(userDto2.getUsername());
		ccd.setCreditCardNumber("11223344");
		ccd.setCvv("ttt");
		ccd.setUserId(userDto2.getId());
		ccd.addCreditCard();
		
		out.println(ccd.getCvv());
		
		ccd.setCvv("tvv");
		int cid = ccd.getUserId();

		ccd.getCreditCardById(cid);
		out.println(ccd.getCvv());
		
		User user;
		UserDAO ud = new UserDAO();
		user = ud.getUserById(id);
		user.setAddressLine1("addr1122333blah");
		ud.updateUser(user);

		ArrayList<CreditCard> ccdl = user.getCreditCard();
		CreditCard creditCard = ccdl.get(0);;
		creditCard.setCvv("aaa");
		
		ud.updateCreditCard(user, creditCard);
	
		user = ud.getUserById(id);
		out.println(user.getAddressLine1());
		ccdl = user.getCreditCard();
		creditCard = ccdl.get(0);
		out.println(creditCard.getCvv());
		
		
		CreditCardDTO ccd2 = new CreditCardDTO();
		// ccd2.getCreditCardByCreditCardNumber("113223344");
		
		//ccd2.deleteCreditCard(ccd2.getId());
		//userDto.deleteUserById(userDto2.getId());
	    
		return;
	}
	
	private void dumpCreditCard(PrintWriter out) throws Exception
	{
		CreditCardDTO creditCardDto = new CreditCardDTO();
		
		ArrayList<String> list = creditCardDto.getCreditCardNumbersForUser(2);
		for (String s : list)
		{
			creditCardDto.Clear();
			creditCardDto.getCreditCardByCreditCardNumber(s);
			out.println(creditCardDto.getCardHolderName());
			out.println(creditCardDto.getCardNickName());
			out.println(creditCardDto.getBalance());
		}
	
		return;
	}
	
	private void dumpUserDao(PrintWriter out) throws Exception
	{
		UserDAO userDao = new UserDAO();
		User user;
		
		user = userDao.getUserByUsername("rrr");
		
		out.println(user.getUsername());
		out.println(user.getPassword());
		out.println(user.getUserId());
		
		ArrayList<CreditCard> cardList = user.getCreditCard();
		for (CreditCard card : cardList)
		{
			out.println(card.getHolderName());
			out.println(card.getNickName());
			out.println(card.getBalance());
		}
	
		return;
	}
}
