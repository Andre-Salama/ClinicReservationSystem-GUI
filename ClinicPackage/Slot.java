package ClinicPackage;

import Users.Doctor;
import java.io.Serializable;

public class Slot implements Serializable {

    private static int id = 1; //Auto generate
    private final int SID; //Slot ID
    private final String day;
    private final int room;
    private final String time;
    private boolean availability;
    private Reservation reservation;
    private Doctor assignedTo;

    public Slot(String day, int room, String time) {
        this.SID = id++;
        this.day = day;
        this.room = room;
        this.time = time;
        availability = true;
        reservation = null;
        assignedTo = null;
    }

    public static void viewAvailableApp(Slot[] AllSlots) {
        for (Slot AllSlot : AllSlots)
            if (AllSlot.getAssignedTo() == null)
                System.out.println("\n" + AllSlot + "\n");
    }

    /*------------------------------------
    toString
    &
    equals
    ---------------------------------------*/
    @Override
    public String toString() {
        if (assignedTo == null)
            return "\nSID: " + SID + "\nDate: " + day + "\nRoom: " + room + "\nTime: " + time;
        else if (reservation != null)
            return day + " " + time + " PM, room " + room + ": RID " + reservation.getRID() + ", PID " + reservation.getPID();
        return day + " " + time + " PM, room " + room;
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public String getDay() {
        return day;
    }

    public int getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getSID() {
        return SID;
    }

    public Doctor getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Doctor assignedTo) {
        this.assignedTo = assignedTo;
    }

    public static Slot[] initializeAllSlots() {
        Slot AllSlots[] = new Slot[273];
        AllSlots[0] = new Slot("Sunday", 1, "12");
        AllSlots[1] = new Slot("Sunday", 2, "12");
        AllSlots[2] = new Slot("Sunday", 3, "12");
        AllSlots[3] = new Slot("Sunday", 1, "12:30");
        AllSlots[4] = new Slot("Sunday", 2, "12:30");
        AllSlots[5] = new Slot("Sunday", 3, "12:30");
        AllSlots[6] = new Slot("Sunday", 1, "1");
        AllSlots[7] = new Slot("Sunday", 2, "1");
        AllSlots[8] = new Slot("Sunday", 3, "1");
        AllSlots[9] = new Slot("Sunday", 1, "1:30");
        AllSlots[10] = new Slot("Sunday", 2, "1:30");
        AllSlots[11] = new Slot("Sunday", 3, "1:30");
        AllSlots[12] = new Slot("Sunday", 1, "2");
        AllSlots[13] = new Slot("Sunday", 2, "2");
        AllSlots[14] = new Slot("Sunday", 3, "2");
        AllSlots[15] = new Slot("Sunday", 1, "2:30");
        AllSlots[16] = new Slot("Sunday", 2, "2:30");
        AllSlots[17] = new Slot("Sunday", 3, "2:30");
        AllSlots[18] = new Slot("Sunday", 3, "3");
        AllSlots[19] = new Slot("Sunday", 3, "3");
        AllSlots[20] = new Slot("Sunday", 3, "3");
        AllSlots[21] = new Slot("Sunday", 1, "3:30");
        AllSlots[22] = new Slot("Sunday", 2, "3:30");
        AllSlots[23] = new Slot("Sunday", 3, "3:30");
        AllSlots[24] = new Slot("Sunday", 1, "4");
        AllSlots[25] = new Slot("Sunday", 2, "4");
        AllSlots[26] = new Slot("Sunday", 3, "4");
        AllSlots[27] = new Slot("Sunday", 1, "4:30");
        AllSlots[28] = new Slot("Sunday", 2, "4:30");
        AllSlots[29] = new Slot("Sunday", 3, "4:30");
        AllSlots[30] = new Slot("Sunday", 1, "5");
        AllSlots[31] = new Slot("Sunday", 2, "5");
        AllSlots[32] = new Slot("Sunday", 3, "5");
        AllSlots[33] = new Slot("Sunday", 1, "5:30");
        AllSlots[34] = new Slot("Sunday", 2, "5:30");
        AllSlots[35] = new Slot("Sunday", 3, "5:30");
        AllSlots[36] = new Slot("Sunday", 1, "6");
        AllSlots[37] = new Slot("Sunday", 2, "6");
        AllSlots[38] = new Slot("Sunday", 3, "6");

        AllSlots[39] = new Slot("Monday", 1, "12");
        AllSlots[40] = new Slot("Monday", 2, "12");
        AllSlots[41] = new Slot("Monday", 3, "12");
        AllSlots[42] = new Slot("Monday", 1, "12:30");
        AllSlots[43] = new Slot("Monday", 2, "12:30");
        AllSlots[44] = new Slot("Monday", 3, "12:30");
        AllSlots[45] = new Slot("Monday", 1, "1");
        AllSlots[46] = new Slot("Monday", 2, "1");
        AllSlots[47] = new Slot("Monday", 3, "1");
        AllSlots[48] = new Slot("Monday", 1, "1:30");
        AllSlots[49] = new Slot("Monday", 2, "1:30");
        AllSlots[50] = new Slot("Monday", 3, "1:30");
        AllSlots[51] = new Slot("Monday", 1, "2");
        AllSlots[52] = new Slot("Monday", 2, "2");
        AllSlots[53] = new Slot("Monday", 3, "2");
        AllSlots[54] = new Slot("Monday", 1, "2:30");
        AllSlots[55] = new Slot("Monday", 2, "2:30");
        AllSlots[56] = new Slot("Monday", 3, "2:30");
        AllSlots[57] = new Slot("Monday", 3, "3");
        AllSlots[58] = new Slot("Monday", 3, "3");
        AllSlots[59] = new Slot("Monday", 3, "3");
        AllSlots[60] = new Slot("Monday", 1, "3:30");
        AllSlots[61] = new Slot("Monday", 2, "3:30");
        AllSlots[62] = new Slot("Monday", 3, "3:30");
        AllSlots[63] = new Slot("Monday", 1, "4");
        AllSlots[64] = new Slot("Monday", 2, "4");
        AllSlots[65] = new Slot("Monday", 3, "4");
        AllSlots[66] = new Slot("Monday", 1, "4:30");
        AllSlots[67] = new Slot("Monday", 2, "4:30");
        AllSlots[68] = new Slot("Monday", 3, "4:30");
        AllSlots[69] = new Slot("Monday", 1, "5");
        AllSlots[70] = new Slot("Monday", 2, "5");
        AllSlots[71] = new Slot("Monday", 3, "5");
        AllSlots[72] = new Slot("Monday", 1, "5:30");
        AllSlots[73] = new Slot("Monday", 2, "5:30");
        AllSlots[74] = new Slot("Monday", 3, "5:30");
        AllSlots[75] = new Slot("Monday", 1, "6");
        AllSlots[76] = new Slot("Monday", 2, "6");
        AllSlots[77] = new Slot("Monday", 3, "6");

        AllSlots[78] = new Slot("Tuesday", 1, "12");
        AllSlots[79] = new Slot("Tuesday", 2, "12");
        AllSlots[80] = new Slot("Tuesday", 3, "12");
        AllSlots[81] = new Slot("Tuesday", 1, "12:30");
        AllSlots[82] = new Slot("Tuesday", 2, "12:30");
        AllSlots[83] = new Slot("Tuesday", 3, "12:30");
        AllSlots[84] = new Slot("Tuesday", 1, "1");
        AllSlots[85] = new Slot("Tuesday", 2, "1");
        AllSlots[86] = new Slot("Tuesday", 3, "1");
        AllSlots[87] = new Slot("Tuesday", 1, "1:30");
        AllSlots[88] = new Slot("Tuesday", 2, "1:30");
        AllSlots[89] = new Slot("Tuesday", 3, "1:30");
        AllSlots[90] = new Slot("Tuesday", 1, "2");
        AllSlots[91] = new Slot("Tuesday", 2, "2");
        AllSlots[92] = new Slot("Tuesday", 3, "2");
        AllSlots[93] = new Slot("Tuesday", 1, "2:30");
        AllSlots[94] = new Slot("Tuesday", 2, "2:30");
        AllSlots[95] = new Slot("Tuesday", 3, "2:30");
        AllSlots[96] = new Slot("Tuesday", 3, "3");
        AllSlots[97] = new Slot("Tuesday", 3, "3");
        AllSlots[98] = new Slot("Tuesday", 3, "3");
        AllSlots[99] = new Slot("Tuesday", 1, "3:30");
        AllSlots[100] = new Slot("Tuesday", 2, "3:30");
        AllSlots[101] = new Slot("Tuesday", 3, "3:30");
        AllSlots[102] = new Slot("Tuesday", 1, "4");
        AllSlots[103] = new Slot("Tuesday", 2, "4");
        AllSlots[104] = new Slot("Tuesday", 3, "4");
        AllSlots[105] = new Slot("Tuesday", 1, "4:30");
        AllSlots[106] = new Slot("Tuesday", 2, "4:30");
        AllSlots[107] = new Slot("Tuesday", 3, "4:30");
        AllSlots[108] = new Slot("Tuesday", 1, "5");
        AllSlots[109] = new Slot("Tuesday", 2, "5");
        AllSlots[110] = new Slot("Tuesday", 3, "5");
        AllSlots[111] = new Slot("Tuesday", 1, "5:30");
        AllSlots[112] = new Slot("Tuesday", 2, "5:30");
        AllSlots[113] = new Slot("Tuesday", 3, "5:30");
        AllSlots[114] = new Slot("Tuesday", 1, "6");
        AllSlots[115] = new Slot("Tuesday", 2, "6");
        AllSlots[116] = new Slot("Tuesday", 3, "6");

        AllSlots[117] = new Slot("Wednesday", 1, "12");
        AllSlots[118] = new Slot("Wednesday", 2, "12");
        AllSlots[119] = new Slot("Wednesday", 3, "12");
        AllSlots[120] = new Slot("Wednesday", 1, "12:30");
        AllSlots[121] = new Slot("Wednesday", 2, "12:30");
        AllSlots[122] = new Slot("Wednesday", 3, "12:30");
        AllSlots[123] = new Slot("Wednesday", 1, "1");
        AllSlots[124] = new Slot("Wednesday", 2, "1");
        AllSlots[125] = new Slot("Wednesday", 3, "1");
        AllSlots[126] = new Slot("Wednesday", 1, "1:30");
        AllSlots[127] = new Slot("Wednesday", 2, "1:30");
        AllSlots[128] = new Slot("Wednesday", 3, "1:30");
        AllSlots[129] = new Slot("Wednesday", 1, "2");
        AllSlots[130] = new Slot("Wednesday", 2, "2");
        AllSlots[131] = new Slot("Wednesday", 3, "2");
        AllSlots[132] = new Slot("Wednesday", 1, "2:30");
        AllSlots[133] = new Slot("Wednesday", 2, "2:30");
        AllSlots[134] = new Slot("Wednesday", 3, "2:30");
        AllSlots[135] = new Slot("Wednesday", 3, "3");
        AllSlots[136] = new Slot("Wednesday", 3, "3");
        AllSlots[137] = new Slot("Wednesday", 3, "3");
        AllSlots[138] = new Slot("Wednesday", 1, "3:30");
        AllSlots[139] = new Slot("Wednesday", 2, "3:30");
        AllSlots[140] = new Slot("Wednesday", 3, "3:30");
        AllSlots[141] = new Slot("Wednesday", 1, "4");
        AllSlots[142] = new Slot("Wednesday", 2, "4");
        AllSlots[143] = new Slot("Wednesday", 3, "4");
        AllSlots[144] = new Slot("Wednesday", 1, "4:30");
        AllSlots[145] = new Slot("Wednesday", 2, "4:30");
        AllSlots[146] = new Slot("Wednesday", 3, "4:30");
        AllSlots[147] = new Slot("Wednesday", 1, "5");
        AllSlots[148] = new Slot("Wednesday", 2, "5");
        AllSlots[149] = new Slot("Wednesday", 3, "5");
        AllSlots[150] = new Slot("Wednesday", 1, "5:30");
        AllSlots[151] = new Slot("Wednesday", 2, "5:30");
        AllSlots[152] = new Slot("Wednesday", 3, "5:30");
        AllSlots[153] = new Slot("Wednesday", 1, "6");
        AllSlots[154] = new Slot("Wednesday", 2, "6");
        AllSlots[155] = new Slot("Wednesday", 3, "6");

        AllSlots[156] = new Slot("Thursday", 1, "12");
        AllSlots[157] = new Slot("Thursday", 2, "12");
        AllSlots[158] = new Slot("Thursday", 3, "12");
        AllSlots[159] = new Slot("Thursday", 1, "12:30");
        AllSlots[160] = new Slot("Thursday", 2, "12:30");
        AllSlots[161] = new Slot("Thursday", 3, "12:30");
        AllSlots[162] = new Slot("Thursday", 1, "1");
        AllSlots[163] = new Slot("Thursday", 2, "1");
        AllSlots[164] = new Slot("Thursday", 3, "1");
        AllSlots[165] = new Slot("Thursday", 1, "1:30");
        AllSlots[166] = new Slot("Thursday", 2, "1:30");
        AllSlots[167] = new Slot("Thursday", 3, "1:30");
        AllSlots[168] = new Slot("Thursday", 1, "2");
        AllSlots[169] = new Slot("Thursday", 2, "2");
        AllSlots[170] = new Slot("Thursday", 3, "2");
        AllSlots[171] = new Slot("Thursday", 1, "2:30");
        AllSlots[172] = new Slot("Thursday", 2, "2:30");
        AllSlots[173] = new Slot("Thursday", 3, "2:30");
        AllSlots[174] = new Slot("Thursday", 3, "3");
        AllSlots[175] = new Slot("Thursday", 3, "3");
        AllSlots[176] = new Slot("Thursday", 3, "3");
        AllSlots[177] = new Slot("Thursday", 1, "3:30");
        AllSlots[178] = new Slot("Thursday", 2, "3:30");
        AllSlots[179] = new Slot("Thursday", 3, "3:30");
        AllSlots[180] = new Slot("Thursday", 1, "4");
        AllSlots[181] = new Slot("Thursday", 2, "4");
        AllSlots[182] = new Slot("Thursday", 3, "4");
        AllSlots[183] = new Slot("Thursday", 1, "4:30");
        AllSlots[184] = new Slot("Thursday", 2, "4:30");
        AllSlots[185] = new Slot("Thursday", 3, "4:30");
        AllSlots[186] = new Slot("Thursday", 1, "5");
        AllSlots[187] = new Slot("Thursday", 2, "5");
        AllSlots[188] = new Slot("Thursday", 3, "5");
        AllSlots[189] = new Slot("Thursday", 1, "5:30");
        AllSlots[190] = new Slot("Thursday", 2, "5:30");
        AllSlots[191] = new Slot("Thursday", 3, "5:30");
        AllSlots[192] = new Slot("Thursday", 1, "6");
        AllSlots[193] = new Slot("Thursday", 2, "6");
        AllSlots[194] = new Slot("Thursday", 3, "6");

        AllSlots[195] = new Slot("Friday", 1, "12");
        AllSlots[196] = new Slot("Friday", 2, "12");
        AllSlots[197] = new Slot("Friday", 3, "12");
        AllSlots[198] = new Slot("Friday", 1, "12:30");
        AllSlots[199] = new Slot("Friday", 2, "12:30");
        AllSlots[200] = new Slot("Friday", 3, "12:30");
        AllSlots[201] = new Slot("Friday", 1, "1");
        AllSlots[202] = new Slot("Friday", 2, "1");
        AllSlots[203] = new Slot("Friday", 3, "1");
        AllSlots[204] = new Slot("Friday", 1, "1:30");
        AllSlots[205] = new Slot("Friday", 2, "1:30");
        AllSlots[206] = new Slot("Friday", 3, "1:30");
        AllSlots[207] = new Slot("Friday", 1, "2");
        AllSlots[208] = new Slot("Friday", 2, "2");
        AllSlots[209] = new Slot("Friday", 3, "2");
        AllSlots[210] = new Slot("Friday", 1, "2:30");
        AllSlots[211] = new Slot("Friday", 2, "2:30");
        AllSlots[212] = new Slot("Friday", 3, "2:30");
        AllSlots[213] = new Slot("Friday", 3, "3");
        AllSlots[214] = new Slot("Friday", 3, "3");
        AllSlots[215] = new Slot("Friday", 3, "3");
        AllSlots[216] = new Slot("Friday", 1, "3:30");
        AllSlots[217] = new Slot("Friday", 2, "3:30");
        AllSlots[218] = new Slot("Friday", 3, "3:30");
        AllSlots[219] = new Slot("Friday", 1, "4");
        AllSlots[220] = new Slot("Friday", 2, "4");
        AllSlots[221] = new Slot("Friday", 3, "4");
        AllSlots[222] = new Slot("Friday", 1, "4:30");
        AllSlots[223] = new Slot("Friday", 2, "4:30");
        AllSlots[224] = new Slot("Friday", 3, "4:30");
        AllSlots[225] = new Slot("Friday", 1, "5");
        AllSlots[226] = new Slot("Friday", 2, "5");
        AllSlots[227] = new Slot("Friday", 3, "5");
        AllSlots[228] = new Slot("Friday", 1, "5:30");
        AllSlots[229] = new Slot("Friday", 2, "5:30");
        AllSlots[230] = new Slot("Friday", 3, "5:30");
        AllSlots[231] = new Slot("Friday", 1, "6");
        AllSlots[232] = new Slot("Friday", 2, "6");
        AllSlots[233] = new Slot("Friday", 3, "6");

        AllSlots[234] = new Slot("Saturday", 1, "12");
        AllSlots[235] = new Slot("Saturday", 2, "12");
        AllSlots[236] = new Slot("Saturday", 3, "12");
        AllSlots[237] = new Slot("Saturday", 1, "12:30");
        AllSlots[238] = new Slot("Saturday", 2, "12:30");
        AllSlots[239] = new Slot("Saturday", 3, "12:30");
        AllSlots[240] = new Slot("Saturday", 1, "1");
        AllSlots[241] = new Slot("Saturday", 2, "1");
        AllSlots[242] = new Slot("Saturday", 3, "1");
        AllSlots[243] = new Slot("Saturday", 1, "1:30");
        AllSlots[244] = new Slot("Saturday", 2, "1:30");
        AllSlots[245] = new Slot("Saturday", 3, "1:30");
        AllSlots[246] = new Slot("Saturday", 1, "2");
        AllSlots[247] = new Slot("Saturday", 2, "2");
        AllSlots[248] = new Slot("Saturday", 3, "2");
        AllSlots[249] = new Slot("Saturday", 1, "2:30");
        AllSlots[250] = new Slot("Saturday", 2, "2:30");
        AllSlots[251] = new Slot("Saturday", 3, "2:30");
        AllSlots[252] = new Slot("Saturday", 3, "3");
        AllSlots[253] = new Slot("Saturday", 3, "3");
        AllSlots[254] = new Slot("Saturday", 3, "3");
        AllSlots[255] = new Slot("Saturday", 1, "3:30");
        AllSlots[256] = new Slot("Saturday", 2, "3:30");
        AllSlots[257] = new Slot("Saturday", 3, "3:30");
        AllSlots[258] = new Slot("Saturday", 1, "4");
        AllSlots[259] = new Slot("Saturday", 2, "4");
        AllSlots[260] = new Slot("Saturday", 3, "4");
        AllSlots[261] = new Slot("Saturday", 1, "4:30");
        AllSlots[262] = new Slot("Saturday", 2, "4:30");
        AllSlots[263] = new Slot("Saturday", 3, "4:30");
        AllSlots[264] = new Slot("Saturday", 1, "5");
        AllSlots[265] = new Slot("Saturday", 2, "5");
        AllSlots[266] = new Slot("Saturday", 3, "5");
        AllSlots[267] = new Slot("Saturday", 1, "5:30");
        AllSlots[268] = new Slot("Saturday", 2, "5:30");
        AllSlots[269] = new Slot("Saturday", 3, "5:30");
        AllSlots[270] = new Slot("Saturday", 1, "6");
        AllSlots[271] = new Slot("Saturday", 2, "6");
        AllSlots[272] = new Slot("Saturday", 3, "6");
        return AllSlots;
    }
}
