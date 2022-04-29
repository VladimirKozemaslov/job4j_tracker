package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Ошибка активна: " + this.active + ", статус: " + this.status + ", " + this.message);
    }

    public static void main(String[] args) {
        Error err1 = new Error();
        Error err2 = new Error(true, 12, "Недопустимое значение переменной");
        err2.printError();
        Error err3 = new Error(false, 25, "Истекло время ожидания ответа");
        err3.printError();
    }
}
