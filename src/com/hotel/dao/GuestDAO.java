package com.hotel.dao;

import com.hotel.bean.Guest;
import com.hotel.util.DBUtil;

import java.sql.*;
import java.util.*;

public class GuestDAO {

    public Guest findGuest(String guestID) {
        Guest guest = null;

        try (Connection conn = DBUtil.getDBConnection()) {

            String sql = "SELECT * FROM GUEST_TBL WHERE guest_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, guestID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                guest = new Guest();
                guest.setGuestID(rs.getString(1));
                guest.setFullName(rs.getString(2));
                guest.setPhone(rs.getString(3));
                guest.setEmail(rs.getString(4));
                guest.setPaymentPreference(rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return guest;
    }

    public List<Guest> viewAllGuests() {

        List<Guest> list = new ArrayList<>();

        try (Connection conn = DBUtil.getDBConnection()) {

            String sql = "SELECT * FROM GUEST_TBL";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                Guest g = new Guest();
                g.setGuestID(rs.getString(1));
                g.setFullName(rs.getString(2));
                g.setPhone(rs.getString(3));
                g.setEmail(rs.getString(4));
                g.setPaymentPreference(rs.getString(5));
                list.add(g);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean insertGuest(Guest guest) {

        try (Connection conn = DBUtil.getDBConnection()) {

            String sql = "INSERT INTO GUEST_TBL VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, guest.getGuestID());
            ps.setString(2, guest.getFullName());
            ps.setString(3, guest.getPhone());
            ps.setString(4, guest.getEmail());
            ps.setString(5, guest.getPaymentPreference());

            int rows = ps.executeUpdate();
            conn.commit();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteGuest(String guestID) {

        try (Connection conn = DBUtil.getDBConnection()) {

            String sql = "DELETE FROM GUEST_TBL WHERE guest_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, guestID);

            int rows = ps.executeUpdate();
            conn.commit();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
