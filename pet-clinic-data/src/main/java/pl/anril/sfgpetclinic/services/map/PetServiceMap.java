package pl.anril.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Pet;
import pl.anril.sfgpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
}
