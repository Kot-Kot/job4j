package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User neededUser = findByPassport(passport);
        if (neededUser != null && !users.get(neededUser).contains(account)) {
            users.get(neededUser).add(account);
        } else {
            System.out.println("User doesnot exist or account already exists");
        }
    }

    public User findByPassport(String passport) {
        User neededUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                neededUser = user;
                break;
            }
        }
        return neededUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account neededAccount = null;
        User neededUser = findByPassport(passport);
        if (neededUser != null) {
            for (Account account : users.get(neededUser)) {
                if (account.getRequisite().equals(requisite)) {
                    neededAccount = account;
                    break;
                }
            }
        }
        return neededAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (isEnoughMoney(srcAccount, destAccount, amount)) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public boolean isEnoughMoney(Account srcAccount, Account destAccount, double amount) {
        boolean rsl = false;
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() - amount >= 0) {
          rsl = true;
        }
        return rsl;
    }
}