package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parkingSlot;

public interface ParkingSlotRepository extends CrudRepository<parkingSlot, Integer> {

    @Query(value = "select * from parking_slot where parking_type_id = :id", nativeQuery = true)
    Iterable<parkingSlot> getParkSpots(int id);

    @Query(value = "select * from parking_slot where parking_type_id = :id and parking_park_id = 1", nativeQuery = true)
    Iterable<parkingSlot> getSpotTypes1(int id);

    @Query(value = "select * from parking_slot where parking_type_id = :id and parking_park_id = 2", nativeQuery = true)
    Iterable<parkingSlot> getSpotTypes2(int id);


}
