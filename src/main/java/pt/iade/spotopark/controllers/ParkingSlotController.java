package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.parkingSlot;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.ParkingSlotRepository;

@RestController
@RequestMapping(path = "/api/parking_slot")
public class ParkingSlotController {
    private final Logger logger = LoggerFactory.getLogger(ParkingSlotRepository.class);
    @Autowired
    private ParkingSlotRepository parking_slotRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<parkingSlot> getUsers() {
        logger.info("Sending all parking_slots!");
        return parking_slotRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public parkingSlot getParking_slot(@PathVariable int id_parking_slot) {
        logger.info("Sending parking_slot with id " + id_parking_slot);
        Optional<parkingSlot> parking_slot1 = parking_slotRepository.findById(id_parking_slot);
        if (!parking_slot1.isPresent())
            throw new NotFoundException("" + id_parking_slot, "Parking_slot", "id");
        else
            return parking_slot1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public parkingSlot saveParking_slot(@RequestBody parkingSlot parking_slot) {
        parkingSlot savedParking_slot = parking_slotRepository.save(parking_slot);
        logger.info("Saving parking_slot with id " + savedParking_slot.getParkingSlotId());
        return savedParking_slot;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteParking_slot(@PathVariable int id_parking_slot) {
        logger.info("Deleting parking_slot with id " + id_parking_slot);
        Optional<parkingSlot> parking_slot1 = parking_slotRepository.findById(id_parking_slot);
        if (!parking_slot1.isPresent())
            throw new NotFoundException("" + id_parking_slot, "Parking_slot", "id");
        else
            parking_slotRepository.deleteById(id_parking_slot);
        return new Response("Deleted parking_slot with id " + id_parking_slot, null);
    }

    @GetMapping(path = "/type", produces= MediaType.APPLICATION_JSON_VALUE)
        public Iterable<String> getTypeNUm() {
        return parking_slotRepository.getTypeNum();
   }
}
