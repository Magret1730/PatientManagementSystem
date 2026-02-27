package org.codewithmagret.waitingRoom;

import org.codewithmagret.models.Patient;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Class representing a patient waiting queue using a LinkedList to manage patients.
 */
public class PatientWaitingQueue {
    /**
     * The LinkedList to store the patients in the waiting queue.
     * This list allows for efficient addition and removal of patients
     * from the queue, as well as insertion at specific positions when necessary.
     */
    private final LinkedList<Patient> patientList = new LinkedList<Patient>();

    /**
     * Adds a patient to the waiting queue.
     *
     * @param patient the Patient object to be added to the queue
     * @return the Patient object that was added to the queue
     */
    public Patient addPatientToQueue(Patient patient) {
        patientList.add(patient);

        return patient;
    }

    /**
     * Checks if the waiting queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return patientList.isEmpty();
    }

    /**
     * Serves the next patient in the waiting queue.
     *
     * @return the Patient object that was served, or null if the queue is empty
     */
    public Patient serveNext() {
        if (isEmpty()) {
            return null;
        }

        return patientList.removeFirst();
    }

    /**
     * Inserts a patient at a specific position in the waiting queue.
     *
     * @param patient  the Patient object to be inserted into the queue
     * @param position the position at which to insert the patient (0-based index)
     * @return the Patient object that was inserted into the queue
     * @throws IllegalArgumentException if the position is out of bounds
     */
    public boolean insertPatientAtPosition(Patient patient, int position) {
        if (position < 0 || position > patientList.size()) {
            return false;
        }

        patientList.add(position, patient);
        return true;
    }

    /**
     * Prints the current state of the patient waiting queue.
     *
     * @return a string representation of the patient waiting queue
     */
    public String printAllPatientInQueue() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient Waiting Queue:\n");
        for (Patient patient : patientList) {
            sb.append(patient.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Method to get the size of the patient waiting queue.
     * Returns the number of patients currently in the waiting queue.
     */
    public int size() {
        return patientList.size();
    }
}

