package pl.anril.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.sfgpetclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
