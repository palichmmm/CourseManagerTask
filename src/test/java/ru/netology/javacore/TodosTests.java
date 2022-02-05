package ru.netology.javacore;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TodosTests {

    private Todos todos = new Todos();
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running TodosTests");
        suiteStartTime = System.nanoTime();
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("TodosTests complete: " + (System.nanoTime() - suiteStartTime));
    }
    @BeforeEach
    public void initTest() {
        System.out.println("\nStarting new test");
        testStartTime = System.nanoTime();
    }
    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Читать", "Писать", "Играть"})
    public void testAddTaskEquals(String task) {
        todos.addTask(task);
        String expected = task;
        Assertions.assertEquals(expected, todos.getAllTasks());
    }
    @Test
    public void testRemoveTaskEquals() {
        String task1 = "Читать";
        String task2 = "Писать";
        String expected = task1; // Ожидаем что останется после удаления только task1

        todos.addTask(task1);
        todos.addTask(task2);
        todos.removeTask(task2);

        Assertions.assertEquals(expected, todos.getAllTasks());
    }
    @Test
    public void testAllTaskEquals() {
        String task1 = "Читать";
        String task2 = "Писать";
        String separator = " ";
        String expected = task2 + separator + task1; // Ожидаемый вывод после натуральной сортировки

        todos.addTask(task1);
        todos.addTask(task2);

        Assertions.assertEquals(expected, todos.getAllTasks());
    }
}
