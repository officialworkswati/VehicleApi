package com.demo.vehicle.service;

import com.demo.vehicle.model.Vehicle;
import com.demo.vehicle.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    Logger logger = LoggerFactory.getLogger(VehicleService.class);


    @Async("asyncExecutor")
    public void createVehicle(Vehicle vehicle) throws Exception {
        // TODO Auto-generated method stub
        logger.info("Vehicle ID: {}", vehicle.getVin());
        vehicleRepository.save(vehicle);
        Thread.sleep(1000L);
        logger.info("Vehicle Post Data: {}", vehicle.toString());
    }
//    public List<Vehicle> getAllVehicles()
//    {
//        return  vehicleRepository.findAll();
//    }
}
