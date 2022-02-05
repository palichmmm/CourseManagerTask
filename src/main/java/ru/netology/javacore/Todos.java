package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        List<String> listTasks = tasks.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return String.valueOf(listTasks)
                .replace(", ", " ")
                .replace("[", "")
                .replace("]", "");
    }

}
