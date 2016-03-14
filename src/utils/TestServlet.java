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

import modelObject.CreditCard;
import modelObject.User;

import dataAccessObject.UserDAO;
import dataTransferObjects.AmenityDTO;
import dataTransferObjects.CreditCardDTO;
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
		
		this.dumpAmenity(out);
		
	    out.println("end");
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
