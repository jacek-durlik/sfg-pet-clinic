package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.Vet;

public class VetServiceMap extends AbstractMapService<Vet, Long> {
    @Override
    public Vet save(Vet object) {
        return save(object.getId(), object);
    }
}
