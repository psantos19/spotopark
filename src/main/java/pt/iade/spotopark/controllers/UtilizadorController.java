package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.utilizador;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.UtilizadorRepository;

@RestController
@RequestMapping(path = "/api/utilizador")
public class UtilizadorController {
    private final Logger logger = LoggerFactory.getLogger(UtilizadorRepository.class);
    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<utilizador> getUsers() {
        logger.info("Sending all utilizadores!");
        return UtilizadorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public event getEvent(@PathVariable int id_event) {
        logger.info("Sending event with id " + id_event);
        Optional<event> event1 = eventRepository.findById(id_event);
        if (!event1.isPresent())
            throw new NotFoundException("" + id_event, "Event", "id");
        else
            return event1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public event saveEvent(@RequestBody event event) {
        event savedEvent = eventRepository.save(event);
        logger.info("Saving event with id " + savedEvent.getEvent_id());
        return savedEvent;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteEvent(@PathVariable int id_event) {
        logger.info("Deleting event with id " + id_event);
        Optional<event> event1 = eventRepository.findById(id_event);
        if (!event1.isPresent())
            throw new NotFoundException("" + id_event, "event", "id");
        else
            eventRepository.deleteById(id_event);
        return new Response("Deleted event with id " + id_event, null);
    }
}
