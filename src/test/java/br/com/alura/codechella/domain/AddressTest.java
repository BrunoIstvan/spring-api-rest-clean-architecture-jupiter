package br.com.alura.codechella.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void whenCreateAddressEntity_shouldHaveANotNullObject() {

        var address = new Address("00000-00", 100, "apto 100");
        assertNotNull(address);

        assertEquals(address.getCep(), "00000-00");
        assertEquals(address.getNumber(), 100);
        assertEquals(address.getComplement(), "apto 100");

    }

    @Test
    void whenComparingTwoEqualAddressEntities_shouldReturnTrue() {

        var address1 = new Address("00000-00", 100, "apto 100");
        var address2 = new Address("00000-00", 100, "apto 100");

        assertEquals(address1, address2);

    }

    @Test
    void whenExecuteHash_shouldReturnValue() {

        var address1 = new Address("00000-00", 100, "apto 100");

        assertEquals(address1.hashCode(), -1583291981);

    }

}