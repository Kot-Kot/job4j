package ru.job4j.tracker;

import java.util.ArrayList;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "===   Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item's name to search: ");
        ArrayList<Item> itemList = tracker.findByName(name);
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) != null) {
                System.out.println("Id : " + itemList.get(i).getId() + "; Name : " + itemList.get(i).getName());
            }
        }
        return true;
    }
}
