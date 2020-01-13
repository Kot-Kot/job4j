package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TrackerSingle1Test {
    @Test
    public void isTheSameObject() {
        TrackerSingle1 tracker1 = TrackerSingle1.INSTANCE;
        TrackerSingle1 tracker2 = TrackerSingle1.INSTANCE;
        assertEquals(tracker1, tracker2);
    }
}
