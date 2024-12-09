package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
public class FacebookUser {

    public FacebookUser(String email, String userCountry, String userActiveTime) {
        this.email = email;
        this.userCountry = userCountry;
        this.userActiveTime = userActiveTime;
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
