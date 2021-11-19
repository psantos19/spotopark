package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.parking_slot;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.Parking_slotRepository;

@RestController
@RequestMapping(path = "/api/parking_slot")
public class Parking_slotController {
    private final Logger logger = LoggerFactory.getLogger(Parking_slotRepository.class);
    @Autowired
    private Parking_slotRepository parking_slotRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<parking_slot> getUsers() {
        logger.info("Sending all parking_slots!");
        return parking_slotRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public parking_slot getParking_slot(@PathVariable int id_parking_slot) {
        logger.info("Sending parking_slot with id " + id_parking_slot);
        Optional<parking_slot> parking_slot1 = parking_slotRepository.findById(id_parking_slot);
        if (!parking_slot1.isPresent())
            throw new NotFoundException("" + id_parking_slot, "Parking_slot", "id");
        else
            return parking_slot1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public parking_slot saveParking_slot(@RequestBody parking_slot parking_slot) {
        parking_slot savedParking_slot = parking_slotRepository.save(parking_slot);
        logger.info("Saving parking_slot with id " + savedParking_slot.getParking_slot_id());
        return savedParking_slot;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteParking_slot(@PathVariable int id_parking_slot) {
        logger.info("Deleting parking_slot with id " + id_parking_slot);
        Optional<parking_slot> parking_slot1 = parking_slotRepository.findById(id_parking_slot);
        if (!parking_slot1.isPresent())
            throw new NotFoundException("" + id_parking_slot, "Parking_slot", "id");
        else
            parking_slotRepository.deleteById(id_parking_slot);
        return new Response("Deleted parking_slot with id " + id_parking_slot, null);
    }

    @GetMapping(path = "/parking_slot", produces= MediaType.APPLICATION_JSON_VALUE)
        public Iterable<String> getTypeNUm() {
        return parking_slotRepository.getTypeNum();
   }
}
