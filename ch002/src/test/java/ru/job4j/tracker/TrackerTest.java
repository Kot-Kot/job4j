package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("request1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void  findAllTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("request1");
        Item item2 = new Item("request2");
        Item item3 = new Item("request3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = {item1, item2, item3};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    @Test
    public void  findByNameTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("request1");
        Item item2 = new Item("request2");
        Item item3 = new Item("request3");
        Item item4 = new Item("request1");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] expected = {item1, item4};
        Item[] result = tracker.findByName("request1");
        assertThat(result, is(expected));
    }
}