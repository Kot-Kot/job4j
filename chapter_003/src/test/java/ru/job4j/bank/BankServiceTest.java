package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {
    @Test
    public void findByPassport1() {
        User user1 = new User("1000", "Petr Arsentev");
        User user2 = new User("2000", "Vasya Ivanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findByPassport("1000"), is(user1));
    }

    @Test
    public void findByPassport2() {
        User user1 = new User("1000", "Petr Arsentev");
        User user2 = new User("2000", "Vasya Ivanov");
        User user3 = null;
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findByPassport("3000"), is(user3));
    }

    @Test
    public void neededAccount() {
        User user1 = new User("1000", "Petr Arsentev");
        User user2 = new User("2000", "Vasya Ivanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount("1000", new Account("120",100));
        bank.addAccount("1000", new Account("150",1000));
        bank.addAccount("1000", new Account("180",2000));

        assertThat(bank.findByRequisite("1000", "150"), is(new Account("150",1000)));
    }

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