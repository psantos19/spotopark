package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.parking_slot_type;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.Parking_slot_typeRepository;

@RestController
@RequestMapping(path = "/api/parking_slot_type")
public class Parking_slot_typeController {
    private final Logger logger = LoggerFactory.getLogger(Parking_slot_typeRepository.class);
    @Autowired
    private Parking_slot_typeRepository parking_slot_typeRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<parking_slot_type> getUsers() {
        logger.info("Sending all parking_slot_types!");
        return parking_slot_typeRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public parking_slot_type getParking_slot_type(@PathVariable int id_parking_slot_type) {
        logger.info("Sending parking_slot_type with id " + id_parking_slot_type);
        Optional<parking_slot_type> parking_slot_type1 = parking_slot_typeRepository.findById(id_parking_slot_type);
        if (!parking_slot_type1.isPresent())
            throw new NotFoundException("" + id_parking_slot_type, "Parking_slot_type", "id");
        else
            return parking_slot_type1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public parking_slot_type saveParking_slot_type(@RequestBody parking_slot_type parking_slot_type) {
        parking_slot_type savedParking_slot_type = parking_slot_typeRepository.save(parking_slot_type);
        logger.info("Saving parking_slot_type with id " + savedParking_slot_type.getType_id());
        return savedParking_slot_type;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteParking_slot_type(@PathVariable int id_parking_slot_type) {
        logger.info("Deleting parking_slot_type with id " + id_parking_slot_type);
        Optional<parking_slot_type> parking_slot_type1 = parking_slot_typeRepository.findById(id_parking_slot_type);
        if (!parking_slot_type1.isPresent())
            throw new NotFoundException("" + id_parking_slot_type, "Parking_slot_type", "id");
        else
            parking_slot_typeRepository.deleteById(id_parking_slot_type);
        return new Response("Deleted parking_slot_type with id " + id_parking_slot_type, null);
    }
}