package pl.anril.sfgpetclinic.services;

import pl.anril.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
