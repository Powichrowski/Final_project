package pl.finalproject.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.finalproject.accessingdatamysql.model.Income;

import java.util.Optional;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Integer> {

    Optional<Income> findById(Integer id);
}
