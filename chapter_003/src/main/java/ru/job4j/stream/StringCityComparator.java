package ru.job4j.stream;

import java.util.Comparator;

public class StringCityComparator implements Comparator<Address> {

    @Override
    public int compare(Address a1, Address a2) {
        //Address a1 = p1.getAddress();
        //Address a2 = p2.getAddress();

        return a1.getCity().compareTo(a2.getCity());
    }


}
