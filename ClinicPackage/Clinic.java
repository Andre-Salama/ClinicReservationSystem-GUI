package ClinicPackage;

import Users.Patient;
import Users.Doctor;
import Users.Admin;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;

public abstract class Clinic {

    public static ArrayList<Patient> AllPatients = new ArrayList<>();
    public static ArrayList<Doctor> AllDoctors = new ArrayList<>();
    public static ArrayList<Admin> AllAdmins = new ArrayList<>();
    public static ArrayList<Supply> AllRequestedSupplies = new ArrayList<>();
    public static Slot[] AllSlots = Slot.initializeAllSlots();
    public static String[][] MedicalSupplies = {
        {"Dermatoscopy", "Dermal biopsy punches", "Dermal curettes"},
        {"Dental drill", "Dental syringe", "Dental probe"},
        {"Tonometer", "Phoropter", "Autorefractor"}
    };
    public static String[] Specializations = {"Dermatology", "Dentistry", "Optometrist"};

    /*
    Saves everything to files from arrays
     */
    public static void saveEverything() {
        saveAdata();
        saveDdata();
        savePdata();
        saveSdata();
    }

    /*
    Loads all the data from the files
     */
    public static void loadEverything() {
        loadAdata();
        loadDdata();
        loadPdata();
        loadSdata();
    }

    /*
    Saves to files from arrays
     */
    public static void savePdata() {
        try {
            FileOutputStream aFile = new FileOutputStream("Patients Data.txt");
            ObjectOutputStream OOF = new ObjectOutputStream(aFile);
            OOF.writeObject(AllPatients);
            OOF.close();
            aFile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveDdata() {
        try {
            FileOutputStream aFile = new FileOutputStream("Doctors Data.txt");
            ObjectOutputStream OOF = new ObjectOutputStream(aFile);
            OOF.writeObject(AllDoctors);
            OOF.close();
            aFile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveAdata() {
        try {
            FileOutputStream aFile = new FileOutputStream("Admins Data.txt");
            ObjectOutputStream OOF = new ObjectOutputStream(aFile);
            OOF.writeObject(AllAdmins);
            OOF.close();
            aFile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveSdata() {
        try {
            FileOutputStream aFile = new FileOutputStream("Requested supplies Data.txt");
            ObjectOutputStream OOF = new ObjectOutputStream(aFile);
            OOF.writeObject(AllRequestedSupplies);
            OOF.close();
            aFile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
   Retrieve from files into arrays
     */
    public static void loadPdata() {
        try {
            FileInputStream aFile = new FileInputStream("Patients Data.txt");
            ObjectInputStream OIF = new ObjectInputStream(aFile);
            AllPatients = (ArrayList<Patient>) OIF.readObject();
            OIF.close();
            aFile.close();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            if (e instanceof EOFException)
                AllPatients = new ArrayList<>();
            else
                e.printStackTrace();
        }
    }

    public static void loadDdata() {
        try {
            FileInputStream aFile = new FileInputStream("Doctors Data.txt");
            ObjectInputStream OIF = new ObjectInputStream(aFile);
            AllDoctors = (ArrayList<Doctor>) OIF.readObject();
            OIF.close();
            aFile.close();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            if (e instanceof EOFException)
                AllDoctors = new ArrayList<>();
            else
                e.printStackTrace();
        }
    }

    public static void loadAdata() {
        try {
            FileInputStream aFile = new FileInputStream("Admins Data.txt");
            ObjectInputStream OIF = new ObjectInputStream(aFile);
            AllAdmins = (ArrayList<Admin>) OIF.readObject();
            OIF.close();
            aFile.close();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            if (e instanceof EOFException)
                AllAdmins = new ArrayList<>();
            else
                e.printStackTrace();
        }
    }

    public static void loadSdata() {
        try {
            FileInputStream aFile = new FileInputStream("Requested supplies Data.txt");
            ObjectInputStream OIF = new ObjectInputStream(aFile);
            AllRequestedSupplies = (ArrayList<Supply>) OIF.readObject();
            OIF.close();
            aFile.close();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            if (e instanceof EOFException)
                AllRequestedSupplies = new ArrayList<>();
            else
                e.printStackTrace();
        }
    }

//This function is only used by the devs, it's not intended to be used for anything other than testing
//This function clears all the data from the files
    private static void clearAllData() {
        try {
            FileOutputStream aFile1 = new FileOutputStream("Patients Data.txt");
            FileOutputStream aFile2 = new FileOutputStream("Doctors Data.txt");
            FileOutputStream aFile3 = new FileOutputStream("Admins Data.txt");
            FileOutputStream aFile4 = new FileOutputStream("Requested supplies Data.txt");
            aFile1.close();
            aFile2.close();
            aFile3.close();
            aFile4.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
