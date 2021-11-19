package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.reserve;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.ReserveRepository;

@RestController
@RequestMapping(path = "/api/reserve")
public class ReserveController {
    private final Logger logger = LoggerFactory.getLogger(ReserveRepository.class);
    @Autowired
    private ReserveRepository reserveRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<reserve> getUsers() {
        logger.info("Sending all reserves!");
        return reserveRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public reserve getReserve(@PathVariable int id_reserve) {
        logger.info("Sending reserve with id " + id_reserve);
        Optional<reserve> reserve1 = reserveRepository.findById(id_reserve);
        if (!reserve1.isPresent())
            throw new NotFoundException("" + id_reserve, "Reserve", "id");
        else
            return reserve1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public reserve saveReserve(@RequestBody reserve reserve) {
        reserve savedReserve = reserveRepository.save(reserve);
        logger.info("Saving reserve with id " + savedReserve.getReserve_id());
        return savedReserve;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteReserve(@PathVariable int id_reserve) {
        logger.info("Deleting reserve with id " + id_reserve);
        Optional<reserve> reserve1 = reserveRepository.findById(id_reserve);
        if (!reserve1.isPresent())
            throw new NotFoundException("" + id_reserve, "Reserve", "id");
        else
            reserveRepository.deleteById(id_reserve);
        return new Response("Deleted reserve with id " + id_reserve, null);
    }

    @GetMapping(path = "/reserve/parking", produces= MediaType.APPLICATION_JSON_VALUE)
        public Iterable<String> getResPark() {
        return reserveRepository.getResPark();
   }
}

