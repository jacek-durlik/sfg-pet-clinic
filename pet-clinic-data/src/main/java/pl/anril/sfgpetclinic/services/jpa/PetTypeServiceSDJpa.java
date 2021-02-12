package pl.anril.sfgpetclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.PetType;
import pl.anril.sfgpetclinic.repositories.PetTypeRepository;
import pl.anril.sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetTypeServiceSDJpa implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    @Override
    public Set<PetType> findAll() {
        final Set<PetType> retSet = new HashSet<>();
        petTypeRepository.findAll().forEach(retSet::add);
        return retSet;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
