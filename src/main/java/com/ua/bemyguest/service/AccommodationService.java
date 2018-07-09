package com.ua.bemyguest.service;

import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.repository.impl.AccommodationDAOH2Impl;

public class AccommodationService {

    private AccommodationDAOH2Impl accommodationDAOH2;

    public AccommodationService() {
        accommodationDAOH2 = AccommodationDAOH2Impl.instance();
    }

    public void addAccommodation(Accommodation accommodation){
        accommodationDAOH2.addAccommodation(accommodation);
    }

    public void removeDriverById(int accommodationId){
        try {
            accommodationDAOH2.deleteAccommodation(accommodationId);
        } catch (DriverNotFoundException e) {
            e.printStackTrace();
        } catch (DriverIncorrectId driverIncorrectId) {
            driverIncorrectId.printStackTrace();
        }
    }

    public List<Driver> getAllDrivers() throws DuplicateDriverException {
        return driverDAOH2.getAllDrivers();
    }

    public Driver getDriverById(int carId) throws DriverIncorrectId {
        return driverDAOH2.getDriverById(carId);
    }

    public void updateDriver(Driver driver){
        driverDAOH2.updateDriver(driver);
    }

    public void removeAllDriver(){
        driverDAOH2.deleteAll();
    }

    public Driver findByLastName(String name){
        return driverDAOH2.findByLastName(name);
    }
}
