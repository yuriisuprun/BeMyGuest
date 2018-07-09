package com.ua.bemyguest.repository.impl;

import com.ua.bemyguest.exception.GuestDetailIncorrectId;
import com.ua.bemyguest.model.GuestDetail;
import com.ua.bemyguest.repository.GuestDetailDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ua.bemyguest.repository.impl.ConnectionFactory.*;

public class GuestDetailDAOH2Impl implements GuestDetailDAO {

    private static final String ADD_GUEST_DETAIL = String.format("INSERT INTO guest_details(%s) " +
            "VALUES(?)", GuestDetail.REVIEW);

    private static final String GET_ALL_GUEST_DETAILS = "SELECT * FROM guest_details";

    private static final String FIND_ALL_SORTED_GUEST_DETAILS = "SELECT * FROM guest_details ORDER BY id ASC";

    private static final String UPDATE_BOOKING = String.format("UPDATE bookings SET %s = ? WHERE %s = ?",
            GuestDetail.REVIEW, GuestDetail.ID);

    private static final String DELETE_GUEST_DETAIL_BY_ID = String.format("DELETE FROM guest_details WHERE %s = ?", GuestDetail.ID);

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    private static GuestDetailDAOH2Impl instance;

    public static GuestDetailDAOH2Impl instance() {
        if (instance == null) {
            instance = new GuestDetailDAOH2Impl();
        }
        return instance;
    }

    @Override
    public GuestDetail findGuestDetailById(int guestDetailId) throws GuestDetailIncorrectId {
        GuestDetail guestDetail = null;
        for (GuestDetail guestDetail1 : getAllGuestDetails()) {
            if (guestDetail1.getGuestId() == guestDetailId) {
                guestDetail = guestDetail1;
            }
        }
        if (guestDetail == null) {
            throw new GuestDetailIncorrectId();
        }
        return guestDetail;
    }

    @Override
    public List<GuestDetail> findAllSortedGuestDetails() {
        List<GuestDetail> sortedResult = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(FIND_ALL_SORTED_GUEST_DETAILS);
            rs = pst.executeQuery();
            while (rs.next()) {
                GuestDetail guestDetail = new GuestDetail();
                guestDetail.setId(rs.getInt(GuestDetail.ID));
                guestDetail.setReview(rs.getString(GuestDetail.REVIEW));
                sortedResult.add(guestDetail);
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
    public void addGuestDetail(GuestDetail guestDetail) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(ADD_GUEST_DETAIL);
            pst.setString(1, guestDetail.getReview());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<GuestDetail> getAllGuestDetails() {
        List<GuestDetail> result = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(GET_ALL_GUEST_DETAILS);
            rs = pst.executeQuery();
            while (rs.next()) {
                GuestDetail guestDetail = new GuestDetail();
                guestDetail.setId(rs.getInt(GuestDetail.ID));
                guestDetail.setReview(rs.getString(GuestDetail.REVIEW));
                result.add(guestDetail);
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
    public void updateGuestDetail(GuestDetail guestDetail) {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(UPDATE_BOOKING);
            pst.setString(1, guestDetail.getReview());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public void deleteGuestDetailById(int guestDetailId) throws GuestDetailIncorrectId {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_GUEST_DETAIL_BY_ID);
            pst.setInt(1, guestDetailId);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new GuestDetailIncorrectId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }
}
