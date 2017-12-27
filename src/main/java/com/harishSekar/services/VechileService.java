package com.harishSekar.services;

import com.harishSekar.Repository.VehicleRepositoryModel;
import com.harishSekar.entity.Vehicle;
import com.harishSekar.exceptions.BadRequestException;
import com.harishSekar.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Bussiness Logic
public class VechileService implements VehicleServiceModel {

    @Autowired
    VehicleRepositoryModel vehicleRepository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAllVehicles();
    }

    @Transactional(readOnly = true)
    public Vehicle findVehicleById(String vin) {
        Vehicle vehicle = vehicleRepository.findVehicleById(vin);

        if(vehicle == null){
            throw new ResourceNotFoundException("Vehicle with VIN: "+vin +" does't exist");
        }
        return vehicle;
    }

    @Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
        Vehicle vehicle_existing = vehicleRepository.findVehicleById(vehicle.getVin());
        if(vehicle_existing != null){
            throw new BadRequestException("Vehicle with VIM: "+ vehicle_existing.getVin()+" already exists");
        }

        return vehicleRepository.createVehicle(vehicle);
    }

    @Transactional
    public Vehicle updateVehicle(String vin, Vehicle vehicle) {
        Vehicle vehicle_existing = vehicleRepository.findVehicleById(vin);
        if(vehicle_existing == null){
            // throw 404
        }
        return vehicleRepository.updateVehicle(vehicle);
    }

    @Transactional
    public void deleteVehicle(String vin) {
        Vehicle vehicle_ = vehicleRepository.findVehicleById(vin);
        if(vehicle_ == null){
            // throw 400
        }
        vehicleRepository.deleteVehicle(vehicle_);
    }
}
