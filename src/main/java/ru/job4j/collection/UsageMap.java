package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("vladikoz555@gmail.com", "Kozemaslov Vladimir Sergeevich");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}
