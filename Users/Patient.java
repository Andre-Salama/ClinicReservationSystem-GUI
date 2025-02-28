package Users;

import ClinicPackage.Clinic;
import ClinicPackage.Reservation;
import ClinicPackage.Slot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient extends User implements Serializable {

    private static int id = 1; //Auto-generates the IDs
    private final int ID;
    private final ArrayList<Reservation> reservations;

    public Patient(String email, String password, String name, String DOB, String gender) {
        super(email, password, name, DOB, gender);
        reservations = new ArrayList<>();
        ID = id++;
    }

    public static int Login(String email, String password) {
        ArrayList<Patient> AllPatients = Clinic.AllPatients;
        if (AllPatients.isEmpty())
            return -1;
        else {
            for (int x = 0; x < AllPatients.size(); x++) {
                if (AllPatients.get(x).getEmail().equals(email))
                    if (AllPatients.get(x).getPassword().equals(password))
                        return x; //It's used to get the correct object for the LOGIN
            }
            return -1; //Indicates "Invalid login"
        }
    }

    public static boolean isTaken(String email) {
        for (int x = 0; x < Clinic.AllPatients.size(); x++)
            if (email.equals(Clinic.AllPatients.get(x).getEmail()))
                return true;
        return false;
    }

    public static void viewAvailableApp(javax.swing.JComboBox<String> DocCB,
            javax.swing.JList<String> SlotList,
            javax.swing.JComboBox<String> SpecsCB,
            javax.swing.JLabel Warning,
            HashMap<Integer, Integer> DocsHM,
            HashMap<Integer, Integer> SlotsHM, boolean isSpec) {
        if (isSpec) {
            DocsHM.clear();
            ArrayList<Doctor> temp = new ArrayList<>();
            int y = 0;
            String specChosen = (String) SpecsCB.getSelectedItem();
            for (int x = 0; x < Clinic.AllDoctors.size(); x++)
                if (Clinic.AllDoctors.get(x).getSpecialization().equals(specChosen)) {
                    temp.add(Clinic.AllDoctors.get(x));
                    DocsHM.put(y++, x);
                }
            String[] temp2 = new String[temp.size()];
            for (int x = 0; x < temp2.length; x++)
                temp2[x] = ("Dr." + temp.get(x).getName() + "-------> " + temp.get(x).getFees() + "L.E");
            DocCB.setModel(new javax.swing.DefaultComboBoxModel<>(temp2));
        }
        Doctor doctor = Clinic.AllDoctors.get(DocsHM.get(DocCB.getSelectedIndex()));
        ArrayList<String> slots1 = new ArrayList<>();
        int a = 1;
        for (Slot assignedSlot : doctor.getAssignedSlots()) {
            if (assignedSlot == null)
                continue;
            if (assignedSlot.getAvailability() == true) {
                slots1.add(a + ") " + assignedSlot);
                SlotsHM.put(a - 1, assignedSlot.getSID() - 1);
                a++;
            }
        }

        if (slots1.isEmpty()) {
            SlotList.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = {""};

                @Override
                public int getSize() {
                    return strings.length;
                }

                @Override
                public String getElementAt(int i) {
                    return strings[i];
                }
            });
            Warning.setVisible(true);
        }
        else {
            SlotList.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = slots1.toArray(new String[slots1.size()]);

                @Override
                public int getSize() {
                    return strings.length;
                }

                @Override
                public String getElementAt(int i) {
                    return strings[i];
                }
            });
            Warning.setVisible(false);
        }
    }

    public void bookApp(Slot slot) {
        reservations.add(new Reservation(ID, slot));
    }

    public void updateBooking(int A2U, Slot slot) { //A2D: Appointment to update
        reservations.get(A2U).getSlot().getAssignedTo().decreaseRevenue();
        reservations.get(A2U).setSlot(slot);
    }

    public void cancelBooking(int A2D) {
        reservations.get(A2D).getSlot().getAssignedTo().decreaseRevenue();
        reservations.get(A2D).getSlot().setAvailability(true);
        reservations.get(A2D).getSlot().setReservation(null);
        reservations.remove(A2D);
    }

    public void viewBookedApps(javax.swing.JList<String> resList) {
        ArrayList<String> res = new ArrayList<>();
        for (int x = 0; x < reservations.size(); x++) {
            res.add((x + 1) + ") " + reservations.get(x).getSlot().getAssignedTo().getSpecialization() + ", " + reservations.get(x));
        }
        resList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = res.toArray(new String[res.size()]);

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public int getID() {
        return ID;
    }

}
