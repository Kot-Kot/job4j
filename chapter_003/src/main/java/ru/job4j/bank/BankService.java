package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

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
        return users.entrySet()
                .stream()
                .filter(user -> user.getKey().getPassport().equals(passport))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account neededAccount = null;
        User neededUser = findByPassport(passport);
        if (neededUser != null) {
            neededAccount = users.entrySet()
                    .stream()
                    .filter(map -> map.getKey().equals(neededUser))
                    .map(Map.Entry::getValue)
                    .map(map -> map.get(0))
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findAny()
                    .orElse(null);

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