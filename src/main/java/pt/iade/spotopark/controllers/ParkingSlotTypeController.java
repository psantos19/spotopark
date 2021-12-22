package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.parkingSlotType;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.ParkingSlotTypeRepository;

@RestController
@RequestMapping(path = "/api/parking_slot_type")
public class ParkingSlotTypeController {
    private final Logger logger = LoggerFactory.getLogger(ParkingSlotTypeRepository.class);

    @Autowired
    private ParkingSlotTypeRepository parking_slot_typeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<parkingSlotType> getUsers() {
        logger.info("Sending all parking_slot_types!");
        return parking_slot_typeRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public parkingSlotType getParking_slot_type(@PathVariable int id_parking_slot_type) {
        logger.info("Sending parking_slot_type with id " + id_parking_slot_type);
        Optional<parkingSlotType> parking_slot_type1 = parking_slot_typeRepository.findById(id_parking_slot_type);
        if (!parking_slot_type1.isPresent())
            throw new NotFoundException("" + id_parking_slot_type, "Parking_slot_type", "id");
        else
            return parking_slot_type1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public parkingSlotType saveParking_slot_type(@RequestBody parkingSlotType parking_slot_type) {
        parkingSlotType savedParking_slot_type = parking_slot_typeRepository.save(parking_slot_type);
        logger.info("Saving parking_slot_type with id " + savedParking_slot_type.getTypeId());
        return savedParking_slot_type;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteParking_slot_type(@PathVariable int id_parking_slot_type) {
        logger.info("Deleting parking_slot_type with id " + id_parking_slot_type);
        Optional<parkingSlotType> parking_slot_type1 = parking_slot_typeRepository.findById(id_parking_slot_type);
        if (!parking_slot_type1.isPresent())
            throw new NotFoundException("" + id_parking_slot_type, "Parking_slot_type", "id");
        else
            parking_slot_typeRepository.deleteById(id_parking_slot_type);
        return new Response("Deleted parking_slot_type with id " + id_parking_slot_type, null);
    }

    @GetMapping(path = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<parkingSlotType> getParkType() {
        return parking_slot_typeRepository.getParkType();
    }
}
