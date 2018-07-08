package com.ua.bemyguest.service;

import com.ua.bemyguest.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ua.bemyguest.repository.impl.ConnectionFactory.getInstance;

public class Init {

    private Connection connection;
    private Statement stmt = null;

    public Init(){
        createTablesIfNotExist();
    }

    private static final String CREATE_HOSTS_TABLE = "CREATE TABLE IF NOT EXISTS hosts (" +
            Host.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            Host.FIRST_NAME + " VARCHAR(255)," +
            Host.LAST_NAME + " VARCHAR(255) UNIQUE," +
            Host.EMAIL + " VARCHAR(255)," +
            Host.PHONE_NUMBER + " VARCHAR(255)," +
            Host.COUNTRY + " VARCHAR(255)," +
            Host.BIRTH_DATE + " DATE," +
            Host.LOCALITY + " VARCHAR(255)," +
            Host.JOIN_DATE + " DATE," +
            Host.WORK + " VARCHAR(255)" +
            ");";

    private static final String CREATE_ACCOMMODATIONS_TABLE = "CREATE TABLE IF NOT EXISTS accommodations (" +
            Accommodation.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            Accommodation.TITLE + " VARCHAR(255) UNIQUE," +
            Accommodation.LOCALITY + " VARCHAR(255)," +
            Accommodation.COUNTRY + " VARCHAR(255)," +
            Accommodation.ADDRESS + " VARCHAR(255)," +
            Accommodation.HOST + " VARCHAR(255)," +
            Accommodation.ACCOMMODATION_TYPE + " VARCHAR(255)," +
            Accommodation.DESCRIPTION + " VARCHAR(255)," +
            Accommodation.PRICE + " VARCHAR(255)," +
            Accommodation.HOST_ID + " INT(11) REFERENCES hosts(id)" +
            ");";

    private static final String CREATE_GUESTS_TABLE = "CREATE TABLE IF NOT EXISTS guests (" +
            Guest.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            Guest.FIRST_NAME + " VARCHAR(255) ," +
            Guest.LAST_NAME + " VARCHAR(255) UNIQUE," +
            Guest.EMAIL + " VARCHAR(255)," +
            Guest.PHONE_NUMBER + " VARCHAR(255)," +
            Guest.COUNTRY + " VARCHAR(255)," +
            Guest.BIRTH_DATE + " DATE DEFAULT (GETDATE())," +
            Guest.LOCALITY + " VARCHAR(255)," +
            Guest.PREFERRED_LANGUAGE + " VARCHAR(255)" +
            ");";

    private static final String CREATE_GUEST_DETAILS_TABLE = "CREATE TABLE IF NOT EXISTS guest_details (" +
            GuestDetail.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            GuestDetail.REVIEW + " VARCHAR(255)," +
            GuestDetail.GUEST_ID + " INT(11) REFERENCES guests(id)" +
            ");";

    private static final String CREATE_BOOKINGS_TABLE = "CREATE TABLE IF NOT EXISTS bookings (" +
            Booking.ID + " INT(11) PRIMARY KEY AUTO_INCREMENT," +
            Booking.START_DATE + " DATE," +
            Booking.END_DATE + " DATE," +
            Booking.ACCOMMODATION_ID + " INT(11) REFERENCES accommodations(id)," +
            Booking.GUEST_ID + " INT(11) REFERENCES guests(id)" +
            ");";

    private void createTablesIfNotExist() {
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_HOSTS_TABLE);
            stmt.executeUpdate(CREATE_ACCOMMODATIONS_TABLE);
            stmt.executeUpdate(CREATE_GUESTS_TABLE);
            stmt.executeUpdate(CREATE_BOOKINGS_TABLE);
            stmt.executeUpdate(CREATE_GUEST_DETAILS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closeStatement(stmt);
            getInstance().closeConnection(connection);
        }
    }
}
