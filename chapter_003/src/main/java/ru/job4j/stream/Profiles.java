package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        //List<Address> addresses = profiles.stream().map(
                //p -> p.getAddress()
        //).collect(Collectors.toList());
        List<Address> addresses = profiles.stream().map(p -> p.getAddress()).sorted(new StringCityComparator()).
                distinct().collect(Collectors.toList());
        return addresses;
    }
}
