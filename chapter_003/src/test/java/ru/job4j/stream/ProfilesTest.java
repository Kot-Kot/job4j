package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfilesTest {
    @Test
    public void addressesList() {
        Address address1 = new Address("a", "a", 1,1);
        Address address2 = new Address("b", "b", 10,10);
        Address address3 = new Address("c", "c", 100,100);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(address1));
        profiles.add(new Profile(address2));
        profiles.add(new Profile(address3));
        List<Address> actual = new Profiles().collect(profiles);

        List<Address> expected = new ArrayList<>();
        expected.add(address1);
        expected.add(address2);
        expected.add(address3);

        assertEquals(expected, actual);
    }
}
