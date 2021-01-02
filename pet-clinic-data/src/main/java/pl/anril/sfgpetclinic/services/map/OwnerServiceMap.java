package pl.anril.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.services.OwnerService;

import java.util.Map;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner save(Owner object) {
        return save(object.getId(), object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(e -> e.getValue().getLastName().equals(lastName))
                .map(Map.Entry::getValue).findFirst().orElse(null);
    }
}
