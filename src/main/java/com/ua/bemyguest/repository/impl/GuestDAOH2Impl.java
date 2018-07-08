package com.ua.bemyguest.repository.impl;

import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.GuestIncorrectId;
import com.ua.bemyguest.exception.GuestIncorrectLastName;
import com.ua.bemyguest.repository.GuestDAO;
import com.ua.bemyguest.model.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.bemyguest.repository.impl.ConnectionFactory.*;

public class GuestDAOH2Impl implements GuestDAO {

    private static final String ADD_GUEST = String.format("INSERT INTO guests(%s, %s, %s, %s, %s, %s, %s, %s) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)", Guest.FIRST_NAME, Guest.LAST_NAME, Guest.EMAIL, Guest.PHONE_NUMBER,
            Guest.COUNTRY, Guest.BIRTH_DATE, Guest.LOCALITY, Guest.PREFERRED_LANGUAGE);

    private static final String GET_ALL_GUESTS = "SELECT * FROM guests";

    private static final String FIND_ALL_SORTED_GUESTS = "SELECT * FROM guests ORDER BY last_name ASC";

    private static final String UPDATE_GUEST = String.format("UPDATE guests SET %s = ?, %s = ?, %s = ?, %s = ?, " +
            "%s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?", Guest.FIRST_NAME, Guest.LAST_NAME, Guest.EMAIL,
            Guest.PHONE_NUMBER, Guest.COUNTRY, Guest.BIRTH_DATE, Guest.LOCALITY, Guest.PREFERRED_LANGUAGE, Guest.ID);

    private static final String DELETE_GUEST_BY_ID = String.format("DELETE FROM guests WHERE %s=?", Guest.ID);

    private Connection connection;
    private PreparedStatement pst = null;
    private ResultSet rs;

    @Override
    public Guest findGuestById(int guestId) throws GuestIncorrectId{
        Guest guest = null;
        for (Guest guest1 : getAllGuests()) {
            if (guest1.getId() == guestId){
                guest = guest1;
            }
        }
        if (guest == null){
            throw new GuestIncorrectId();
        }
        return guest;
    }

    @Override
    public Guest findGuestByLastName(String guestLastName) throws GuestIncorrectLastName{
        Guest guest = null;
        for (Guest guest1 : getAllGuests()) {
            if (guest1.getLastName().equals(guestLastName)){
                guest = guest1;
            }
        }
        if (guest == null){
            throw new GuestIncorrectLastName();
        }
        return guest;
    }

    @Override
    public List<Guest> findAllSortedGuests() {
        List<Guest> sortedResult = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(FIND_ALL_SORTED_GUESTS);
            rs = pst.executeQuery();
            while (rs.next()){
                Guest guest = Guest.builder().build();
                guest.setId(rs.getInt(Guest.ID));
                guest.setFirstName(rs.getString(Guest.FIRST_NAME));
                guest.setLastName(rs.getString(Guest.LAST_NAME));
                guest.setEmail(rs.getString(Guest.EMAIL));
                guest.setPhoneNumber(rs.getString(Guest.PHONE_NUMBER));
                guest.setCountry(rs.getString(Guest.COUNTRY));
                guest.setBirthDate(rs.getDate(Guest.BIRTH_DATE).toLocalDate());
                guest.setLocality(rs.getString(Guest.LOCALITY));
                guest.setPreferredLanguage(rs.getString(Guest.PREFERRED_LANGUAGE));
                sortedResult.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return sortedResult;
    }

    @Override
    public void addGuest(Guest guest) throws DuplicateGuestException {
        for (Guest guest1 : getAllGuests()) {
            if (guest.getLastName().equals(guest1.getLastName())){
                throw new DuplicateGuestException();
            }
        }
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(ADD_GUEST);
            pst.setString(1, guest.getFirstName());
            pst.setString(2, guest.getLastName());
            pst.setString(3, guest.getEmail());
            pst.setString(4, guest.getPhoneNumber());
            pst.setString(5, guest.getCountry());
            pst.setObject(6, guest.getBirthDate());
            pst.setString(7, guest.getLocality());
            pst.setString(8, guest.getPreferredLanguage());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        List<Guest> result = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_ALL_GUESTS);
            rs = pst.executeQuery();
            while (rs.next()){
                Guest guest = Guest.builder().build();
                guest.setId(rs.getInt(Guest.ID));
                guest.setFirstName(rs.getString(Guest.FIRST_NAME));
                guest.setLastName(rs.getString(Guest.LAST_NAME));
                guest.setEmail(rs.getString(Guest.EMAIL));
                guest.setPhoneNumber(rs.getString(Guest.PHONE_NUMBER));
                guest.setCountry(rs.getString(Guest.COUNTRY));
                guest.setBirthDate(rs.getDate(Guest.BIRTH_DATE).toLocalDate());
                guest.setLocality(rs.getString(Guest.LOCALITY));
                guest.setPreferredLanguage(rs.getString(Guest.PREFERRED_LANGUAGE));
                result.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
        return result;
    }

    @Override
    public void updateGuest(Guest guest) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_GUEST);
            pst.setString(1, guest.getFirstName());
            pst.setString(2, guest.getLastName());
            pst.setString(3, guest.getEmail());
            pst.setString(4, guest.getPhoneNumber());
            pst.setString(5, guest.getCountry());
            pst.setObject(6, guest.getBirthDate());
            pst.setString(7, guest.getLocality());
            pst.setString(8, guest.getPreferredLanguage());
            pst.setInt(9, guest.getId());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteGuestById(int guestId) throws GuestIncorrectId {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_GUEST_BY_ID);
            pst.setInt(1, guestId);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new GuestIncorrectId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }
}
