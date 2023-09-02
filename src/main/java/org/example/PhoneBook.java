package org.example;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    public static PhoneBook instance = null;
    private Map<String, String> phoneBook = new TreeMap<>();
    private PhoneBook() {}

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    int add(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, phoneNumber);
            System.out.println("Контакт [" + name + "] c номером: " + phoneNumber + " добавлен.");
        } else {
            System.out.println("Контакт с именем \"" + name + "\" уже существует");
        }
        return phoneBook.size();
    }
}