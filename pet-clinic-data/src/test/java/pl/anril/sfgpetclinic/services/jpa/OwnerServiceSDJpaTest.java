package pl.anril.sfgpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.anril.sfgpetclinic.model.Owner;
import pl.anril.sfgpetclinic.repositories.OwnerRepository;
import pl.anril.sfgpetclinic.repositories.PetRepository;
import pl.anril.sfgpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OwnerServiceSDJpaTest {
    public static final String LAST_NAME = "Smith";
    @InjectMocks
    private OwnerServiceSDJpa ownerServiceSDJpa;

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;
    private Owner returnedOwner = Owner.builder().id(1L).firstName("John").lastName(LAST_NAME).build();
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(ownerRepository.save(Mockito.any())).thenReturn(returnedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(returnedOwner);
        ownerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> retSet = ownerServiceSDJpa.findAll();
        assertThat(retSet, notNullValue());
        assertThat(retSet, not(emptyIterable()));
        assertThat(retSet.size(), equalTo(2));
    }

    @Test
    void findById() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(returnedOwner));

        Owner retOwner = ownerServiceSDJpa.findById(1L);
        assertThat(retOwner, notNullValue());
        assertThat(retOwner.getLastName(), equalTo(LAST_NAME));
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Owner retOwner = ownerServiceSDJpa.findById(1L);
        assertThat(retOwner, nullValue());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        Owner saved = ownerServiceSDJpa.save(ownerToSave);

        assertThat(saved, notNullValue());
        assertThat(saved.getLastName(), equalTo(LAST_NAME));
    }

    @Test
    void delete() {
        ownerServiceSDJpa.save(returnedOwner);
        ownerServiceSDJpa.delete(returnedOwner);
        verify(ownerRepository).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        ownerServiceSDJpa.save(returnedOwner);
        ownerServiceSDJpa.deleteById(1L);
        verify(ownerRepository).deleteById(1L);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(returnedOwner);
        Owner smith = ownerServiceSDJpa.findByLastName(LAST_NAME);
        assertThat(smith, notNullValue());
        assertThat(smith, equalTo(returnedOwner));
        verify(ownerRepository).findByLastName(eq(LAST_NAME));
    }
}