package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item's id for changing: ");
        String newName = input.askStr("Enter item's new name: ");
        if (tracker.replace(id, newName)) {
            System.out.println("Item(s) has been edited");
        } else {
            System.out.println("Needed item was not found");
        }
        return true;
    }
}
