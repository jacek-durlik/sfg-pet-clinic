package pl.anril.sfgpetclinic.services.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Visit;
import pl.anril.sfgpetclinic.repositories.VisitRepository;
import pl.anril.sfgpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VisitServiceSDJpa implements VisitService {
    private final VisitRepository visitRepository;
    @Override
    public Set<Visit> findAll() {
        final Set<Visit> retSet = new HashSet<>();
        visitRepository.findAll().forEach(retSet::add);
        return retSet;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
