package pl.anril.sfgpetclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.repositories.OwnerRepository;
import pl.anril.sfgpetclinic.repositories.PetRepository;
import pl.anril.sfgpetclinic.repositories.PetTypeRepository;
import pl.anril.sfgpetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class OwnerServiceSDJpa  implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    @Override
    public Set<Owner> findAll() {
        Set<Owner> ret = new HashSet<>();
        ownerRepository.findAll().forEach(ret::add);
        return ret;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAllByLastName(String lastName) {
        return ownerRepository.findAllByLastName(lastName);
    }
}
