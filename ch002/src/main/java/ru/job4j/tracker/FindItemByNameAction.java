package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "===   Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter item's name to search: ");
        Item[] itemList = tracker.findByName(name);
        for (int i = 0; i < itemList.length; i++) {
            if (itemList[i] != null) {
                System.out.println(i + ". " + "Id : " + itemList[i].getId() + "; Name : " + itemList[i].getName());
            }
        }
        return true;
    }
}
