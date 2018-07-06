package com.ua.bemyguest.repository.impl;

import com.ua.bemyguest.model.AccommodationType;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.repository.AccommodationDAO;
import com.ua.bemyguest.model.Accommodation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.bemyguest.repository.impl.ConnectionFactory.*;

public class AccommodationDAOH2Impl implements AccommodationDAO {

    private static final String ADD_ACCOMMODATION = String.format("INSERT INTO accommodations(%s, %s, %s, %s, %s, %s, %s, %s) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?);", Accommodation.TITLE, Accommodation.LOCALITY,
            Accommodation.COUNTRY, Accommodation.ADDRESS, Accommodation.HOST, Accommodation.ACCOMMODATION_TYPE,
            Accommodation.DESCRIPTION, Accommodation.PRICE);

    private static final String GET_ALL_ACCOMMODATIONS = "SELECT * FROM accommodations";

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs;

    public AccommodationDAOH2Impl(){

    }

    @Override
    public Accommodation findAccommodationById(int accommodationId) {
        return null;
    }

    @Override
    public Accommodation findAccommodationByName(String accommodationName) {
        return null;
    }

    @Override
    public void findSorted() {

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
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_ACCOMMODATIONS);

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
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
        return result;
    }

    @Override
    public void updateAccommodation(Accommodation accommodation) {

    }

    @Override
    public void deleteAccommodation(int accommodationId) {

    }
}
