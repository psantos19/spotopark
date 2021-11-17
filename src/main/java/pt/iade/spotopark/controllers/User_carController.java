package pt.iade.spotopark.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import pt.iade.spotopark.models.user_car;
import pt.iade.spotopark.models.exceptions.NotFoundException;
import pt.iade.spotopark.models.exceptions.Response;
import pt.iade.spotopark.models.repositories.User_carRepository;

@RestController
@RequestMapping(path = "/api/user_car")
public class User_carController {
    private final Logger logger = LoggerFactory.getLogger(User_carRepository.class);
    @Autowired
    private User_carRepository user_carRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<user_car> getUser_car()
    {
        logger.info("Sending all car users!");
        return user_carRepository.findAll();
    }
    
    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public user_car getUser_car(@PathVariable int id_user_car) {
        logger.info("Sending car user with id " + id_user_car);
        Optional<user_car> user_car1 =   user_carRepository.findById(id_user_car);
        if (!user_car1.isPresent()) throw
                new NotFoundException("" + id_user_car, "User", "id");
        else
            return user_car1.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public  user_car saveUser_car(@RequestBody user_car user_car) {
        user_car savedUser_car = user_carRepository.save(user_car);
        logger.info("Saving user with id " + savedUser_car.getUser_car_id());
        return savedUser_car;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUser_car(@PathVariable int id_user_car) {
        logger.info("Deleting car user with id " + id_user_car);
        Optional<user_car> user_car1 = user_carRepository.findById(id_user_car);
        if (!user_car1.isPresent()) throw
                new NotFoundException("" + id_user_car, "car user", "id");
        else
            user_carRepository.deleteById(id_user_car);
            return new Response("Deleted car user with id " + id_user_car, null);
    }
}
