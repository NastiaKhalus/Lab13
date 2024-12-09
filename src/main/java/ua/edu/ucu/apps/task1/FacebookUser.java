package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class FacebookUser {

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
