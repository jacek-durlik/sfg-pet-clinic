package pl.anril.sfgpetclinic.services;

import pl.anril.sfgpetclinic.model.Pet;
import pl.anril.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
