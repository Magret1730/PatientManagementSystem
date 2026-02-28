package org.codewithmagret;

import org.codewithmagret.history.PatientHistoryList;
import org.codewithmagret.ui.ConsoleMenu;
import org.codewithmagret.waitingRoom.PatientWaitingQueue;

import java.util.Scanner;

/**
 * Main class for the Java application.
 * This class contains the main method which serves as the entry point of the application.
 */
public class Main {
    /**
     * The main method initializes the necessary components and starts the console menu.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PatientWaitingQueue queue = new PatientWaitingQueue();
        PatientHistoryList history = new PatientHistoryList();
        history.seedTenRecords();

        new ConsoleMenu(scanner, queue, history).start();
    }
}
