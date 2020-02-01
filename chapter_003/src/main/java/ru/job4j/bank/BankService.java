package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        } else {
            System.out.println("User already exists");
        }
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
            if (user.getPassport() == passport) {
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
                if (account.getRequisite() == requisite) {
                    neededAccount = account;
                    break;
                }
            }
            if (neededAccount == null) {
                System.out.println("Account doesnot exist");
            }
        } else {
            System.out.println("User doesnot exist");
        }
        return neededAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount != null && destAccount != null && srcAccount.getBalance() - amount >= 0) {
            System.out.println("srcAccount.getBalance() 1 : " + srcAccount.getBalance());
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            System.out.println("srcAccount.getBalance() 2 : " + srcAccount.getBalance());
            System.out.println("destAccount.getBalance() 1 : " + destAccount.getBalance());
            destAccount.setBalance(destAccount.getBalance() + amount);
            System.out.println("destAccount.getBalance() 2 : " + destAccount.getBalance());
            rsl = true;
        }
        return rsl;
    }
}