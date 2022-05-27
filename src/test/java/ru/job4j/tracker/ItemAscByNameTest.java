package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemAscByNameTest {
    @Test
    public void whenItemsSortInAscendingOrder() {
        Item item1 = new Item(1, "Zack");
        Item item2 = new Item(2, "Carl");
        Item item3 = new Item(3, "Bob");
        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        Collections.sort(list, new ItemAscByName());
        List<Item> expected = List.of(new Item(3, "Bob"), new Item(2, "Carl"), new Item(1, "Zack"));
        assertThat(list, is(expected));
    }
}