package reservationsTransactionsPackage;

import hotels.EditHotels;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.PaymentService;
import ModelServiceLayer.ReservationService;
import ModelServiceLayer.TransactionService;

import utils.globals;

import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.ReservationsBean;
import modelObject.Room;
import modelObject.Transaction;

/**
 * Servlet implementation class ClientCancelReservationAndRefund
 */
@WebServlet(name = "/ClientCancelReservationAndRefund", urlPatterns = { "/ClientCancelReservationAndRefund" })
public class ClientCancelReservationAndRefund extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(EditHotels.class.getName());
	
    public ClientCancelReservationAndRefund() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = null;
		ReservationsBean rbean = null;
		
		TransactionService transactionService = null;
		PaymentService paymentService = null;
		ReservationService reservationService = null;
		IHotelServiceLayer hotelService = null;
		
		Transaction transaction = null;
		Reservation reservation = null;
		
		try
		{
			logger.info("cancel and refund reservation");
			
			session = request.getSession();
			rbean = (ReservationsBean)session.getAttribute(globals.session_clientCancelBean);

			if(null == rbean)
			{
				throw new Exception ("Unable to get reservation details from session");
			}
			
			reservationService = new ReservationService();
			transactionService = new TransactionService();
			paymentService = new PaymentService();
			hotelService = new HotelService();
			
			logger.info("get objects");
			transaction = rbean.getTransaction();
			reservation = rbean.getReservation();
			
			logger.info("reverse payment");
			if(false == paymentService.makePayment(transaction.getOwnerUserId(), transaction.getOwnerCreditCardId(), 
					transaction.getCustomerUserId(), transaction.getCustomerCreditCardId(),
					transaction.getAmount()))
			{
				throw new Exception("Unable to credit amount back to user");
			}
			
			logger.info("cancel transaction and reservation");
			transactionService.cancelTransaction(transaction);
			reservationService.cancelReservation(reservation);
			
			logger.info("Update available rooms");
			Hotel hotel = null;
			hotel = hotelService.getHotelById(rbean.getReservation().getHotelId());
			
			Room room = null;
			ArrayList<Room> roomlist = hotel.getRoom();
			int roomType = rbean.getReservation().getRoomTypeId();
			
			logger.info("get room : " + roomType);
			for(Room r : roomlist)
			{
				logger.info(r.getRoomTypeId());
				if(roomType == r.getRoomTypeId())
				{
					room = r;
				}
			}
			
			if(null == room)
			{
				throw new Exception("Unable to find room");
			}
			
			int av = room.getAvailableNumber();
			room.setAvailableNumber(av + rbean.getReservation().getNumberOfRooms());
			hotelService.updateRoomForHotel(hotel, room);
			
			logger.info("cancelled reservation. now redirect");
			response.sendRedirect("ClientCancelReservationConfirmation.jsp");
		}
		catch (Exception ex)
		{
			logger.fatal("unable to cancel and refund reservation" + ex.getMessage());
			response.sendRedirect("ClientCancelReservationFaile.jsp");
		}
	}
	
}
