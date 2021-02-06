package pl.anril.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
