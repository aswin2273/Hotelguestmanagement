package com.hotel.dao;

import com.hotel.bean.Stay;
import com.hotel.util.DBUtil;

import java.sql.*;

public class StayDAO {

    public int generateStayID() throws Exception {

        Connection conn = DBUtil.getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT NVL(MAX(stay_id),60000)+1 FROM STAY_TBL");

        if (rs.next())
            return rs.getInt(1);

        return 60001;
    }

    public boolean recordCheckIn(Stay stay) throws Exception {

        Connection conn = DBUtil.getDBConnection();

        String sql = "INSERT INTO STAY_TBL VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, stay.getStayID());
        ps.setString(2, stay.getGuestID());
        ps.setString(3, stay.getRoomNumber());
        ps.setDate(4, new java.sql.Date(stay.getCheckInDate().getTime()));
        ps.setDate(5, null);
        ps.setDouble(6, stay.getRoomRate());
        ps.setDouble(7, stay.getExtras());
        ps.setString(8, stay.getStatus());

        int rows = ps.executeUpdate();
        conn.commit();

        return rows > 0;
    }

    public boolean closeStay(int stayID, double extras, java.util.Date checkOutDate) throws Exception {

        Connection conn = DBUtil.getDBConnection();

        String sql = "UPDATE STAY_TBL SET check_out_date=?, extras=?, status='CLOSED' WHERE stay_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDate(1, new java.sql.Date(checkOutDate.getTime()));
        ps.setDouble(2, extras);
        ps.setInt(3, stayID);

        int rows = ps.executeUpdate();
        conn.commit();

        return rows > 0;
    }

    public boolean isRoomOccupied(String roomNumber) throws Exception {

        Connection conn = DBUtil.getDBConnection();

        String sql = "SELECT * FROM STAY_TBL WHERE room_number=? AND status='ACTIVE'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, roomNumber);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
}
