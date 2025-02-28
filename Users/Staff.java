package Users;

import java.io.Serializable;

public abstract class Staff extends User implements Serializable {

    private final long SSN;

    public Staff(long SSN, String email, String password, String name, String DOB, String gender) {
        super(email, password, name, DOB, gender);
        this.SSN = SSN;
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public long getSSN() {
        return SSN;
    }
}
