package org.codewithmagret.models;

/**
 * Model class representing a Patient entity with id, name, and reason for visit.
 */
public class Patient {
    private Long id;
    private String name;
    private int reasonForVisit;

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
    public Patient(Long id, String name, int reasonForVisit) {
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
    public int getReasonForVisit() { return reasonForVisit; }

    /**
     * Setter for reasonForVisit
     * @param reasonForVisit the reason for the patient's visit to set
     */
    public void setReasonForVisit(int reasonForVisit) { this.reasonForVisit = reasonForVisit; }

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
