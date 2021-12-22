package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.parking;
import pt.iade.spotopark.models.parkingSlot;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.ParkingRepository;
import pt.iade.spotopark.models.repositories.ParkingSlotRepository;

@RestController
@RequestMapping(path = "/api/parking")
public class ParkingController {
    private final Logger logger = LoggerFactory.getLogger(ParkingRepository.class);
    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<parking> getUsers() {
        logger.info("Sending all parkings!");
        return parkingRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public parking getParking(@PathVariable int id_parking) {
        logger.info("Sending parking with id " + id_parking);
        Optional<parking> parking1 = parkingRepository.findById(id_parking);
        if (!parking1.isPresent())
            throw new NotFoundException("" + id_parking, "Parking", "id");
        else
            return parking1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public parking saveParking(@RequestBody parking parking) {
        parking savedParking = parkingRepository.save(parking);
        logger.info("Saving parking with id " + savedParking.getParkId());
        return savedParking;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteParking(@PathVariable int id_parking) {
        logger.info("Deleting parking with id " + id_parking);
        Optional<parking> parking1 = parkingRepository.findById(id_parking);
        if (!parking1.isPresent())
            throw new NotFoundException("" + id_parking, "Parking", "id");
        else
            parkingRepository.deleteById(id_parking);
        return new Response("Deleted parking with id " + id_parking, null);
    }

}
