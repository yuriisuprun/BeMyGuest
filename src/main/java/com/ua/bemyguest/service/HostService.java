package com.ua.bemyguest.service;

import com.ua.bemyguest.exception.DuplicateHostException;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.exception.HostIncorrectLastName;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.repository.impl.HostDAOH2Impl;

import java.util.List;

public class HostService {

    private HostDAOH2Impl hostDAOH2;

    public HostService() {
        hostDAOH2 = HostDAOH2Impl.instance();
    }

    public Host findHostById(int hostId)throws HostIncorrectId{
        return hostDAOH2.findHostById(hostId);
    }

    public Host findHostByLastName(String hostLastName) throws HostIncorrectLastName{
        return hostDAOH2.findHostByLastName(hostLastName);
    }

    public List<Host> findSortedHosts(){
        return hostDAOH2.findSortedHosts();
    }

    public void addHost(Host host) throws DuplicateHostException{
        hostDAOH2.addHost(host);
    }

    public List<Host> getAllHosts(){
        return hostDAOH2.getAllHosts();
    }

    public void updateHost(Host host){
        hostDAOH2.updateHost(host);
    }

    public void deleteHostById(int hostId) throws HostIncorrectId{
        hostDAOH2.deleteHostById(hostId);
    }

    public void printHosts(List<Host> hosts){
        for (Host host : getAllHosts()) {
            System.out.println(host);
        }
    }
}
