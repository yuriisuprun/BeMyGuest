package com.ua.bemyguest.repository.impl;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.AccommodationIncorrectTitle;
import com.ua.bemyguest.model.AccommodationType;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.repository.AccommodationDAO;
import com.ua.bemyguest.model.Accommodation;
import sun.plugin.javascript.navig.Array;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.bemyguest.repository.impl.ConnectionFactory.*;

public class AccommodationDAOH2Impl implements AccommodationDAO {

    private static final String ADD_ACCOMMODATION = String.format("INSERT INTO accommodations(%s, %s, %s, %s, %s, %s, %s, %s) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?);", Accommodation.TITLE, Accommodation.LOCALITY,
            Accommodation.COUNTRY, Accommodation.ADDRESS, Accommodation.HOST, Accommodation.ACCOMMODATION_TYPE,
            Accommodation.DESCRIPTION, Accommodation.PRICE);

    private static final String FIND_ALL_SORTED_ACCOMMODATIONS = "SELECT * FROM accommodations ORDER BY title ASC";

    private static final String GET_ALL_ACCOMMODATIONS = "SELECT * FROM accommodations";

    private static final String UPDATE_ACCOMMODATION = String.format("UPDATE accommodations SET %s = ?, %s = ?, %s = ?, " +
                    "%s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?", Accommodation.TITLE, Accommodation.LOCALITY,
            Accommodation.COUNTRY, Accommodation.ADDRESS, Accommodation.HOST, Accommodation.ACCOMMODATION_TYPE,
            Accommodation.DESCRIPTION, Accommodation.PRICE, Accommodation.ID);

    private static final String DELETE_ACCOMMODATION_BY_ID = String.format("DELETE FROM accommodations WHERE %s=?;", Accommodation.ID);

    private Connection connection;
    private PreparedStatement pst = null;
    private ResultSet rs;

    private static AccommodationDAOH2Impl instance;

    public static AccommodationDAOH2Impl instance() {
        if (instance == null) {
            instance = new AccommodationDAOH2Impl();
        }
        return instance;
    }

    @Override
    public Accommodation findAccommodationById(int accommodationId) throws AccommodationIncorrectId {
        Accommodation accommodation = null;
        for (Accommodation accommodation1 : getAllAccommodations()) {
            if (accommodation1.getId() == accommodationId) {
                accommodation = accommodation1;
            }
        }
        if (accommodation == null) {
            throw new AccommodationIncorrectId();
        }
        return accommodation;
    }

    @Override
    public Accommodation findAccommodationByTitle(String accommodationTitle) throws AccommodationIncorrectTitle {
        Accommodation accommodation = null;
        for (Accommodation accommodation1 : getAllAccommodations()) {
            if (accommodation1.getTitle().equals(accommodationTitle)) {
                accommodation = accommodation1;
            }
        }
        if (accommodation == null) {
            throw new AccommodationIncorrectTitle();
        }
        return accommodation;
    }

    @Override
    public List<Accommodation> findSortedAccommodations() {
        List<Accommodation> sortedResult = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(FIND_ALL_SORTED_ACCOMMODATIONS);
            rs = pst.executeQuery();
            while (rs.next()) {
                Accommodation accommodation = Accommodation.newBuilder().build();
                accommodation.setId(rs.getInt(Host.ID));
                accommodation.setTitle(rs.getString(Accommodation.TITLE));
                accommodation.setLocality(rs.getString(Accommodation.LOCALITY));
                accommodation.setCountry(rs.getString(Accommodation.COUNTRY));
                accommodation.setAddress(rs.getString(Accommodation.ADDRESS));
                accommodation.setHost((Host) rs.getObject(Accommodation.HOST));
                accommodation.setAccommodationType(AccommodationType.valueOf(rs.getString(Accommodation.ACCOMMODATION_TYPE)));
                accommodation.setDescription(rs.getString(Accommodation.DESCRIPTION));
                accommodation.setPrice(rs.getDouble(Accommodation.PRICE));
                sortedResult.add(accommodation);
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
    public void addAccommodation(Accommodation accommodation) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(ADD_ACCOMMODATION);
            pst.setString(1, accommodation.getTitle());
            pst.setString(2, accommodation.getLocality());
            pst.setString(3, accommodation.getCountry());
            pst.setString(4, accommodation.getAddress());
            pst.setObject(5, accommodation.getHost());
            pst.setString(6, String.valueOf(accommodation.getAccommodationType()));
            pst.setString(7, accommodation.getDescription());
            pst.setDouble(8, accommodation.getPrice());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Accommodation> getAllAccommodations() {
        List<Accommodation> result = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_ALL_ACCOMMODATIONS);
            rs = pst.executeQuery();
            while (rs.next()) {
                Accommodation accommodation = new Accommodation();
                accommodation.setId(rs.getInt(Accommodation.ID));
                accommodation.setTitle(rs.getString(Accommodation.TITLE));
                accommodation.setLocality(rs.getString(Accommodation.LOCALITY));
                accommodation.setCountry(rs.getString(Accommodation.COUNTRY));
                accommodation.setAddress(rs.getString(Accommodation.ADDRESS));
                accommodation.setHost((Host) rs.getObject(Accommodation.HOST));
                accommodation.setAccommodationType(AccommodationType
                        .valueOf(rs.getString(Accommodation.ACCOMMODATION_TYPE)));
                accommodation.setDescription(rs.getString(Accommodation.DESCRIPTION));
                accommodation.setPrice(rs.getDouble(Accommodation.PRICE));
                result.add(accommodation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeResultSet(rs);
            getInstance().closeStatement(pst);
            getInstance().closeConnection(connection);
        }
        return result;
    }

    @Override
    public void updateAccommodation(Accommodation accommodation) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_ACCOMMODATION);
            pst.setString(1, accommodation.getTitle());
            pst.setString(2, accommodation.getLocality());
            pst.setString(3, accommodation.getCountry());
            pst.setString(4, accommodation.getAddress());
            pst.setObject(5, accommodation.getHost());
            pst.setObject(6, accommodation.getAccommodationType());
            pst.setString(7, accommodation.getDescription());
            pst.setObject(8, accommodation.getPrice());
            pst.setInt(9, accommodation.getId());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteAccommodation(int accommodationId) throws AccommodationIncorrectId{
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_ACCOMMODATION_BY_ID);
            pst.setInt(1, accommodationId);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new AccommodationIncorrectId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }
}
