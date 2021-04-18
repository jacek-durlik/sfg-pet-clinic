package pl.anril.sfgpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.anril.sfgpetclinic.model.Owner;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.assertj.core.api.Assertions.assertThatCode;

class OwnerServiceMapTest {

    public static final long OWNER_ID = 1L;
    public static final long OWNER_ID2 = 2L;
    public static final String LAST_NAME = "Durlik";
    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save((Owner) Owner.builder().firstName("Jacek").lastName(LAST_NAME).id(OWNER_ID).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertThat(ownerSet.size(), equalTo(1));
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(OWNER_ID);
        assertThat(owner.getId(), equalTo(OWNER_ID));
    }

    @Test
    void saveExistingId() {
        Owner owner = ownerServiceMap.save(Owner.builder().id(OWNER_ID2).build());
        assertThat(owner.getId(), equalTo(OWNER_ID2));
    }

    @Test
    void saveGenerateId() {
        Owner owner = ownerServiceMap.save(Owner.builder().build());
        assertThat(owner, notNullValue());
        assertThat(owner.getId(), notNullValue());
    }

    @Test
    void deleteById() {
        assertThatCode(()->ownerServiceMap.deleteById(OWNER_ID)).doesNotThrowAnyException();
        assertThat(ownerServiceMap.findAll().size(), equalTo(0));
    }

    @Test
    void delete() {
        assertThatCode(()->ownerServiceMap.delete(ownerServiceMap.findById(OWNER_ID))).doesNotThrowAnyException();
        assertThat(ownerServiceMap.findAll().size(), equalTo(0));
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(LAST_NAME);
        assertThat(owner, notNullValue());
        assertThat(owner.getId(), equalTo(OWNER_ID));
    }
}