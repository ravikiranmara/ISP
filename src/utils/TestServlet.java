package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelObject.CreditCard;
import modelObject.User;

import dataAccessObject.UserDAO;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
	    
		out.println("begin");
		
		this.dumpUserDao(out);
		
	    out.println("end");
	}

	private void dumpUserDto(PrintWriter out) throws Exception
	{
		UserDTO userDto = new UserDTO();
		userDto.getUserByUsername("sss");
		//userDto.getUserById(1);
		
		out.println(userDto.getUsername());
		out.println(userDto.getPassword());
	    
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
