package pl.anril.sfgpetclinic.services.map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Specialty;
import pl.anril.sfgpetclinic.model.Vet;
import pl.anril.sfgpetclinic.services.SpecialtyService;
import pl.anril.sfgpetclinic.services.VetService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    @Override
    public Vet save(Vet object) {
        if (Objects.nonNull(object)) {
            if (Objects.nonNull(object.getSpecialties())) {
                object.getSpecialties().forEach(spec->{
                    if (Objects.isNull(spec.getId())) {
                        Specialty specialty = specialtyService.save(spec);
                        spec.setId(specialty.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }
}
