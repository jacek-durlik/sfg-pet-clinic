package pl.anril.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
