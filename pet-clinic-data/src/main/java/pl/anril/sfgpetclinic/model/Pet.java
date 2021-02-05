package pl.anril.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
