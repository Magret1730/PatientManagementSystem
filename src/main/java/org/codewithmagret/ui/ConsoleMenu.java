package org.codewithmagret.ui;

import org.codewithmagret.history.PatientHistoryList;
import org.codewithmagret.models.Patient;
import org.codewithmagret.models.PatientRecord;
import org.codewithmagret.waitingRoom.PatientWaitingQueue;

import java.util.Scanner;

/**
 * ConsoleMenu provides a simple text-based interface for managing patients in a waiting room
 * and viewing patient history. It allows users to add patients to the queue, serve patients,
 * insert emergency patients at specific positions, and navigate through patient history records.
 */
public class ConsoleMenu {
    /**
     * Scanner for reading user input from the console.
     */
    private final Scanner scanner;

    /**
     * The waiting queue for patients.
     * This is where patients are added and served.
     */
    private final PatientWaitingQueue waitingQueue;

    /**
     * The patient history list.
     * This is where patient records are stored and can be navigated through.
     */
    private final PatientHistoryList history;

    /**
     * Constructor for ConsoleMenu.
     *
     * @param scanner the Scanner object for reading user input
     * @param waitingQueue the PatientWaitingQueue object for managing the waiting room
     * @param history the PatientHistoryList object for managing patient history records
     */
    public ConsoleMenu(Scanner scanner, PatientWaitingQueue waitingQueue, PatientHistoryList history) {
        this.scanner = scanner;
        this.waitingQueue = waitingQueue;
        this.history = history;
    }

    /**
     * Starts the console menu and handles user interactions.
     * This method displays the main menu and processes user choices to navigate
     * through the waiting room and patient history functionalities.
     */
    public void start() {
        while (true) {
            System.out.println("\n *** Welcome to Patient Management System ***");
            System.out.println("1. Waiting Room");
            System.out.println("2. Patient History");
            System.out.println("3. Exit");

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> waitingRoomMenu();
                case 2 -> historyMenu();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Wrong option. Try again.");
            }
        }
    }

    /**
     * Displays the waiting room menu and
     * handles user interactions related to managing the patient queue.
     */
    private void waitingRoomMenu() {
        while (true) {
            System.out.println("\n*** Waiting Room Menu ***");
            System.out.println("1. Add patient");
            System.out.println("2. Serve next patient");
            System.out.println("3. Emergency add patient at position");
            System.out.println("4. Print queue");
            System.out.println("5. Back");

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> serveNextPatient();
                case 3 -> emergencyInsertFlow();
                case 4 -> printQueue();
                case 5 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    /**
     * Handles the flow for adding a new patient to the waiting queue.
     * It prompts the user for patient details
     * and adds the patient to the queue.
     */
    private void addPatient() {
        String name = readLine("Name: ");
        String reason = readLine("Reason for visit: ");

        Patient newPatient = waitingQueue.addPatientToQueue(new Patient(name, reason));
        System.out.println("\nPatient added to the queue.\n" + newPatient);
    }

    /**
     * Handles the flow for serving the next patient in the waiting queue.
     * It retrieves and removes the next patient from the queue
     * and displays their information.
     */
    private void serveNextPatient() {
        Patient served = waitingQueue.serveNext();
        if (served == null) {
            System.out.println("\nNo patients in the queue to serve.");
        } else {
            System.out.println("\nServing patient: " + served);
        }
    }

    /**
     * Handles the flow for inserting an emergency patient at a specific position in the waiting queue.
     * It prompts the user for patient details and the desired position, then attempts to insert the patient.
     */
    public void emergencyInsertFlow() {
        String name = readLine("Name: ");
        String reason = readLine("Reason for visit: ");

        int position = readInt("Insert patient from position 0 to " + waitingQueue.size() + ": ");

        Patient emergencyPatient = new Patient(name, reason);
        boolean inserted = waitingQueue.insertPatientAtPosition(emergencyPatient, position);

        while (!inserted) {
            System.out.println("\nInvalid position. Insert patient from position 0 to " + waitingQueue.size());
            position = readInt("Insert patient from position 0 to " + waitingQueue.size() + ": ");
            inserted = waitingQueue.insertPatientAtPosition(emergencyPatient, position);

            if  (inserted) {
                System.out.println("\nEmergency patient inserted at position " + position + ".");
            }
        }
    }

    /**
     * Prints the current state of the patient waiting queue.
     * If the queue is empty, it informs the user accordingly.
     */
    public void printQueue() {
        String queueState = waitingQueue.printAllPatientInQueue();
        if (queueState.isEmpty()) {
            System.out.println("\nThe waiting queue is currently empty.");
        } else {
            System.out.print("\nPatient Waiting Queue:\n" + queueState);
        }
    }

    /**
     * Displays the patient history menu and handles user interactions related to navigating through patient records.
     * It allows users to view the newest and oldest records, navigate to the next and previous records,
     * and view the current record.
     */
    private void historyMenu() {
        if (history.size == 0) {
            history.seedTenRecords();
        }

        while (true) {
            System.out.println("\n*** Patient History Menu ***");
            System.out.println("1. Show newest record");
            System.out.println("2. Show oldest record");
            System.out.println("3. Show next record");
            System.out.println("4. Show previous record");
            System.out.println("5. Show current record");
            System.out.println("6. Show all records");
            System.out.println("7. Show all records in reverse");
            System.out.println("8. Back");

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> {
                    PatientRecord newestRecord = history.navigateToNewestRecord();
                    if (newestRecord == null) {
                        System.out.println("\nNo records in history.");
                    } else {
                        System.out.println("\nNewest record:\n" + history.navigateToNewestRecord());
                    }
                }
                case 2 -> {
                    PatientRecord oldestRecord = history.navigateToOldestRecord();
                    if (oldestRecord == null) {
                        System.out.println("\nNo records in history.");
                    } else {
                        System.out.println("\nOldest record:\n" + history.navigateToOldestRecord());
                    }
                }
                case 3 -> {
                    PatientRecord nextRecord = history.navigateToNextRecord();

                    // nextRecord prevents passing tail by returning current record
                    if  (history.isAtNewest()) {
                        System.out.println("\nNo next record. This is the oldest record:\n" + nextRecord);
                    } else {
                        System.out.println("\nNext record:\n" + nextRecord);
                    }
                }
                case 4 -> {
                    PatientRecord previousRecord = history.navigateToPreviousRecord();

                    // previousRecord prevents passing head by returning current record
                    if (history.isAtOldest()) {
                        System.out.println("\nNo previous record. This is the newest record:\n" + previousRecord);
                    } else {
                        System.out.println("\nPrevious record:\n" + previousRecord);
                    }
                }
                case 5 -> {
                    PatientRecord previousRecord = history.getCurrentRecord();
                    if (previousRecord == null) {
                        System.out.println("\nNo current record:\n" + previousRecord);
                    } else {
                        System.out.println("\nCurrent record:\n" + previousRecord);
                    }
                }
                case 6 -> {
                    String currentRecord = history.patientRecordOldestToNewest();
                    if (currentRecord.isEmpty()) {
                        System.out.println("\nNo records in history.");
                    } else {
                        System.out.print("\nPatient Record from oldest to newest:\n" + currentRecord);
                    }
                }
                case 7 -> {
                    String reverseRecord = history.PatientRecordNewestToOldest();
                    if (reverseRecord.isEmpty()) {
                        System.out.println("\nNo records in history.");
                    } else {
                    System.out.print("\nPatient Record from newest to oldest:\n" + reverseRecord);
                    };
                }
                case 8 -> { return; }
                default -> System.out.println("\nInvalid option. Choose between 1 and 8.");
            }
        }
    }

    /**
     * Helper method to read an integer from the user with a prompt.
     * It handles invalid input and continues to prompt until a valid integer is entered.
     *
     * @param prompt the message to display to the user when asking for input
     * @return the integer value entered by the user
     */
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Helper method to read a line of text from the user with a prompt.
     *
     * @param prompt the message to display to the user when asking for input
     * @return the string entered by the user, trimmed of leading and trailing whitespace
     */
    private String readLine(String prompt) {
        try {
            System.out.print(prompt);
            return scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Error reading input. Please try again.");
            return readLine(prompt);
        }
    }
}