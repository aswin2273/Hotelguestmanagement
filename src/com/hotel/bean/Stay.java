package com.hotel.bean;

import java.util.Date;

public class Stay {

    private int stayID;
    private String guestID;
    private String roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private double roomRate;
    private double extras;
    private String status;

    // Getters & Setters
    public int getStayID() { return stayID; }
    public void setStayID(int stayID) { this.stayID = stayID; }

    public String getGuestID() { return guestID; }
    public void setGuestID(String guestID) { this.guestID = guestID; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Date getCheckInDate() { return checkInDate; }
    public void setCheckInDate(Date checkInDate) { this.checkInDate = checkInDate; }

    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }

    public double getRoomRate() { return roomRate; }
    public void setRoomRate(double roomRate) { this.roomRate = roomRate; }

    public double getExtras() { return extras; }
    public void setExtras(double extras) { this.extras = extras; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
