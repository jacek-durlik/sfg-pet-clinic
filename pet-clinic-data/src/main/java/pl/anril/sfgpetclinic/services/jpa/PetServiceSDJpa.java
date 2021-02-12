package pl.anril.sfgpetclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Pet;
import pl.anril.sfgpetclinic.repositories.PetRepository;
import pl.anril.sfgpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetServiceSDJpa implements PetService {
    private final PetRepository petRepository;

    @Override
    public Set<Pet> findAll() {
        final Set<Pet> retSet = new HashSet<>();
        petRepository.findAll().forEach(retSet::add);
        return retSet;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
