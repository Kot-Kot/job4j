package ru.job4j.tracker;

import java.util.ArrayList;

public class StartUI {
    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validateInput = new ValidateInput(input);
        Tracker tracker = new Tracker();
        tracker.add(new Item("i1"));
        tracker.add(new Item("i2"));
        tracker.add(new Item("i3"));
        tracker.add(new Item("i2"));
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        actions.add(new ShowAction());
        actions.add(new ReplaceAction());
        actions.add(new DeleteAction());
        actions.add(new FindItemByIdAction());
        actions.add(new FindItemByNameAction());
        new StartUI().init(validateInput, tracker, actions);
    }
}