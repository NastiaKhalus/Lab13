package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
public class FacebookUser {

    public FacebookUser(String name, String email, String date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }
    
    private String email;
    private String userCountry;
    private String userActiveTime;

    public String getEmail() {
        return email;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserActiveTime() {
        return userActiveTime;
    }
}
