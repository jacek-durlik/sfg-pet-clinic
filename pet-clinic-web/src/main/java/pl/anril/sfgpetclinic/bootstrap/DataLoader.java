package pl.anril.sfgpetclinic.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.model.PetType;
import pl.anril.sfgpetclinic.model.Vet;
import pl.anril.sfgpetclinic.services.OwnerService;
import pl.anril.sfgpetclinic.services.PetTypeService;
import pl.anril.sfgpetclinic.services.VetService;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        ownerService.save(owner2);

        System.out.println("Loaded owners ......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded vets .........");

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType savedPetType1 = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType1.setName("Cat");
        PetType savedPetType2 = petTypeService.save(petType2);



        System.out.println("Loaded pet types .........");

    }
}
