package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(new Job("Take a shower", 1), new Job("Go for a walk", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(new Job("Take a shower", 1), new Job("Go for a walk", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(new Job("Take a shower", 1), new Job("Go for a walk", 2));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(new Job("Take a shower", 1), new Job("Go for a walk", 2));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriorityAndAscByName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobAscByName());
        List<Job> list = new ArrayList<>();
        list.add(new Job("Add string", 3));
        list.add(new Job("Fix bug", 2));
        list.add(new Job("Delete line", 4));
        list.add(new Job("Put comment", 1));
        list.add(new Job("Break line", 4));
        list.add(new Job("Break line", 5));
        list.add(new Job("Delete line", 3));
        Collections.sort(list, cmpPriorityName);
        List<Job> expected = List.of(
                new Job("Break line", 5),
                new Job("Break line", 4),
                new Job("Delete line", 4),
                new Job("Add string", 3),
                new Job("Delete line", 3),
                new Job("Fix bug", 2),
                new Job("Put comment", 1)
        );
        assertThat(list, is(expected));
    }

    @Test
    public void whenComparatorAscByNameAndDescByPriority() {
        Comparator<Job> cmpPriorityName = new JobAscByName().thenComparing(new JobDescByPriority());
        List<Job> list = new ArrayList<>();
        list.add(new Job("Add string", 3));
        list.add(new Job("Fix bug", 2));
        list.add(new Job("Delete line", 4));
        list.add(new Job("Put comment", 1));
        list.add(new Job("Break line", 4));
        list.add(new Job("Break line", 5));
        list.add(new Job("Delete line", 3));
        Collections.sort(list, cmpPriorityName);
        List<Job> expected = List.of(
                new Job("Add string", 3),
                new Job("Break line", 5),
                new Job("Break line", 4),
                new Job("Delete line", 4),
                new Job("Delete line", 3),
                new Job("Fix bug", 2),
                new Job("Put comment", 1)
        );
        assertThat(list, is(expected));
    }
}