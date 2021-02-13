package pl.anril.sfgpetclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Specialty;
import pl.anril.sfgpetclinic.repositories.SpecialtyRepository;
import pl.anril.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class SpecialtyServiceSDJpa implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    @Override
    public Set<Specialty> findAll() {
        final Set<Specialty> retSet = new HashSet<>();
        specialtyRepository.findAll().forEach(retSet::add);
        return retSet;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
