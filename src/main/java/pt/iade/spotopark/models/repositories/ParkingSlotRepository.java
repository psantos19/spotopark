package pt.iade.spotopark.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parkingSlot;

public interface ParkingSlotRepository extends CrudRepository<parkingSlot, Integer> {

}
