package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== List of all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> itemList = tracker.findAll();
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println("Id : " + itemList.get(i).getId() + "; Name : " + itemList.get(i).getName());
        }
        return true;
    }
}
