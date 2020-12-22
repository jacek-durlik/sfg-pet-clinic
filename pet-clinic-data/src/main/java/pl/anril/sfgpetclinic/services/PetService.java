package pl.anril.sfgpetclinic.services;

import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
