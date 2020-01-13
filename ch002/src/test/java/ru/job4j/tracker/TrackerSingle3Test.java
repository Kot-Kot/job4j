package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrackerSingle3Test {
    @Test
    public void isTheSameObject() {
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();
        TrackerSingle3 tracker2 = TrackerSingle3.getInstance();
        assertEquals(tracker1, tracker2);
    }
}
