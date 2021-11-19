package pt.iade.spotopark.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parkingSlotType;


public interface ParkingSlotTypeRepository extends CrudRepository <parkingSlotType, Integer> {
    
}

