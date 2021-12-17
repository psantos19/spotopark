package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parking;


public interface ParkingRepository extends CrudRepository <parking, Integer> {
    
}