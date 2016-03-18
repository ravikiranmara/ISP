package dataAccessObject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import modelObject.CreditCard;
import modelObject.User;
import org.apache.log4j.Logger;

import utils.UserType;
import dataTransferObjects.*;


// user = userBasic + credit card details
public class UserDAO implements IUserDao {

	private void initializeUserDtoFromUser(UserDTO userDto, User user)
	{
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setId(user.getUserId());
		userDto.setPassword(user.getPassword());
		userDto.setUsername(user.getUsername());
		userDto.setAddressLine1(user.getAddressLine1());
		userDto.setAddressLine2(user.getAddressLine2());
		userDto.setCity(user.getCity());
		userDto.setState(user.getState());
		userDto.setStatus(user.getUserStatus());
		userDto.setPostalCode(user.getPostalCode());
		userDto.setType(user.getUserType().getValue());
		
		return;
	}
	
	
	private void initializeUserFromUserDTO(User user, UserDTO userDto)
	{
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUserId(userDto.getId());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		user.setAddressLine1(userDto.getAddressLine1());
		user.setAddressLine2(userDto.getAddressLine2());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setUserStatus(userDto.getStatus());
		user.setPostalCode(userDto.getPostalCode());
		
		//user type
		int usertypeint = userDto.getType();
		UserType userType = (usertypeint == UserType.Client.getValue())?
				UserType.Client:UserType.Customer;
		user.setUserType(userType);
		
		return;
	}

	private void initializeDTOFromCreditCard(CreditCardDTO creditCardDto, CreditCard creditCard)
	{
		creditCardDto.setBalance(creditCard.getBalance());
		creditCardDto.setCreditCardNumber(creditCard.getCardNumber());
		creditCardDto.setCvv(creditCard.getCvv());
		creditCardDto.setCardHolderName(creditCard.getHolderName());
		creditCardDto.setCardNickName(creditCard.getNickName());
		creditCardDto.setId(creditCard.getId());
		creditCardDto.setUserId(creditCard.getUserId());
		
		return;
	}
	
	private void initializeCreditCardFromDTO(CreditCard creditCard, CreditCardDTO creditCardDto)
	{
		creditCard.setBalance(creditCardDto.getBalance());
		creditCard.setCardNumber(creditCardDto.getCreditCardNumber());
		creditCard.setCvv(creditCardDto.getCvv());
		creditCard.setHolderName(creditCardDto.getCardHolderName());
		creditCard.setNickName(creditCardDto.getCardNickName());
		creditCard.setId(creditCardDto.getId());
		creditCard.setUserId(creditCardDto.getUserId());
		
		return;
	}
	
	@Override
	public boolean addUser(User user) throws Exception 
	{
		boolean status = false;
		UserDTO userDto = null;
		CreditCardDTO creditCardDto = null;
		ArrayList<CreditCard> creditCard = null;
		
		try
		{
			userDto = new UserDTO();
			creditCardDto = new CreditCardDTO();
			
			// fetch user details
			logger.info("Put user details from to db");
			this.initializeUserDtoFromUser(userDto, user);
			int id = userDto.addNewUser();
			if(-1 == id)
			{
				throw new Exception("Unable to insert user");
			}
			else
			{
				user.setUserId(id);
			}
			
			logger.info("Foreach card number get card info");
			creditCard = user.getCreditCard();
			
			// hacky, don't want to put another exception
			if(null == creditCard)
			{
				creditCard = new ArrayList<CreditCard>();
			}
			
			creditCardDto = new CreditCardDTO();
			for (CreditCard card : creditCard)
			{
				// lets get the dto and initialize
				creditCardDto.Clear();
				this.initializeDTOFromCreditCard(creditCardDto, card);
				
				// set userid for credit card
				creditCardDto.setUserId(id);
				
				int creditCardId = creditCardDto.addCreditCard();
				card.setId(creditCardId);
			}
			
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
	public User getUserByUsername(String username) throws Exception 
	{
		User tempUser = null;
		UserDTO userDto = null;
		CreditCardDTO creditCardDto = null;
		ArrayList<String> creditCardNumber = null;
		ArrayList<CreditCard> creditCard = null;
		CreditCard temp;
		
		try
		{
			tempUser = new User();
			userDto = new UserDTO();
			creditCardDto = new CreditCardDTO();
			
			// fetch user details
			logger.info("Get user details from dto");
			if(false == userDto.getUserByUsername(username))
			{
				throw new NoSuchElementException();
			}
			this.initializeUserFromUserDTO(tempUser, userDto);
			
			logger.info("Getting list of credit Cards dto");
			creditCardNumber = creditCardDto.getCreditCardNumbersForUser(userDto.getId());
			
			logger.info("Foreach card number get card info");
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
		catch(NoSuchElementException e)
		{
			logger.info("No such user exists");
			tempUser = null;
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
	}

	@Override
	public User getUserById(int id) throws Exception 
	{
		User tempUser = null;
		UserDTO userDto = null;
		CreditCardDTO creditCardDto = null;
		ArrayList<String> creditCardNumber = null;
		ArrayList<CreditCard> creditCard = null;
		CreditCard temp;
		
		try
		{
			userDto = new UserDTO();
			creditCardDto = new CreditCardDTO();
			tempUser = new User();
			
			// fetch user details
			logger.info("Get user details from dto");
			if(false == userDto.getUserById(id))
			{
				throw new NoSuchElementException();
			}
			
			this.initializeUserFromUserDTO(tempUser, userDto);
			
			logger.info("Getting list of credit Cards dto");
			creditCardNumber = creditCardDto.getCreditCardNumbersForUser(userDto.getId());
			
			logger.info("Foreach card number get card info");
			creditCard = new ArrayList<CreditCard>();
			for (String number : creditCardNumber)
			{
				// lets get the dto and initialize
				creditCardDto.Clear();
				temp = new CreditCard();
				creditCardDto.getCreditCardByCreditCardNumber(number);
				
				this.initializeCreditCardFromDTO(temp, creditCardDto);
				creditCard.add(temp);
			}
			// no exceptions so make final assignment
			tempUser.setCreditCard(creditCard);		
		}
		catch(NoSuchElementException e)
		{
			logger.info("No such user exists");
			tempUser = null;
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
	}


	@Override
	public boolean removeUser(User user) throws Exception 
	{
		boolean status = false;
		
		UserDTO userDto = null;
		CreditCardDTO creditCardDto = null;
		ArrayList<CreditCard> creditCard = null;
		
		try
		{
			userDto = new UserDTO();
			creditCardDto = new CreditCardDTO();
			
			// fetch user details
			logger.info("Foreach card number delete card info");
			creditCard = user.getCreditCard();
			for (CreditCard card : creditCard)
			{
				// lets get the dto and initialize
				creditCardDto.Clear();
				creditCardDto.deleteCreditCard(card.getId());
			}
			
			logger.info("delete user details from to db");
			userDto.deleteUserById(user.getUserId());
			
			// still no exceptions, then we are good
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
	public boolean updateUser(User user) throws Exception 
	{
		boolean status = false;
		UserDTO userDto = null;
		
		try
		{
			userDto = new UserDTO();
			
			// fetch user details
			logger.info("update user details from to db");
			this.initializeUserDtoFromUser(userDto, user);
			status = userDto.updateUser();			
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
	public boolean addCreditCard(User user, CreditCard creditCard) throws Exception 
	{
		boolean status = false;
		CreditCardDTO creditCardDto = null;
		
		try
		{
			creditCardDto = new CreditCardDTO();
			
			// fetch user details
			logger.info("add credit card");
			this.initializeDTOFromCreditCard(creditCardDto, creditCard);
			creditCardDto.setUserId(user.getUserId());
			
			int creditCardId = creditCardDto.addCreditCard();
			creditCard.setId(creditCardId);
			
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
	public boolean removeCreditCard(User user, CreditCard creditCard) throws Exception 
	{
		boolean status = false;
		CreditCardDTO creditCardDto = null;
		
		try
		{
			creditCardDto = new CreditCardDTO();
			
			// fetch user details
			logger.info("add credit card");
			creditCardDto.setUserId(user.getUserId());
			
			creditCardDto.deleteCreditCard(creditCard.getId());

			// now update user
			ArrayList<CreditCard> creditCardList = user.getCreditCard();
			creditCardList.remove(creditCard);
			user.setCreditCard(creditCardList);
			
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
	public boolean updateCreditCard(User user, CreditCard creditCard) throws Exception 
	{
		boolean status = false;
		CreditCardDTO creditCardDto = null;
		
		try
		{
			creditCardDto = new CreditCardDTO();
			
			// fetch user details
			logger.info("update credit card");
			this.initializeDTOFromCreditCard(creditCardDto, creditCard);
			creditCardDto.setUserId(user.getUserId());
			creditCardDto.updateCreditCard();
			logger.info("Update credit card : " + creditCard.getBalance());
			
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to update User credit card: ");
			throw e;
		}
		finally
		{
			
		}
		
		return status;
	}
}
