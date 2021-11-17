package pt.iade.spotopark.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.spotopark.models.reserve;

public interface ReserveRepository extends CrudRepository <reserve, Integer> {
    
}
