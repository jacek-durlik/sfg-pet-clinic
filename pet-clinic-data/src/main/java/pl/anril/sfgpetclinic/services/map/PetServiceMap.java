package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.Pet;

public class PetServiceMap extends AbstractMapService<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return save(object.getId(), object);
    }
}
