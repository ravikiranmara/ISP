package utils;

import java.sql.Date;

public class globals 
{
    static public String propertiesPath = "WEB-INF";
	static public String webInfPath = null;
	static public String webConfig_dbname = "dbname";
	static public String webConfig_dbdriver = "dbDriver";
	static public String webConfig_username = "username";
	static public String webConfig_password = "password";
	static public String webConfig_connString = "connectionString";
	static public int valid = 0;
	static public int invalid = 1;
	static public Date invalidDate =  java.sql.Date.valueOf( "1970-01-01" );
	static public String session_username = "username";
	static public String session_hotelsByOwner = "hotelsByOwner";
	static public String session_editHotelObject = "editHotelObject";
	static public String session_userid = "session_userid";
	static public String session_clientres = "session_clientRes";
	static public String session_clientResTrans = "session_clientResTrans";
	static public String session_clientResCust = "session_clientResCust";
	static public String session_clientResCli = "session_clientResCli";
	static public String session_clientResHotelname = "session_clientResHotelname";
	static public String session_clientResRoomType = "session_clientResRoomType";
	static public String session_clientResRoom = "session_clientResRoom";
	static public String session_clientResCustCC = "session_clientResCustCC";
	static public String session_clientCurrResList = "session_clientCurrResList";
	static public String session_clientCancelBean = "session_clientCancelBean";
	static public String session_CreateReshotelsByOwner = "session_CreateReshotelsByOwner";
	static public String session_customerReservationsList = "session_customerReservationsList";
	static public String session_customerCancelBean = "session_customerCancelBean";
	static public String session_customerSearchHotelList = "session_customerSearchHotelList";
	static public String session_customerReservationObject = "session_customerReservationObject";
	static public String session_customerReservationBean = "session_customerReservationBean";
	static public String session_customerSelectBean = "session_customerSelectBean";
	static public String session_customerReserveTransUser = "session_customerReserveTransUser";
	static public String session_customerResCustCC = "session_customerResCustCC";
	static public String session_Exception = "session_Exception";
	static public short transaction_cancelFalse = 0;
	static public short transaction_cancelTrue = 1;
	static public short transaction_reservationTrue = 0;
	static public short transaction_reservationFalse = 1;
	static public short reservation_cancelFalse = 0;
	static public short reservation_cancelTrue = 1;

}
