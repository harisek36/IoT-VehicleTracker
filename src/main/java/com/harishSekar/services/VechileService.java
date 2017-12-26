package com.harishSekar.services;

import com.harishSekar.Repository.VehicleRepositoryModel;
import com.harishSekar.entity.Vehicle;
import com.harishSekar.exceptions.BadRequestException;
import com.harishSekar.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Bussiness Logic
public class VechileService implements VehicleServiceModel {

    @Autowired
    VehicleRepositoryModel vehicleRepository;

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAllVehicles();
    }

    public Vehicle findVehicleById(String vin) {
        Vehicle vehicle = vehicleRepository.findVehicleById(vin);

        if(vehicle == null){
            throw new ResourceNotFoundException("Vehicle with VIN: "+vin +" does't exist");
        }
        return vehicle;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        Vehicle vehicle_ = vehicleRepository.findVehicleById(vehicle.getVin());
        if(vehicle_ != null){
            throw new BadRequestException("Vehicle with VIM: "+ vehicle_.getVin()+" already exists");
        }

        return vehicleRepository.createVehicle(vehicle);
    }

    public Vehicle updateVehicle(String vin, Vehicle vehicle) {
        Vehicle vehicle_ = vehicleRepository.findVehicleById(vin);
        if(vehicle_ == null){
            // throw 404
        }
        return vehicleRepository.updateVehicle(vin,vehicle);
    }

    public void deleteVehicle(String vin) {
        Vehicle vehicle_ = vehicleRepository.findVehicleById(vin);
        if(vehicle_ == null){
            // throw 400
        }
        vehicleRepository.deleteVehicle(vin);
    }
}
