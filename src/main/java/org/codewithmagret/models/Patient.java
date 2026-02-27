package org.codewithmagret.models;

/**
 * Model class representing a Patient entity with id, name, and reason for visit.
 */
public class Patient {
    /**
     * The ID of the patient.
     * This field is used to uniquely identify a patient in the system.
     */
    private Long id;

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
     * @param id the ID of the patient
     * @param name the name of the patient
     * @param reasonForVisit the reason for the patient's visit
     */
    public Patient(Long id, String name, String reasonForVisit) {
        this.id = id;
        this.name = name;
        this.reasonForVisit = reasonForVisit;
    }

    /**
     * Getter for id
     * @return the ID of the patient
     */
    public Long getId() { return id; }

    /**
     * Setter for id
     * @param id the ID of the patient to set
     */
    public void setId(Long id) { this.id = id; }

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
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reasonForVisit=" + reasonForVisit +
                '}';
    }
}
