package modelObject;

import java.util.ArrayList;

public class CustomerReservationListBean 
{
	ArrayList<Reservation> reservation = null;
	Transaction transaction = null;
	User user = null;
	
	public CustomerReservationListBean()
	{	
	}
	
	public boolean addReservation(Reservation reservation) throws Exception
	{
		boolean status = false;
		
		try 
		{
			this.reservation.add(reservation);
			status = true;
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		return status;
	}
	
	// getter and setter
	public ArrayList<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(ArrayList<Reservation> reservation) {
		this.reservation = reservation;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
