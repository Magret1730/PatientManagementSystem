package org.codewithmagret.history;

import org.codewithmagret.models.Patient;
import org.codewithmagret.models.PatientRecord;
import java.time.LocalDate;
import java.util.List;

/**
 * Patient History System using a Doubly Linked List.
 *
 * Requirements covered:
 * - Include at least 10 patient history records (seedTenRecords)
 * - Navigate next / previous from a current position
 * - Display newest (tail) and oldest (head)
 * - Prevent navigation past head or tail
 */

/**
 * Class representing a list of patient history records. This class can be used to store and manage
 * the history of patients, including their visits, treatments, and other relevant information.
 */
public class PatientHistoryList {
    public DoubleNode head;
    public DoubleNode tail;
    public int size;
    public DoubleNode current;

    /**
     * Default constructor for PatientHistoryList. Required for JSON deserialization.
     */
    public PatientHistoryList() {}

    /**
     * Returns the number of patient records in the history list.
     * @return the size of the patient history list
     */
    public int size() {
        return size;
    }

    /**
     * Creates a new double linked list with a single node containing the specified value.
     *
     * @param patientRecord the PatientRecord object to be stored in the first node of the linked list
     * @return the head of the newly created linked list
     */
    public void createLinkedList (PatientRecord patientRecord) {
        DoubleNode node = new DoubleNode();
        node.patientRecord = patientRecord;
        node.next = null;
        node.previous = null;

        head = node;
        tail = node;
        current = node;
        size = 1;
    }

    /**
     * Adds a patient record to the history list at a specific location.
     *
     * @param patientRecord the PatientRecord object to be added to the history list
     * @param location the position at which to insert the patient record (0-based index)
     */
    public void addToPatientRecord(PatientRecord patientRecord, int location) {
        if (patientRecord == null) {
            throw new IllegalArgumentException("patientRecord must not be null");
        }

        if (head == null) {
            createLinkedList(patientRecord);
            return;
        }

        DoubleNode node = new DoubleNode();
        node.patientRecord = patientRecord;

        // If location is less than or equal to 0, insert at the head of the list
        if (location <= 0) {
            node.next = head;
            node.previous = null;

            head.previous = node;
            head = node;

            size++;
            return;
        }

        // If location is greater than or equal to the size of the list, insert at the tail of the list
        if (location >= size) {
            node.next = null;
            node.previous = tail;

            tail.next = node;
            tail = node;

            size++;
            return;
        }

        DoubleNode tempNode = head;
        int index = 0;
        // Takes the node to its position before the location where the new node will be inserted
        while (index < location - 1) {
            tempNode = tempNode.next;
            index++;
        }
        DoubleNode nextNode = tempNode.next;

        node.previous = tempNode;
        node.next = nextNode;

        tempNode.next = node;
        nextNode.previous = node;

        size++;
    }

    /**
     * Displays the patient records in the history list from head to tail.
     *
     * @return a string representation of the patient history list,
     *          showing the records from oldest to newest
     */
    public String nextPatientRecord (){
        StringBuilder sb = new StringBuilder();
        sb.append("Patient History List: (Oldest -> Newest):\n");

        if (head == null) {
            sb.append("(Empty PatientRecord)\n");
            return sb.toString();
        }

        DoubleNode tempNode = head;
        for (int i = 0; i < size; i++){
            sb.append(tempNode.patientRecord);
            if (i != size - 1){
                sb.append(" <-> ");
            }
            tempNode = tempNode.next;
        }
        sb.append("\n");

        return sb.toString();
    }

    /**
     * Displays the patient records in the history list from tail to head.
     *
     * @return a string representation of the patient history list,
     */
    public String reversePatientRecord (){
        StringBuilder sb = new StringBuilder();
        sb.append("Patient History List: (Newest -> Oldest):\n");

        if (head == null) {
            sb.append("(Empty PatientRecord)\n");
            return sb.toString();
        }

        DoubleNode tempNode = tail;
        for (int i = 0; i < size; i++){
            sb.append(tempNode.patientRecord);
            if (i != size - 1){
                sb.append(" <-> ");
            }
            tempNode = tempNode.previous;
        }
        sb.append("\n");

        return sb.toString();
    }

    /**
     * Displays the newest patient record in the history list (the tail).
     *
     * @return the newest PatientRecord object in the history list, or null if the list is empty
     */
    public PatientRecord navigateToNewestRecord() {
        if (tail == null) {
            return null;
        }
        current = tail;
        return current.patientRecord;
    }

    /**
     * Displays the oldest patient record in the history list (the head).
     *
     * @return the oldest PatientRecord object in the history list, or null if the list is empty
     */
    public PatientRecord navigateToOldestRecord() {
        if (head == null) {
            return null;
        }
        current = head;
        return current.patientRecord;
    }

    /**
     * Navigates to the next patient record in the history list.
     *
     * @return the next PatientRecord object in the history list, or null if there is no next record
     */
    public PatientRecord navigateToNextRecord() {
        if (current == null) {
            return null;
        }

        if (current.next == null) {
            return current.patientRecord;
        }

        current = current.next;
        return current.patientRecord;
    }

    /**
     * Navigates to the previous patient record in the history list.
     *
     * @return the previous PatientRecord object in the history list, or null if there is no previous record
     */
    public PatientRecord navigateToPreviousRecord() {
        if (current == null) {
            return null;
        }

        if (current.previous == null) {
            return current.patientRecord;
        }

        current = current.previous;
        return current.patientRecord;
    }

    /**
     * Requirement: include at least 10 records.
     * Call this in Main or when starting the history menu.
     */
    public void seedTenRecords() {
        addToPatientRecord(new PatientRecord("2026-01-01", "Flu", "Rest, hydration"), size);
        addToPatientRecord(new PatientRecord("2026-01-03", "Sprain", "Ice, wrap, elevate"), size);
        addToPatientRecord(new PatientRecord("2026-01-06", "Migraine", "Pain relief + rest"), size);
        addToPatientRecord(new PatientRecord("2026-01-10", "Allergy", "Antihistamine"), size);
        addToPatientRecord(new PatientRecord("2026-01-14", "Sore throat", "Supportive care"), size);
        addToPatientRecord(new PatientRecord("2026-01-18", "Back pain", "Stretching plan"), size);
        addToPatientRecord(new PatientRecord("2026-01-22", "Checkup", "Vitals normal"), size);
        addToPatientRecord(new PatientRecord("2026-01-26", "Stomach bug", "Fluids + rest"), size);
        addToPatientRecord(new PatientRecord("2026-02-02", "Skin rash", "Topical cream"), size);
        addToPatientRecord(new PatientRecord("2026-02-10", "Follow-up", "Improving"), size);

//        navigateToNewestRecord();
    }
}
