package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "===  Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item's Id to search: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item has not found");
        } else {
            System.out.println(item.getId() + " : " + item.getName());
        }
        return true;
    }
}
