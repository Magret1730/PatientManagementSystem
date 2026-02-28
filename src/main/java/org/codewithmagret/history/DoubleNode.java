package org.codewithmagret.history;

import org.codewithmagret.models.PatientRecord;

public class DoubleNode {
    /**
     * The PatientRecord object stored in this node.
     * This field is used to hold the patient record data
     * associated with this node in the double linked list.
     */
    PatientRecord patientRecord;

    /**
     * The next node in the double linked list.
     * This field is used to reference the next node in the list,
     * allowing for traversal in the forward direction.
     */
    DoubleNode next;

    /**
     * The previous node in the double linked list.
     * This field is used to reference the previous node in the list,
     * allowing for traversal in the backward direction.
     */
    DoubleNode previous;

    /**
     * Default constructor for DoubleNode.
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
