package pl.anril.sfgpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
