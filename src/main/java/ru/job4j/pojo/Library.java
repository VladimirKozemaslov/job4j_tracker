package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book warAndPeace = new Book("Война и мир", 1015);
        Book regularStory = new Book("Обыкновенная история", 743);
        Book fiftyShades = new Book("50 оттенков серого", 251);
        Book cleanCode = new Book("Clean code", 1455);

        Book[] books = new Book[4];
        books[0] = warAndPeace;
        books[1] = regularStory;
        books[2] = fiftyShades;
        books[3] = cleanCode;

        for (int i = 0; i < books.length; i++) {
            System.out.println("Имя книги: " + books[i].getName() + ", количество страниц " + books[i].getPageAmount() + ".");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            if (Objects.equals(books[i].getName(), "Clean code")) {
                System.out.println("Имя книги: " + books[i].getName() + ", количество страниц " + books[i].getPageAmount() + ".");
            }
        }
    }
}
