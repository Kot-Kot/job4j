package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item's Id for deleting: ");
        Item deletedItem = tracker.delete(id);
        if (deletedItem != null) {
            System.out.println("Item has been deleted");
        } else {
            System.out.println("Item has not found");
        }
        return true;
    }
}
