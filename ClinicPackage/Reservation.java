package ClinicPackage;

import java.io.Serializable;

public class Reservation implements Serializable {

    private static int id = 1; // Used for auto-generated IDs
    private final int RID; //Reservation ID
    private final int PID; //Patient ID
    private Slot slot;

    public Reservation(int PID, Slot slot) { //Reserve slot
        this.slot = slot;
        this.PID = PID;
        RID = id++;
        slot.setAvailability(false);
        slot.getAssignedTo().increaseRevenue();
        slot.setReservation(this);
    }

    /*------------------------------------
    toString
    &
    equals
    ---------------------------------------*/
    @Override
    public String toString() {
        return slot.getDay() + " " + slot.getTime() + " PM, room " + slot.getRoom() + " with Dr." + slot.getAssignedTo().getName() + " for " + slot.getAssignedTo().getFees() + "L.E";
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public int getRID() {
        return RID;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot.setAvailability(true);
        this.slot.setReservation(null);
        this.slot = slot;
        slot.getAssignedTo().increaseRevenue();
    }

    public int getPID() {
        return PID;
    }
}
