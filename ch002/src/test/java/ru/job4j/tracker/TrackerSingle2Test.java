package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrackerSingle2Test {
    @Test
    public void isTheSameObject() {
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        TrackerSingle2 tracker2 = TrackerSingle2.getInstance();
        assertEquals(tracker1, tracker2);
    }
}
