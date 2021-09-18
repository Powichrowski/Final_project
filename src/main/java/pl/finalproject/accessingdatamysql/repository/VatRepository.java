package pl.finalproject.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.finalproject.accessingdatamysql.model.Vat;

import java.util.Optional;

@Repository
public interface VatRepository extends CrudRepository<Vat, Integer> {

    Optional<Vat> findById(Integer id);

    Vat findByUserLogin(String login);


}
