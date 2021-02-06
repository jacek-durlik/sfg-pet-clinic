package pl.anril.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
