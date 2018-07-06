package com.ua.bemyguest.repository.impl;

import com.ua.bemyguest.exception.DuplicateHostException;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.repository.HostDAO;
import com.ua.bemyguest.model.Host;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.ua.bemyguest.repository.impl.ConnectionFactory.*;

public class HostDAOH2Impl implements HostDAO {

    private static final String ADD_HOST = String.format("INSERT INTO hosts(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", Host.FIRST_NAME, Host.LAST_NAME, Host.EMAIL, Host.PHONE_NUMBER,
            Host.COUNTRY, Host.BIRTH_DATE, Host.LOCALITY, Host.ACCOMMODATIONS, Host.LANGUAGES, Host.JOIN_DATE, Host.WORK);

    private static final String GET_ALL_HOSTS = "SELECT * FROM hosts";

    private static final String DELETE_HOST_BY_ID = String.format("DELETE FROM hosts WHERE %s=?;", Host.ID);

    private Connection connection;
    private PreparedStatement pst = null;
    private Statement stmt = null;
    private ResultSet rs;

    public HostDAOH2Impl() {

    }

    @Override
    public Host findHostById(int hostId) {
        return null;
    }

    @Override
    public Host findHostByLastName(String hostLastName) {
        return null;
    }

    @Override
    public void findSorted() {

    }

    @Override
    public void addHost(Host host) throws DuplicateHostException {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(ADD_HOST);
            pst.setString(1, host.getFirstName());
            pst.setString(2, host.getLastName());
            pst.setString(3, host.getEmail());
            pst.setString(4, host.getPhoneNumber());
            pst.setString(5, host.getCountry());
            pst.setDate(6, Date.valueOf(host.getBirthDate()));
            pst.setString(7, host.getLocality());
            /*accommodations
            languages*/
            pst.setDate(8, Date.valueOf(host.getJoinDate()));
            pst.setString(9, host.getWork());
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }

    @Override
    public List<Host> getAllHosts() {
        List<Host> result = new ArrayList<>();
        try {
            connection = getInstance().getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_HOSTS);
            while (rs.next()) {
                Host host = Host.newBuilder().build();
                host.setId(rs.getInt(Host.ID));
                host.setFirstName(rs.getString(Host.FIRST_NAME));
                host.setLastName(rs.getString(Host.LAST_NAME));
                host.setEmail(rs.getString(Host.EMAIL));
                host.setPhoneNumber(rs.getString(Host.PHONE_NUMBER));
                host.setCountry(rs.getString(Host.COUNTRY));
                host.setBirthDate(rs.getDate(Host.BIRTH_DATE).toLocalDate());
                host.setLocality(rs.getString(Host.LOCALITY));
                host.setJoinDate(rs.getDate(Host.JOIN_DATE).toLocalDate());
                host.setWork(rs.getString(Host.WORK));
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
    public void updateHost(Host host) {

    }

    @Override
    public void deleteHostById(int hostId) throws HostIncorrectId {
        try {
            connection = getInstance().getConnection();
            pst = connection.prepareStatement(DELETE_HOST_BY_ID);
            pst.setInt(1, hostId);
            int result = pst.executeUpdate();
            if (result == 0) {
                throw new HostIncorrectId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getInstance().closePreparedStatement(pst);
            getInstance().closeConnection(connection);
        }
    }
}
