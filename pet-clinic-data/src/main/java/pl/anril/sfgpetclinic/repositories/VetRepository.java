package pl.anril.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
