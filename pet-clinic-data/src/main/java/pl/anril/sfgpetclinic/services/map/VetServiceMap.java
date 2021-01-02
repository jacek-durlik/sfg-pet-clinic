package pl.anril.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Vet;
import pl.anril.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
}
