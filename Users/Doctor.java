package Users;

import ClinicPackage.Slot;
import java.io.Serializable;
import java.util.ArrayList;
import ClinicPackage.Clinic;

public class Doctor extends Staff implements Serializable {

    private static double totalRevenue = 0;
    private double revenue;
    private String specialization;
    private double fees;
    private final Slot[] assignedSlots;

//AOS: Amount of slots
    public Doctor(String specialization, int AOS, long SSN, String email, String password, String name, String DOB, String gender, double fees) {
        super(SSN, email, password, name, DOB, gender);
        this.specialization = specialization;
        this.assignedSlots = new Slot[AOS];
        this.fees = fees;
        this.revenue = 0;
    }

    public static int Login(String email, String password) {
        ArrayList<Doctor> AllDoctors = Clinic.AllDoctors;
        if (AllDoctors.isEmpty())
            return -1;
        else {
            for (int x = 0; x < AllDoctors.size(); x++) {
                if (AllDoctors.get(x).getEmail().equals(email))
                    if (AllDoctors.get(x).getPassword().equals(password))
                        return x; //It's used to get the correct object for the LOGIN
            }
            return -1; //Indicates "Invalid login"
        }
    }

    public static boolean isTaken(String email) {
        ArrayList<Doctor> AllDoctors = Clinic.AllDoctors;
        for (int x = 0; x < AllDoctors.size(); x++)
            if (email.equals(AllDoctors.get(x).getEmail()))
                return true;
        return false;
    }

    public void browseSchedule() {
        System.out.println("");
        for (int x = 0; x < assignedSlots.length; x++) {
            if (assignedSlots[x] != null)
                System.out.println("\nSlot number " + ((int) x + 1) + ":\n" + assignedSlots[x] + "\n");
            else
                System.out.println("Slot number " + ((int) x + 1) + ": Empty");
        }
    }

    public void increaseRevenue() { //Increases when a reservation is made
        revenue += fees;
        totalRevenue += fees;
    }

    public void decreaseRevenue() { //Decrease when a reservation is cancelled or changed
        revenue -= fees;
        totalRevenue -= fees;
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Slot[] getAssignedSlots() {
        return assignedSlots;
    }

    public void setSlot(Slot assignedSlot, int Index) { //Setter for "AssignedSlots", and "Update Schedule"
        if (this.assignedSlots[Index] != null)
            this.assignedSlots[Index].setAssignedTo(null);
        this.assignedSlots[Index] = assignedSlot;
        assignedSlot.setAssignedTo(this);
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void setTotalRevenue(double totalRevenue) {
        Doctor.totalRevenue = totalRevenue;
    }

}
