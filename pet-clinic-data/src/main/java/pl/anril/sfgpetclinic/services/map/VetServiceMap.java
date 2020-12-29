package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.Vet;
import pl.anril.sfgpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet object) {
        return save(object.getId(), object);
    }
}
