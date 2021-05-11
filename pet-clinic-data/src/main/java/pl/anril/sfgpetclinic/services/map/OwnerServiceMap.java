package pl.anril.sfgpetclinic.services.map;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.model.Pet;
import pl.anril.sfgpetclinic.services.OwnerService;
import pl.anril.sfgpetclinic.services.PetService;
import pl.anril.sfgpetclinic.services.PetTypeService;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
@RequiredArgsConstructor
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(e -> e.getValue().getLastName().equals(lastName))
                .map(Map.Entry::getValue).findFirst().orElse(null);
    }

    @Override
    public Set<Owner> findAllByLastName(String lastName) {
        return map.entrySet().stream()
                .filter(e -> e.getValue().getLastName().equals(lastName))
                .map(Map.Entry::getValue).collect(Collectors.toSet());
    }

    @Override
    public Owner save(Owner object) {
        if (Objects.nonNull(object)) {
            if (Objects.nonNull(object.getPets())) {
                object.getPets().forEach(pet->{
                    if (Objects.nonNull(pet.getPetType())) {
                        if (Objects.isNull(pet.getPetType().getId())) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required.");
                    }

                    if (Objects.isNull(pet.getId())) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }
}
