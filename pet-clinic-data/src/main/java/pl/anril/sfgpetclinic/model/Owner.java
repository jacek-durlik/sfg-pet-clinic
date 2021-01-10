package pl.anril.sfgpetclinic.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Owner extends Person {
    private Set<Pet> pets = new HashSet<>();
}
