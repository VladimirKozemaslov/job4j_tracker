package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывающий банковское обслуживание,
 * хранит счета и методы для работы со счетами.
 * @author Vladimir Kozemaslov
 * @version 1.0
 */
public class BankService {
    /**
     * Поле users хранит всех клиентов банка и их банковские счета.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет клиента к списку клиентов.
     * @param user Клиент банка.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод ищет клиента по паспорту среди списка клиентов и
     * в случае если клиент найден добавляет ему новый счет к списку его счетов.
     * @param passport Паспортные данные клиента.
     * @param account Счет для добавления к списку счетов клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет клиента по паспорту среди списка клиентов,
     * в случае если клиент не найден возвращает null
     * @param passport Паспортные данные клиента.
     * @return Возвращает объект типа User если клиент найден, либо null если клиент не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет клиента по реквизитам счета, в случае если клиент
     * не найден или найден счет у клиента возвращает null
     * @param passport Паспортные данные клиента.
     * @param requisite Реквизиты счета.
     * @return Возвращает объект типа Account если счет найден, либо null если не найден счет или клиент.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (Objects.equals(account.getRequisite(), requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой, в случае успешного перевода
     * возвращает true, иначе false.
     * @param srcPassport Паспортные данные плательщика.
     * @param srcRequisite Реквизиты счета плательщика.
     * @param destPassport Паспортные данные получателя.
     * @param destRequisite Реквизиты счета получателя.
     * @param amount Сумма перевода.
     * @return Возвращает true если перевод успешно завершен, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}