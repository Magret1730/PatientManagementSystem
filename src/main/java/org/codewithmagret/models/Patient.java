package org.codewithmagret.models;

/**
 * Model class representing a Patient entity with id, name, and reason for visit.
 */
public class Patient {

    /**
     * Static counter to generate unique IDs for patients.
     */
    private static int idCounter = 1;

    /**
     * The ID of the patient.
     * This field is used to uniquely identify a patient in the system.
     */
    private String id;

    /**
     * The name of the patient.
     * This field is used to store the patient's full name.
     */
    private String name;

    /**
     * The reason for the patient's visit.
     * This field is used to store the reason why the patient is visiting the healthcare facility.
     */
    private String reasonForVisit;

    /**
     * Default constructor for Patient. Required for JSON deserialization.
     */
    public Patient() {}

    /**
     * Parameterized constructor for Patient.
     *
     * @param name the name of the patient
     * @param reasonForVisit the reason for the patient's visit
     */
    public Patient(String name, String reasonForVisit) {
        this.id = generateId();
        this.name = name;
        this.reasonForVisit = reasonForVisit;
    }

    /**
     * Getter for id
     * @return the ID of the patient
     */
    public String getId() { return id; }

    /**
     * Generates a unique ID for the patient using a static counter.
     *
     * @return a unique ID string for the patient
     */
    private String generateId() {
        return "P" + (idCounter++);
    }

    /**
     * Getter for name
     * @return the name of the patient
     */
    public String getName() { return name; }

    /**
     * Setter for name
     * @param name the name of the patient to set
     */
    public void setName(String name) { this.name = name; }

    /**
     * Getter for reasonForVisit
     * @return the reason for the patient's visit
     */
    public String getReasonForVisit() { return reasonForVisit; }

    /**
     * Setter for reasonForVisit
     * @param reasonForVisit the reason for the patient's visit to set
     */
    public void setReasonForVisit(String reasonForVisit) { this.reasonForVisit = reasonForVisit; }

    /**
     * Returns a string representation of the Patient object.
     *
     * @return a string containing the patient's ID, name, and reason for visit
     */
    @Override
    public String toString() {
        return "Patient { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reasonForVisit=" + reasonForVisit +
                '}';
    }
}
