package com.hotel.util;

public class NoAvailableRoomException extends Exception {
    public NoAvailableRoomException(String msg){
        super(msg);
    }
}
