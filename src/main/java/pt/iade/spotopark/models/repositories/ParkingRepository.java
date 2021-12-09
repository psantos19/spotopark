package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parking;


public interface ParkingRepository extends CrudRepository <parking, Integer> {
    // ver quantos lugares tem um parque
    // https://spotopark-projeto.herokuapp.com/api/parking/parking_slot
    String resQuery1 = "select park_address , count(*) "
    + "from parking , parking_slot " +
    "where park_id = parking_park_id " + 
    "group by park_address"; 

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getParkSpots();
}