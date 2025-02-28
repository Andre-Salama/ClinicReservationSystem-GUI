package Users;

import java.io.Serializable;

public abstract class User implements Serializable {

    private final String DOB;
    private final String name;
    private String email;
    private String password;
    private String mobile;
    private String address;
    private final String gender;

    public User(String email, String password, String name, String DOB, String gender) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
    }

    public void updateAccount(String email, String password, String mobile, String address) {
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

}
