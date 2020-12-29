package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.Pet;
import pl.anril.sfgpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Pet save(Pet object) {
        return save(object.getId(), object);
    }
}
