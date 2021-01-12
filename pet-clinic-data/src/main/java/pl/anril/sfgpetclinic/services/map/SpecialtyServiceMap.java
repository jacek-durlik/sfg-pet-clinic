package pl.anril.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Specialty;
import pl.anril.sfgpetclinic.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {
}
