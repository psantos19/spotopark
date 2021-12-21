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
    public Iterable<utilizador> getUtilizador()
    {
        logger.info("Sending all users!");
        return utilizadorRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public utilizador getUtilizador(@PathVariable int id) {
        logger.info("Sending user with id " + id);
        Optional<utilizador> _utilizador = utilizadorRepository.findById(id);
        if (!_utilizador.isPresent()) throw
                new NotFoundException("" + id, "User", "id");
        else
            return _utilizador.get();
    }

    
    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE) 
    public utilizador saveUsers(@RequestBody utilizador utilizador) { 
        utilizador savedUtilizador = utilizadorRepository.save(utilizador);
            logger.info("Saving user with id " + savedUtilizador.getId()); 
        return savedUtilizador; 
    }
     

     
    /*@PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveUtilizador(@RequestBody utilizador utilizadorId) {
        logger.info("Registering user with id " + utilizadorId.getId() +
                " with name " + utilizadorId.getName());
        String savedUtilizador = utilizadorRepository.registerUtilizador(utilizadorId);
        return new Response(savedUtilizador + " registration created", utilizadorId); 
    }*/
    
    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUtilizador(@PathVariable int id) {
        logger.info("Deleting user with id " + id);
        Optional<utilizador> utilizador = utilizadorRepository.findById(id);
        if (!utilizador.isPresent()) throw
                new NotFoundException("" + id, "user", "id");
        else
            utilizadorRepository.deleteById(id);
        return new Response("Deleted user with id " + id, null);
    }
}