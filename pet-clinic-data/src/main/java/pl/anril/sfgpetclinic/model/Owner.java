package pl.anril.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;
    @EqualsAndHashCode.Exclude
    private Set<Pet> pets = new HashSet<>();
}
