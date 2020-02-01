package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150d));
    }

    @Test
    public void transferMoney() {
        User user = new User("PASSPORT01", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("1001", 150d));
        bank.addAccount(user.getPassport(), new Account("1002", 50d));
        bank.transferMoney(user.getPassport(), "1001", user.getPassport(), "1002", 150d);
        assertThat(bank.findByRequisite("PASSPORT01", "1002").getBalance(), is(200d));
    }
}