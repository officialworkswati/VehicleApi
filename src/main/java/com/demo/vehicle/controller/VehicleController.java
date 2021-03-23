package com.demo.vehicle.controller;

import com.demo.vehicle.exception.ErrorInResource;
import com.demo.vehicle.exception.InvalidPayload;
import com.demo.vehicle.model.Vehicle;
import com.demo.vehicle.repository.VehicleRepository;
import com.demo.vehicle.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VehicleController {
    Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    VehicleService vehicleService;
    @PostMapping("/vehicle-api/v1/vehicles/vehicle")
    public String saveVehicle(@Valid @RequestBody Vehicle vehicle)throws Exception
    {
        logger.info(vehicle.toString());
        if (vehicle.getVin() == null || vehicle.getMake() == null || vehicle.getModel() == null || vehicle.getYear() == 0 || vehicle.getTransmissionType() == null) {
            throw new InvalidPayload(HttpStatus.INTERNAL_SERVER_ERROR, "null attribute is present ");
        } else if (!(vehicle.getTransmissionType().equals("MANUAL")) && !(vehicle.getTransmissionType().equals("AUTO"))) {
            throw new ErrorInResource(HttpStatus.BAD_REQUEST, "Transmission = MANUAL or AUTO");
        } else {
            System.out.println(vehicle.toString());
            vehicleService.createVehicle(vehicle);
            return vehicle.getVin();
        }

    }


//
//    @GetMapping("/allemp")
//    public List<Vehicle> getAllVehicles(){
//        return vehicleRepository.findAll();
//
//    }

}
