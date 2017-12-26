package com.harishSekar.controller;


import com.harishSekar.entity.Vehicle;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
//@Controller    -> same as @Component                          ]
//@ResponseBody  -> convert the O/P into JSON obj using jackson ] ---> @RestController

@RestController
@RequestMapping(value = "/vehicles")   // 'path' variable can be used instead of 'value'
public class VehicleController {

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAllVehicles(){
        return null;
    }

    @RequestMapping(method = RequestMethod.GET,value = "?"+"vim={vehicleVim}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String findVehicleById(@PathVariable("vehicleVim") String vim){
        return "Vehicle by Id" + vim;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "?updatevim={vehicleVim}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle updateVehicle(@PathVariable("vehicleVim") String vim, @RequestBody Vehicle vehicle){
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "?delvim={vehicleVim}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteVehicle(@PathVariable("vehicleVim") String vim){

    }


}
