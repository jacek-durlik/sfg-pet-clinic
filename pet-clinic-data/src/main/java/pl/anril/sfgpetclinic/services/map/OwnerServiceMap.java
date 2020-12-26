package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.services.CrudService;

import java.util.Random;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> {
    @Override
    public Owner save(Owner object) {
        return save(object.getId(), object);
    }
}
