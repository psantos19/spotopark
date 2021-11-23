package pt.iade.spotopark.models.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pt.iade.spotopark.models.utilizador;

public interface UtilizadorRepository extends CrudRepository<utilizador, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into utilizador (user_name, user_password, user_bdate, " 
            + "user_email, user_coordinates)"
            + " values(:#{#utilizador.name}, :#{#utilizador.password}, "
            + ":#{#utilizador.bdate}, :#{#utilizador.email}" + ", :#{#utilizador.coordinates})", nativeQuery = true)
    Integer registerUtilizador(@Param("utilizador") utilizador utilizador);
}