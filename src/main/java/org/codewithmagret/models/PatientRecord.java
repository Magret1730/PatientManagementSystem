package org.codewithmagret.models;

import java.time.LocalDate;

/**
 * Model class representing a PatientRecord entity.
 */
public class PatientRecord {
    /**
     * The date of the patient's visit.
     * This field is used to store the date when the patient visited the healthcare facility.
     */
    String visitDate;

    /**
     * The diagnosis for the patient.
     * This field is used to store the diagnosis made by the healthcare provider
     * based on the patient's symptoms and examination.
     */
    String diagnosis;

    /**
     * Any treatment notes for the patient.
     * This field is used to store any notes related to the treatment provided to the patient,
     * including medications prescribed, procedures performed, and follow-up instructions.
     */
    String treatmentNotes;

    /**
     * Default constructor for PatientRecord. Required for JSON deserialization.
     */
    public PatientRecord() {}

    /**
     * Parameterized constructor for PatientRecord.
     *
     * @param visitDate the date of the patient's visit
     * @param diagnosis the diagnosis for the patient
     * @param treatmentNotes any treatment notes for the patient
     */
    public PatientRecord(String visitDate, String diagnosis, String treatmentNotes) {
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
    }

    /**
     * Getter for visitDate
     * @return the date of the patient's visit
     */
    public String getVisitDate() { return visitDate; }

    /**
     * Setter for visitDate
     * @param visitDate the date of the patient's visit to set
     */
    public void setVisitDate(String visitDate) { this.visitDate = visitDate;}

    /**
     * Getter for diagnosis
     * @return the diagnosis for the patient
     */
    public String getDiagnosis() { return diagnosis; }

    /**
     * Setter for diagnosis
     * @param diagnosis the diagnosis for the patient to set
     */
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    /**
     * Getter for treatmentNotes
     * @return any treatment notes for the patient
     */
    public String getTreatmentNotes() { return treatmentNotes; }

    /**
     * Setter for treatmentNotes
     * @param treatmentNotes any treatment notes for the patient to set
     */
    public void setTreatmentNotes(String treatmentNotes) { this.treatmentNotes = treatmentNotes;}

    /**
     * Override of the toString method for PatientRecord.
     * @return a string representation of the PatientRecord object
     */
    @Override
    public String toString() {
        return "PatientRecord { " +
                "visitDate=" + visitDate +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatmentNotes='" + treatmentNotes + '\'' +
                '}';
    }
}
