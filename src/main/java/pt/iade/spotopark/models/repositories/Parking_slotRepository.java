package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parking_slot;


public interface Parking_slotRepository extends CrudRepository <parking_slot, Integer> {
    String resQuery1 = "SELECT type_name, count(*)"
    + "from parking_slot, parking_slot_type" +
    "where parking_type_id = type_id" + 
    "group by type_name";

    @Query(value=resQuery1, nativeQuery=true)
    Iterable<String>getTypeNum();
}
