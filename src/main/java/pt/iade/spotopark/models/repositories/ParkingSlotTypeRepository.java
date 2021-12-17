package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parkingSlotType;


public interface ParkingSlotTypeRepository extends CrudRepository <parkingSlotType, Integer> {

        // Ver quantos lugares existem de um certo tipo
        // https://spotopark-projeto.herokuapp.com/api/parking_slot_type/type
    String resQuery3 = "SELECT type_name, count(*) " + "from parking_slot, parking_slot_type "
            + "where parking_type_id = type_id " 
            + "group by type_name";

    @Query(value = resQuery3, nativeQuery = true)
    Iterable<String> getParkType();
}

