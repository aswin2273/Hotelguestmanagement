package com.hotel.bean;

public class Guest {

    private String guestID;
    private String fullName;
    private String phone;
    private String email;
    private String paymentPreference;

    // Getters & Setters
    public String getGuestID() { return guestID; }
    public void setGuestID(String guestID) { this.guestID = guestID; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPaymentPreference() { return paymentPreference; }
    public void setPaymentPreference(String paymentPreference) {
        this.paymentPreference = paymentPreference;
    }
}
