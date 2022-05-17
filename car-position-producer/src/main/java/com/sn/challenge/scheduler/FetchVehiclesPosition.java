package com.sn.challenge.scheduler;

import com.sn.challenge.producer.VehicleEventProducer;
import com.sn.challenge.model.Vehicle;
import com.sn.challenge.service.VehiclesService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Ehsan Sh
 */
@Data
@AllArgsConstructor
@Slf4j
@Component
public class FetchVehiclesPosition {
    private final VehiclesService vehiclesService;
    private final VehicleEventProducer vehicleEventProducer;


    @Scheduled(fixedDelay =30000 )
    public Vehicle[] fetchCarData(){
        log.info("Fetching Vehicles Data .......");
        Vehicle[] vehicles = vehiclesService.getVehicleInfo();
        for (Vehicle vehicle : vehicles){
            log.info("Vehicle with vim:{} sent as event",vehicle.getVin());
            vehicleEventProducer.sendVehicleEvents(vehicle);
        }
        return vehicles;
    }



}   
