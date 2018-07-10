package com.ua.bemyguest.repository;

import com.ua.bemyguest.exception.DuplicateHostException;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.exception.HostIncorrectLastName;
import com.ua.bemyguest.model.Host;

import java.util.List;

public interface HostDAO {

    Host findHostById(int hostId)throws HostIncorrectId;

    Host findHostByLastName(String hostLastName) throws HostIncorrectLastName;

    List<Host> findSortedHosts();

    void addHost(Host host) throws DuplicateHostException;

    List<Host> getAllHosts();

    void updateHost(Host host);

    void deleteHostById(int hostId) throws HostIncorrectId;
}
