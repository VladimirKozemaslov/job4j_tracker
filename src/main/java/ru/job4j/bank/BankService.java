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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет клиента по реквизитам счета, в случае если клиент
     * не найден или найден счет у клиента возвращает null
     * @param passport Паспортные данные клиента.
     * @param requisite Реквизиты счета.
     * @return Возвращает объект типа Account если счет найден, либо null если не найден счет или клиент.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport).stream()
                .flatMap(user -> users.get(user).stream())
                .filter(account -> Objects.equals(account.getRequisite(), requisite))
                .findFirst();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            Account src = srcAccount.get();
            Account dest = destAccount.get();
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}