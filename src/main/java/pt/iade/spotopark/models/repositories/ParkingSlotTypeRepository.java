package pt.iade.spotopark.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.parkingSlotType;

public interface ParkingSlotTypeRepository extends CrudRepository<parkingSlotType, Integer> {

    // Ver quantos lugares existem de um certo tipo
    // https://spotopark-projeto.herokuapp.com/api/parking_slot_type/type
    String resQuery3 = "SELECT type_name, count(*) "
            + "from parking_slot, parking_slot_type "
            + "where parking_type_id = type_id";

    @Query(value = "select type_name, count(*) from parking_slot, parking_slot_type where parking_type_id = type_id", nativeQuery = true)
    Iterable<parkingSlotType> getParkType();

    String resQuery4 = "SELECT * from parking_slot where parking_type_id = :id";

    @Query(value = resQuery4, nativeQuery = true)
    Iterable<parkingSlotType> getSpotTypes(int id);
}
