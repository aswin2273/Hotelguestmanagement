vpackage com.hotel.service;

import com.hotel.bean.*;
import com.hotel.dao.*;
import com.hotel.util.*;

import java.util.Date;

public class StayService {

    private GuestDAO guestDAO = new GuestDAO();
    private StayDAO stayDAO = new StayDAO();

    public boolean registerGuest(Guest guest) throws ValidationException {

        if (guest.getGuestID() == null || guest.getFullName() == null)
            throw new ValidationException("Guest data invalid");

        if (guestDAO.findGuest(guest.getGuestID()) != null)
            throw new ValidationException("Guest already exists");

        return guestDAO.insertGuest(guest);
    }

    public boolean checkInGuest(String guestID, String roomNumber,
                                Date checkInDate, double roomRate)
            throws Exception {

        if (guestID.isEmpty() || roomNumber.isEmpty() || roomRate <= 0)
            throw new ValidationException("Invalid check-in data");

        if (guestDAO.findGuest(guestID) == null)
            return false;

        if (stayDAO.isRoomOccupied(roomNumber))
            throw new NoAvailableRoomException("Room Occupied!");

        Stay stay = new Stay();
        stay.setStayID(stayDAO.generateStayID());
        stay.setGuestID(guestID);
        stay.setRoomNumber(roomNumber);
        stay.setCheckInDate(checkInDate);
        stay.setRoomRate(roomRate);
        stay.setExtras(0);
        stay.setStatus("ACTIVE");

        return stayDAO.recordCheckIn(stay);
    }

    public boolean checkOutGuest(int stayID, Date checkOutDate, double extras)
            throws Exception {

        if (stayID <= 0)
            throw new ValidationException("Invalid stay ID");

        return stayDAO.closeStay(stayID, extras, checkOutDate);
    }
}
