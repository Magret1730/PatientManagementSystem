package org.codewithmagret.history;

import org.codewithmagret.models.PatientRecord;

public class DoubleNode {
    PatientRecord patientRecord;
    DoubleNode next;
    DoubleNode previous;

    /**
     * Default constructor for DoubleNode. Required for JSON deserialization.
     */
    public DoubleNode() {}

    /**
     * Parameterized constructor for DoubleNode.
     *
     * @param patientRecord the PatientRecord object to be stored in the node
     */
    public DoubleNode(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
        this.next = null;
        this.previous = null;
    }
}
