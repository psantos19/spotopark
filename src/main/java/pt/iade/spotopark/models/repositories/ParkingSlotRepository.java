package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parkingSlot;

public interface ParkingSlotRepository extends CrudRepository<parkingSlot, Integer> {
    // Ver quantos lugares existem de um certo tipo
    String resQuery3 = "SELECT type_name, count(*) " + "from parking_slot, parking_slot_type "
            + "where parking_type_id = type_id " 
            + "group by type_name";

    @Query(value = resQuery3, nativeQuery = true)
    Iterable<String> getTypeNum();
}
