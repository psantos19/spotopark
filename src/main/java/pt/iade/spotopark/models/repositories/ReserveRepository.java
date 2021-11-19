package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.reserve;

public interface ReserveRepository extends CrudRepository <reserve, Integer> {
    String resQuery1 = "select reserve_id , park_id, park_address"
    + "from reserve , parking_slot , parking" +
    "where reserve_parking_slot_id = parking_slot_id and park_id = parking_park_id"; 

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getResPark();
}
