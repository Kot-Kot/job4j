package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrackerSingle4Test {
    @Test
    public void isTheSameObject() {
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();
        TrackerSingle4 tracker2 = TrackerSingle4.getInstance();
        assertEquals(tracker1, tracker2);
    }
}
