package com.harishSekar.controller;


import com.harishSekar.entity.Vehicle;
import com.harishSekar.services.VehicleServiceModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@Controller    -> same as @Component                          ]
//@ResponseBody  -> convert the O/P into JSON obj using jackson ] ---> @RestController

//@CrossOrigin(origins = "http://mocker.egen.io/")
@RestController
@RequestMapping(value = "/vehicles")   // 'path' variable can be used instead of 'value'
public class VehicleController {

    @Autowired
    VehicleServiceModel vehicleServiceModel;



    private static  Logger logger = Logger.getLogger(VehicleController.class);



    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAllVehicles(){
        return vehicleServiceModel.findAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/vin={vehicleVin}",
            produces = "application/json")
    public Vehicle findVehicleById(@PathVariable("vehicleVin") String vin){
        return vehicleServiceModel.findVehicleById(vin);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){

            return vehicleServiceModel.createVehicle(vehicle);


    }

    @RequestMapping(method = RequestMethod.PUT,value = "/updateVin={vehicleVin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle updateVehicle(@PathVariable("vehicleVin") String vin, @RequestBody Vehicle vehicle){
        return vehicleServiceModel.updateVehicle(vin,vehicle);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delVin={vehicleVin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteVehicle(@PathVariable("vehicleVin") String vin){
        vehicleServiceModel.deleteVehicle(vin);

    }


}
