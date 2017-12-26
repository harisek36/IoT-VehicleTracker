package com.harishSekar.Repository;

import com.harishSekar.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VehicleRepository implements VehicleRepositoryModel {


    public List<Vehicle> findAllVehicles() {
        Vehicle vehicle1 =  new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        return Arrays.asList(vehicle1,vehicle2);

    }

    public Vehicle findVehicleById(String vin) {
        return null;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return null;
    }

    public Vehicle updateVehicle(String vin, Vehicle vehicle) {
        return null;
    }

    public void deleteVehicle(String vin) {

    }
}
