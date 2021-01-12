package pl.anril.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.PetType;
import pl.anril.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
}
