package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== List of all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] itemList = tracker.findAll();
        for (int i = 0; i < itemList.length; i++) {
            System.out.println("Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
        }
        return true;
    }
}
