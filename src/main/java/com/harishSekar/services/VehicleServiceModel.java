package com.harishSekar.services;

import com.harishSekar.entity.Vehicle;

import java.util.List;

public interface VehicleServiceModel {


     List<Vehicle> findAllVehicles();

     Vehicle findVehicleById(String vim);

     Vehicle createVehicle(Vehicle vehicle);

     Vehicle updateVehicle(String vim,Vehicle vehicle);

     void deleteVehicle(String vim);


}
