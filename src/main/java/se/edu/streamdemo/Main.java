package se.edu.streamdemo;

import se.edu.streamdemo.data.Datamanager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Datamanager dataManager = new Datamanager("./data/data.txt");
        // "C:\University\NUS\Y2S2\CS2113\Tasks\data" <<< absolute path

        ArrayList<Task> tasksData = dataManager.loadData();

        printWelcomeMessage();
        System.out.println("Printing all data ...");
        printAllData(tasksData);
        printDataUsingSTreams(tasksData);

        System.out.println("Printing deadlines ...");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesUsingStreams(ArrayList<Task> tasks) {
        int count = (int)tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
        return count;
    }

    public static void printWelcomeMessage () {
        System.out.println("Welcome to Task Manager (using streams) ");
    }

    public static void printAllData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println("Printing data using titration...");
        }
        System.out.println();
    }

    public static void printDataUsingSTreams(ArrayList<Task> tasks) {
        tasks.stream()
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Pringting all tasks using iteration");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlineUsingStreams(ArrayList<Task> tasks) {
        tasks.parallelStream()
                .filter(t -> t instanceof Deadline)
                .forEach(System.out::println);
    }

}
